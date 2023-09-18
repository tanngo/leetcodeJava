package Backtracking;

import Common.PrintUtils;

import java.util.ArrayList;
import java.util.List;

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
        dfs(candidates,start,result,subset,total+candidates[start],target);

        subset.remove(subset.size() -1);
        dfs(candidates, start+1, result,subset, total,target);
    }
}
