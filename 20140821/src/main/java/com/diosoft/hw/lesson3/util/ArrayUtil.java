package main.java.com.diosoft.hw.lesson3.util;

/**
 * Array utilities class for arrays of integers
 *
 * @author a.zamkovyi
 * @version 0.0.1
 */

import java.util.Arrays;

public class ArrayUtil {

    private static int[] getSafeArray(int[] inputArray) {
        int[] array = null;
        if (inputArray == null) {
            array = new int[0];
        } else {
            array = inputArray;
        } //end if
        return array;
    }

    /** Merges two arrays and returns only unique elements, the result is sorted
     *
     * <pre>
     *     Given: {1,5,4,23,65,32,72} and {3,5,24,4,1,2,34,45,32,5}
     *     Result: {1, 2, 3, 4, 5, 23, 24, 32, 34, 45, 65, 72}
     * </pre>
     *
     * @param inputLeftArray left array to merge
     * @param inputRightArray right array to merge
     * @returns array
     */
    public static int[] mergeUnique(final int[] inputLeftArray, final int[] inputRightArray) {
        int[] leftArray = getSafeArray(inputLeftArray);
        int[] rightArray = getSafeArray(inputRightArray);

        int resultMaxLength = leftArray.length + rightArray.length;

        int[] resultArray = Arrays.copyOf(leftArray, resultMaxLength);
        System.arraycopy(rightArray,0,resultArray,leftArray.length,rightArray.length);

        return sortAndGroupArray(resultArray);
    }

    /** Returns sorted array of unique elements
     *
     * <pre>
     *     Given: {1,5,4,23,65,32,72, 3,5,24,4,1,2,34,45,32,5}
     *     Result: {1, 2, 3, 4, 5, 23, 24, 32, 34, 45, 65, 72}
     * </pre>
     *
     * @param resultArray array to be sorted
     * @returns array
     */
    public static int[] sortAndGroupArray(final int[] resultArray) {

        assert resultArray != null;

        int resultMaxLength = resultArray.length;

        //guardian block
        if (resultMaxLength < 2) return resultArray;

        Arrays.sort(resultArray);

        int grouppedResultArrayLength = getMergedAndGrouppedArrayLength(resultMaxLength, resultArray);

        int previousValue;
        int j = 0;
        previousValue = resultArray[0];
        int[] grouppedResultArray = new int[grouppedResultArrayLength];
        grouppedResultArray[j] = previousValue;
        for (int i = 1; i < resultMaxLength; i++) {
            int currentValue = resultArray[i];

            if (currentValue != previousValue) {
                j++;
                grouppedResultArray[j] = currentValue;
            } //end if
            previousValue = currentValue;
        } //end for

        return grouppedResultArray;
    }

    private static int getMergedAndGrouppedArrayLength(int resultMaxLength, final int[] resultArray) {

        assert resultArray != null;

        int previousValue = resultArray[0];

        int grouppedResultArrayLength = 1;

        for (int i = 1; i < resultMaxLength; i++) {
            int currentValue = resultArray[i];

            if (currentValue != previousValue) {
                grouppedResultArrayLength++;
            } //end if
            previousValue = currentValue;
        } //end for
        return grouppedResultArrayLength;
    }

    /** Unions two arrays by copying first array elements and adding
     * the second array element which the first array contains
     *
     * <pre>
     *     Given: {1,5,4,23,65,32,72} and {3,5,24,4,1,2,34,45,32,5}
     *     Result: {1, 5, 4, 23, 65, 32, 72, 5, 4, 1, 32, 5}
     * </pre>
     *
     * @param inputLeftArray left array in left union operation
     * @param inputRightArray right array in left union operation
     * @returns array
     */
    public static int[] leftUnion(final int[] inputLeftArray, final int[] inputRightArray) {
        int[] leftArray = getSafeArray(inputLeftArray);
        int[] rightArray = getSafeArray(inputRightArray);

        int resultArrayLength = leftArray.length;

        for (int current: rightArray) {
            if (arrayContains(leftArray, current)) {
                resultArrayLength++;
            } //end if
        } //end for

        int[] resultArray = Arrays.copyOf(leftArray, resultArrayLength);

        int i = leftArray.length;
        for (int current: rightArray) {
            if (arrayContains(leftArray, current)) {
                resultArray[i++] = current;
            } //end if
        } //end for

        return resultArray;
    }

