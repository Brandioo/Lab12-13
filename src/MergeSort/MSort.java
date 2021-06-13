package MergeSort;

import java.util.*;

public class MSort {

    static int Array[];

    public static void exchange(int i, int j) {
        int t = Array[i];
        Array[i] = Array[j];
        Array[j] = t;
    }

    static void Merge(int TmpArray[], int Lpos, int Rpos, int RightEnd) {

        int i, LeftEnd, NumElements, TmpPos;
        LeftEnd = Rpos - 1;
        TmpPos = Lpos;
        NumElements = RightEnd - Lpos + 1;

        /* main loop */
        while (Lpos <= LeftEnd && Rpos <= RightEnd)
            if (Array[Lpos] <= Array[Rpos])
                TmpArray[TmpPos++] = Array[Lpos++];
            else
                TmpArray[TmpPos++] = Array[Rpos++];

        while (Lpos <= LeftEnd) /* Copy rest of first half */
            TmpArray[TmpPos++] = Array[Lpos++];

        while (Rpos <= RightEnd) /* Copy rest of second half */
            TmpArray[TmpPos++] = Array[Rpos++];

        /* Copy TmpArray back */
        for (i = 0; i < NumElements; i++, RightEnd--)
            Array[RightEnd] = TmpArray[RightEnd];
    }


    // Main function that sorts arr[l..r] using
    // Merge()
    static void sort(int TmpArray[], int Left, int Right) {
        int Center;
        // Find the middle point
        if (Left < Right) {
            Center = (Left + Right) / 2;

            // Sort first and second halves
            sort(TmpArray, Left, Center);
            sort(TmpArray, Center + 1, Right);

            // Merge the sorted halves
            Merge(TmpArray, Left, Center + 1, Right);
        }
    }


    static void Mergesort(int N) {
        int TmpArray[] = new int[N];
        if (TmpArray != null) {
            sort(TmpArray, 0, N - 1);
        } else
            System.out.print("No space for tmp array!!!");
    }

    public static void main(String[] args) {
        int n, lst[];
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        Array = new int[n];

        for (int i = 0; i < n; i++)
            Array[i] = input.nextInt();

        Mergesort(n);
        for (int i = 0; i < n; i++)
            System.out.print(Array[i] + " ");
        System.out.println();

    }
}
