public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;

    private Price price;

    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        this.setPriceCode(newpriceCode);
    }

    public int getPriceCode() {
        return this.price.getPriceCode();
    }
    public void setPriceCode(int arg) {
        switch(arg)
        {
            case Movie.REGULAR:
                this.price = new RegularPrice();
                break;
            case Movie.NEW_RELEASE:
                this.price = new NewReleasePrice();
                break;
            case Movie.CHILDRENS:
                this.price = new ChildrensPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }
    public String getTitle (){
        return title;
    };

    public double getCharge(int daysRented) {
       return this.price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented)
    {
        if (this.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
        {
            return 2;
        }
        return 1;
    }
}