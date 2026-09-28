package lw02.unguided;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        LinkedList<String[]> request = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();

        while(scanner.hasNext()){
            String name = scanner.next();
            String book = scanner.next();
            String[] arr = {name, book};
            request.add(arr);
        }

        for(String[] arr : request){
            String name = arr[0];
            String jmlKalkulus = "2";
            String jmlFisika = "1";
            String jmlStatistika = "2";
            for(String[] req : books){
                if(name.equals("Kalkulus")){
                    books.add(new String[]{name, jmlKalkulus});
                } else if(name.equals("Fisika")){
                    books.add(new String[]{name, jmlFisika});
                } else if(name.equals("Statistika")){
                    books.add(new String[]{name, jmlStatistika});
                }
            }
        }

        for(String[] arr : request){
            String name = arr[0];
            boolean done = false;

            for(String[] member : members){
                if(member[0].equals(name)){
                    done = true;
                    break;
                }
            }
            if(!done){
                members.add(new String[]{name, "0"});
            }
        }

        Queue<String[]> queue = new LinkedList<>(request);
        Stack<String[]> fails = new Stack<>();

        while(!queue.isEmpty()){
            String arr[] = queue.poll();

            String name = arr[0];
            String book = arr[1];

            
            if(book.equals("Kalkulus")){

            }
        }

    }   
}
