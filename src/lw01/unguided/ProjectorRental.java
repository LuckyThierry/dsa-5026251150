package lw01.unguided;

public class ProjectorRental extends Rental {
    public ProjectorRental(String id, int days){
        super(id, days);
    }

    public int calculateCharge(){
        int total;

        if(getDays() <= 3){
            total = getDays() * 60000;
        } else {
            total = (3 * 60000) + ((getDays() - 3)* 45000);
        }
        return total + 20000;
    }

    public String label(){
        return "Projector";
    }
}
