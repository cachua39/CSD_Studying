/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luonglv;

/**
 *
 * @author levalu
 */
public class Sorting {
    public static void main(String[] args) {
        int a[] = {23, 43, 56, 12, 87, 14, 87, 15, 90, 23, 10};
        bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // Insertion sort
    public static void insertionSort(int a[]) {
        int j, tmp;
        for (int i = 0; i < a.length; i++) {
            tmp = a[i];
            j = i;
            while (j > 0 && tmp < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = tmp;
        }
    }

    // Selection sort
    public static void selectionSort(int a[]) {
        int i, j, min, tmp;
        for (i = 0; i < a.length - 1; i++) {
            min = i;
            for (j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            if (min != i) {
                tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }

    // Bubble sort
    public static void bubbleSort(int a[]) {
        int i, tmp;
        boolean swapped;
        do {
            swapped = false;
            for (i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Quick sort
    public static void quickSort(int a[], int low, int high) {
        int pivotIndex;
        if (low < high) {
            pivotIndex = partition(a, low, high);
            quickSort(a, low, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, high);
        }
    }

    public static int partition(int a[], int low, int high) {
        int pivotVal = a[low];
        int up = low;
        int down = high;
        int tmp;
        // Repeat until UP meet of pass DOWN
        while (up <= down) {
            // Increase up until select the first element greater than the pivot value
            if (a[up] <= pivotVal) {
                up++;
            } // Decrease down until it selects the first element less than the pivot value
            else if (a[down] > pivotVal) {
                down--;
            } // if UP <= DOWN, exchange thier value
            else {
                tmp = a[up];
                a[up] = a[down];
                a[down] = tmp;
            }
        }

        // Exchange the first element in array and DOWN
        tmp = a[low];
        a[low] = a[down];
        a[down] = tmp;

        // Define the PivotIndex as DOWN and return it
        return down;
    }

    public static void mergeSort(int a[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int mid = (l + r) / 2;

            // Sort first and second halves
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, r);

            // Merge the sorted halves
            merge(a, l, mid, r);
        }

    }

    // Merge two sorted subarrays of a[]
    // First sorted subarray is a[l..m]
    // Second sorted suarray is a[m+1...r]
    public static void merge(int a[], int l, int m, int r) {
        
        // Find sizes of the temp arrays
        int n = r - l + 1;
        // Creat a temp array
        int temp[] = new int[n];

        // Initital index of the first subarray a[l..m]
        int i = l;
        // Initial index of the second subarray a[m+1..r]
        int j = m + 1;
        // Initial index of the temp array
        int k = 0;

        // Begin merge two sorted subbarrays
        while (i <= m && j <= r) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        // Coppy the remaining elements of the first sorted subarray
        while (i <= m) {
            temp[k++] = a[i++];
        }
        while (j <= r) {
            temp[k++] = a[j++];
        }
        k = 0;
        for (i = l; i <= r; i++) {
            a[i] = temp[k++];
        }
    }
    
    public static void heapSort(int a[]) {
        int n = a.length;
        
        // Build unsorted array to heap ( rearrange array)
        for(int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }
        
        // One by one, pop the top element from the heap and reduce the heap one by one
        for(int i = n - 1; i >= 0; i--) {
            // Move curret root (the top of the heap) to the end (of the heap);
            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            
            heapify(a, i, 0);
        }
    }
    
    // Heapify a subtree rooted with node i which is an index in the a[]. n is the size of heap
    public static void heapify(int a[], int n, int i) {
        int largest = i;        // Initalize largest as a root
        int l = 2 * i + 1;      // left node of the largest node (root)
        int r = 2 * i + 2;      // right node of the largest node (root)
        
        // If the left child greater than root
        if(l < n && a[l] > a[largest]) {
            largest = l;
        }
        
        // If the right child greater than largest (the left above) so far
        if(r < n && a[r] > a[largest]) {
            largest = r;
        }
        
        // If the largest is not root
        if(largest != i) {
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;
            
            // Recursively heapify the affected sub-tree
            heapify(a, n, largest);
        }
        
    }
}
