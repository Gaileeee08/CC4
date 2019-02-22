import java.util.Scanner;

/**
 *
 * @author CC4-13
 */
public class Adressing {
    public static void main(String[] args) {
       
        
        Scanner gg = new Scanner(System.in);
        int input,g = 0,y = 1;
        double totel = 1,index = 0,total = 0;
        System.out.print("Enter Array Dimension: ");
        
        input = gg.nextInt();
        int[] dimension = new int[input];
        int[] array = new int[input];
        
        for(int a = 0; a < input; a++){
          System.out.print("Enter UB "+(a+1)+": ");
          dimension[a] = gg.nextInt();
          totel *= dimension[a];
        }
        System.out.print("Enter Starting Address: ");
        int start = gg.nextInt();
        System.out.print("Enter esize: ");
        
        int esize = gg.nextInt();
        System.out.print("Total number of Elements in the Array: "+totel);
        System.out.println("\n\n***SEARCH FOR MEMORY ADDRESS OF THE ith ELEMENT***\n");
        
        for(int l = 0; l < input; l++){
            do{
                g = 0;
             System.out.print("Input Search Index at Dimension "+(l+1)+" : ");
             array[l] = gg.nextInt();
             if(array[l] > dimension[l] || array[l] < 0){
             System.out.println("Error! Out of Bounds Dimension!");
             g = 1;
             }
            }while(g == 1);
        }
        
        for(int v = 0; v < input; v++){
           index = array[v];
           for(int i = y; i < input; i++){
           index = index * dimension[i];
           }
           y++;
           total += index; 
          
           System.out.print("MEMORY ADDRESS OF: "+ (start + total*esize));
           System.out.println("\nDone.");
           }
           
    
    
    }
}
