class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(String s, int start, List<String> path,
                   List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);

            if (isPalindrome(sub)) {
                path.add(sub);
                backtrack(s, i + 1, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}
