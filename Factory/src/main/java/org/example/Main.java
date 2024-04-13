package org.example;


// Main class to demonstrate the usage of the factory method
public class Main {
    public static void main(String[] args) {
        // Create different types of tickets using the factory method
        Ticket economyTicket = TicketFactory.createTicket(TicketFactory.TicketType.ECONOMY,"Hyderabad" ,"Mumbai", 8000.0);
        Ticket premiumEconomyTicket = TicketFactory.createTicket(TicketFactory.TicketType.PREMIUM_ECONOMY,"New Delhi", "Dubai", 10000.0);
        Ticket businessTicket = TicketFactory.createTicket(TicketFactory.TicketType.BUSINESS, "Chennai","Kolkata", 7000.0);
        Ticket firstClassTicket = TicketFactory.createTicket(TicketFactory.TicketType.FIRST_CLASS, "Chennai","Ahmedabad", 4500.0);
        Ticket Random = TicketFactory.createTicket(TicketFactory.TicketType.FIRST_CLASS, "XYZ","ABC", 4500.0);


        // call the display method for each ticket
        economyTicket.display();
        premiumEconomyTicket.display();
        businessTicket.display();
        firstClassTicket.display();
    }
}