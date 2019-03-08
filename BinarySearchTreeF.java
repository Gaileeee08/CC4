/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreef;
import java.util.Scanner;
/**
 *
 * @author CC4-13
 */
public class BinarySearchTreeF {

    /**
     * @param args the command line arguments
     */
     static Scanner gg = new Scanner(System.in);
    public static void main(String[] args) {
      String array [];
      boolean cycle = true;
      while(true){
          try {
              System.out.println("Enter a number:");
              int node= gg.nextInt();
              array = new String[node];
              break;
          } catch(Exception g){
              gg.next();
              System.out.println("Invalid Input!, Please Enter an Integer Value.");
          }
      }
     while(cycle){
         System.out.println("Insert or Delete");
         
     }        
     
        
        
    }
    
}
