package org.example;

public class Producer extends Thread{

    Company c;

    Producer(Company c)
    {
        this.c = c;
    }
    public void run()
    {
        int i = 1;
        while(true) {
            try{this.c.produce_item(i);
            i++;}
            catch(Exception e){}
        }
    }
}
