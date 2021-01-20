// Time Complexity: O(N^2), where N is the length of A.

// Space Complexity: O(1) in additional space complexity.

class Solution {
    public int minFallingPathSum(int[][] A) {
        int N = A.length;
        for(int r=N-2;r>=0;r--){
            for(int c=0;c<N;c++){
                int best = A[r+1][c];
                if(c>0){
                    best = Math.min(best, A[r+1][c-1]);
                }
                if(c+1<N){
                    best = Math.min(best, A[r+1][c+1]);
                }
                A[r][c]+=best;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i : A[0]){
            ans = Math.min(ans, i);
        }
        return ans;
    }
}