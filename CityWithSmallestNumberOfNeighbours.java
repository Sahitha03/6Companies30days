class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] matrix = new int[n][n];

        for(int edge[] : edges) {
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        }        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) matrix[i][j] = (int)1e9;
                if(i == j) matrix[i][j] = 0;
            }
        }
        for(int via = 0; via < n; via++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == (int)1e9) matrix[i][j] = 0;
            }
        }
        
        int min = n + 1;
        int node = -1;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] <= distanceThreshold && matrix[i][j] != 0) count++;
            }
            if(count <= min) {
                min = count;
                node = i;
            }
        }
        return node;
    }
}
