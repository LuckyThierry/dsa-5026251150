package lw01.unguided;

abstract class Rental implements Chargeable {
    private String id;
    private int days;

    protected Rental(String id, int days){
        if(days <= 0){
            throw new IllegalArgumentException("Days must be a postive number");
        }
        this.id = id;
        this.days = days;
    }

    public String getId(){
        return id;
    }

    public int getDays(){
        return days;
    }

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int unit){
        if(unit <= 0){
            throw new IllegalArgumentException("Unit must be a positive number");
        }
        return unit * calculateCharge();
    }

    public String label(){
        return "Rental";
    }

    public String summary(int units){
        return id + "|" + label() + "|" + calculateCharge(units);
    }
}
