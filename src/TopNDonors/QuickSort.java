//Brand BINF-A
package TopNDonors;

import java.util.Scanner;

public class QuickSort {
    //Create vector Donor with it's Variables
    static class Donor {
        String name, surname;
        double donated;
    }

    //Swap Function
    static void swap(Donor[] donors, int i, int j) {
        double temp = donors[i].donated;
        donors[i].donated = donors[j].donated;
        donors[j].donated = temp;
    }

    static int partition(Donor[] array, int low, int high) {

        double index = array[high].donated;

        // Index of smaller element indicates the right position of index found so far

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // current element is smaller than the index than increment index of smaller element
            if (array[j].donated < index) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i + 1);
    }


    static void quickSort(Donor[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            //before partition and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

        /*
              array[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Donor[] array = new Donor[n];

        for (int i = 0; i < n; i++) {
            array[i] = new Donor();
            array[i].name = sc.next();
            array[i].surname = sc.next();
            array[i].donated = sc.nextDouble();
        }

        quickSort(array, 0, n - 1);

        for (int j = n - 1; j >= n - m; j--) {
            System.out.println(array[j].name + " " + array[j].surname + " " + array[j].donated);
        }

    }
}
