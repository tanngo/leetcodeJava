package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BeautifulTower {
    public static void main(String[] args) {
        List<Integer> newlist = new ArrayList<Integer>();
        newlist.add(1);
        newlist.add(2);
        newlist.add(6);
        newlist.add(3);
        newlist.add(4);
        newlist.add(1);
        System.out.println(String.format("final result %d",maximumSumOfHeights(newlist)));
    }
    public static long maximumSumOfHeights(List<Integer> A) {
        int n = A.size();

        long[] left = new long[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        long res = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(String.format("i - %d",i));
            while (stack.size() > 1 && A.get(stack.peek()) > A.get(i)) {
                System.out.print("stack - ");
                System.out.println(stack);
                int j = stack.pop();
                cur -= 1L * (j - stack.peek()) * A.get(j);
                System.out.println(String.format("cur-inside - %d",i));
            }
            cur += 1L * (i - stack.peek()) * A.get(i);
            System.out.println(String.format("cur - %d",i));
            stack.push(i);
            left[i] = cur;
            System.out.print("left - ");
            System.out.println(Arrays.toString(left));
        }

        stack.clear();
        stack.push(n);
        cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() > 1 && A.get(stack.peek()) > A.get(i)) {
                int j = stack.pop();
                cur -= 1L * -(j - stack.peek()) * A.get(j);
            }
            cur += 1L * -(i - stack.peek()) * A.get(i);
            stack.push(i);
            res = Math.max(res, left[i] + cur - A.get(i));
        }

        return res;
    }
}
