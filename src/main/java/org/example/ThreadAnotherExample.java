package org.example;

public class ThreadAnotherExample extends Thread{

    @Override
    public void run() {
        for(int i=10; i>=1; i--)
        {
            System.out.println("value of reverse i : "+i);
            try{Thread.sleep(1000);}
            catch (Exception e){}
        }
    }
}
