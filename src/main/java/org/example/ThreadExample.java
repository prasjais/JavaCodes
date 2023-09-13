package org.example;

public class ThreadExample implements Runnable{

    @Override
    public void run() {

        for(int i=1; i<=10; i++)
        {
            System.out.println("value of i : "+ i);
            try{Thread.sleep(1000);}
            catch (Exception e){}
        }
    }
}
