package org.example;

public class See {

    private int num;

    private int add(int a, int b)
    {
        return a+b;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static See getInstance()
    {
        return new See();
    }
}
