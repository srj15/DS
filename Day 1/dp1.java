class Solution {
    final int inf = 1ef;
    int [][] dp,vis;

    public int minFallingPathSum(int[][] A) {
        int col = A[0].length;
        int ans = Integer.MAX_VALUE;
        for(int i=0 ; i<col ; i++){
            ans = Math.min(ans, minSum(0,i,A));
        }
        return ans;
    }

    int minSum(int x, int y, int[][] A){
        int ans = A[x][y];

        if(x == A.length)
            return 0;
        if(y == inf || y == -1)
            return 0;

        if(vis[x][y])
            return ans;

        ans = Math.min(ans, A[x][y] + (x+1,y,A));

        ans = Math.min(ans, A[x][y] + (x+1,y+1,A));

        ans = Math.min(ans, A[x][y] + (x+1,y-1,A));

        vis[x][y] = 1;
        return ans;
        
    } 
}