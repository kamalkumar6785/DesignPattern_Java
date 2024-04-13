package org.example;



// Factory class to create different types of tickets
class TicketFactory {

    public enum TicketType
    {

        ECONOMY,
        PREMIUM_ECONOMY,
        BUSINESS,
        FIRST_CLASS
    }

    // Factory method to create tickets based on the  ticket type

    public static Ticket createTicket(TicketType type, String source,String destination, double price)

    {
        switch (type)
        {

            case ECONOMY:
                return new EconomyTicket(source,destination, price);

            case PREMIUM_ECONOMY:
                return new PremiumEconomyTicket(source,destination, price);

            case BUSINESS:
                return new BusinessTicket(source,destination, price);


            case FIRST_CLASS:
                return new FirstClassTicket(source,destination, price);

            default:
                throw new IllegalArgumentException( type + " is not a valid ticket type");

        }
    }
}