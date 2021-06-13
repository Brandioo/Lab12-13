package ArraySort;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;


public class ASort {

    public static void main(String args[]) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        String name;
        int grade;


        student[] array = new student[n];

        for (int i = 0; i < n; i++) {
            name = scan.next();
            grade = scan.nextInt();

            array[i] = new student(name, grade);
        }


        System.out.println("Before sorting: ");
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);

        Arrays.sort(array);

        System.out.println("\nAfter Sorting:");
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }
}

class student implements Comparable<student> {
    String name;
    int grade;

    student(String n, int g) {
        this.name = n;
        this.grade = g;
    }

    @Override
    public int compareTo(student that) {
        if (this.grade > that.grade)
            return 1;
        else if (this.grade < that.grade)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return this.name + "\t" + this.grade;
    }
}
