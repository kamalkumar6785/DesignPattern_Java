package org.example;

abstract class Ticket {
    protected  String source;
    protected  String destinaiton;
    protected  double price;

    public  Ticket(String source, String destinaiton, double price)
    {
        this.source = source;
        this.destinaiton = destinaiton;
        this.price = price;
    }
    public abstract  void display();

}
