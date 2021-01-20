//Time Complexity: O(N^3) for input string of length N.
//Space Complexity: O(1). We don't need to allocate any extra space since we are repeatedly iterating on the input string itself.
class Solution {
    int find(int i, int j, String s){
        int ans = 0;
        if(i==j)
            return 1;
        if(i>j)
            return 1;
        if(s.charAt(i)!=s.charAt(j))
            return 0;
        return ans = find(i + 1, j - 1, s);
    }
    public int countSubstrings(String s) {
        int N = s.length();
        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                ans += find(i,j,s);
            }
        }
        return ans;
    }
}


//Optimized Code

// Time Complexity: O(N^2) for input string of length NN. The total time taken in this approach is dictated by two variables:

// The number of possible palindromic centers we process.
// How much time we spend processing each center.
// The number of possible palindromic centers is 2N-1: there are NN single character centers and N-1N−1 consecutive character pairs as centers.

// Each center can potentially expand to the length of the string, so time spent on each center is linear on average. Thus total time spent is N . (2N-1) ≃ N^2
// Space Complexity: O(1). We don't need to allocate any extra space since we are repeatedly iterating on the input string itself.


class Solution {
    public int countSubstrings(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); ++i) {
            // odd-length palindromes, single character center
            ans += countPalindromesAroundCenter(s, i, i);

            // even-length palindromes, consecutive characters center
            ans += countPalindromesAroundCenter(s, i, i + 1);
        }

        return ans;
    }

    private int countPalindromesAroundCenter(String ss, int lo, int hi) {
        int ans = 0;

        while (lo >= 0 && hi < ss.length()) {
            if (ss.charAt(lo) != ss.charAt(hi))
                break;      // the first and last characters don't match!

            // expand around the center
            lo--;
            hi++;

            ans++;
        }

        return ans;
    }
}