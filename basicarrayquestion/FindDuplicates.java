package basicarrayquestion;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

    public static Set<Integer> findDuplicates(int[] arr ){
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int i = 0 ; i < arr.length; i++){
            int nums = arr[i];
            if(!seen.add(nums)){
                duplicates.add(nums);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 5, 1};

        Set<Integer> duplicates = findDuplicates(arr);

        if(duplicates.isEmpty()){
            System.out.println("No duplicates found");
        }else{
            System.out.println("Duplicates: " + duplicates);
        }
    }
}
