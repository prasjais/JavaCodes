package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Rate {

    private static final String API_URL = "https://api.mathjs.org/v4";
    private static final int RATE_LIMIT = 50; // Requests per second per client
    private static final int EXPRESSIONS_PER_SECOND = 500; // Desired number of expressions to be evaluated per second

    private static class RateLimiter {
        private final Object lock = new Object();
        private int tokens;

        public RateLimiter(int rateLimit) {
            this.tokens = rateLimit;
        }

        public boolean getToken() {
            synchronized (lock) {
                if (tokens > 0) {
                    tokens--;
                    return true;
                }
                return false;
            }
        }

        public void refillTokens() {
            synchronized (lock) {
                tokens = RATE_LIMIT;
            }
        }
    }

    private static String evaluateExpression(String expression) throws IOException {
        String url = API_URL + "?expr=" + expression;
        URL newUrl = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) newUrl.openConnection();
        httpURLConnection.setRequestProperty("accept", "application/json");
        InputStream responseStream = httpURLConnection.getInputStream();
        String text = new BufferedReader(
                new InputStreamReader(responseStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        return text;
    }

    private static List<String> processBatch(List<String> expressions, RateLimiter rateLimiter) throws IOException{
        List<String> results = new ArrayList<>();
        for (String expression : expressions) {
            if (rateLimiter.getToken()) {
                String result = evaluateExpression(expression);
                results.add(expression + " => " + result);
            } else {
                results.add(expression + " => Rate limit exceeded");
            }
        }
        return results;
    }

    private static List<String> evaluateExpressions(List<String> expressions) {
        RateLimiter rateLimiter = new RateLimiter(RATE_LIMIT);
        int numThreads = Math.min(EXPRESSIONS_PER_SECOND / RATE_LIMIT, expressions.size());
        int batchSize = numThreads * RATE_LIMIT;
        List<String> results = new ArrayList<>();

        for (int i = 0; i < expressions.size(); i += batchSize) {
            List<String> batch = expressions.subList(i, Math.min(i + batchSize, expressions.size()));
            ExecutorService executor = Executors.newFixedThreadPool(numThreads);

            for (int j = 0; j < numThreads; j++) {
                final int index = j;
                executor.submit(() -> {
                    List<String> batchResults = null;
                    try {
                        batchResults = processBatch(batch.subList(index, batch.size()), rateLimiter);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (results) {
                        results.addAll(batchResults);
                    }
                });
            }

            executor.shutdown();
            try {
                executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            rateLimiter.refillTokens();
        }

        return results;
    }

    public static void main(String[] args) {

        List<String> expressions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expressions and please Type 'end' to finish input.");
        while (true) {
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            }
            expressions.add(expression);
        }
        scanner.close();

        List<String> results = evaluateExpressions(expressions);

        for (String result : results) {
            System.out.println(result);
        }
    }
}
