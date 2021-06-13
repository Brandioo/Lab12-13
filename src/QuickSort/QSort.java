package QuickSort;

import java.io.*;
import java.util.*;

public class QSort {

    public static void main(String args[]) throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader("src/QuickSort/inputting.txt"));
        int n = input.nextInt();
        int[] Array = new int[n];

        for (int i = 0; i < n; i++)
            Array[i] = input.nextInt();

        System.out.println("Before sorting: ");
        for (int i = 0; i < Array.length; i++)
            System.out.print(Array[i] + " ");

        System.out.println("\nAfter Sorting:");
        quickSort(Array, 0, n - 1);
        for (int i = 0; i < Array.length; i++)
            System.out.print(Array[i] + " ");

    }

    static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;
        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++; 	}

            while (arr[j] > pivot) {
                j--; 	}

            if (i <= j) {
                swap(arr, i, j);
                i++; 	j--;
            }
        }
        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);
        if (high > i)
            quickSort(arr, i, high);
    }

    static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

}
