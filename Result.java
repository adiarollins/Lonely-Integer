import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.Scanner;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyInteger(int arr[]) {
    // Write your code here
    //Create a arr that hold all unique values (2ndarr)
        int secondArr[] = new int[(arr.length + 1)/2];
        int secondArrTracker = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean present = false;
            for (int k = 0; k < secondArr.length; k++) {
                if (arr[i] == secondArr[k]) {
                    present = true;
                } 
                
            }
            
            if (!present) {
                secondArr[secondArrTracker] = arr[i];
                secondArrTracker = secondArrTracker + 1;
            }
        }

        int thirdArr[] = new int[secondArr.length];
//Create arr that tracks how many times a number was present (3rdarr)
        for (int i = 0; i < secondArr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (secondArr[i] == arr[j]) {
                    thirdArr[i] = thirdArr[i]+1; 
                }
            }
        }
//Find which number only appears once and returns the number 
        int lonelyInt = 0;
        for (int i = 0; i < thirdArr.length; i++) {
            if (thirdArr[i] == 1) {
                lonelyInt = i;
            }
        } 
        return secondArr[lonelyInt];
    }

}