    /** Returns true if <code>leftArray</code> contains the <code>current</code>
     *
     * @param array array to search in
     * @param current element to be found
     * @returns boolean
     */
    private static boolean arrayContains(final int[] array, int current) {
        assert array != null;

        for (int element: array) {
            if (element == current)  {
                //we need to find only first occurrence
                return true;
            } //end if
        } //end for
        return false;
    }

    /** Inner joins two arrays
     *
     * <pre>
     *     [1,5,4,23,65,32,78]
     *     [3,5,24,4,1,2,34,45,32,5]
     *     res:
     *     [5,4,32,1]
     * </pre>
     *
     * @param inputLeftArray  left array in inner join operation
     * @param inputRightArray right array in inner join operation
     * @returns array
     */
    public static int[] innerJoin(final int[] inputLeftArray, final int[] inputRightArray) {

        int[] leftArray = ArrayUtil.sortAndGroupArray(getSafeArray(inputLeftArray));
        int[] rightArray = ArrayUtil.sortAndGroupArray(getSafeArray(inputRightArray));

        int maxLength = Math.max(leftArray.length, rightArray.length);
        int minLength = Math.min(leftArray.length, rightArray.length);
        int leftArrayCursor = 0;
        int rightArrayCursor = 0;

        int resultArrayLength = 0;
        int[] shadowResultArray = new int[minLength + maxLength];

        for (;;) {
            if (leftArrayCursor == leftArray.length || rightArrayCursor == rightArray.length) {
                //no elements to add
                break;
            } //end if

            int currentLeftArrayElement = leftArray[leftArrayCursor];
            int currentRightArrayElement = rightArray[rightArrayCursor];

            if (currentLeftArrayElement > currentRightArrayElement) {
                rightArrayCursor++;
            } else if (currentLeftArrayElement < currentRightArrayElement) {
                leftArrayCursor++;
            } else {
                leftArrayCursor++;
                rightArrayCursor++;
                shadowResultArray[resultArrayLength++] = currentLeftArrayElement;
            } //end if
        } //end for

        return Arrays.copyOf(shadowResultArray, resultArrayLength);
    }

    /** Outer joins two arrays
     *
     * <pre>
     * [1,5,4,23,65,32,78]
     * [3,5,24,4,1,2,34,45,32,5]
     * res:
     * [2, 3, 23, 24, 34, 45, 65, 78]
     * </pre>
     *
     * @param inputLeftArray left array in outer join operation
     * @param inputRightArray right array in outer join operation
     * @returns array
     */
    public static int[] outerJoin(final int[] inputLeftArray, final int[] inputRightArray) {

        int[] leftArray = ArrayUtil.sortAndGroupArray(getSafeArray(inputLeftArray));
        int[] rightArray = ArrayUtil.sortAndGroupArray(getSafeArray(inputRightArray));

        int maxLength = Math.max(leftArray.length, rightArray.length);
        int minLength = Math.min(leftArray.length, rightArray.length);
        int leftArrayCursor = 0;
        int rightArrayCursor = 0;

        int resultArrayLength = 0;
        int[] shadowResultArray = new int[minLength + maxLength];

        for (;;) {

            if (leftArrayCursor > leftArray.length - 1) {
                int tailLength = rightArray.length - rightArrayCursor;
                System.arraycopy(rightArray,rightArrayCursor,shadowResultArray,resultArrayLength,tailLength);
                resultArrayLength+=tailLength;
                break;
            } //end if

            if (rightArrayCursor > rightArray.length - 1) {
                int tailLength = leftArray.length - leftArrayCursor;
                System.arraycopy(leftArray,leftArrayCursor,shadowResultArray,resultArrayLength,tailLength);
                resultArrayLength+=tailLength;
                break;
            } //end if

            int currentLeftArrayElement = leftArray[leftArrayCursor];
            int currentRightArrayElement = rightArray[rightArrayCursor];

            if (currentLeftArrayElement > currentRightArrayElement) {
                rightArrayCursor++;
                shadowResultArray[resultArrayLength++] = currentRightArrayElement;
            } else if (currentLeftArrayElement < currentRightArrayElement) {
                leftArrayCursor++;
                shadowResultArray[resultArrayLength++] = currentLeftArrayElement;
            } else {
                leftArrayCursor++;
                rightArrayCursor++;
            } //end if
        } //end for

        return Arrays.copyOf(shadowResultArray, resultArrayLength);
    }
}
