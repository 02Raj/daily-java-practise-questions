package withoutrecursion;

public class findHighest {

    public static int findHighest(int[] arr){

        int highest = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > highest){
                highest = arr[i];
            }
        }
        return highest;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,4,6,8};
        System.out.println("First Highest Number:" + findHighest(arr));
    }
}
