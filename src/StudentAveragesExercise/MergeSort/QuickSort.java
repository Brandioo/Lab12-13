package StudentAveragesExercise.MergeSort;


import java.util.Scanner;

public class QuickSort {

    static class Student {
        String name, surname;
        double avg;
    }


    static void swap(Student[] arr, int i, int j) {
        double temp = arr[i].avg;
        arr[i].avg = arr[j].avg;
        arr[j].avg = temp;
    }

    static int partition(Student[] arr, int low, int high) {

        // pivot
        double pivot = arr[high].avg;

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j].avg < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void sort(Student[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
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
