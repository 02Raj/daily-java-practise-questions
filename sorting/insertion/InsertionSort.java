package sorting.insertion;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j;

            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
    }


    public static void main(String[] args) {
        int[] arr  =  {5, 3, 8, 6, 2};
        insertionSort(arr);

        for (int j : arr) {
            System.out.print("num:  " + j);
        }
    }


}
