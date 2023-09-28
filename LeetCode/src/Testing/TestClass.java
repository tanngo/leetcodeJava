package Testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestClass {
    public static void main(String[] args){
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        int []nums = new int[]{1,2,3};
        backtrack(ans, subset, nums,0,0,3);

//        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        List<Integer> numList2 = IntStream.of(nums).boxed().collect(Collectors.toList());
//        backtrack(ans, subset,numList,0);

    }

    public static void backtrack(List<List<Integer>> ans, List<Integer>subset, int[]nums, int start, int total, int target) {
        if(total == target){
            ans.add(new ArrayList<>(subset));
            return;
        }
        if(total> target || start >= nums.length){return;}
        //with element at start
        subset.add(nums[start]);
        backtrack(ans,subset,nums,start+1,total+nums[start],target);

        //remove element

        subset.remove(subset.size()-1);
        backtrack(ans,subset,nums,start+1,total,target);
    }

}
