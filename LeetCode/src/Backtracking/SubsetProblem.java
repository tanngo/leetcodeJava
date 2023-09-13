package Backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/submissions/
public class SubsetProblem {
    public static void main(String[] args) {
        SubsetProblem problem = new SubsetProblem();
        int[] numbers = new int[]{1,2,4};
        List<List<Integer>> result = problem.subsets(numbers);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        ArrayList<Integer> subset = new ArrayList();
        backTracking(result,subset,nums,0);
        return result;
    }
    public void backTracking(List<List<Integer>> ans, ArrayList<Integer> subset, int[] nums, int start){
        System.out.println(start);
        if(start == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        //include i element
        subset.add(nums[start]);
        backTracking(ans,subset,nums,start+1);

        //exclude i element
        subset.remove(subset.size()-1);

        backTracking(ans,subset,nums,start+1);

    }
}
