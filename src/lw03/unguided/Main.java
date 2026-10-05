package lw03.unguided;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        Map<String, Integer> data = new LinkedHashMap<>();

        int failedCount = 0;
        System.out.println("===== Enrollment Checks =====");
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] parts = line.split(" ", 2);
            String operation = parts[0];

            if(operation.equals("REGISTER")){
                String[] cek = parts[1].split(" ", 2);
                String course = cek[0];
                int count = Integer.parseInt(cek[1]);
                if(count > 0){
                    if(data.containsKey(course)){
                        data.put(course, data.get(course)+count);
                    } else if(!data.containsKey(course)){
                        data.put(course, count);
                    }
                } else {
                    failedCount++;
                }    
            } else if (operation.equals("WITHDRAW")){
                String[] cek = parts[1].split(" ", 2);
                String course = cek[0];
                int count = Integer.parseInt(cek[1]);
                if(count > 0){
                    if(data.containsKey(course) && count <= data.get(course)){
                        data.put(course, data.get(course) - count);
                    } else {
                        failedCount++;
                    }
                } else {
                    failedCount++;
                }
            } else if (operation.equals("CHECK")){
                if(data.containsKey(parts[1])){
                    System.out.println(parts[1] + ": " + data.get(parts[1]) + " students");
                } else{
                    System.out.println(parts[1] + ": Not found");
                }
            }
        }
        scanner.close();

        System.out.println();
        System.out.println("===== Final Enrollment =====");
        for(String n : data.keySet()){
            System.out.println(n+": "+data.get(n));
        }
        System.out.println();
        System.out.println("Rejected operations: "+ failedCount);

    }
}
