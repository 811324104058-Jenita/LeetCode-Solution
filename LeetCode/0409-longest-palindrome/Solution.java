class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int ans = 0;

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (int n : count) {
            ans += (n / 2) * 2;
            if (ans % 2 == 0 && n % 2 == 1) {
                ans++;
            }
        }

        return ans;
    }
}