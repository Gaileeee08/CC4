

import java.util.*;



public class RecordsG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner aa = new Scanner(System.in);
        
        int input, answer = 0,totalSize = 0,c = 1;
        double bb = 1,total = 0,totAdd = 0;
        
        
        String tempStr = "";
        System.out.print("Enter Dimension: ");
        
        
        input = aa.nextInt();
        int[] dimension = new int[input];
        int[] index = new int[input];
        
        
        for(int a = 0; a < input; a++){
            System.out.print("Upper Bound "+(a+1)+": ");
            dimension[a] = aa.nextInt();
            bb = bb * dimension[a];
        }
        System.out.print("\nNumber of Fields in each Record: ");
        
        
        int fields = aa.nextInt();
        int[] array = new int[fields];
        for(int l = 0; l < fields; l++){
            System.out.print("FIELD "+(l+1)+" NAME: ");
            String field = aa.next();
            System.out.print("FIELD "+(l+1)+" LENGTH: ");
            int length = aa.nextInt();
            System.out.print("FIELD "+(l+1)+" DATATYPE: ");
            String data = aa.next();
            tempStr = data;
        
        for(int v = 1; v < 2; v++){
            if(tempStr.equals("char")){
                answer = length*1;
            }
            if(tempStr.equals("int")){
                answer = length*2;
            }
            if(tempStr.equals("float")){
                answer = length*4;
            }
            if(tempStr.equals("double")){
                answer = length*8;
            }
            
        }
        array[l] = answer;
        System.out.println("\nData Field "+field+" is "+array[l]+" bytes in size\n"); 
        }
        System.out.print("Enter Starting Address: ");
        int start = aa.nextInt();
        
        for(int i = 0; i < fields; i++){
            totalSize = totalSize+array[i];
        }
        System.out.println("Esize per record: "+totalSize);
        System.out.println("Your database can hold "+bb+" records.");
        System.out.println("Your database consumes "+(totalSize*bb)+" bytes of memory space.");
        System.out.println("\nSEARCH FOR THE ADDRESS OF A FIELD IN A SPECIFIC RECORD FROM THE DATABASE\n");
        
        for(int n = 0; n < input; n++){
        System.out.print("Input record search index at dimension "+(n+1)+" :");
        index[n] = aa.nextInt();
        }
        System.out.print("Input Field Name to search in the record: ");
        String fieldN = aa.next();
        for(int g = 0; g < input;g++){
            total += index[g]; 
      
          for(int y = c; y < input; y++){
             total = total*dimension[y]; 
            }
             c++;
             totAdd += total;
           if(c == input+1){
           System.out.println("The address of this record's "+fieldN+" is located at: "
                            +((start+(totAdd*totalSize))-answer));
          }
        }
   
    }
}
        
        
        
        
        
  