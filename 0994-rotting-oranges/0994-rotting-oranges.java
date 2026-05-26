class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row ,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(n==1 && m==1 && grid[0][0]==0)return 0;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }
 
            int count =-1;
        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                Pair p=q.poll();
                int row=p.row;
                int col=p.col;
                
                
                int dr[]={1,-1,0,0};
                int dc[]={0,0,-1,1};

                for(int j=0;j<4;j++){
                    int tempR=row+dr[j];
                    int tempC=col + dc[j];

                    if(tempR>=0 && tempR<n && tempC>=0 && tempC<m && grid[tempR][tempC]==1  ){
                        q.add(new Pair(tempR,tempC));
                        grid[tempR][tempC]=2;
                    }
                }
            }
            count++;
        }
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return count==-1?0 : count;
    }
}