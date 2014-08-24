package test.java;

/**
 * Test cases for <code>ObjectArrayUtil</code> class
 * Home work, Task 3 tests
 *
 * @author a.zamkovyi
 * @version 0.0.1
 */

import main.java.com.diosoft.hw.lesson3.model.Student;
import main.java.com.diosoft.hw.lesson3.model.StudentAgeComparator;
import main.java.com.diosoft.hw.lesson3.util.ObjectArrayUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Lesson3ObjectArrayUtilTests {

    @Test
    public void testLeftUnionGivesFirstArrayAndAndSecondArrayElementsFirstArrayContainsWithAgeComparator() {

        StudentAgeComparator comparator = new StudentAgeComparator();

        Student[] firstArray = {
              new Student("Alex", "Veins", 32),
              new Student("Chuck", "Norris", 77),
              new Student("Steven", "Seagal", 60),
              new Student("Alex", "Veins", 32),
              new Student("Robert", "DeNiro", 50)
        };
        Student[] secondArray = {
              new Student("Steven", "Seagal", 60),
              new Student("Robert", "DeNiro", 50),
              new Student("Bruce", "Lee", 80),
        };
        Student[] testResultArray = {
              new Student("Alex", "Veins", 32),
              new Student("Chuck", "Norris", 77),
              new Student("Steven", "Seagal", 60),
              new Student("Alex", "Veins", 32),
              new Student("Robert", "DeNiro", 50),
              new Student("Steven", "Seagal", 60),
              new Student("Robert", "DeNiro", 50)
        };

        Object[] resultArray = ObjectArrayUtil.leftUnion(firstArray, secondArray);

        Arrays.sort(testResultArray, comparator);
        Arrays.sort(resultArray, comparator);

        Assert.assertArrayEquals(testResultArray, resultArray);
    }

    @Test
    public void testMergeAndGroupGivesFirstAndSecondArrayUniqueElementsWithAgeComparator() {

        StudentAgeComparator comparator = new StudentAgeComparator();

        Student[] firstArray = {
                new Student("Alex", "Veins", 32),
                new Student("Chuck", "Norris", 77),
                new Student("Steven", "Seagal", 60),
                new Student("Alex", "Veins", 32),
                new Student("Robert", "DeNiro", 50)
        };
        Student[] secondArray = {
                new Student("Steven", "Seagal", 60),
                new Student("Robert", "DeNiro", 50),
                new Student("Bruce", "Lee", 80),
        };
        Student[] testResultArray = {
                new Student("Alex", "Veins", 32),
                new Student("Chuck", "Norris", 77),
                new Student("Steven", "Seagal", 60),
                new Student("Robert", "DeNiro", 50),
                new Student("Bruce", "Lee", 80)
        };

        Object[] resultArray = ObjectArrayUtil.mergeUnique(firstArray, secondArray, comparator);

        Arrays.sort(testResultArray, comparator);
        Arrays.sort(resultArray, comparator);

        Assert.assertArrayEquals(testResultArray, resultArray);
    }

    @Test
    public void testInnerJoinReturnsOnlyUniqueElementsBothArraysContainWithAgeComparator() {

        StudentAgeComparator comparator = new StudentAgeComparator();

        Student[] firstArray = {
                new Student("Alex", "Veins", 32),
                new Student("Chuck", "Norris", 77),
                new Student("Steven", "Seagal", 60),
                new Student("Alex", "Veins", 32),
                new Student("Robert", "DeNiro", 50)
        };
        Student[] secondArray = {
                new Student("Steven", "Seagal", 60),
                new Student("Robert", "DeNiro", 50),
                new Student("Bruce", "Lee", 80),
        };
        Student[] testResultArray = {
                new Student("Steven", "Seagal", 60),
                new Student("Robert", "DeNiro", 50)
        };

        Object[] resultArray = ObjectArrayUtil.innerJoin(firstArray, secondArray, comparator);

        Arrays.sort(testResultArray, comparator);
        Arrays.sort(resultArray, comparator);

        Assert.assertArrayEquals(testResultArray, resultArray);
    }

    @Test
    public void testOuterJoinReturnsOnlyUniqueElementsBothArraysDiffersWithAgeComparator() {

        StudentAgeComparator comparator = new StudentAgeComparator();

        Student[] firstArray = {
                new Student("Alex", "Veins", 32),
                new Student("Chuck", "Norris", 77),
                new Student("Steven", "Seagal", 60),
                new Student("Alex", "Veins", 32),
                new Student("Robert", "DeNiro", 50)
        };
        Student[] secondArray = {
                new Student("Steven", "Seagal", 60),
                new Student("Robert", "DeNiro", 50),
                new Student("Bruce", "Lee", 80),
        };
        Student[] testResultArray = {
                new Student("Alex", "Veins", 32),
                new Student("Chuck", "Norris", 77),
                new Student("Bruce", "Lee", 80)
        };

        Object[] resultArray = ObjectArrayUtil.outerJoin(firstArray, secondArray, comparator);

        Arrays.sort(testResultArray, comparator);
        Arrays.sort(resultArray, comparator);

        Assert.assertArrayEquals(testResultArray, resultArray);
    }
}
