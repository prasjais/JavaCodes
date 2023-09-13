package org.example;

public class Check {

    private Check()
    {
        System.out.println("Calling constructor.....");
    }

    public static Check getCheck()
    {
        return new Check();
    }

    public void display()
    {
        System.out.println("Display");
    }
}
