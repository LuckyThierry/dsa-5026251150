package lw03.prelab;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void totalSong(){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        List<String> playlist = new ArrayList<>();
        
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] parts = line.split(" ", 2);
            String operation = parts[0];

            if(operation.equals("ADD")){
                playlist.add(parts[1]);
            } else if(operation.equals("REMOVE")){
                playlist.remove(parts[1]);
            } else if(operation.equals("INSERT")){
                String[] cek = parts[1].split(" ", 2);
                int index = Integer.parseInt(cek[0]);
                playlist.add(index, cek[1]);
            }
        }
        scanner.close();

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: "+ playlist.size());
        for(int i=0; i<playlist.size();i++){
            System.out.println(i+1 +" : "+ playlist.get(i));
        }
        System.out.println();

    }

    public static void manageWorkshop(){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        Set<String> data = new LinkedHashSet<>();
        int duplicateCount =0;

        while(scanner.hasNext()){
            String line = scanner.next();
            if(!data.add(line)){
                duplicateCount++;
            }
        }
        scanner.close();

        int totalUnique = data.size();
        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: "+totalUnique);
        int idx = 1;
        for (String n : data){
            System.out.println(idx +". "+n);
            idx++;
        }   
        System.out.println("Duplicate registrations: "+duplicateCount);
        System.out.println();

    }

    public static void productInventory(){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            String[] parts = line.split(" ", 3);
            int quantity = Integer.parseInt(parts[2]);
            if(parts[0].equals("ADD")){
                if(inventory.containsKey(parts[1])){
                    inventory.put(parts[1], inventory.get(parts[1]) + quantity);
                } else if(!inventory.containsKey(parts[1])){
                    inventory.put(parts[1], quantity);
                }
            } else if(parts[0].equals("SELL")){
                if(inventory.containsKey(parts[1]) && inventory.get(parts[1]) >= quantity ){
                    inventory.put(parts[1], inventory.get(parts[1]) - quantity);
                } else{
                    failedSales++;
                }
            }
        }
        scanner.close();
        
        System.out.println("===== Problem 3 =====");
        for(String product : inventory.keySet()){
            System.out.println(product+": "+inventory.get(product));
        }
        System.out.println("Failed sales: " + failedSales);
    }
    public static void main(String[] args) {

        totalSong();
        manageWorkshop();
        productInventory();

    }
}
