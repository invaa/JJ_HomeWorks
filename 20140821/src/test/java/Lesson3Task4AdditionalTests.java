package test.java;

/**
 * Additional test cases for <code>ArrayUtil</code> class
 * Home work, Task 4 tests
 *
 * @author a.zamkovyi
 * @version 0.0.1
 */

/*
Дополнительные сценарии поведения:
- пустой первый массив
- пустой второй массив
- первый массив - null
- второй массив - null
- (@excluded) большой второй массив (size IInteger.MAX_VALUE) ? 8gb*3 needed + 8gb for test result
- (@excluded) большой первый массив (size IInteger.MAX_VALUE) ? 8gb*3 needed + 8gb for test result
- тест с дубликатами
 */

import main.java.com.diosoft.hw.lesson3.util.ArrayUtil;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

// Note : good tests
public class Lesson3Task4AdditionalTests {

    // BEGINNING OF LEFT UNION TESTS

    @Test
    public void testLeftUnionGivesFirstArrayAndAndSecondArrayElementsFirstArrayContainsWhenFirstArrayIsEmpty() {

        int[] firstArray = { };
        int[] secondArray = {3,5,24,4,1,2,34,45,32,5};

        int[] testResultArray = { };

        Assert.assertArrayEquals(testResultArray, ArrayUtil.leftUnion(firstArray, secondArray));
    }

    @Test
    public void testLeftUnionGivesFirstArrayAndAndSecondArrayElementsFirstArrayContainsWhenSecondArrayIsEmpty() {

        int[] firstArray = { 1,5,4,23,65,32,72 };
        int[] secondArray = { };

        int[] testResultArray = { 1,5,4,23,65,32,72 };

        Assert.assertArrayEquals(testResultArray, ArrayUtil.leftUnion(firstArray, secondArray));
    }

    @Test
    public void testLeftUnionGivesFirstArrayAndAndSecondArrayElementsFirstArrayContainsWhenFirstArrayIsNull() {

        int[] firstArray = null;
        int[] secondArray = {3,5,24,4,1,2,34,45,32,5};

        int[] testResultArray = { };

        Assert.assertArrayEquals(testResultArray, ArrayUtil.leftUnion(firstArray, secondArray));
    }

    @Test
    public void testLeftUnionGivesFirstArrayAndAndSecondArrayElementsFirstArrayContainsWhenSecondArrayIsNull() {

        int[] firstArray = { 1,5,4,23,65,32,72 };
        int[] secondArray = null;

        int[] testResultArray = { 1,5,4,23,65,32,72 };

        Assert.assertArrayEquals(testResultArray, ArrayUtil.leftUnion(firstArray, secondArray));
    }

    @Test
     public void testLeftUnionGivesFirstArrayAndAndSecondArrayElementsFirstArrayContainsWithDuplicates() {

        int[] firstArray = { 1,5,4,23,65,32,72 };
        int[] secondArray = { 1,5,4,23,65,32,72 };

        int[] testResultArray = { 1,5,4,23,65,32,72,1,5,4,23,65,32,72 };

        Assert.assertArrayEquals(testResultArray, ArrayUtil.leftUnion(firstArray, secondArray));
    }

    // END OF LEFT UNION TESTS

    // BEGINNING OF MERGE TESTS

    @Test
    public void testMergeAndGroupGivesFirstAndSecondArrayUniqueElementsWhenFirstArrayIsEmpty() {

        int[] firstArray = { };
        int[] secondArray = {3,5,24,4,1,2,34,45,32,5};

        int[] testResultArray = { 1, 2, 3, 4, 5, 24, 32, 34, 45};

        Assert.assertArrayEquals(testResultArray, ArrayUtil.mergeUnique(firstArray, secondArray));
    }

    @Test
    public void testMergeAndGroupGivesFirstAndSecondArrayUniqueElementsWhenSecondArrayIsEmpty() {

        int[] firstArray = { 1,5,4,23,65,32,72 };
        int[] secondArray = { };

        int[] testResultArray = { 1, 4, 5, 23, 32, 65, 72 };

        Assert.assertArrayEquals(testResultArray, ArrayUtil.mergeUnique(firstArray, secondArray));
    }

    @Test
    public void testMergeAndGroupGivesFirstAndSecondArrayUniqueElementsWhenFirstArrayIsNull() {

        int[] firstArray = null;
        int[] secondArray = {3,5,24,4,1,2,34,45,32,5};

        int[] testResultArray = { 1, 2, 3, 4, 5, 24, 32, 34, 45};

        Assert.assertArrayEquals(testResultArray, ArrayUtil.mergeUnique(firstArray, secondArray));
    }

    @Test
    public void testMergeAndGroupGivesFirstAndSecondArrayUniqueElementsWhenSecondArrayIsNull() {

        int[] firstArray = { 1,5,4,23,65,32,72 };
        int[] secondArray = null;

        int[] testResultArray = { 1, 4, 5, 23, 32, 65, 72 };

        Assert.assertArrayEquals(testResultArray, ArrayUtil.mergeUnique(firstArray, secondArray));
    }

