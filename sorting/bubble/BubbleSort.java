package sorting.bubble;

public class BubbleSort {

 static  void bubbleSort(int[] a){
     int n = a.length;

     for (int i = 0 ; i < n-1; i++){
         boolean flag = false;
         for (int j = 0; j < n-i-1; j++){

             if(a[j] > a[j + 1]){
                 int temp = a[j];
                 a[j] = a[j+1];
                 a[j+1] = temp;
                 flag = true;
             }

         }

         if(flag == false){
             return;
         }
     }
 }
    static void bubbleSort2(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int arr[] = {7, 2, 5, 1, 3};

        bubbleSort2(arr);

        System.out.println("Sorted Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
     

}
