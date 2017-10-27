/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // The kind of machine
    private boolean prize;
    // Max number of tickets
    private int max;
    // Counter of tickets
    private int ticketcounter;
    
    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost, boolean special,int tick)
    {
        price = cost;
        prize = special;
        max = tick;
        balance = 0;
        total = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if (ticketcounter >= max)
        {
            //Send message if u reach max number of tickets printed
            System.out.println("Max number of tickets reached");
        }
        else 
        {
            if(amount > 0) {
                balance = balance + amount;
            }
            else {
                System.out.println("Use a positive amount rather than: " + amount);
            }
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */

    public void printTicket()
    {
        if(balance >= price) 
        {
            if (ticketcounter >= max)
            {
                //Send message if u reach max number of tickets printed
                System.out.println("Max number of tickets reached");
            }
            else
            {
                if (prize == true)
                {
                    //Simulate the printing of a prize ticket
                    System.out.println("##################");
                    System.out.println("# The BlueJ Line");
                    System.out.println("# Prize Ticket");
                    System.out.println("##################");
                    System.out.println();
                    ticketcounter = ticketcounter + 1;
                }
                // Simulate the printing of a ticket.
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + price + " cents.");
                System.out.println("##################");
                System.out.println();
                ticketcounter = ticketcounter + 1;
                // Update the total collected with the price.
                total = total + price;
                // Reduce the balance by the prince.
                balance = balance - price;
            }
        }
        else 
        {
            System.out.println("You must insert at least: " +
            (price - balance) + " more cents.");
        }
        
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund; 
    }
    
    /**
     * Return the money in the balance
     * The balance is cleared
     * The total money is cleared
     */
    public int emptyMachine()
    {
        int status = -1;
        if (balance != 0)
        {
            System.out.println("No se puede vacíar ya que alguien esta realizando una operacion en este momento");
        }
        else
        {
            int balanceToRefund;
            balanceToRefund = total;
            total = 0;
            status = balanceToRefund;
        }
        return status;
    }
}
