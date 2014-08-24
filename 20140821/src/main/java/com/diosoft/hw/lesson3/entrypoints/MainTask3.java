package main.java.com.diosoft.hw.lesson3.entrypoints;

/**
 * Home work, Task 3: Merge, Inner and Outer Join two Arrays of POJOs
 *
 * @author a.zamkovyi
 * @version 0.0.1
 */

import main.java.com.diosoft.hw.lesson3.model.Student;
import main.java.com.diosoft.hw.lesson3.model.StudentAgeComparator;
import main.java.com.diosoft.hw.lesson3.util.ObjectArrayUtil;

import java.util.Arrays;

public class MainTask3 {

     public static void main(String [] args) {

         //Input data

         Student[] leftArray = { new Student("Alex", "Veins", 32), new Student("Chuck", "Norris", 72) };
         Student[] rightArray = { new Student("Alex", "Veins", 32), new Student("Steven", "Seagal", 60) };
         StudentAgeComparator comparator = new StudentAgeComparator();

         System.out.println("Left array: " + Arrays.toString(leftArray));
         System.out.println("Right array: " + Arrays.toString(rightArray));

         //SubTask1
         //Merge without duplicates
         System.out.println("Result of merge:" + Arrays.toString(ObjectArrayUtil.mergeUnique(leftArray, rightArray, comparator)));

         //SubTask2
         //Inner joins two arrays
         System.out.println("Result of inner-join:" + Arrays.toString(ObjectArrayUtil.innerJoin(leftArray, rightArray, comparator)));

         //SubTask3
         //Outer joins two arrays
         System.out.println("Result of outer-join:" + Arrays.toString(ObjectArrayUtil.outerJoin(leftArray, rightArray, comparator)));

     }

}
