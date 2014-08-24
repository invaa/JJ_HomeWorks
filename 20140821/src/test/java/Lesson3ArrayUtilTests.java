package test.java;

/**
 * Test cases for <code>ArrayUtil</code> class
 *
 * @author a.zamkovyi
 * @version 0.0.1
 */

import main.java.com.diosoft.hw.lesson3.util.ArrayUtil;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Lesson3ArrayUtilTests {

    @Test
    public void testLeftUnionGivesFirstArrayAndAndSecondArrayElementsFirstArrayContains() {

        int[] firstArray = {1,5,4,23,65,32,72};
        int[] secondArray = {3,5,24,4,1,2,34,45,32,5};

        int[] testResultArray = {1, 5, 4, 23, 65, 32, 72, 5, 4, 1, 32, 5};

        Assert.assertArrayEquals(testResultArray, ArrayUtil.leftUnion(firstArray, secondArray));
    }

    @Test
    public void testMergeAndGroupGivesFirstAndSecondArrayUniqueElements() {

        int[] firstArray = {1,5,4,23,65,32,72};
        int[] secondArray = {3,5,24,4,1,2,34,45,32,5};

        int[] testResultArray = {1, 2, 3, 4, 5, 23, 24, 32, 34, 45, 65, 72};

        assertArrayEquals(testResultArray, ArrayUtil.mergeUnique(firstArray, secondArray));
    }

    @Test
    public void testInnerJoinReturnsOnlyUniqueElementsBothArraysContain() {

        int[] firstArray = { 1, 5, 4, 23, 65, 32, 78 };
        int[] secondArray = { 3, 5, 24, 4, 1, 2, 34, 45, 32, 5 };

        int[] testResultArray = { 1, 4, 5, 32 };

        assertArrayEquals(testResultArray, ArrayUtil.innerJoin(firstArray, secondArray));
    }

    @Test
    public void testOuterJoinReturnsOnlyUniqueElementsBothArraysDiffers() {

        int[] firstArray = { 1, 5, 4, 23, 65, 32, 78 };
        int[] secondArray = { 3, 5, 24, 4, 1, 2, 34, 45, 32, 5 };

        int[] testResultArray = { 2, 3, 23, 24, 34, 45, 65, 78 };

        assertArrayEquals(testResultArray, ArrayUtil.outerJoin(firstArray, secondArray));
    }
}
