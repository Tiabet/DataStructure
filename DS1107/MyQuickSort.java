package DS1107;

public class MyQuickSort {
	/*
	 * Quick Sort :
	 * First, Middle, Last 중에 중간인 수를 처음에 피벗으로 설정!
	 * 피벗을 기준으로 작은 수들은 왼쪽, 큰 수들은 오른쪽으로 모음 (partition)
	 * 그 뒤 왼쪽, 오른쪽에 각각 partiton을 진행! 
	 * 원소 개수가 2 이하일 때까지 재귀적으로 계속 진행함
	 * partition은 O(n), QuickSorting은 O(n logn)
	 */

    public static int MIN_SIZE = 3;

    public static void main(String[] args) {
        //Unsorted array
        //Integer[] a = { 2, 6, 3, 5, 1 };
        Integer[] a = {2, 6, 3, 5, 1, 10, 13, 66, 21, 32, 135, 31, 78};

        //Call quick sort
        MyQuickSort.<Integer>quickSort(a, 0, a.length - 1);

        //Check the output which is sorted array
        System.out.println(java.util.Arrays.toString(a));
    }

    /**
     * Sorts an array into ascending order. Uses quick sort with median-of-three
     * pivot selection for arrays of at least MIN_SIZE entries, and uses
     * insertion sort for other arrays.
     */
    public static <T extends Comparable<? super T>>
            void quickSort(T[] a, int first, int last) {
        System.out.println("Here 1: " + first + ", " + last);
        if (last - first + 1 < MIN_SIZE) {
            System.out.println("Here 2: " + first + ", " + last);
            //insertionSort(a, first, last);
            T minElem = (a[first].compareTo(a[last]) >= 0 ? a[last] : a[first]);
            T maxElem = (a[first].compareTo(a[last]) >= 0 ? a[first] : a[last]);
            a[first] = minElem;
            a[last] = maxElem;
            System.out.println("minElem: " + minElem);
            System.out.println("maxElem: " + maxElem);//1개여도 알아서 됨
        } else {
            // create the partition: Smaller | Pivot | Larger
            int pivotIndex = partition(a, first, last);
            //pivotindex기준으로 앞에는 더 작은 거, 뒤에는 더 큰 것들만 모여있음
            //개수가 3 이상일 때는 서로 swap해줄수가 없기 때문에 partition을 재귀적으로 진행함

            // sort subarrays Smaller and Larger
            quickSort(a, first, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, last);
        } // end if
    } // end quickSort

    /**
     * Sorts the first, middle, and last entries of an array into ascending
     * order.
     *
     * @param a an array of Comparable objects
     * @param first the integer index of the first array entry; first >= 0 and <
     * a.length @para m
     * mid the integer index of the middle array entry
     * @param last the integer index of the last array entry; last - first >= 2,
     * last < a.length
     */
    private static <T extends Comparable<? super T>>
            void sortFirstMiddleLast(T[] a, int first, int mid, int last) {
        order(a, first, mid); // make a[first] <= a[mid]
        order(a, mid, last);  // make a[mid] <= a[last]
        order(a, first, mid); // make a[first] <= a[mid]
    } // end sortFirstMiddleLast

    /**
     * Orders two given array elements into ascending order so that a[i] <=
     * a[j]. @pa
     *

     *
     * ram a an array of Comparable objects
     * @param i an integer >= 0 and < array.length @param j
     * an integer >= 0 and < array.length
     */
    private static <T extends Comparable<? super T>>
            void order(T[] a, int i, int j) {
        if (a[i].compareTo(a[j]) > 0) {
            swap(a, i, j);
        }
    } // end order

    /**
     * Partitions an array as part of quick sort into two subarrays called
     * Smaller and Larger that are separated by a single entry called the pivot.
     * Entries in Smaller are <= pivot and appear before the
     * pivot in the array.
     * Entries in Larger are >= pivot and appear after the pivot in the array.
     *
     * @param a an array of Comparable objects
     * @param first the integer index of the first array entry; first >= 0 and <
     * a.length @para m
     * last the integer index of the last array entry; last - first >= 3; last <
     * a.length @retu
     * rn the index of the pivot
     */
    private static <T extends Comparable<? super T>>
            int partition(T[] a, int first, int last) {
        int mid = (first + last) / 2;
        sortFirstMiddleLast(a, first, mid, last);

        // Assertion: The pivot is a[mid]; a[first] <= pivot and 
        // a[last] >= pivot, so do not compare these two array entries
        // with pivot.
        // move pivot to next-to-last position in array
        swap(a, mid, last - 1);
        int pivotIndex = last - 1;
        T pivot = a[pivotIndex];

        // determine subarrays Smaller = a[first..endSmaller]
        // and                 Larger  = a[endSmaller+1..last-1]
        // such that entries in Smaller are <= pivot and 
        // entries in Larger are >= pivot; initially, these subarrays are empty
        int indexFromLeft = first + 1;
        int indexFromRight = last - 2;

        boolean done = false;
        while (!done) {
            // starting at beginning of array, leave entries that are < pivot;
            // locate first entry that is >= pivot; you will find one,
            // since last entry is >= pivot
            while (a[indexFromLeft].compareTo(pivot) < 0) {
                indexFromLeft++;
            }

            // starting at end of array, leave entries that are > pivot; 
            // locate first entry that is <= pivot; you will find one, 
            // since first entry is <= pivot
            while (a[indexFromRight].compareTo(pivot) > 0) {
                indexFromRight--;
            }

            assert a[indexFromLeft].compareTo(pivot) >= 0
                    && a[indexFromRight].compareTo(pivot) <= 0;

            if (indexFromLeft < indexFromRight) {
                swap(a, indexFromLeft, indexFromRight);
                indexFromLeft++;
                indexFromRight--;
            } else {
                done = true;
            }

        } // end while

        // place pivot between Smaller and Larger subarrays
        swap(a, pivotIndex, indexFromLeft);
        pivotIndex = indexFromLeft;

        // Assertion:
        //   Smaller = a[first..pivotIndex-1]
        //   Pivot = a[pivotIndex]
        //   Larger = a[pivotIndex+1..last]
        return pivotIndex;
    } // end partition

    /**
     * Swaps the array entries array[i] and array[j].
     */
    private static void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    } // end swap

}
