//Brand BINF-A
package HighestAverage;

import java.util.Scanner;

public class QuickSort {
    //Create vector Student with it's Variables
    static class Student {
        String name, lastName;
        double average;
    }


    //Swap Function
    static void swap(Student[] array, int i, int j) {
        Student temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static int partition(Student[] array, int low, int high) {

        // index
        double index = array[high].average;

        // Index of smaller element indicates the right position of index found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the index
            if (array[j].average < index) {

                // Increment index of smaller element
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i + 1);
    }


    static void sort(Student[] array, int low, int high) {
        if (low < high) {

            // pi is partitioning index, array[p] is now at right place
            int pi = partition(array, low, high);

            // Separately sort elements before partition & after partition
            sort(array, low, pi - 1);
            sort(array, pi + 1, high);
        }
    }


   /*
              array[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfStudents = input.nextInt();
        Student[] array = new Student[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            double sum = 0;
            double grade = 0;
            double cnt = 0;
            array[i] = new Student();
            array[i].name = input.next();
            array[i].lastName = input.next();
            while (grade != -1) {
                grade = input.nextInt();
                if (grade != -1) {
                    sum += grade;
                    cnt++;
                }
            }
            if (cnt < 4) {
                array[i].average = sum / 4;
            } else {
                array[i].average = sum / cnt;
            }

        }

        sort(array, 0, numberOfStudents - 1);

        System.out.println(array[numberOfStudents - 1].name + " " + array[numberOfStudents - 1].lastName + " " + array[numberOfStudents - 1].average);

    }
}
