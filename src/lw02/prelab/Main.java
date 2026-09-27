package lw02.prelab;

import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("transaction.txt"));

        LinkedList<String[]> transactions = new LinkedList<>();
        
        while(scanner.hasNext()){
            String name = scanner.next();
            String type = scanner.next();
            String amount = scanner.next();

            String[] arr = {name, type, amount};
            transactions.add(arr);
        }

        LinkedList<String[]> customerData = new LinkedList<>();

        for(String[] arr : transactions){
            String name = arr[0];

            boolean done = false;
            for(String[] customer : customerData){
                if(customer[0].equals(name)){
                    done = true;
                    break;
                }
            }
            if(!done){
                customerData.add(new String[]{name, "0"});
            }
        }

        Queue<String[]> transactionQueue = new LinkedList<>();

        for(String[] arr : transactions){
            transactionQueue.add(arr);
        }

        Stack<String[]> failedTransaction = new Stack<>();

        while(!transactionQueue.isEmpty()){
            String[] arr = transactionQueue.poll();
            
            String name = arr[0];
            String type = arr[1];
            int amount = Integer.parseInt(arr[2]);

            int index = -1;
            for(int i=0;i<customerData.size();i++){
                if(customerData.get(i)[0].equals(name)){
                    index = i;
                    break;
                }
            }

            int currentBalance = Integer.parseInt(customerData.get(index)[1]);

            if(type.equals("DEPOSIT")){
                int newBalance = currentBalance + amount;
                customerData.get(index)[1] = String.valueOf(newBalance);
            } else if(type.equals("WITHDRAW")){
                if(amount > currentBalance){
                    failedTransaction.push(arr);
                } else {
                    int newBalance = currentBalance - amount;
                    customerData.get(index)[1] = String.valueOf(newBalance);
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for(String[] cust : customerData){
            System.out.println(cust[0] + " : " + cust[1]);
        }
        System.out.println();
        System.out.println("=== Failed Transactions ===");
        while(!failedTransaction.isEmpty()){
            String[] failed = failedTransaction.pop();
            System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
        }
        
        scanner.close();

    }
}