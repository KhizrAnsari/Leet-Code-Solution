class Solution {
    static int PiivotIndex(int[] nums){
     int n = nums.length;
     int s = 0;
     int e = n-1;
     int ans = -1;

// agar rotation nahi hau ho tab
     if(nums[s] < nums[e]){
        return -1;
     }

     while( s <= e){
        // mid pointer nikala
        int mid = s + (e-s)/2;
        // condition check karna hai  
        if(nums[mid] <= nums[n-1]){
            e = mid - 1;
        }else{
            // agar arr[mid] > arr[n-1]
            // ans store karna hai 
            ans= mid;
            //right side move on karna hai
            s = mid + 1;
        }
     }
             return ans;

    }
    public static int Binary(int[] nums, int s, int e, int target ){   
           int n = nums.length;
           while( s <= e){
            int mid = s + (e-s)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if ( nums[mid] < target){
                s = mid +1;
            }else{
                e = mid - 1;
            }
           }
            return -1;
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivotIndex = PiivotIndex(nums);

        // if pivotIndex = -1 so array is already sorted
           if(pivotIndex == -1){
            int ans = Binary(nums,0,n-1,target);
                return ans;
           }else{
        // Array is not sorted , Array is roteted sorted
        // Array can be devide into l1 and l2

        // index for l1 wale array ka part
        int startArray1 = 0;
        int endArray1 = pivotIndex;

        if(target >= nums[startArray1] && target <= nums[endArray1]){
            int ans = Binary(nums, startArray1, endArray1, target);
            return ans;
        }

        // index of l2 wale array ka part
        int startArray2 = pivotIndex + 1;
        int endArray2 = n-1;

        if(target >= nums[startArray2] && target <= nums[endArray2]){
            int ans = Binary(nums, startArray2, endArray2, target);
            return ans;
        }
    }
    return -1;

}
}