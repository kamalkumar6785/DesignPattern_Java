package org.example;

class BusinessTicket extends Ticket {
    public BusinessTicket(String source,String destination, double price) {
        super(source,destination, price);
    }

    @Override
    public void display() {
        System.out.println("Business class From " + source +" to" + destinaiton + "and Price is ₹" + price);
    }
}