package org.example;

public class FirstClassTicket extends  Ticket {
    public FirstClassTicket(String source,String destination, double price) {
        super(source,destination, price);
    }

    @Override
    public void display() {
        System.out.println("First class  From " + source +" to" + destinaiton + " and Price is ₹" + price);
    }
}