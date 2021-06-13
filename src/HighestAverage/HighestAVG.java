package HighestAverage;

import java.util.Scanner;

public class HighestAVG
{

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

    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int numberOfStudents= input.nextInt();
        Student[] array = new Student[numberOfStudents];

        for(int i=0;i<numberOfStudents;i++)
        {
            double sum=0;
            double grade=0;
            double cnt=0;
            array[i]=new Student();
            array[i].name= input.next();
            array[i].lastName = input.next();
            while(grade!=-1) //It ends when it is inputted -1
            {
                grade= input.nextInt();
                if(grade!=-1)
                {
                    sum+=grade;
                    cnt++;
                }
            }
            if(cnt<4)
            {
                array[i].avg=sum/4;
            }
            else
            {
                array[i].avg=sum/cnt;
            }

        }

        sort(array,0,numberOfStudents-1);

        System.out.println(array[numberOfStudents-1].name+" "+array[numberOfStudents-1].lastName +" "+array[numberOfStudents-1].avg);

    }

}
