package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubStringProblem {
    public static void main(String[] args) {
        SubStringProblem sub = new SubStringProblem();
        List<String> subList = sub.findAllSubString("abc");
        for(String s :subList){
            System.out.println(s);
        }
    }
    public  List<String> findAllSubString(String input){
        char []chars = input.toCharArray();
        List<String> output = new ArrayList();
        backTracking(chars,0,"",output);
        return output;
    }
    public void backTracking(char[] arr, int start,
                             String cur,List<String> output){
        if(start == arr.length ){
            if(!cur.equals(""))output.add(cur);
            return;
        }
        cur += arr[start];
        backTracking(arr, start+1, cur,output);
        cur = cur.substring(0,cur.length()-1);
        backTracking(arr, start+1, cur,output);
    }
}
