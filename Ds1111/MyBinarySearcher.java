package Ds1111;

public class MyBinarySearcher {

    public static int searchVer1(Comparable[] arr, Comparable target) {
        int first = 0;
        int last = arr.length-1;
        int mid;
        if (arr == null || arr.length == 0) {
            return -1;
        }
        while (first <= last) {
            mid = (first + last) / 2;
            //System.out.println("mid:" + mid + " first:" + first + ", last:" + last);
            if (target.equals(arr[mid])) {
                return mid;
            } else {
                if (target.compareTo(arr[mid]) < 0) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            }
            // if target is not existed,
            // not occur reversal of the first and last
        }
        return -1;
        // when target is not existed
    }

    public static int searchVer2(Comparable[] myArray, int first, int last, Comparable desiredItem) {
        int foundIndex = -1;
        int mid = first + (last - first) / 2;
        //Comparable cmp = (Comparable<T>) desiredItem;

        if (first > last) {
            foundIndex = -1;
        } else if (desiredItem.equals(myArray[mid])) {
            foundIndex = mid;
        } else if (desiredItem.compareTo(myArray[mid]) < 0) {
            foundIndex = searchVer2(myArray, first, mid - 1, desiredItem);
        } else {
            foundIndex = searchVer2(myArray, mid + 1, last, desiredItem);
        }

        return foundIndex;
    }

}
