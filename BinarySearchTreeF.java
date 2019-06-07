 package binarytree;

    import java.util.Scanner;

    public class BST {

        public static void main(String[] args) {
            Binary1 bst = new Binary1();
            Scanner sc = new Scanner(System.in);
            int choice;
            int numb;
            try {
                do {
                    System.out.println("\nBINARY SEARCH TREE ");
                    System.out.println("OPTIONS:"+ " [1]INSERT"+ " [2]DELETE"+ " [3]EXIT");
                    choice = sc.nextInt();
                    try {
                        switch (choice) {
                            case 1:
                                System.out.print("Insert number: ");
                                numb = sc.nextInt();
                                bst.root = bst.insert(bst.root, numb);
                                break;
                            case 2:
                                if (bst.getHeight() == 0) {
                                    System.out.println("Tree is empty");
                                    break;
                                } else {
                                    System.out.print("Delete number: ");
                                    numb = sc.nextInt();
                                    bst.root = bst.deleteNode(bst.root, numb);
                                    break;
                                }
                            case 3:
                                System.exit(0);

                            default:
                                break;
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Number not found!");

                    }
                    bst.printBST();
                    System.out.println();
                } while (choice != 4);




            } catch (IllegalArgumentException e) {
                System.out.println("SMART USER!.");
                System.exit(0);
            }
        }
    }








    class Node {
//can have a value or not, each with one value
        int key, height;
        Node left, right;
//identify a field within a record that contains other data
        Node(int d) {
            key = d;
            height = 1;
        }
    }

    class Binary1 {

        Node root;

        int height(Node N) {
            if (N == null) {
                return 0;
            }
            return N.height;
        }

        // A utility function to get maximum of two integers
        int max(int a, int b) {
            return (a > b) ? a : b;
        }

        Node insert(Node node, int key) {
            /* 1.  Perform the normal BST2 rotation */
            if (node == null) {
                return (new Node(key));
            }
            if (key < node.key) {
                node.left = insert(node.left, key);
            } else if (key > node.key) {
                node.right = insert(node.right, key);
            } else // Equal keys not allowed
            {
                return node;
            }
            /* 2. Update height of this ancestor node */
            node.height = 1 + max(height(node.left),
                    height(node.right));
            return node;
        }
    //Not the entire tree needs to be searched

        Node minValueNode(Node node) {
            Node current = node;
            /* loop down to find the leftmost leaf */
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }

        Node deleteNode(Node root, int key) {
            if (root == null) {
                return root;
            }
            if (key < root.key) {
                root.left = deleteNode(root.left, key);
            } else if (key > root.key) {
                root.right = deleteNode(root.right, key);
            } // if key is same as root's key, then this is the node
            // to be deleted
            else {
                // node with only one child or no child
                if ((root.left == null) || (root.right == null)) {
                    Node temp = null;
                    if (temp == root.left) {
                        temp = root.right;
                    } else {
                        temp = root.left;
                    }

                    // No child case
                    if (temp == null) {
                        temp = root;
                        root = null;
                    } else // One child case
                    {
                        root = temp; // Copy the contents of
                    }                                 // the non-empty child
                } else {
                    // node with two children: Get the inorder
                    // successor (smallest in the right subtree)
                    Node temp = minValueNode(root.right);
                    // Copy the inorder successor's data to this node
                    root.key = temp.key;
                    // Delete the inorder successor
                    root.right = deleteNode(root.right, temp.key);
                }
            }
            // If you only have 1 node and then return
            if (root == null) {
                return root;
            }
            // STEP 2:update height's node
            root.height = max(height(root.left), height(root.right)) + 1;
            return root;
        }

        public int getHeight() {
            return root.height;
        }
        private String x;
        private String y;
        private int[] bstArray;
        private int[] bstArrayInt;
        private int indArray[];
        private int lastKnownIndex = 0;

        public void printBST() {

            x = "";
            try {
                int avlSize = ((int) Math.pow(2, root.height)) - 1;

                if (avlSize > 0) {
                    bstArray = new int[avlSize];

                    int index = 0;
                    bstArray[index] = root.key;

                    if (avlSize > 1) {
                        BSTSearch(root, index);
                    }

                    for (int b = 0; b < bstArray.length; b++) {
                        if (b <= lastKnownIndex) {
                            String bstValue = (bstArray[b] == 0) ? "null " : bstArray[b] + " ";
                            x = x + "\t" + bstValue;
                        }
                    }
                    System.out.print("Index:");
                    for (int b=0;b<bstArray.length;b++){
                        System.out.print("\t"+b);
                    }
                    System.out.print("\nBST:" + x);
                }
            } catch (NullPointerException e) {
                System.out.println("null");

            }
        }

        public void showIndex() {
            int bstSize = 0;
            bstSize = ((int) Math.pow(2, root.height)) - 1;
            if (bstSize > 0) {
                indArray = new int[bstSize];

                for (int i = 0; i < bstSize; i++) {
                    indArray[i] = i;
                }
                for (int i = 0; i < bstSize; i++) {
                    System.out.print(" " + indArray[i] + " ");
                }
            }
        }

        public void BSTSearch(Node node, int i) {
            Node lt, rt;
            lt = node.left;
            rt = node.right;

            int nodeLeftIndex = (2 * i) + 1;
            int nodeRightIndex = (2 * i) + 2;
            if (lt != null) {
                bstArray[nodeLeftIndex] = lt.key;
                BSTSearch(lt, nodeLeftIndex);
                lastKnownIndex = Math.max(nodeLeftIndex, lastKnownIndex);
            } else {
                if (nodeLeftIndex < bstArray.length - 1) {
                    bstArray[nodeLeftIndex] = 0;
                }
            }
            if (rt != null) {
                bstArray[nodeRightIndex] = rt.key;
                BSTSearch(rt, nodeRightIndex);
                lastKnownIndex = Math.max(nodeRightIndex, lastKnownIndex);
            } else {
                if (nodeRightIndex < bstArray.length - 1) {
                    bstArray[nodeRightIndex] = 0;
                }
            }
        }
    }
