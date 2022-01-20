// i) Amy Raval :)
// ii) COmp 282 2-3:15pm
//iii) Programming assignment #3
//iv) 12/02/21
//v) This file contains various method that will partition and sort through given arrays.
    //will add: HeapSortTopDown, HeapSortBottomUp,trickleDown, trickleUp.


import java.util.Random;

// Used to return the two pivots in the 2-pivot partition
class Pair {
    public int left, right;
    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

// Class to hold all the sorts and their associated methods
class ArraySorts {

    // method to return student name
    public static String myName(){

        return "Amy Raval";

    }
    // method for sorting array with insertion sort
    // passes array
    //pass integer n; n is number in array
    // while loop moves elements in the array that
    // are larger than val, ahead of their previous spot
    public static void insertionSort(int a[], int n){

        for (int i = 1; i < n; ++i) {
            int val = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > val) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = val;
        }
    }

//driver method for outside in random pivot
    public static void QS_OutsideIn_randomPivot(int a[], int n, int cutoff) {
        QS_OutsideIn_randomPivot(a,0, n - 1, cutoff);
        insertionSort(a, n);
    }
//recursive method to quicksort using outside-in w/ random pivot
    private static void QS_OutsideIn_randomPivot(int a[], int lf, int rt,
                                                 int cutoff) {
        int pivot;
        while ((rt - lf + 1) >= cutoff) {
            pivot = lf + (int) (Math.random() * (rt - lf + 1));
            pivot = partitionOutsideIn(a, lf, rt, pivot);
            if ((pivot - lf) < (rt - pivot)) {
                QS_OutsideIn_randomPivot(a, lf, pivot-1, cutoff);
                lf = pivot+1;
            } else {
                QS_OutsideIn_randomPivot(a, pivot+1, rt, cutoff);
                rt = pivot-1;
            }
        }
    }

    //method using outside-in partition method: first we place the pivot to the left side of the array
    // leftPt will keep moving to the right until a value greater than the pivot is found
    // rightPt will keep decrementing (to the left) until a value greater than the pivot is found
    // this will loop through until the two pointers cross, and the values are in their proper spots.
    public static int partitionOutsideIn(int a[], int lf, int rt, int pivot) {
        pivot = lf; // place pivot at the leftmost side of the array
        swap(a, lf, pivot); // swap lf with pivot
        int leftPT = lf +1; // start leftPT at lf +1 in the array
        int rightPT = rt; // start rightPt at rt in array

        while(leftPT < rightPT) {
            //while the value of leftPt is less than or equal to the value of the pivot,
            // the left partition pointer is less than the right, move/increment leftPt.
            while(a[leftPT] <= a[pivot] && leftPT < rt){
                leftPT++;
            }
            // same method applies as above^, but decrement while pivot as long as
            // right value is greater than pivot, and right partition is greater than or equal to left pointer.
            while(a[rightPT] > a[pivot] && rightPT >= lf){
                rightPT--;
            }
            // if leftPt, is greater than rightPT, then swap
            if(leftPT <= rightPT) {
                swap(a, leftPT, rightPT);
            }

        }
        swap(a, pivot, rightPT);
        pivot = rightPT;
        return pivot;

    }

    // swap function used to swap values in array
    // Source: https://stackoverflow.com/questions/36869741/swap-method-for-quicksort-in-java
    public static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // driver method for quicksort lef to right w/ random pivot
    public static void QS_LeftToRight_randomPivot(int a[], int n, int cutoff){
            QS_LeftToRight_randomPivot(a, 0, n-1, cutoff);
            insertionSort(a, n); // n + 1
    }

    // recursive method for left to right random pivot
    private static void QS_LeftToRight_randomPivot(int a[], int lf, int rt, int cutoff){
          int pivot;
          while((rt - lf +1) >= cutoff){
              pivot = lf + (int) (Math.random() * (rt - lf +1));
              pivot = partitionLeftToRight(a, lf, rt, pivot);
              if ((pivot - lf) < (rt - pivot)){
                  QS_LeftToRight_randomPivot(a, lf, pivot -1, cutoff);
                  lf = pivot + 1;
              }
              else {
                  QS_LeftToRight_randomPivot(a, pivot + 1, rt, cutoff);
                  rt = pivot -1;
              }
          }



    }

