class Solution {
    public int maxLength(int[] nums) {
        
        int left = 0;
        int ans = 0;

        for(int right =0; right < nums.length; right++){
            while(!isValid(nums, left, right)){
                left++;
            }
            ans = Math.max(ans, right -left + 1);
        }
        return ans;
    }
    private boolean isValid(int[] nums, int left,int right){
        if(right - left + 1 <= 2){
            return true;
        }
        for(int i= left; i<= right; i++){
            for(int j=i+1; j<= right; j++){
                if(gcd(nums[i], nums[j]) != 1){
                    return false;
                }
            }
        }
        return true;
    }
    private int gcd(int a, int b){
        while( b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}