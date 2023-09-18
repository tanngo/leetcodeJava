package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationProblem {

    public static void main(String[] args) {
        int [] nums = new int[]{1,3,4};
        PermutationProblem problem = new PermutationProblem();
        List<List<Integer>> result = problem.permute(nums);
    }
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        List<List<Integer>> result = new ArrayList();
         permute(list,result);
         return result;
    }
    public List<List<Integer>>permute(List<Integer> list,List<List<Integer>> result ){

        if(list.size() == 1){
            List<List<Integer>> output = new ArrayList();
            output.add(list);
            return output;
        }
        for(int i =0;i< list.size();i++){
            Integer n = list.get(0);
            list.remove(0);
            List<List<Integer>>subset = permute(list,result);
            for(List<Integer> item: subset){
                item.add(n);

            }
            result.addAll(subset);
            list.add(n);
        }
        return result;

    }
}
