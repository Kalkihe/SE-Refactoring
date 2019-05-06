
import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };

    public String statement() {
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();	    
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            // add frequent renter points
            frequentRenterPoints += each.getFrequentRenterPoints();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" +
                    each.getCharge() + "\n";
        }
        //add footer lines
        result += "Amount owed is " + this.getTotalCharge() + "\n";
        result += "You earned " + this.getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private int getTotalFrequentRenterPoints()
    {
        int result = 0;
        Enumeration rentalsEnum = this.rentals.elements();
        while (rentalsEnum.hasMoreElements())
        {
            Rental each = (Rental) rentalsEnum.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    private double getTotalCharge()
    {
        double result = 0;
        Enumeration rentalsEnum = this.rentals.elements();
        while(rentalsEnum.hasMoreElements())
        {
            Rental each = (Rental) rentalsEnum.nextElement();
            result += each.getCharge();
        }
        return result;
    }
}
    