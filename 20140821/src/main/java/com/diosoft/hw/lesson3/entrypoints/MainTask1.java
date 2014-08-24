package main.java.com.diosoft.hw.lesson3.entrypoints;

/**
 * Home work, Task 1: "Arrays Intro"
 *
 * @author a.zamkovyi
 * @version 0.0.1
 */

import main.java.com.diosoft.hw.lesson3.util.ArrayUtil;
import java.util.Arrays;

public class MainTask1 {

     public static void main(String [] args) {

         //Input data
         int[] leftArray = { 1, 5, 4, 23, 65, 32, 72 };
         int[] rightArray = { 3, 5, 24, 4, 1, 2, 34, 45, 32, 5 };
         System.out.println("Left array:" + Arrays.toString(leftArray));
         System.out.println("Right array:" + Arrays.toString(rightArray));

         //SubTask1
         //Merge without duplicates
         System.out.println("Result of merge:" + Arrays.toString(ArrayUtil.mergeUnique(leftArray, rightArray)));

         //SubTask2
         //Inner joins two arrays
         System.out.println("Result of inner-join:" + Arrays.toString(ArrayUtil.innerJoin(leftArray, rightArray)));

         //SubTask3
         //Outer joins two arrays
         System.out.println("Result of outer-join:" + Arrays.toString(ArrayUtil.outerJoin(leftArray, rightArray)));

     }

}
