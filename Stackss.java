
package stackss;

import java.util.*;

public class Stackss {
    static Scanner zac = new Scanner(System.in);
    public static void main(String[] args) {
        //Setting container
        String array[];
        boolean cycle = true;
        while (true) {
            try {
                System.out.print("Enter the number of elements: ");
                int arraysize = zac.nextInt();
                array = new String[arraysize];
                break;
            } catch (Exception e) {
                zac.next();
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        //Choosing between stack or queue
        while (cycle) {
            System.out.print("Choose container ([1] Stack | [2] Queue): ");
            String ansType = zac.next();
            switch (ansType) {
                case "stack":
                case "Stack":
                case "1":
                        System.out.println();
                        stack(array);
                        cycle = false;
                        break;
                case "queue":
                case "Queue":
                case "2":
                        System.out.println();
                        queue(array);
                        cycle = false;
                        break;
                default:
                        break;
            }
        }
    }
    //Stack and Queue Methods
    static void stack(String array[]) {
        boolean cycle = true;
        int count = 0;
        while (cycle) {
            System.out.println("Index: ");
            displayIndex(array, 0);
            System.out.println("\nStack: ");
            displayArray(array, 0);
            System.out.print("\nTop: " + (count-1));
            System.out.print("\nChoose action ([1] Push | [2] Pop | [Exit]): ");
            switch (zac.next()) {
                case "push":
                case "Push":
                case "1":
                    if (count == array.length) {
                        System.out.println("You can't push anymore. The container is full.\n");
                    } else {
                        System.out.print("Enter an object: ");
                        array[count] = zac.next();
                        System.out.println(array[count] + " is inserted in the container\n");
                        count++;
                    }
                    break;
                case "pop":
                case "Pop":
                case "2":
                    if (count == 0) {
                        System.out.println("You cannot pop anymore. The container is empty.\n");
                    } else {
                        count--;
                        System.out.println(array[count] + " is deleted from the container\n");
                        array[count] = null;
                    }
                    break;
                case "exit":
                case "Exit":
                    cycle = false;
                    break;
                default:
                    System.out.println("Invalid Value!\n");
            }
        }
        System.out.print("\nThe array is:\n[\t");
        displayArray(array, 0);
        System.out.println("]");
        System.out.println("Index: ");
        displayIndex(array, 0);
        System.out.println("\nStack: ");
        displayArray(array, 0);
        System.out.println();
    }
    static void queue(String array[]) {
        int rear = 0, front = 0;
        boolean cycle = true;
        while (cycle) {
            System.out.println("Index: ");
            displayIndex(array, rear);
            System.out.println("\nQueue: ");
            displayArray(array, rear);
            System.out.print("\n\nFront: " + (front - 1) + "\nRear: " + (rear - 1));
            System.out.print("\n\nChoose action ([1] Enqueue | [2] Dequeue | [Exit]): ");
            switch (zac.next()) {
                case "Enqueue":
                case "enqueue":
                case "1":
                    if (front == array.length) {
                        front = 0;
                    }
                    if (array[front] != null) {
                        System.out.println("You can't enqueue anymore. The container is full.\n");
                        break;
                    } else {
                        System.out.print("Enter an object: ");
                        array[front] = zac.next();
                        System.out.println(array[front] + " is inserted in the container.\n");
                        front++;
                    }
                    
                    break;
                case "Dequeue":
                case "dequeue":
                case "2":
                    if (rear == array.length){
                        rear = 0;
                    }
                    if (array[rear] == null) {
                        System.out.println("you can't Dequeue anymore. The container is empty.\n");
                        break;
                    } else {
                        System.out.println(array[rear] + " is deleted from the container\n");
                        array[rear] = null;
                    }
                    rear++;
                    break;
                case "Exit":
                case "exit":
                    cycle = false;
                    break;
                default:
                        System.out.println("Please try again!!\n");
            }
        }
        System.out.print("\nThe array is:\n[\t");
        displayArray(array, rear);
        System.out.println("]\n");
        System.out.println("Index:");
        displayIndex(array, rear);
        System.out.println("\nQueue:");
        displayArray(array, rear);
        System.out.println();
    }
    
    //Displaying Methods
    static void displayArray(String array[], int arrayStart) {
        int count = arrayStart;
        while (count < array.length) {
            if (array[count] == null) {
                System.out.print("_\t");
            } else {
                System.out.print(array[count] + "\t");
            }
            count++;
        }
        count = 0;
        while (count < arrayStart) {
            if (array[count] == null) {
                System.out.print("_\t");
            } else {
                System.out.print(array[count] + "\t");
            }
            count++;
        }
    }
    static void displayIndex(String array[], int arrayStart) {
        int count = arrayStart;
        count = 0;
        while (count < array.length) {
            System.out.print(count + "\t");
            count++;
        }
    }
	
}