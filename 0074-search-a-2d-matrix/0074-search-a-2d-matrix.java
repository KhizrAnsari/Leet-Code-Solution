class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int Totalrow = matrix.length;
        int Totalcol = matrix[0].length;

        int n = Totalrow * Totalcol;
        int s = 0;
        int e = n-1;

        while(s<=e){
            int mid = s+(e-s)/2;
            int RowIndex = mid/Totalcol;
            int ColIndex = mid%Totalcol;

            if(matrix[RowIndex][ColIndex] == target){
                return true;
            }else if(matrix[RowIndex][ColIndex] > target){
                e= mid-1;
            }else{
                s = mid+1;
            }
        }
        return false;
    }
}