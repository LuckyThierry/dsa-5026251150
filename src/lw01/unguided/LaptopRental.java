package lw01.unguided;

public class LaptopRental extends Rental{
    public LaptopRental(String id, int days){
        super(id, days);
    }

    public int calculateCharge(){
        return (40000 * getDays()) + 10000;
    }

    public String label(){
        return "Laptop";
    }
}
