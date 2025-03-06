package Recursion;

public class MinMaxElementRecursive {

    public static void main(String[] args) {
        int[] array ={5, 10, 3, 8, 15, 7};

        int min = findMin(array,0,array.length-1);
        int max = findMax(array,0,array.length-1);
        System.out.println("Min Element:"+ min);
        System.out.println("Max Element:"+ max);
    }

  public static int  findMin(int[] array, int start, int end){

        if(start == end ){
            return array[start];
        }

        int mid = (start + end) / 2;
        int leftMin = findMin(array,start,mid);
        int rightMin = findMin(array,mid+1,end);

        return Math.min(leftMin,rightMin);
  }

  public static int findMax(int[] array,int start,int end){

        if(start == end){
            return array[start];
        }

        int mid = (start + end) / 2;
        int leftMax = findMax(array,start,mid);
        int rightMax = findMax(array,mid + 1,end);

        return Math.max(leftMax,rightMax);
  }
}