    // method to partition from left to right
    public static int partitionLeftToRight(int a[], int lf, int rt, int pivot) {
        swap(a, lf, pivot); // swap lf and pivot
        int lastSmall;// last small
        int firstUnk; //first unknown

        lastSmall = lf; // set last small to left most pivot
        firstUnk = lf +1; // set first unknown to lf +1; next value
        pivot = lf; // set pivot to lf; left to right

        while(firstUnk < rt + 1){
                // if value of first unknown is greater or equal to the pivot, then increment unknown
            if(a[firstUnk] >= a[pivot]){
                firstUnk++;
            }
            // if unknown is less than pivot then increment last small
            // and then swap first unknown and last small
            //and then increment first unknown
            if(a[firstUnk] < a[pivot]){

                lastSmall++;
                swap(a, firstUnk,lastSmall);
                firstUnk++;

            }

        }
        // return last small
        swap(a, pivot, lastSmall);
        pivot = lastSmall;
        return pivot;


    }

    //driver method for outside in left pivot
    public static void QS_OutsideIn_lfPivot(int a[], int n, int cutoff){
        QS_OutsideIn_lfPivot(a, 0, n-1, cutoff);
        insertionSort(a, n);
    }

    // recursive method for outside-in left pivot
    // sets pivot to the left
    // calls partition method
    private static void QS_OutsideIn_lfPivot(int a[], int lf, int rt, int cutoff){
        // int pivot = lf;
        while((rt - lf +1) >= cutoff){
            // pivot = lf + (pivot * (rt - lf +1));
            int pivot = lf;
            pivot = partitionOutsideIn(a, lf, rt, pivot);
            if ((pivot - lf) < (rt - pivot)){
                QS_OutsideIn_lfPivot(a, lf, pivot -1, cutoff);
                lf = pivot + 1;
            }
            else {
                QS_OutsideIn_lfPivot(a, pivot + 1, rt, cutoff);
                rt = pivot -1;
            }
        }
    }

    public static void QS_LeftToRight_lfPivot(int a[], int n, int cutoff) {
        QS_LeftToRight_lfPivot(a, 0, n-1, cutoff);
        insertionSort(a, n);
    }

    private static void QS_LeftToRight_lfPivot(int a[], int lf, int rt, int cutoff){
        while((rt - lf +1) >= cutoff){
            // pivot = lf + (pivot * (rt - lf +1));
            int pivot = lf;
            pivot = partitionLeftToRight(a, lf, rt, pivot);
            if ((pivot - lf) < (rt - pivot)){
                QS_LeftToRight_lfPivot(a, lf, pivot -1, cutoff);
                lf = pivot + 1;
            }
            else {
                QS_LeftToRight_lfPivot(a, pivot + 1, rt, cutoff);
                rt = pivot -1;
            }
        }
    }

// method for dual partitioning
    // inherits class pair
    // three partitions: first unknown, first big, and last small

     public static Pair partition2Pivot(int a[], int lf, int rt, int pivotl, int pivotr){

        int lastSmall = lf;
        int firstUnk = lf +1;
        int firstBig = rt;

        // when right pivot is less than left pivot, make right/left = i
        if(a[pivotr] < a[pivotl]){

            int i = pivotr;
            pivotr = pivotl;
           pivotl = i;
        }
         // swap left pivot & lf
        swap(a, pivotl, lf);
        // swap right pivot & rt
        swap(a, pivotr, rt);

        while(firstUnk < firstBig){
            // if the first unknown is less than lf, increment last small, swap last small and first unknown
            // increment unknown. <= P
            if(a[firstUnk] < a[lf]){
                lastSmall++;
                swap(a, lastSmall, firstUnk);
                firstUnk++;
            }
            // if first unknown is less than rt, decrement first big, swap first big and first unknown
            // the first unknown doesn't move. >= P
            else if (a[firstUnk] > a[rt]){
                firstBig--;
                swap(a, firstUnk, firstBig);
            }
            // middle element is in the right partition, increment first unknown
            // >= P & <= P
            else{
                firstUnk++;
            }
        }
        swap(a, lf, lastSmall);
        swap(a, rt, firstBig);
        Pair PAIR = new Pair(pivotl, pivotr);
        return PAIR;

    }


