class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, p, i, 0);
            dfs(heights, a, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, p, 0, j);
            dfs(heights, a, m - 1, j);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] && a[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    void dfs(int[][] h, boolean[][] vis, int r, int c) {
        if (r < 0 || c < 0 || r >= h.length || c >= h[0].length || vis[r][c])
            return;

        vis[r][c] = true;

        for (int[] d : dir) {
            int nr = r + d[0], nc = c + d[1];

            if (nr >= 0 && nc >= 0 && nr < h.length && nc < h[0].length
                    && h[nr][nc] >= h[r][c]) {
                dfs(h, vis, nr, nc);
            }
        }
    }
}