package Algorithm;

public class TwoPointerAlgorithm {


    public static int[] findNumbersWithSum(int arr[], int targetSum){
        for(int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1 ; i < arr.length; i++){
                if(arr[i] + arr[j] == targetSum){
                    return new int[] {arr[i],arr[j]};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int targetSum = 14;

        int[] result = findNumbersWithSum(arr,targetSum);

        if(result[0] != -1 && result[0] != -1){
            System.out.println("Numbers Found: " + result[0] + " ,"+ result[1]);
        } else {
            System.out.println(" Numbers Not Found:" + result[0] + " " + result[1]);
        }
    }
}
