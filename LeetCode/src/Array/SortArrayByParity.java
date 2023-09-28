package Array;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length ==1)return nums;
        int left =0;
        int right =nums.length -1;
        while(left<=right && left >=0){
            if(nums[right] %2 == 1) right--;
            else
            if(nums[left] %2 ==0) left++;
            else
            if(nums[left] % 2 ==1 && right > left){
                //switch with right -1
                int temp = nums[right];
                nums[right]= nums[left];
                nums[left]= temp;
                left++;
                right--;
            }
            else if(nums[right] % 2 == 0 && right > left){
                //switch with right -1
                int temp = nums[right];
                nums[right]= nums[left];
                nums[left]= temp;
                left++;
                right--;
            }
        }
        return nums;
    }
}
