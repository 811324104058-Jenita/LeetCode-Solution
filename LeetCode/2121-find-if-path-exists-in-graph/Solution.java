class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination) return true;
        List<List<Integer>>adjlist=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int []edge:edges){
           int src=edge[0];
            int dest=edge[1];
            adjlist.get(src).add(dest);
            adjlist.get(dest).add(src);
        }
        boolean visit[]=new boolean[n];
        Queue<Integer>q=new LinkedList<>();
        visit[source]=true;
        q.offer(source);
        while(!q.isEmpty()){
            source=q.poll();
            for(int vertex:adjlist.get(source)){
                if(vertex==destination) return true;
                if(!visit[vertex]){
                    visit[vertex]=true;
                    q.offer(vertex);
                }
            }
        }
        return false;
    }
} 
