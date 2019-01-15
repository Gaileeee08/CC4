/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertion;

/**
 *
 * @author CC4-5
 */
import java.util.*;
public class Insertion {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        // TODO code application logic here
      
    int a,size;
    Scanner in = new Scanner(System.in);
       
    System.out.println("ENTER SIZE: ");
    size = in.nextInt();
    int array[] = new int[size]; 
    
    System.out.println("ENTER INTEGERS: ");
    for (a = 0; a < size; a ++)
        array[a] = in.nextInt();

        
    for(int i=0;i<array.length;i++){
            int j = i;

        while(j>0){
        if(array[j-1] > array[j]){
            int temp = array[j-1];
            array[j-1] = array[j];
            array[j] = temp;
        }    
        else{
        break;}
            j--;
        }
    }
    for(int x:array){
        System.out.print(x);
        System.out.print(", ");
       }
    }
 }
    

