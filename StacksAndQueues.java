/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks.and.queues;

import java.util.Scanner;

/**
 *
 * @author CC4-13
 */
public class StacksAndQueues {

    /**
     * @param args the command line arguments
     */
    static Scanner gg = new Scanner(System.in);

    public static void main(String[] args) {
        String array[];
        boolean cycle = true;
        while (true) {
            try {
                System.out.print("Enter the number of elements: ");
                int arraysize = gg.nextInt();
                array = new String[arraysize];
                break;
            } catch (Exception e) {
                gg.next();
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        //Choosing between stack or queue
        while (cycle) {
            System.out.println("Choose Options ([1] Stack | [2] Queue): ");
            String ansType = gg.next();
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
            System.out.print("\nTop: " + (count - 1));
            System.out.print("\nChoose Options ([1] Push | [2] Pop | [3] Exit): ");
            switch (gg.next()) {
                case "push":
                case "Push":
                case "1":
                    if (count == array.length) {
                        System.out.println("\nSorry, The Stack is full!\n");
                    } else {
                        System.out.print("\nPush a number: ");
                        array[count] = gg.next();
                        System.out.println(array[count] + " \nis inserted in the container\n");
                        count++;
                    }
                    break;
                case "pop":
                case "Pop":
                case "2":
                    if (count == 0) {
                        System.out.println("\nSorry, The Stack is empty!\n");
                    } else {
                        count--;
                        System.out.println(array[count] + "\n is removed from the container\n");
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

          
            System.out.println("\nQueue: ");
            displayArray(array, rear);
            System.out.print("\n\nRear: " + (front - 1) + "\nFront: " + (rear - 1));
            System.out.print("\n\nChoose action ([1] Insert | [2] Delete |[3] Exit): ");
            switch (gg.next()) {
                case "Insert":
                case "insert":
                case "1":
                    if (front == array.length) {
                        front = 0;
                    }
                    if (array[front] != null) {
                        System.out.println("\nSorry,The Queue is Full!\n");
                        break;
                    } else {
                        System.out.print("\nInsert a number: ");
                        array[front] = gg.next();
                        System.out.println(array[front] + " \nis inserted in the container.\n");
                        front++;
                    }

                    break;
                case "Delete":
                case "delete":
                case "2":
                    if (rear == array.length) {
                        rear = 0;
                    }
                    if (array[rear] == null) {
                        System.out.println("Sorry, the Queue is empty.\n");
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
      
        System.out.println("\nQueue:");
        displayArray(array, rear);
        System.out.println();
    }

    //Displaying Methods
    static void displayArray(String array[], int arrayStart) {
        int count = arrayStart;
        while (count < array.length) {
            if (array[count] == null) {
                System.out.print("\t");
            } else {
                System.out.print(array[count] + "\t");
            }
            count++;
        }
        count = 0;
        while (count < arrayStart) {
            if (array[count] == null) {
                System.out.print("\t");
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
