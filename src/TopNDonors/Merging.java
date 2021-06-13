//Brand BINF-A
package TopNDonors;

import java.util.Scanner;

public class Merging
{

    static Donor Array[];

    static class Donor
    {
        String name, lastName;
        double amountDonated;
    }


    // First subArray is arr[l TO Rpos]
    // Second subArray is arr[Rpos+1 TO RightEnd]
    static void Merge(Donor[] array, int Lpos, int Rpos, int RightEnd)
    {
        // Find sizes of two subArrays to be merged
        int n1 = Rpos - Lpos + 1;
        int n2 = RightEnd - Rpos;

        //Create temp Arrays
        Donor[] Left = new Donor[n1];
        Donor[] Right = new Donor[n2];

        //Copy data to temp Arrays
        System.arraycopy(array, Lpos, Left, 0,n1);

        for(int j = 0; j < n2; ++j)
        {
            Right[j] = array[Rpos + 1 + j];
        }


        //Merge the temporary arrays


        int i = 0, j = 0;  //Initial indexes of first and second subArrays


        int mergedSubarray = Lpos;
        while (i < n1 && j < n2)
        {
            if (Left[i].amountDonated <= Right[j].amountDonated)
            {
                array[mergedSubarray] = Left[i];
                i++;
            }
            else
            {
                array[mergedSubarray] = Right[j];
                j++;
            }
            mergedSubarray++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            array[mergedSubarray] = Left[i];
            i++;
            mergedSubarray++;
        }

        /* Copy remaining elements of Right[] if any */
        while (j < n2)
        {
            array[mergedSubarray] = Right[j];
            j++;
            mergedSubarray++;
        }
    }

    // Main function that sorts array[Left To Right] using
    // merge()
    static void sort(Donor[] arr, int l, int r)
    {
        if (l < r)
        {
            // Find the center point
            int center =l+ (r-l)/2;

            // Sort first and second point
            sort(arr, l, center);
            sort(arr, center + 1, r);

            // Merge the sorted point
            Merge(arr, l, center, r);
        }
    }

    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int numberOfStudents= input.nextInt();
        int numberOfStudentsDisplayed= input.nextInt();
        Donor[] arr = new Donor[numberOfStudents];

        for(int i=0;i<numberOfStudents;i++)
        {
            arr[i]=new Donor();
            arr[i].name= input.next();
            arr[i].lastName = input.next();
            arr[i].amountDonated = input.nextDouble();
        }

        sort(arr,0,numberOfStudents-1);

        for(int j=numberOfStudents-1;j>=numberOfStudents-numberOfStudentsDisplayed;j--)
        {
            System.out.println(arr[j].name+" "+arr[j].lastName +" "+arr[j].amountDonated);
        }

    }

}
