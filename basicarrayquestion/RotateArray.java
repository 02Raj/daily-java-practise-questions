package basicarrayquestion;

public class RotateArray {

    public static void reverse(int[] arr, int left , int right){
        while(left < right){
            int temp = arr[left];
            arr[left]= arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void rotate(int[] arr, int k){
        int n = arr.length;
        k = k % n;
        if(k < 0){
            k += n;
        }

        // Reverse first part
        reverse(arr, 0, n - k - 1);

        // Reverse second part
        reverse(arr, n - k, n - 1);

        // Reverse whole array
        reverse(arr, 0 , n - 1);
    }

    public static void main(String[] args) {
        int[] arr =  {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(arr, k);

        // Output to verify
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
