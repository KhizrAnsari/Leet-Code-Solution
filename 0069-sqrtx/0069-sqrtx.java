class Solution {
    public int mySqrt(int x) {
        int s = 1;
        int e = x;
        int ans = 1;

        if(x == 0){
            return 0;
        }

        while( s <= e){
            int mid = s + (e-s)/2;

            if(mid == x/mid){
                return mid;
            }
            else if(mid > x/mid){
                // right part ko remove kar do
                e = mid - 1;
            }else{
                // answer ko store karo 
                // lest part ko remove kar do
                ans = mid;
                s = mid + 1;
            }

        }
        return ans;
    }
}