    // driver method
    public static void QuickSort_2Pivot_BothRandom(int a[], int n, int cutoff) {
        Quicksort_2Pivot_BothRandom(a, 0, n - 1, cutoff);
        insertionSort(a, n);
    }
    // recursive method for dual pivot that are both random
    private static void Quicksort_2Pivot_BothRandom(int a[], int lf, int rt, int cutoff) {
        Pair pair;
        int lf_pivot;
        int rt_pivot;

        // loop that randomized pivot placements for ls and rt
        while ((rt - lf + 1) >= cutoff) {
            lf_pivot = lf + (int) (Math.random() * (rt - lf + 1));
            rt_pivot = lf + (int) (Math.random() * (rt - lf + 1));
            while (rt_pivot == lf_pivot) {
                rt_pivot = lf + (int) (Math.random() * (rt - lf + 1));
            }

            // call to 2 pivot partition
            // inherits pair class; left and right
            pair = partition2Pivot(a, lf, rt, lf_pivot, rt_pivot);

            int partition_lf = pair.left - lf; // left partition

            int partition_rt = rt - pair.right; // right partition

            int partitionInMiddle = pair.right - pair.left; // middle partition

            // if the left partition is greater or = to both the right and middle partition
            // call recursive and driver methods
            // decrement left by 1 = rt
            if ((partition_lf >= partition_rt) && (partition_lf >= partitionInMiddle)) {

                Quicksort_2Pivot_BothRandom(a, pair.left + 1, pair.right - 1, cutoff);
                Quicksort_2Pivot_BothRandom(a, pair.right + 1, rt, cutoff);

                rt = pair.left - 1;

            }
            // if the middle partition is greater or = to both the left and right partition
            // call recursive and driver methods
            // lf = increment left by 1 and rt decrements right by one
            else if ((partitionInMiddle >= partition_lf) && (partitionInMiddle >= partition_rt)) {
                Quicksort_2Pivot_BothRandom(a, lf, pair.left - 1, cutoff);
                Quicksort_2Pivot_BothRandom(a, pair.right + 1, rt, cutoff);
                lf = pair.left + 1;
                rt = pair.right - 1;

            }
            // if the right partition is greater or = to both the right and middle partition
            // call recursive and driver methods
            // increment by 1 = lf
            else if ((partition_rt >= partition_lf) && (partition_rt >= partitionInMiddle)) {
                Quicksort_2Pivot_BothRandom(a, pair.left + 1, pair.right - 1, cutoff);
                Quicksort_2Pivot_BothRandom(a, lf, pair.left - 1, cutoff);
                lf = pair.right + 1;
            }
        }
    }



     public static void trickleUp(int a[], int rt) {
        // top down
    }


     public static void HeapSortTopDown(int a[], int n) {

    }

    public static void HeapSortBottomUp(int a[], int n) {

    }

    // unfinished trickle-down method, flaw in logic
    public static void trickleDown(int a[], int lf, int rt) {
        int i = lf; // sets i to lf
        int large = i; // i is largest value in heap
        lf = 2 * large +1; // calc for left side of heap
        rt = 2* large +1; // calc for right side of heap

        if(lf < large && a[lf] > a[large]){
            large = lf;
        }

        if(rt < large && a[rt] > a[large]){
            large = rt;
        }

        if(large != i){
            large = (i-1)/2;
        }
    }





    public static void AlmostQS_OutsideIn_randomPivot(int a[], int n, int cutoff) {
        QS_OutsideIn_randomPivot(a, 0, n - 1, cutoff);
    }

    public static void AlmostQS_LeftToRight_randomPivot(int a[], int n, int cutoff) {
            QS_LeftToRight_randomPivot(a, 0, n-1, cutoff);
    }

    public static void AlmostQuickSort_2Pivot_BothRandom(int a[], int n, int cutoff) {
            Quicksort_2Pivot_BothRandom(a, 0, n-1, cutoff);
    }
 







    }


