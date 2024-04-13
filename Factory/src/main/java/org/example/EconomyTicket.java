package org.example;

class EconomyTicket extends Ticket
{
    public EconomyTicket(String source,String destination, double price)
    {
        super(source,destination, price);
        // calling the constuctor of the parent class
    }

    @Override
    public void display() {
        System.out.println("Economy class From " + source +" to" + destinaiton + " and Price is ₹" + price);
    }
}
