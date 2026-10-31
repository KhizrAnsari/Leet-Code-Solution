class Solution {
    public int maxSubArray(int[] nums) {

        int sum =0;
        int max = Integer.MIN_VALUE;
        //step1 sum ko find karne h
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
        //step2  max ko sotre karna h
         max = Math.max(max,sum);
        //step3  sum check karna ahi for (0<)
        if(sum < 0)
        sum = 0;
        }
            return max;

    }

}
