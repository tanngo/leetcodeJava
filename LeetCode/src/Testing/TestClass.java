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
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> numList2 = IntStream.of(nums).boxed().collect(Collectors.toList());
        backtrack(ans, subset,numList,0);

    }

    public static void backtrack(List<List<Integer>> ans, List<Integer>subset, List<Integer>nums, int start) {
        if(start == nums.size()){
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums.get(start));
        backtrack(ans,subset,nums,start+1);
        //without eleements
        subset.remove(nums.get(start));
        backtrack(ans,subset,nums,start+1);    }



}
