import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char choice;
        int myVal;
        BinaryTree bst = new BinaryTree();

        while(true) {
            System.out.println("_____________________________________");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Tree Height");
            System.out.println("5. Number of Leaf Nodes");
            System.out.println("6. Occurrences");
            System.out.println("7. Inorder Traversal");
            System.out.println("8. Preorder Traversal");
            System.out.println("9. Postorder Traversal");

            Scanner scan = new Scanner(System.in);
            System.out.print("\nEnter choice: ");
            choice = scan.next().trim().charAt(0);
            switch (choice) {
                case '1':
                    Scanner insert = new Scanner(System.in);
                    System.out.print("      Enter a value to insert: ");
                    myVal = insert.nextInt();
                    bst.insert(myVal);
                    System.out.println("      "+myVal+" inserted!");
                    break;
                case '2':
                    Scanner delete = new Scanner(System.in);
                    System.out.print("      Enter a value to delete: ");
                    myVal = delete.nextInt();
                    bst.delete(myVal);
                    System.out.println("      "+myVal+" deleted!");
                    break;
                case '3':
                    Scanner search = new Scanner(System.in);
                    System.out.print("      Enter a value to search for: ");
                    myVal = search.nextInt();
                    if(bst.search(myVal))
                        System.out.println("      "+myVal+" was found!");
                    else
                        System.out.println("      "+myVal+" was not found!");
                    break;
                case '4':
                    System.out.println("        The current height of the tree is "+bst.getHeight());
                    break;
                case '5':
                    System.out.println("        The current number of leaf nodes is "+bst.getNumberOfLeafNodes() +" (root is not considered a leaf node)");
                    break;
                case '6':
                    Scanner occurrences = new Scanner(System.in);
                    System.out.print("      Enter a value to get occurrences for: ");
                    myVal = occurrences.nextInt();
                    System.out.println("      The occurrences of "+myVal+" is "+bst.getOcurrences(myVal));
                    break;
                case '7':
                    System.out.print("        Inorder traversal: ");
                    bst.traverseCall('1');
                    System.out.println(" ");
                    break;
                case '8':
                    System.out.print("        Preorder traversal: ");
                    bst.traverseCall('2');
                    System.out.println(" ");
                    break;
                case '9':
                    System.out.print("        Postorder traversal: ");
                    bst.traverseCall('3');
                    System.out.println(" ");
                    break;
                default:
                    System.out.println("Not a valid option!");
                    continue;
            }
        }
    }
}
