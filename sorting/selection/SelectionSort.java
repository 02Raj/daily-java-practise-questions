package sorting.selection;

public class SelectionSort {


    public static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1 ; i++){
            int min_index = i;
            for (int j = i + 1; j < n ; j++){
                if(arr[j] < arr[min_index]){
                min_index = j;
                }
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }


    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Array before sorting:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("\nArray after sorting:");
        printArray(arr);





    }
}