    @Test
    public void testMergeAndGroupGivesFirstAndSecondArrayUniqueElementsWithDuplicates() {

        int[] firstArray = { 1,5,4,23,65,32,72 };
        int[] secondArray = { 1,5,4,23,65,32,72 };

        int[] testResultArray = { 1, 4, 5, 23, 32, 65, 72 };

        Assert.assertArrayEquals(testResultArray, ArrayUtil.mergeUnique(firstArray, secondArray));
    }

    // END OF MERGE TESTS

    // BEGINNING OF INNER JOIN TESTS

    @Test
    public void testInnerJoinReturnsOnlyUniqueElementsBothArraysContainWhenFirstArrayIsEmpty() {

        int[] firstArray = { };
        int[] secondArray = { 3, 5, 24, 4, 1, 2, 34, 45, 32, 5 };

        int[] testResultArray = { };

        assertArrayEquals(testResultArray, ArrayUtil.innerJoin(firstArray, secondArray));
    }

    @Test
    public void testInnerJoinReturnsOnlyUniqueElementsBothArraysContainWhenSecondArrayIsEmpty() {

        int[] firstArray = { 1,5,4,23,65,32,72 };
        int[] secondArray = { };

        int[] testResultArray = { };

        Assert.assertArrayEquals(testResultArray, ArrayUtil.innerJoin(firstArray, secondArray));
    }

    @Test
    public void testInnerJoinReturnsOnlyUniqueElementsBothArraysContainWhenFirstArrayIsNull() {

        int[] firstArray = null;
        int[] secondArray = {3,5,24,4,1,2,34,45,32,5};

        int[] testResultArray = { };

        Assert.assertArrayEquals(testResultArray, ArrayUtil.innerJoin(firstArray, secondArray));
    }

    @Test
    public void testInnerJoinReturnsOnlyUniqueElementsBothArraysContainWhenSecondArrayIsNull() {

        int[] firstArray = { 1,5,4,23,65,32,72 };
        int[] secondArray = null;

        int[] testResultArray = { };

        Assert.assertArrayEquals(testResultArray, ArrayUtil.innerJoin(firstArray, secondArray));
    }

    @Test
    public void testInnerJoinReturnsOnlyUniqueElementsBothArraysContainWithDuplicates() {

        int[] firstArray = { 1,5,4,23,65,32,72 };
        int[] secondArray = { 1,5,4,23,65,32,72 };

        int[] testResultArray = { 1, 4, 5, 23, 32, 65, 72 };

        int[] returnedValue = ArrayUtil.innerJoin(firstArray, secondArray);

        Assert.assertArrayEquals(testResultArray, returnedValue);
    }
    //local code review (vtegza): no need for comments, the method names tell everything @ 31.08.14
    // END OF INNER JOIN TESTS

    // BEGINNING OF OUTER JOIN TESTS

    @Test
    public void testOuterJoinReturnsOnlyUniqueElementsBothArraysDiffersWhenFirstArrayIsEmpty() {

        int[] firstArray = { };
        int[] secondArray = { 3, 5, 24, 4, 1, 2, 34, 45, 32, 5 };

        int[] testResultArray = { 1, 2, 3, 4, 5, 24, 32, 34, 45 };

        assertArrayEquals(testResultArray, ArrayUtil.outerJoin(firstArray, secondArray));
    }

    @Test
    public void testOuterJoinReturnsOnlyUniqueElementsBothArraysDiffersWhenSecondArrayIsEmpty() {

        int[] firstArray = { 1, 5, 4, 23, 65, 32, 72 };
        int[] secondArray = { };

        int[] testResultArray = { 1, 4, 5, 23, 32, 65, 72 };

        Assert.assertArrayEquals(testResultArray, ArrayUtil.outerJoin(firstArray, secondArray));
    }

    @Test
    public void testOuterJoinReturnsOnlyUniqueElementsBothArraysDiffersWhenFirstArrayIsNull() {

        int[] firstArray = null;
        int[] secondArray = { 3, 5, 24, 4, 1, 2, 34, 45, 32, 5 };

        int[] testResultArray = { 1, 2, 3, 4, 5, 24, 32, 34, 45 };

        Assert.assertArrayEquals(testResultArray, ArrayUtil.outerJoin(firstArray, secondArray));
    }

    @Test
    public void testOuterJoinReturnsOnlyUniqueElementsBothArraysDiffersWhenSecondArrayIsNull() {

        int[] firstArray = { 1, 5, 4, 23, 65, 32, 72 };
        int[] secondArray = null;

        int[] testResultArray = { 1, 4, 5, 23, 32, 65, 72 };

        Assert.assertArrayEquals(testResultArray, ArrayUtil.outerJoin(firstArray, secondArray));
    }

    @Test
    public void testOuterJoinReturnsOnlyUniqueElementsBothArraysDiffersWithDuplicates() {

        int[] firstArray = { 1, 5, 4, 23, 65, 32, 72 };
        int[] secondArray = { 1, 5, 4, 23, 65, 32, 72 };

        int[] testResultArray = { };

        Assert.assertArrayEquals(testResultArray, ArrayUtil.outerJoin(firstArray, secondArray));
    }

    // END OF OUTER JOIN TESTS

}
