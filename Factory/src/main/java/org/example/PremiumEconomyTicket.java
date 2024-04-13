package org.example;

class PremiumEconomyTicket extends Ticket {
    public PremiumEconomyTicket(String source,String destination, double price) {
        super(source,destination, price);
    }

    @Override
    public void display() {
        System.out.println("Premium Economy From " + source +" to" + destinaiton + " and Price is ₹" + price);
    }
}