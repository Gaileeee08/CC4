
package stacks;

import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Arlene
 */
public class Stacks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        Stack st = new Stack();

        System.out.println("Enter the size of the Stack: ");
        int size = sc.nextInt();
        int choice;
        int top = -1; 

        do {
            System.out.println("Options: " + "\n[1] PUSH" + "\n[2] POP");
            choice = sc.nextInt();
            if (choice == 1) {

                if (top == size - 1) {
                    System.out.println("Stack is Full!");
                    for (int i = 0; i < st.size(); i++) {
                        System.out.println(st.elementAt(i));

                    }
                } else {
                    System.out.println("Enter element to push:"); // 1st
                    int x = sc.nextInt();
                    st.push(x); // Push value of x in stack
                    System.out.println("STACK: \n"
                            + "#######[TOP]########");
                    for (int i = 0; i < st.size(); i++) {
                        System.out.println(st.elementAt(i));
                    }
                    System.out.println("######[BOTTOM]#######");
                    top++;//index
                }
            } else if (choice == 2) {
                if (top == -1) {
                    System.out.println("Stack is Empty!");
                } else {
                    st.pop();
                    System.out.println("STACK: \n"
                            + "[TOP]");
                    for (int i = 0; i < st.size(); i++) {
                        System.out.println(st.elementAt(i));
                    }
                    System.out.println("[BOTTOM]");
                    top--;
                }
            }

        } while (choice != 3);

        System.out.println("Final Stack: " + st);

    }
}
