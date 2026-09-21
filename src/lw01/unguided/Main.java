package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("rentals.txt"));

        int n = scanner.nextInt();

        Rental[] rental = new Rental[n];
        int[] unit = new int[n];

        for(int i=0; i<n; i++){
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int units = scanner.nextInt();

            if(type.equals("LAPTOP")){
                rental[i] = new LaptopRental(id, days);
            } else if(type.equals("PROJECTOR")){
                rental[i] = new ProjectorRental(id, days);
            }

            unit[i] = units;
        }
        scanner.close();

        for(int x=0;x<n;x++){
                System.out.println(rental[x].summary(unit[x]));
            }
    }
}
