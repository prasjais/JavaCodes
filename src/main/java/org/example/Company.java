package org.example;

public class Company {

    int n;
    boolean flag = false;
    synchronized public void produce_item(int n) throws Exception
    {
        if(flag)
        {
            wait();
        }
        this.n = n;
        System.out.println("Produce : "+this.n);
        flag = true;
        notify();
    }

    synchronized public int consume_item() throws Exception
    {
        if(!flag)
        {
            wait();
        }
        System.out.println("Consume : "+this.n);
        flag = false;
        notify();
        return this.n;
    }
}
