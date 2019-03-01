/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InfixToPostfix;

import java.util.Stack;
import java.util.Scanner;

public class InfixToPostfix {
    
    public static void main(String args[]){
        
//        String token = "8/2*3-6+(6-4+3%2^2)";
//        &A+B-C*D*@(E+F-G*H^I^J)+L/M+(N*O/P+(Q^R^S^T))+U#
//        8/2*3-6+(6-4+3%2^2)#
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Infix: ");
        String token = input.nextLine();
        Stack <String> stacks = new Stack<>();
        
        boolean compute = true, flush = false; boolean e = false;
        int icpX = 0, ispY = 0, outputCounter = 0, i, j;
        
        String check = Character.toString(token.charAt(token.length()-1));
        if (!"#".equals(check)) {
            token = token + "#";  
        }
        
       
        System.out.println("\nToken\tStacks\t\tOutput");
        
        stacks.push("#");
        
        String checks = Character.toString(token.charAt(0));
        
        if ("E".equalsIgnoreCase(checks)) {
            token = token.substring(3, token.length());
            e = true;
        }
        
        String output[] = new String[token.length()];
        
        for (i = 0; i < token.length(); i++) {
            
            String x = Character.toString(token.charAt(i));
            System.out.print(x+"\t");
            
            if (")".equals(x)) {
                compute = false;
                flush = true;
            } else if("^".equals(x)){
                icpX = 4;
            } else if("*".equals(x) || "/".equals(x) || "%".equals(x)){
                icpX = 2;
            } else if("+".equals(x) || "-".equals(x)){
                icpX = 1;
            } else if("(".equals(x)){
                icpX = 4;
            } else if("#".equals(x)){
                if (!stacks.empty()) {
                    while(true){
                        if ("#".equals(stacks.peek())) {
                            break;
                        } else {
                            output[outputCounter] = stacks.pop();
                            outputCounter++;
                        }
                    }
                }
                compute = false;
            } else if("!".equals(x) || "@".equals(x) || "$".equals(x) || "&".equals(x) || ";".equals(x) || ":".equals(x)
                   || ".".equals(x) || "`".equals(x) || "~".equals(x) || "<".equals(x) || ">".equals(x) || "?".equals(x)
                   || "\"".equals(x)|| "[".equals(x) || "]".equals(x) || "{".equals(x) || "}".equals(x) || "\\".equals(x)
                   || "|".equals(x) || "\'".equals(x)|| "=".equals(x)){
                
                output[outputCounter] = x;
                outputCounter++;
                compute = false;
            } else {
                compute = false;
                output[outputCounter] = x;
                outputCounter++;
                compute = false;
            }
            
            if (compute) {
                
                while(true){
                    if (!stacks.isEmpty()) {
                        if("^".equals(stacks.peek())){
                            ispY = 3;
                        } else if("*".equals(stacks.peek()) || "/".equals(stacks.peek()) || "%".equals(stacks.peek())){
                            ispY = 2;
                        } else if("+".equals(stacks.peek()) || "-".equals(stacks.peek())){
                            ispY = 1;
                        } else if("(".equals(stacks.peek())){
                            ispY = 0;
                        } else {
                            ispY = 0;
                        }
                        
                    } else {
                        ispY = 0;
                    }
                    
                    if (ispY >= icpX && !stacks.empty()) {
                        output[outputCounter] = stacks.pop();
                        outputCounter++;
                        
                    } else {
                        stacks.push(x);
                        break;
                    }
                }
                
            } else if(flush && !stacks.empty()){
                
                while(true){
                    if ("(".equals(stacks.peek()) && !stacks.empty()) {
                        stacks.pop();
                        break;
                    } else {
                        output[outputCounter] = stacks.pop();
                        outputCounter++;
                    }
                }
            }
            
            String n = stacks.toString().replaceAll(",", "").replaceAll(" ","");
            System.out.print(n.substring(1,n.length()-1));
            
//            if (stacks.size() <= 3) {
//                System.out.print("\t\t\t\t");
//            } else if(stacks.size() <= 5){
//                System.out.print("\t\t\t\t");
//            } else if (stacks.size() <= 8){
//                System.out.print("\t\t\t");
//            } else if (stacks.size() <= 11){
//                System.out.print("\t\t");
//            } else {
//                System.out.print("\t");
//            } if (stacks.size() <= 11)

            if (stacks.size() <= 7) {
                System.out.print("\t\t");
            } else {
                System.out.print("\t");
            }

            for (j = 0; j <= i; j++) {
                if (output[j] != null) {
                    System.out.print(output[j]);
                }
            } 

            System.out.println("");
            compute = true;
            flush = false;
        }
        System.out.println("\nInfix: " + token);
        System.out.print("Postfix (Converted): ");
        
        if (output[0] == null) {
            System.out.println("None");
        } else if (e){
            System.out.print("E = ");
            for (j = 0; j < output.length; j++) {
                if (output[j] != null) {
                    System.out.print(output[j]);
                } else if(" ".equals(output[j])) {
                    
                }
            }
            System.out.println("");
        } else {    
            for (j = 0; j < output.length; j++) {
                if (output[j] != null) {
                    System.out.print(output[j]);
                } else if(" ".equals(output[j])) {
                    
                }
            }
            System.out.println("");
        }
        
    }
    
}




