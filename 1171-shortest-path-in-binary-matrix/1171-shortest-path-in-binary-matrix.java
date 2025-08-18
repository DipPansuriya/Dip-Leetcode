class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;

        if(grid[0][0] != 0 || grid[m-1][m-1] != 0) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][m];

        // Map<String, String> parent = new HashMap<>();
        // parent.put("0-0", null);

        // Stack<String> stack = new Stack<>();

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        int[][] dirs = {{-1,0}, {1,0}, {0, 1}, {0, -1}, {-1,1}, {1, 1}, {1, -1}, {-1, -1}};

        int ans = 0;

        while(!queue.isEmpty()) {
            int qlen = queue.size();

            for(int i=0; i<qlen; i++) {
                int[] temp = queue.poll();

                if(temp[0] == m-1 && temp[1] == m-1) {
                    
                    // String current = temp[0] + "-" + temp[1];

                    // while(current != null) {
                    //     stack.push(current);
                    //     current = parent.get(current);
                    // }

                    // StringBuilder sb = new StringBuilder();

                    // while(!stack.isEmpty()) {
                    //     sb.append(stack.pop() + " ");
                    // }

                    // System.out.println(sb.toString());


                    return ans + 1;
                }

                for(int[] dir : dirs) {
                    int dx = dir[0] + temp[0];
                    int dy = dir[1] + temp[1];

                    if(dx < 0 || dx >= grid.length || dy < 0 || dy >= grid[0].length || visited[dx][dy] || grid[dx][dy] == 1) {
                        continue;
                    }

                    queue.add(new int[]{dx, dy});
                    visited[dx][dy] = true;

                    // parent.put(dx+"-"+dy, temp[0]+"-"+temp[1]);
                }
            }

            ans++;
        }

        return -1;
    }
}