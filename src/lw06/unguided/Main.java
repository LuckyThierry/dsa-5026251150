package lw06.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        BinarySearchTree bst = new BinarySearchTree();
        // String firstline = read.nextLine();
        String[] numbers = read.nextLine().split(" ");

        Node root = null;

        for(int i=0; i<numbers.length;i++){
            int value = Integer.parseInt(numbers[i]);
            bst.insert(value);
        }
        int target = 0;
        if(read.hasNextInt()){
            target = read.nextInt();
        }

        System.out.print("Preorder : ");
        bst.preOrder();

        System.out.print("Inorder : ");
        bst.inOrder();

        System.out.print("Postorder : ");
        bst.postOrder();

        System.out.println("Search "+target+" : " + bst.search(target));
        

        System.out.print("Minimum : "+bst.findMin());
        System.out.println();

        System.out.print("Maximum : "+bst.findMax());

        read.close();
    }
}
