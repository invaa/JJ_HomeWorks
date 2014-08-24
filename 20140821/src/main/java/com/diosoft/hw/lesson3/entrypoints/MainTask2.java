package main.java.com.diosoft.hw.lesson3.entrypoints;

/**
 * Home work, Task 2: Two POJO arrays and comparation
 *
 * @author a.zamkovyi
 * @version 0.0.1
 */

import main.java.com.diosoft.hw.lesson3.model.Student;

import java.util.Arrays;

public class MainTask2 {

     public static void main(String [] args) {

         //Input data

         //SubTask1
         Student[] leftArray = { new Student("Alex", "Veins", 32), new Student("Chuck", "Norris", 72) };
         Student[] rightArray = { new Student("Alex", "Veins", 32), new Student("Chuck", "Norris", 72) };

         System.out.println("Left array: " + Arrays.toString(leftArray));
         System.out.println("Right array: " + Arrays.toString(rightArray));

         //SubTask2
         System.out.println("Arrays are equals?: " + Arrays.equals(leftArray, rightArray));
     }

}
