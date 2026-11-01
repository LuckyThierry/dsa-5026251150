package lw04.prelab;

import java.util.Scanner;

public class Main {

    static void insertionSortDesc(int[] a, int passes) {
        for(int i=1; i<=passes && i < a.length; i++) {
            int key = a[i];
            int j = i-1;
            while (j >= 0 && a[j] < key) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }

    static int linearSearch(int[] a, int target) {
        for(int i=0; i<a.length; i++) {
            if (a[i] == target) return i;
        }
        return -1;
    }

    static final int passes = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = scanner.nextInt();
        int[] branches = new int[n];

        for(int i=0; i<n; i++){
            branches[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] targets = new int[m];

        for(int i=0; i<m; i++){
            targets[i] = scanner.nextInt();
        }
        scanner.close();

        insertionSortDesc(branches, passes);

        for(int i=0; i<n; i++){
            System.out.print(branches[i]);
            if(i<n-1){
                System.out.print(" ");
            }
        }
        System.out.println();

        for(int t:targets){
            int idx = linearSearch(branches, t);
            if(idx != -1){
                System.out.println(t+": FOUND at index "+idx);
            } else{
                System.out.println(t+": NOT FOUND");
            }
        }
    }    
}
