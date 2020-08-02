/**
 * LeetCode 1514
 * 最后一个报超时，且LeetCode不显示用例
 */
class SolutionL1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] nodeMaxProb = new double[n];
        int currentNode = start;
        boolean[] visited = new boolean[n];
        visited[start] = true;
        nodeMaxProb[start] = 1;
        // current用于贪心遍历，遍历到-1则说明遍历失败
        while (currentNode != end && currentNode != -1) {
            double maxProb = 0;
            int maxFrom = -1, maxTo = -1;
            for (int i = 0; i < edges.length; i++) {
                if (visited[edges[i][0]] ^ visited[edges[i][1]]) {
                    int from, to;
                    if (visited[edges[i][0]]) {
                        from = edges[i][0];
                        to = edges[i][1];
                    } else {
                        from = edges[i][1];
                        to = edges[i][0];
                    }
                    double temp = succProb[i] * nodeMaxProb[from];
                    if (temp > maxProb) {
                        maxProb = temp;
                        maxFrom = from;
                        maxTo = to;
                    }
                }
            }
            // 遍历下一个节点如存在，则标记为已访问，且更新最大概率列表
            if (maxFrom != -1) {
                visited[maxTo] = true;
                nodeMaxProb[maxTo] = maxProb;
            }
            currentNode = maxTo;
        }
        if (currentNode == -1) {
            return 0;
        } else {
            return nodeMaxProb[end];
        }
    }

///   邻接矩阵方法内存溢出
//    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
//        // 邻接矩阵
//        double[][] matrix = new double[n][n];
//        // 邻接表转邻接矩阵
//        for (int i = 0; i < edges.length; i++) {
//            matrix[edges[i][0]][edges[i][1]] = succProb[i];
//            matrix[edges[i][1]][edges[i][0]] = succProb[i];
//        }
//
//        int currentNode = start;
//        // 邻接矩阵只使用右上的一半
//        boolean[] visited = new boolean[n];
//        visited[start] = true;
//        // 邻接对角线用于存储到对应节点的最高概率值
//        matrix[start][start] = 1;
//        // current用于贪心遍历，遍历到-1则说明遍历失败
//        while (currentNode != end && currentNode != -1) {
//            double maxProb = 0;
//            int maxi = -1, maxj = -1;
//            for (int i = 0; i < n; i++) {
//                if (visited[i]) {
//                    for (int j = 0; j < n; j++) {
//                        if (!visited[j]) {
//                            double temp = matrix[i][j] * matrix[i][i];
//                            if (temp > maxProb) {
//                                maxProb = temp;
//                                maxi = i;
//                                maxj = j;
//                            }
//                        }
//                    }
//                }
//            }
//            // 遍历下一个节点如存在，则标记为已访问，且更新邻接表对角线
//            if (maxi != -1) {
//                visited[maxj] = true;
//                matrix[maxj][maxj] = maxProb;
//            }
//            currentNode = maxj;
//        }
//        if (currentNode == -1) {
//            return 0;
//        } else {
//            return matrix[end][end];
//        }
//    }
}