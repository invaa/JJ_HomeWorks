package main.java.com.diosoft.hw.lesson3.util;

/**
 * Array utilities class for arrays of objects
 *
 * @author a.zamkovyi
 * @version 0.0.1
 */

import java.util.Arrays;
import java.util.Comparator;

public class ObjectArrayUtil {

    private static Object[] getSafeArray(Object[] inputArray) {
        Object[] array = null;
        if (inputArray == null) {
            array = new Object[0];
        } else {
            array = inputArray;
        }
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
    public static Object[] mergeUnique(final Object[] inputLeftArray, final Object[] inputRightArray, Comparator comparator) {
        Object[] leftArray = getSafeArray(inputLeftArray);
        Object[] rightArray = getSafeArray(inputRightArray);

        int resultMaxLength = leftArray.length + rightArray.length;

        Object[] resultArray = Arrays.copyOf(leftArray, resultMaxLength);

        System.arraycopy(rightArray,0,resultArray,leftArray.length,rightArray.length);

        return sortAndGroupArray(resultArray, comparator);
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
    public static Object[] sortAndGroupArray(final Object[] resultArray, Comparator comparator) {

        assert resultArray != null;

        int resultMaxLength = resultArray.length;

        //guardian block
        if (resultMaxLength < 2) return resultArray;

        Arrays.sort(resultArray, comparator);

        int grouppedResultArrayLength = getMergedAndGrouppedArrayLength(resultMaxLength, resultArray, comparator);

        Object previousValue;
        int j = 0;
        previousValue = resultArray[0];
        Object[] grouppedResultArray = new Object[grouppedResultArrayLength];
        grouppedResultArray[j] = previousValue;
        for (int i = 1; i < resultMaxLength; i++) {
            Object currentValue = resultArray[i];

            if (!currentValue.equals(previousValue)) {
                j++;
                grouppedResultArray[j] = currentValue;
            }
            previousValue = currentValue;
        }

        return grouppedResultArray;
    }

    private static int getMergedAndGrouppedArrayLength(int resultMaxLength, final Object[] resultArray, Comparator comparator) {

        assert resultArray != null;

        Object previousValue = resultArray[0];

        int grouppedResultArrayLength = 1;

        for (int i = 1; i < resultMaxLength; i++) {
            Object currentValue = resultArray[i];

            if (!currentValue.equals(previousValue)) {
                grouppedResultArrayLength++;
            }
            previousValue = currentValue;
        }
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
    public static Object[] leftUnion(final Object[] inputLeftArray, final Object[] inputRightArray) {

        Object[] leftArray = getSafeArray(inputLeftArray);
        Object[] rightArray = getSafeArray(inputRightArray);

        int resultArrayLength = leftArray.length;

        for (Object current: rightArray) {
            if (arrayContains(leftArray, current)) {
                resultArrayLength++;
            }
        }

        Object[] resultArray = Arrays.copyOf(leftArray, resultArrayLength);

        int i = leftArray.length;
        for (Object current: rightArray) {
            if (arrayContains(leftArray, current)) {
                resultArray[i++] = current;
            }
        }

        return resultArray;
    }

    /** Returns true if <code>leftArray</code> contains the <code>current</code>
     *
     * @param array array to search in
     * @param current element to be found
     * @returns boolean
     */
    private static boolean arrayContains(final Object[] array, Object current) {
        for (Object element: array) {
            if (element.equals(current))  {
                //we need to find only first occurrence
                return true;
            }
        }
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
    public static Object[] innerJoin(final Object[] inputLeftArray, final Object[] inputRightArray, Comparator comparator) {

        Object[] leftArray = ObjectArrayUtil.sortAndGroupArray(getSafeArray(inputLeftArray), comparator);
        Object[] rightArray = ObjectArrayUtil.sortAndGroupArray(getSafeArray(inputRightArray), comparator);

        int maxLength = Math.max(leftArray.length, rightArray.length);
        int minLength = Math.min(leftArray.length, rightArray.length);
        int leftArrayCursor = 0;
        int rightArrayCursor = 0;

        int resultArrayLength = 0;
        Object[] shadowResultArray = new Object[minLength + maxLength];

        for (;;) {
            if (leftArrayCursor == leftArray.length || rightArrayCursor == rightArray.length) {
                //no elements to add
                break;
            } //end for

            Object currentLeftArrayElement = leftArray[leftArrayCursor];
            Object currentRightArrayElement = rightArray[rightArrayCursor];

            if (comparator.compare(currentLeftArrayElement, currentRightArrayElement) > 0) {
                rightArrayCursor++;
            } else if (comparator.compare(currentLeftArrayElement, currentRightArrayElement) < 0) {
                leftArrayCursor++;
            } else {
                leftArrayCursor++;
                rightArrayCursor++;
                shadowResultArray[resultArrayLength++] = currentLeftArrayElement;
            } //end for
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
    public static Object[] outerJoin(final Object[] inputLeftArray, final Object[] inputRightArray, Comparator comparator) {

        Object[] leftArray = ObjectArrayUtil.sortAndGroupArray(getSafeArray(inputLeftArray), comparator);
        Object[] rightArray = ObjectArrayUtil.sortAndGroupArray(getSafeArray(inputRightArray), comparator);

        int maxLength = Math.max(leftArray.length, rightArray.length);
        int minLength = Math.min(leftArray.length, rightArray.length);
        int leftArrayCursor = 0;
        int rightArrayCursor = 0;

        int resultArrayLength = 0;
        Object[] shadowResultArray = new Object[minLength + maxLength];

        for (;;) {

            if (leftArrayCursor > leftArray.length - 1) {
                int tailLength = rightArray.length - rightArrayCursor;
                System.arraycopy(rightArray,rightArrayCursor,shadowResultArray,resultArrayLength,tailLength);
                resultArrayLength+=tailLength;
                break;
            } //end for

            if (rightArrayCursor > rightArray.length - 1) {
                int tailLength = leftArray.length - leftArrayCursor;
                System.arraycopy(leftArray,leftArrayCursor,shadowResultArray,resultArrayLength,tailLength);
                resultArrayLength+=tailLength;
                break;
            } //end for

            Object currentLeftArrayElement = leftArray[leftArrayCursor];
            Object currentRightArrayElement = rightArray[rightArrayCursor];

            if (comparator.compare(currentLeftArrayElement, currentRightArrayElement) > 0) {
                rightArrayCursor++;
                shadowResultArray[resultArrayLength++] = currentRightArrayElement;
            } else if (comparator.compare(currentLeftArrayElement, currentRightArrayElement) < 0) {
                leftArrayCursor++;
                shadowResultArray[resultArrayLength++] = currentLeftArrayElement;
            } else {
                leftArrayCursor++;
                rightArrayCursor++;
            } //end for
        }

        return Arrays.copyOf(shadowResultArray, resultArrayLength);
    }
}
