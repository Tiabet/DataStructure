package DS1107;

import java.util.*;

public class MergeSort {

    public static void main(String[] args) {
        //Unsorted array
        Integer[] a = {2, 6, 3, 5, 1};

        //Call merge sort
        mergeSort(a);

        //Check the output which is sorted array
        System.out.println(Arrays.toString(a));
    }

    @SuppressWarnings("rawtypes")
    public static Comparable[] mergeSort(Comparable[] list) {
        //If list is empty; no need to do anything
        if (list.length <= 1) {
            return list; 
        }

        //Split the array in half in two parts
        //2개일때부터 작동을 시작함, 반으로 쪼개는 작업
        Comparable[] first = new Comparable[list.length / 2];
        Comparable[] second = new Comparable[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);//list의 0부터를 first의 0부터에 넣음, 길이는 first.length
        System.arraycopy(list, first.length, second, 0, second.length);

        //Sort each half recursively
        mergeSort(first);
        mergeSort(second);

        //Merge both halves together, overwriting to original array
        merge(first, second, list);
        //들어오는 리스트의 크기와 똑같아서 넘치거나 모자랄 일이 없음
        return list;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void merge(Comparable[] first, Comparable[] second, Comparable[] result) {
        //Index Position in first array - starting with first element
        int iFirst = 0;

        //Index Position in second array - starting with first element
        int iSecond = 0;

        //Index Position in merged array - starting with first position
        int iMerged = 0;

        //Compare elements at iFirst and iSecond, 
        //and move smaller element at iMerged
        //first와 second를 비교해서 작은거먼저 merged result에 채워넣는 방식
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].compareTo(second[iSecond]) < 0) 
            {
                result[iMerged] = first[iFirst];
                iFirst++;
            } 
            else
            {
                result[iMerged] = second[iSecond];
                iSecond++;
            }

            iMerged++;
        }
        //한쪽이 먼저 다 result에 넣어버리면 나머지 한쪽에는 sorting된 채로 남아있을 것이기 때문에 남은 걸 넣어주는 메소드임
        //먼저 찬 한 쪽, First나 Second는 자동으로 실행 안 됨
        //copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);

    }
}
