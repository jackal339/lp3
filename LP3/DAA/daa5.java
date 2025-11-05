//Write a program for analysis of quick sort by using deterministic and randomized variant.

import java.util.*;
public class daa5
{
    static int partitiondet(int lb,int ub,int arr[])
    {
        int pivot=arr[lb];
        int start=lb;
        int end=ub;
        while(start<end)
        {
            while(start<=ub && arr[start]<=pivot)
            {
                start++;
            }
            while(end>=lb && arr[end]>pivot)
            {
                end--;
            }
            if(start<end)
            {
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
            }

        }
        int temp=arr[lb];
        arr[lb]=arr[end];
        arr[end]=temp;
        return end;

    }
    static void quicksortdet(int lb,int ub,int arr[])
    {
       if(lb<ub)
       {
        int mid=partitiondet(lb, ub, arr);
        quicksortdet(lb, mid-1, arr);
        quicksortdet(mid+1, ub, arr);
       }
    }

    static int partitionrand(int lb,int ub,int arr[])
    {
        Random rd=new Random();
        int randompivot=lb+rd.nextInt(ub-lb+1);
        int temp=arr[randompivot];
        arr[randompivot]=arr[lb];
        arr[lb]=temp;

        int start=lb;
        int end=ub;
        int pivot=arr[lb];
        while(start<end)
        {
            while( start<=ub && arr[start]<=pivot)
            {
                start++;
            }
            while(end>=lb && arr[end]>pivot)
            {
                end--;
            }
            if(start<end)
            {
                temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
            }
        }
        temp=arr[lb];
        arr[lb]=arr[end];
        arr[end]=temp;
        return end;
    }
    static void quicksortrand(int arr[],int lb,int ub)
    {
        if(lb<ub)
        {
           int mid=partitionrand(lb, ub, arr);
           quicksortrand(arr, lb, mid-1);
           quicksortrand(arr, mid+1, ub);
        }
    }
    public static void main(String args[])
    {
        int arr1[] = {10, 15, 1, 2, 9, 16, 11};
        int arr2[] = arr1.clone();

        System.out.println("Original Array: " + Arrays.toString(arr1));

        // Deterministic
        long t1 = System.nanoTime();
        quicksortdet( 0, arr1.length - 1,arr1);
        long t2 = System.nanoTime();

        System.out.println("\nDeterministic Quick Sort: " + Arrays.toString(arr1));
        System.out.println("Execution Time: " + (t2 - t1) + " ns");
       

        // Randomized
        long t3 = System.nanoTime();
        quicksortrand(arr2, 0, arr2.length - 1);
        long t4 = System.nanoTime();

        System.out.println("\nRandomized Quick Sort: " + Arrays.toString(arr2));
        System.out.println("Execution Time: " + (t4 - t3) + " ns");
    }

}