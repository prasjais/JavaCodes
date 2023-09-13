package org.example;

import java.io.*;
import java.net.http.HttpRequest;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
//
//    static int n1 = 0, n2 = 1,  n3 = 0;
//    public static void func(int n)
//    {
//        if(n > 0)
//        {
//            n3 = n1 + n2;
//            n1 = n2;
//            n2 = n3;
//            System.out.println(n3+" ");
//            func(n-1);
//        }
//
//        return;
//    }

//    public static int func()
//    {
//        try{
//            System.out.println("hello");
//            return 1;
//        }
//        catch (Exception e)
//        {
//            System.out.println(e);
//        }
//        finally {
//            System.out.println("world");
//            return 2;
//        }
//    }
//    static String s1 = "Hello";
//    static String s2 = "World";
//    boolean flag = true;
//
//    Thread t1 = new Thread()
//    {
//        @Override
//        public void run() {
//            while(flag)
//            {
//                flag = false;
//                synchronized (s1)
//                {
//                    System.out.println(Thread.currentThread().getName()+" "+ s1);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    synchronized(s2)
//                    {
//                        System.out.println(Thread.currentThread().getName()+" "+ s2);
//                    }
//
//                }
//                flag = true;
//            }
//        }
//    };
//
//    Thread t2 = new Thread()
//    {
//        @Override
//        public void run() {
//            while(flag)
//            {
//                flag = true;
//                synchronized (s2)
//                {
//                    System.out.println(Thread.currentThread().getName()+" "+s2);
//                    synchronized (s1)
//                    {
//                        System.out.println(Thread.currentThread().getName()+" "+s1);
//                    }
//                }
//                flag = false;
//            }
//        }
//    };



    public static void main(String[] args) {

//        Main m = new Main();
//        m.t1.start();
//        m.t2.start();

//        int result = func();
//        System.out.println(result);

//        Check c = Check.getCheck();
//        c.display();


//        System.out.println(n1+" ");
//        System.out.println(n2+" ");
//        func(5-2);

        //Serialization
//        Demo d = new Demo(100, "Prashant");
//
//        String filename = "C:\\Users\\PRASJAIS\\demo.txt";
//
//        try{
//            FileOutputStream fos = new FileOutputStream(filename);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(d);
//
//            oos.close();
//            fos.close();
//            System.out.println("Inserted successfully");
//
//        }
//        catch (Exception e)
//        {
//            System.out.println(e);
//        }

        //De-serialization
//        String filename = "C:\\Users\\PRASJAIS\\demo.txt";
//
//        try{
//            FileInputStream fis = new FileInputStream(filename);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            Demo d = (Demo)ois.readObject();
//
//            System.out.println(d.getId());
//            System.out.println(d.getName());
//
//            ois.close();
//
//        }
//        catch(Exception e)
//        {
//            System.out.println(e);
//        }
//-------------------------------------------------------------------------------

//        String str1 = "Java";
//        System.out.println(str1.hashCode());
//        str1 = "Hello";
//        System.out.println(str1.hashCode());
//
//        StringBuilder s1 = new StringBuilder("Java");
//        System.out.println(s1.hashCode());
//        StringBuilder s2 = new StringBuilder("Hello");
//        System.out.println(s1.hashCode());
//--------------------------------------------------------------------------------
//        ThreadExample the = new ThreadExample();
//        ThreadAnotherExample tae = new ThreadAnotherExample();
//        Thread th = new Thread(the);
//
//        th.start();
//        tae.start();

//        System.out.println("program started");
//        int x = 26 + 32;
//        System.out.println("value of x : "+x);
//
//        Thread t = Thread.currentThread();
//        String tname = t.getName();
//        System.out.println("thread name is "+tname);
//        t.setName("FirstThread");
//        System.out.println(t.getName());
//        System.out.println(t.getId());
//        System.out.println("program ended");

 //       ------------//Producer Consumer Problem-----------------------------concept of synchronized and inter thread communication

//        Company comp = new Company();
//        Producer p = new Producer(comp);
//        Consumer c = new Consumer(comp);
//
//        p.start();
//        c.start();

        //----------------Thread Safe---------------

        //Thread safe basically means if one thread has occupied some resource then other thread should not be able to interrupt that resource

//        Count c = new Count();
//        //if we want to get the count of 2000 then either we can use to achieve this or we can use 2 threads
//        //first we are using for loop
//
////        for(int i=1; i<=2000; i++)
////        {
////            c.increment();
////        }
////
////        System.out.println(c.count);
//
//        //second now we are creating two threads to get count=2000
//
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                for(int i=1; i<=1000; i++)
//                {
//                    c.increment();
//                }
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                for(int i=1; i<=1000; i++)
//                {
//                    c.increment();
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//        System.out.println(c.count);

        //if we try to get the count of 2000 by using 2 threads then it will not be possible, it is always giving different value of count because the count is not synchronized
        //so to achieve this either we can make our method synchronized or we can use Atomic Interface like instead of normal int we can use AtomicInteger
        //if we are using multi threading and we need to work on some collection framework then we can use ConcurrentHash which is also a thread-safe in nature;


//        ---------------------------------FailFast and FailSafe------------------------------------------

//        fail fast and fail safe iterator
//        iterator in java have two feature either fail fast or fail safe.
//        fail-fast iterator in java:-
//                ----------------------------------
//                fail-fast iterator immediately throw ConcurrentModificationException if collection is modified while iterating over it.
//                fail-fast iterator uses the original collection to traverse so it doesn't requires any additional memory.
//                ex - ArrayList, HashMap, Vector
//        fail-safe iterator in java:-
//                -----------------------------------
//                Fail-safe iterator doesn't throw any exception if collection is modified while iterating over it.
//                Fail-safe iterator use copy of original collection to traverse so it requires an additional memory.
//                Fail-safe may not have the latest elements in the collection.


//        List<String> list = new ArrayList<>();
//        list.add("one");
//        list.add("two");
//        list.add("three");
//        list.add("four");
//
//        Iterator<String> itr = list.iterator();
//        while(itr.hasNext())
//        {
//            System.out.println(itr.next());
//            list.add("five");          //this line is try to modify the collection so it is throwing one error called concurrentModificationException.
//            list.remove("second");  //same
//            //if we can check the internal implementation of the iterator what we see there is an CheckModification() function inside the iterator because of that we get the exception for
//            //array, vector and hashmap
//        }

        //HashMap implementation

//        Map<Integer, String> mp = new HashMap<>();
//        mp.put(1,"one");
//        mp.put(2,"two");
//        mp.put(3,"three");
//        mp.put(4,"four");
//
//        Iterator<Map.Entry<Integer, String>> itr = mp.entrySet().iterator();
//        while(itr.hasNext())
//        {
//            Map.Entry<Integer, String> entry = itr.next();
//            System.out.println(entry.getKey()+" "+entry.getValue());
//            mp.put(5, "five");
//        }

        //Above were the examples of the fail-fast
        //Below are the example of the fail-safe

//        List<String> list = new CopyOnWriteArrayList<>();
//        list.add("one");
//        list.add("two");
//        list.add("three");
//        list.add("four");
//
//        Iterator<String> itr = list.iterator();
//        while(itr.hasNext()) {
//            System.out.println(itr.next());
//            list.add("five"); // we can see if we are using "CopyOnWriteArrayList" this will not give any exception because it works on duplicate data
//        }

//        Map<Integer, String> mp = new ConcurrentHashMap<>();
//        mp.put(1,"one");
//        mp.put(2,"two");
//        mp.put(3,"three");
//        mp.put(4,"four");
//
//        Iterator<Map.Entry<Integer, String>> itr = mp.entrySet().iterator();
//        while(itr.hasNext())
//        {
//            Map.Entry<Integer, String> entry = itr.next();
//            System.out.println(entry.getKey()+" "+entry.getValue());
//            mp.put(5, "five");
//        }
//----------------------------------------------------------------------------------------------------------------------
//        List<Employee> lst = new ArrayList<>();
//        lst.add(new Employee(1, "Prashant", "SDE", 80000));
//        lst.add(new Employee(2, "Shubham", "Junior", 30000));
//        lst.add(new Employee(1, "Anand", "Junior SDE", 50000));
//        lst.add(new Employee(1, "Priyesh", "SDE", 60000));

//        List<Employee> l = lst.stream().filter(i->i.getSalary()>=50000).collect(Collectors.toList());
//
//        for (Employee e: l) {
//
//            System.out.println(e.getName()+" "+e.getDesignation()+" "+e.getSalary());
//
//        }

//        long c = lst.stream().filter(i->i.getSalary()>=50000).count();

//        List<Employee> emp = lst.stream().map(i->i.getSalary()+10000).collect();
//
//        System.out.println(c);

//        for (Employee e: emp) {
//
//            System.out.println(e.getName()+" "+e.getDesignation()+" "+e.getDesignation());
//
//        }

//----------------------------------------------------------------------------------------------------------------------
       //Deep Copy
        // In deep copy both the objects are using the different memory area.
//        Example ex = new Example();
//        ex.x = 10;
//        ex.y = 20;
//
//        Example ex1 = new Example();
//        ex1.x = 20;
//        ex1.y = 30;
//
//        ex1.x = ex.x;
//        ex1.y = ex.y;
//
//        ex.display();
//        ex1.display();

        //Shallow Copy
        //In shallow copy objects are using the shared memory area or single memory area

//        Example ex = new Example();
//        ex.x = 10;
//        ex.y = 20;
//
//        Example ex1 = ex;
//        ex1.x = 30;
//        ex1.y = 40;
//
//        ex.display();
//        ex1.display();

        //System.out.println("HelloWorld");

//        String str = "hello";
//        char[] ch = str.toCharArray();
//        char temp = ch[0];
//        ch[0] = ch[ch.length-1];
//        ch[ch.length-1] = temp;
//
//        String str1 = "";
//        for (char i: ch) {
//            str1 += i;
//        }
//
//        System.out.println(str1);


//        int[] arr = {7,4,5,8,8,3,9,8,7,6};
//        int k = 7;
//        int sum = 0;
//        for(int i=0; i<arr.length; i++)
//        {
//            sum += arr[i];
//            arr[i] = sum;
//        }
//
//        double max = arr[k-1];
//
//        for(int i=k; i<arr.length; i++)
//        {
//            int num = arr[i] - arr[i-k];
//            if(num > max)
//            {
//                max = num;
//            }
//            System.out.println(max);
//        }
//
//        System.out.println(max/k);

//        int arr[] = {1,5,3,2,6,10,-5};
//        int max = Integer.MIN_VALUE; //max
//        for(int i=0; i<arr.length; i++)
//        {
//            if(arr[i] > max)
//            {
//                max = arr[i];
//            }
//        }

//        int arr[] = {2,4,5,6,1,10};
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for(int i=0; i< arr.length; i++)
//        {
//            pq.add(arr[i]);
//        }
//
//        int k = arr.length - 2;
//        while(k>0)
//        {
//            pq.poll();
//            k--;
//        }
//
//        System.out.println(pq.peek());


//        convert hashset to treeset

//       Set<Integer> st = new HashSet<>();
//       st.add(1);
//       st.add(2);
//
//       System.out.println(st);
//
//       Set<Integer> ht = new TreeSet<Integer>();
//       ht.addAll(st);
//
//       System.out.println(ht);


//        String s1 = new String("JAVA");
//
//        if(s1.equals(s1.concat("J2EE")))
//        {
//            System.out.println("Same object");
//        }
//        else
//        {
//            System.out.println("different object");
//        }



//        List<Employee> e1 = new ArrayList<>();
//        e1.add(new Employee(5,"Prashant","Developer", 50000));
//        e1.add(new Employee(2,"Abhishek","Developer", 20000));
//        e1.add(new Employee(3,"Shukla","Developer", 60000));
//
//
////        Collections.sort(e1);
////        IDcomparator id = new IDcomparator();
//        NameComparator name = new NameComparator();
//
//        Collections.sort(e1, name);
//
//        System.out.println(e1);

//        ImmutableClass ic = new ImmutableClass(1,"hello");
//        System.out.println(ic.getId()+" "+ic.getName());

//        int a = 1;
//        int b = 2;
//        int i = 0;
//        try{
//            int num = a/2;
//            if(i==0)
//            {throw new MyException("Cannot divide by zero");}
//        }
//        catch(MyException e)
//        {
//            System.out.println(e);
//        }

//        ***********Builder Pattern***********************
//        User user = new User.UserBuilder().setEmail("Prashant@123").setId(1).setName("Prashant").build();
//        System.out.println(user);

//        Map<Integer, Integer> mp = new HashMap<>();
//        mp.put(1, 2);
//        mp.put(2, 3);
//
//        if(mp.containsKey(1))
//        {
//            System.out.println("true");
//        }



        //convert static array to list
//        int arr[] = {1,2,3,4};
//        List nums = Arrays.asList(arr);
//        nums.add(5);


//        int result = Arrays.stream(new int[]{1, 2, 3, 4, 5})
//                .filter(item -> {
//                    System.out.println(item);
//                    return item > 2;
//                })
//                .map(item -> {
//                    System.out.println(item);
//                    return item * 3;
//                }).sum();
//
//        System.out.println(result);
        int arr[] = {1,2,3,4,5};

        HashMap<Integer, Integer> mp = new HashMap<>();

        mp.put(1,1);
        mp.put(2,1);
        mp.put(3,1);
        mp.put(4,1);
        mp.put(5,1);

        int target  = 5;
        HashSet<HashSet<Integer>> result = new HashSet<>();
        HashSet<Integer> st = new HashSet<>();
        for(int i=0; i<arr.length/2; i++)
        {
            int diff = target - arr[i];
            if(mp.containsKey(diff))
            {
                st.add(arr[i]);
                st.add(diff);
                result.add(st);

            }

        }

        System.out.println(result);




























    }
}