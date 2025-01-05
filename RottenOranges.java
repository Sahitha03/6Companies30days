class Pair{
    int row;
    int col;
    int tm;
    Pair(int r,int c,int t)
    {
        this.row=r;
        this.col=c;
        this.tm=t;
    }
}


class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int vis[][]=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else if(grid[i][j]==0)
                {
                    vis[i][j]=0;
                }
                else
                {
                    cnt++; //To count fresh oranges
                }
            }
        }
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        int tm=0;
        int co=0;
        while(!q.isEmpty())
        {
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().tm;
            tm=Math.max(tm,t);
            q.remove();
            for(int i=0;i<4;i++)
            {
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol] != 2)
                {
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    co++;
                }
            }
        }
        if(cnt!=co)
        {
            return -1;
        }
        return tm;
    }
}
