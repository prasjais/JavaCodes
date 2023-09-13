package org.example;

public class Consumer extends Thread{

    Company c;

    Consumer(Company c)
    {
        this.c = c;
    }

    @Override
    public void run(){

        while(true)
        {
            try{this.c.consume_item();}
            catch (Exception e){}
        }
    }
}
