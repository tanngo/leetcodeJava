package Backtracking;

import Common.PrintUtils;

import java.util.ArrayList;
import java.util.List;

//Given an array of positive integers arr[] and an integer x, The task is to find all unique combinations in arr[] where the sum is equal to x.
//        The same repeated number may be chosen from arr[] an unlimited number of times. Elements in a combination (a1, a2, …, ak)
//        must be printed in non-descending order. (ie, a1 <= a2 <= … <= ak). If there is no combination possible print “Empty”.
public class CombinationSumProblem {
    public static void main(String[] args) {
        CombinationSumProblem problem = new CombinationSumProblem();
        int [] candidates = new int[]{1,2,3,4,7};
       List<List<Integer>> result = problem.combinationSum(candidates,7);
       
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> subset = new ArrayList();
        dfs(candidates,0,result,subset,0,target);
        return result;
    }

    public void dfs(int []candidates,int start, List<List<Integer>> result, List<Integer> subset, int total, int target){
        if(total == target){
            result.add(new ArrayList<Integer>(subset));
            return;
        }
        if(start == candidates.length || total > target) return;
        subset.add(candidates[start]);
        dfs(candidates,start+1,result,subset,total+candidates[start],target);
        subset.remove(subset.size() -1);
        dfs(candidates, start+1, result,subset, total,target);
    }
}
