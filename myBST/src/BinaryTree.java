public class BinaryTree{
   private Node root;
   private int leftHeight, rightHeight;

    /** Constructor set root to null
     * root = entry point to BST
     */
   BinaryTree(){
       root = null;
   }

    /** determines whether tree is empty or not
     *returns true if empty, otherwise false
     */
   public boolean isEmpty(){
       if(root == null) return true;
       else return false;
   }

    /** insertion into BST
     * this goes through a tree, starting from root, and determines placement
     * if root = null, set root as key for insertion-- else cycle through
     * moving left means value is less than current node-- right means greater than current node
     * DUPES ALLOWED
     */
   public void insert(int key){

       if(isEmpty()) {/** check for empty tree **/
           Node newNode = new Node();   /** create a new node **/
           newNode.myData = key;        /** set value of current node to key **/
           root = newNode;/** set new root equal to new node **/
       }
       else{/** tree is not empty **/

           Node current = root;         /** create a current node to go through tree **/

           /** loop through tree-- stops when the next value on left or right is null **/
           while(true){
               if (current.myData > key) {/** value less than current node? go left **/
                    if(current.left == null){
                        Node newNode = new Node();   /** create a new node **/
                        newNode.myData = key;        /** set value of current node to key **/
                        current.left = newNode;/** insert to left of current node **/
                        return;
                     }
                    current = current.left;
                   }
               else if (current.myData <= key){  /** value greater than/equal to node? go right **/
                   if(current.right == null) {
                       Node newNode = new Node();   /** create a new node **/
                       newNode.myData = key;        /** set value of current node to key **/
                       current.right = newNode;
                       return;
                   }
                   current = current.right;
               }
           }
       }
   }

    /** deletion from BST
     * searches for the value to delete
     * three deletion cases:    Node has no children
     *                          Node has one child
     *                          Node has Two or more children
     */
   public void delete(int key){

   }

    /** searches through BST
     *returns true if the node was found, otherwise false
     */
   public boolean search(int key){
       Node current = root;
       if(root == null)
           return false;
       while(true) {
           if (current.myData < key)
               current = current.right;
           else if(current.myData > key)
               current = current.left;
           else
               return true;

           if(current == null)
               return false;
       }
   }

   /** inorder traversal for BST**/
   public void inOrder(Node traverse){
       if(traverse == null) return;
       inOrder(traverse.left);
       System.out.print(traverse.myData+" ");
       inOrder(traverse.right);
   }

   /** preorder traversal for BST **/
   public void preOrder(Node traverse){
       if(traverse == null)
           return;
       System.out.print(traverse.myData+" ");
       preOrder(traverse.left);
       preOrder(traverse.right);
    }

    /** postorder traversal of BST **/
   public void postOrder(Node traverse){
       if (traverse == null) return;
       postOrder(traverse.left);
       postOrder(traverse.right);
       System.out.print(traverse.myData+" ");
   }

    /** allows for traversals to be called
     *uses switch case statements in place of if else
     */
    public void traverseCall(char choice){
        if (isEmpty()) {/** checks for empty tree **/
            System.out.print("The tree is empty!");
            return;
        }
       switch(choice){
           case '1':
               inOrder(root);
               break;
           case '2':
               preOrder(root);
               break;
           case '3':
               postOrder(root);
               break;
           default:
               System.out.println("Invalid input!");
               break;
       }
    }

    /** counts number of leaf nodes
     * this will return the number of leaf nodes found in a tree
     */
    public int numberOfLeafNodes(Node findLeafCount){
        if(isEmpty())/** check if tree is empty **/
            return 0;
        if(root.left == null && root.right == null)/** root is not considered leaf, so check for this condition **/
            return 0;
        if(findLeafCount.left == null && findLeafCount.right == null)/** if left and right of current node is null, it is a leaf **/
            return 1;
        else
            return numberOfLeafNodes(findLeafCount.left)+numberOfLeafNodes(findLeafCount.right);/** add return values together **/
    }

    /** simply calls for and returns numberOfLeafNodes function **/
    public int getNumberOfLeafNodes(){
        return numberOfLeafNodes(root);
    }

    /** find the height of a given tree
     * this will recursively find the height of a given tree and return it
     */
    public int treeHeight(Node findHeight){

        if(findHeight == null)/** node == null? then return 0 as the value **/
            return 0;
        leftHeight= (treeHeight(findHeight.left));
        rightHeight= (treeHeight(findHeight.right));
        if(leftHeight>rightHeight)
            return leftHeight+1;
        else
            return rightHeight+1;
    }

    /** functions that calls for and returns treeHeight function **/
    public int getHeight(){
        return treeHeight(root);
    }

    /** counts the occurences of a Node with a specific value in a BST
     * returns the number of occurences in a BST for a specific value
     */
    public int occurences(Node ocur, int key){
        if(isEmpty())
            return 0;
        if(ocur == null)
            return 0;
        if(ocur.myData == key)
            return 1+occurences(ocur.right,key)+occurences(ocur.left,key);
        else if(key >= ocur.myData)
            return occurences(ocur.right,key);
        else
            return occurences(ocur.left,key);
    }

    /** function that calls an returns the final value of occurrences **/
    public int getOcurrences(int key){
        return occurences(root, key);
    }

}
