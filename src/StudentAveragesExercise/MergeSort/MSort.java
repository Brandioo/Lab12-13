package StudentAveragesExercise.MergeSort;

import HighestAverage.HighestAVG;

import java.util.*;

public class MSort {
    static class Student
    {
        String name, lastName;
        double avg;
    }

    // Merges two subarrays of array[].
    // First subarray is array[Lpos..Rpos]
    // Second subarray is array[Rpos+1..RightEnd]
    static void merge(Student[] array, int Lpos, int Rpos, int RightEnd)
    {
        // Find sizes of two subarrays to be merged
        int n1 = Rpos - Lpos + 1;
        int n2 = RightEnd - Rpos;

        /* Create temp arrays */
        Student[] leftTemp = new Student[n1];
        Student[] rightTemp = new Student[n2];

        /*Copy data to temp arrays*/
        System.arraycopy(array, Lpos, leftTemp, 0,n1);

        for(int j = 0; j < n2; ++j)
        {
            rightTemp[j] = array[Rpos + 1 + j];
        }


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        int mergedSubArray = Lpos;
        while (i < n1 && j < n2)
        {
            if (leftTemp[i].avg <= rightTemp[j].avg)
            {
                array[mergedSubArray] = leftTemp[i];
                i++;
            }
            else
            {
                array[mergedSubArray] = rightTemp[j];
                j++;
            }
            mergedSubArray++;
        }

        /* Copy remaining elements of leftTemp[] if any */
        while (i < n1)
        {
            array[mergedSubArray] = leftTemp[i];
            i++;
            mergedSubArray++;
        }

        /* Copy remaining elements of rightTemp[] if any */
        while (j < n2)
        {
            array[mergedSubArray] = rightTemp[j];
            j++;
            mergedSubArray++;
        }
    }

    // Function that sorts array[LeftToRight] using Merge()
    static void sort(Student[] arr, int left, int right)
    {
        if (left < right)
        {
            // Find the center point
            int center =left+ (right-left)/2;

            // Sort first and second halves
            sort(arr, left, center);
            sort(arr, center + 1, right);

            // Merge the sorted halves
            merge(arr, left, center, right);
        }
    }
//
//    static void Mergesort(int N) {
//        int TmpArray[] = new int[N];
//        if (TmpArray != null) {
//            sort(TmpArray, 0, N - 1);
//        } else
//            System.out.print("No space for tmp array!!!");
//    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        Student[] arr = new Student[n];

        for (int i = 0; i < n; i++) {
            double sum = 0;
            arr[i] = new Student();
            arr[i].name = input.next();
            arr[i].lastName = input.next();
            for (int j = 0; j < 4; j++) {
                sum += input.nextInt();
            }
            arr[i].avg = sum / 4;
        }

        sort(arr, 0, n - 1);

        for (int j = n - 1; j >= n - m; j--) {
            System.out.println(arr[j].name + " " + arr[j].lastName + " " + arr[j].avg);
        }

    }
}
