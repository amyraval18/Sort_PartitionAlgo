public class MyTestProg3 {
    public static void main(String[] args) {
        // insertion sort
        int[] arr1 = {9,14,3,2,43,11,58,22};
        int n = arr1.length;

        System.out.println("Before Insertion Sort");
        for(int i:arr1){
            System.out.print(i+" ");
        }
        System.out.println();


        ArraySorts.insertionSort(arr1, n );//sorting array using insertion sort

        System.out.println("After Insertion Sort");
        for(int i:arr1){
            System.out.print(i+" ");
        }
        System.out.println();

        // outside in partition
        int[] arr2 = {2, 7, 10, 9, 1, 5};
        int n2 = arr2.length;
        int pivot = arr2.length - 1;

        System.out.println( "Before partition OutsideIn");
        for(int i:arr2){
            System.out.print(i+" ");
        }
        System.out.println();


        ArraySorts.partitionOutsideIn(arr2, 0, n2 - 1, pivot);

        System.out.println("After partition OutsideIn");
        for(int i:arr2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // outside in random pivot

        int[] arr3 = {1, 3, 2, 6, 9, 5, 8};
        int n3 = arr3.length;
        int pivot2 = arr3.length - 1;

        System.out.println( "Before QS outside in random");
        for(int i:arr3){
            System.out.print(i+" ");
        }
        System.out.println();


        ArraySorts.QS_OutsideIn_randomPivot(arr3, n3-1, pivot2);

        System.out.println("After QS outside in random");
        for(int i:arr3) {
            System.out.print(i + " ");
        }
        System.out.println();

        //partition left to right
        int[] arr4 = {2, 3, 2, 5, 6, 1, 3, 14, 12};
        int n4 = arr4.length;
        int pivot3 = arr4.length - 1;



        System.out.println( "Before left to right partition");
        for(int i:arr4){
            System.out.print(i+" ");

        }
        System.out.println();


        ArraySorts.QS_LeftToRight_randomPivot(arr4, n4-1, pivot3);
        System.out.println("After after left to right partition");
        for(int i:arr4) {
            System.out.print(i + " ");
        }
        System.out.println();

        // outside in w/ left pivot

        int[] arr5 = {62, 83, 21, 14, 71, 35, 65, 89, 50,};
        int n5 = arr5.length;
        int pivot4 = arr5.length - 1;



        System.out.println( "Before outside in left pivot");
        for(int i:arr5){
            System.out.print(i+" ");

        }
        System.out.println();


        ArraySorts.QS_OutsideIn_lfPivot(arr5, n5-1, pivot4);

        System.out.println("After outside in pivot");
        for(int i:arr5) {
            System.out.print(i + " ");
        }
        System.out.println();


        // left to right w/ left pivot
        int[] arr6 = {6, 1, 4, 12, 13, 4, 5, 9};
        int n6 = arr6.length;
        int pivot5 = arr6.length - 1;



        System.out.println( "Before outside in left pivot");
        for(int i:arr6){
            System.out.print(i+" ");

        }
        System.out.println();


        ArraySorts.QS_LeftToRight_lfPivot(arr6, n6-1, pivot5);

        System.out.println("After outside in pivot");
        for(int i:arr6) {
            System.out.print(i + " ");
        }
        System.out.println();


        // trickle down
        int[] arr7 = {3, 6, 7, 11, 12, 4, 5};
        int n7 = arr7.length;
        int pivot6 = arr7.length - 1;



        System.out.println( "Before trickle down ");
        for(int i:arr7){
            System.out.print(i+" ");

        }
        System.out.println();


        //ArraySorts.trickleDown(arr7, n7-1, pivot6);

        System.out.println("After trickle down");
        for(int i:arr7) {
            System.out.print(i + " ");
        }
        System.out.println();














            }



}
