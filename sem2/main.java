package sem2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        // int[] arr = new int[10];
        // System.out.println("Укажите индекс элемента массива, B который хотите записать значение");
        
        // try {
        //     int index = scanner.nextInt();
        //     if (index >= 0 && index <= arr.length) {
        //         arr[index] = 1;
                
        //     } else {
                
        //         System.out.println("Указан индекс за пределами массива");
        //     }
        // } catch (InputMismatchException e) {
        //     System.out.println("Веден не индекс");
        // } 
        // String[][] arr = {
        //     {"1", "hdh", "rdr", "2", "t", "rr"},
        //     {"1", "hdh", "rdr", "2", "t", "rr"},
        //     {"1", null , "rdr", "2", "t", "rr"},
        //     {"1", "hdh", "rdr", "2", "t", "rr"},
        //     {"45", "hdh", "rdr", "t"}
        // };
        // System.out.println(sum2d(arr));
        changeAndWrite(readerFile());

    }
     
    
    // public static int sum2d(String[][] arr) {
    //     int sum = 0;
    //     if(arr == null){
    //         throw new RuntimeException("Array is null");
    //     }
        
    //     for (int i = 0; i < arr.length; i++) {
    //         if(arr[i].length < 5){
    //             throw new RuntimeException("too small");
    //         }
    //         for (int j = 0; j <5; j++) {
    //             try {
    //                 int val = Integer.parseInt(arr[i][j]);
    //                 sum += val;
    //             } catch (NumberFormatException e){
    //                 System.out.println("NumberFormatException");


    //             }
                
        
    //         }
         
    //     }
        
    //     return sum;
    // }

    
    public static Map<String, String> readerFile() throws IOException {
       
        String filePath = "file.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        Map<String, String> values = new HashMap<>();

        while (true) {
            String temp = bufferedReader.readLine();
            if(temp == null){
                break;

            }
            String[] tempKeyVal = temp.split("=");
            values.put(tempKeyVal[0], tempKeyVal[1]);
            
            

        }
        bufferedReader.close();
        return values;

    }

    public static void changeAndWrite(Map<String, String> values) throws IOException{
        // values.forEach((key, value) -> {
        //     if(value.equals("?"))
        //         value = Integer.toString(key.length());
        //         });
        for (String  key: values.keySet()) {
            String value = values.get(key);
            if(value.equals("?"))
                values.put(key, Integer.toString(key.length()));  

        }
        for (String item : values.values()){
            Integer.parseInt(item);
        }
        
         
        FileWriter fw = new FileWriter("file.txt");
        values.forEach((key, value) -> {
            try{
                fw.write(key + "=" + value + "\n");
            
            } catch(IOException e){
                throw new RuntimeException(e);            
            } 
            

        });
        try {
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

