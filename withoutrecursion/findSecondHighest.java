package withoutrecursion;

public class findSecondHighest {

    public static int secondHighest(int[] arr){
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
           if (arr[i] > highest){
               secondHighest = highest;
               highest = arr[i];
           } else if(arr[i] > secondHighest && arr[i] != highest){
               secondHighest = arr[i];
           }
        }

        if (secondHighest == Integer.MIN_VALUE){
            throw new RuntimeException("NO SECOND HIGHEST EELEMENT FOUND");
        }
        return secondHighest;
    }


    public static void main(String[] args) {
       int[] arr = {1,4,6,8,10,11,12};
        System.out.println("Second highest number is: " + secondHighest(arr));
    }

}
