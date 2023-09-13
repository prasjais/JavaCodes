package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {

    //int count;
//    public void increment()
//    {
//        count++;
//    }

    //by using this synchronized keyword we would be able to get the count of 2000 by using 2 threads
//    synchronized public void increment()
//    {
//        count++;
//    }

    //for the second thing we are changing our normal int variable with the atomic variable which are basically thread safe in nature
    AtomicInteger count = new AtomicInteger();
    public void increment()
    {
        count.incrementAndGet();
    }


}
