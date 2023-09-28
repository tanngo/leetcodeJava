package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RemoveDuplicates {

    public static void main(String[] args) {
       String result = removeDuplicateLetters("cbdeacdcbc");
        System.out.println("result: "+ result);
    }
    public static String removeDuplicateLetters(String s) {
        // find pos - the index of the leftmost letter in our solution
        // we create a counter and end the iteration once the suffix doesn't have each unique character
        // pos will be the index of the smallest character we encounter before the iteration ends
        int[] cnt = new int[26];
        int pos = 0;
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        // our answer is the leftmost letter plus the recursive call on the remainder of the string
        // note that we have to get rid of further occurrences of s[pos] to ensure that there are no duplicates
        if(s.length() >0 ) System.out.println(String.format("string at %d: %s",pos,s.charAt(pos)));
        String substring="";
        if(s.length() >0 )  substring = s.substring(pos + 1).replaceAll("" + s.charAt(pos), "");
        System.out.println(String.format("substring: %s", substring));
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(substring);
    }
}