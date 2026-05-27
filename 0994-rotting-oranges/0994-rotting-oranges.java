class Solution {
    class Pair{
        int row;
        int col;
    
        int  _min;
        Pair(int row ,int col,int _min){
            this.row=row;
            this.col=col;
            this._min=_min;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int countFresh=0;
        
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }
                if(grid[i][j]==1){
                    countFresh++;
                }
            }
        }
 
                int dr[]={1,-1,0,0};
                int dc[]={0,0,-1,1};
           
        int tm=0;
        while(!q.isEmpty()){
          
                Pair p=q.poll();
                int row=p.row;
                int col=p.col;
                int _min=p._min;
                tm=_min;
                

                for(int j=0;j<4;j++){
                    int tempR=row+dr[j];
                    int tempC=col + dc[j];

                    if(tempR>=0 && tempR<n && tempC>=0 && tempC<m && grid[tempR][tempC]==1  ){
                        q.add(new Pair(tempR,tempC,_min+1));
                        grid[tempR][tempC]=2;
                        countFresh--;
                    }
                }
            
           
        }
         if(countFresh!=0)return -1;
        return tm;
    }
}