package withoutrecursion;



public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 3;

        rotateArray(arr, d);


        System.out.println("Rotated array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void rotateArray(int[] arr, int d) {

        for (int i = 0; i < d; i++) {

            int temp = arr[0];


            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }


            arr[arr.length - 1] = temp;
        }
    }


}


