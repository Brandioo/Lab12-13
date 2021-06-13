package StudentAveragesExercise.MergeSort;

import java.util.*;

public class MSort {
    //Declaration of Student
    static class Student {
        String name, surname;
        double avg;
    }

    static int Array[];

    public static void exchange(int i, int j) {
        int t = Array[i];
        Array[i] = Array[j];
        Array[j] = t;
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void Merge(Student[] arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        Student[] L = new Student[n1];
        Student[] R = new Student[n2];

        /*Copy data to temp arrays*/
        System.arraycopy(arr, l, L, 0,n1);

        for(int j = 0; j < n2; ++j)
        {
            R[j] = arr[m + 1 + j];
        }


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i].avg <= R[j].avg)
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    // Main function that sorts arr[l..r] using
    // Merge()
    static void sort(Student[] arr, int Left, int Right) {
        int Center;
        // Find the middle point
        if (Left < Right) {
            Center = (Left + Right) / 2;

            // Sort first and second halves
            sort(arr, Left, Center);
            sort(arr, Center + 1, Right);

            // Merge the sorted halves
            Merge(arr, Left, Center, Right);
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
            arr[i].surname = input.next();
            for (int j = 0; j < 4; j++) {
                sum += input.nextInt();
            }
            arr[i].avg = sum / 4;
        }

        sort(arr, 0, n - 1);

        for (int j = n - 1; j >= n - m; j--) {
            System.out.println(arr[j].name + " " + arr[j].surname + " " + arr[j].avg);
        }

    }
}
