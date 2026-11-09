package lw04.unguided;

import java.util.Scanner;

public class Main {
    
    static void sortCard(int[] arr, int passes){
        int n = arr.length;
        for(int i=0; i<passes && i<n-1; i++){
            int idx = i;
            for(int j=i+1; j<n; j++){
                if(arr[j]<arr[idx]){
                    idx = j;
                }
            }
            int x = arr[i];
            arr[i] = arr[idx];
            arr[idx] = x;
        }
    }

    static int findCard(int[] arr, int target){
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        
        int n = input.nextInt();
        int[] card = new int[n];
        for(int i=0; i<n; i++){
            card[i] = input.nextInt();
        }

        int m = input.nextInt();
        int[] req = new int[m];
        for(int i=0; i<m; i++){
            req[i] = input.nextInt();
        }
        input.close();

        sortCard(card, 2);

        for(int i=0; i<n; i++){
            System.out.print(card[i]);
            if(i<n-1){
                System.out.print(" ");
            }
        }
        System.out.println();

        for(int i=0; i<m; i++){
            int idx = findCard(card, req[i]);
            if(idx != -1){
                System.out.println(req[i]+": FOUND at index "+idx);
            } else{
                System.out.println(req[i]+": NOT FOUND");
            }
        }
    }

}
