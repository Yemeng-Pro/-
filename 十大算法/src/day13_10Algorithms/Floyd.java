package day13_10Algorithms;

import java.util.Arrays;

/**
 * @author Yemeng
 * @create 2021-01-09-19:55
 */
public class Floyd {
    char[] vertex;
    int[][] edges;
    int[][] dis;
    int[][] pre;
    private static final int N = 65535;
    public Floyd(char[] vertex, int[][] edges) {
        this.vertex = vertex;
        this.edges = edges;
        this.dis = edges;
        int len = vertex.length;
        pre = new int[len][len];
        for(int i=0; i<len; i++) {
            Arrays.fill(pre[i], i);
        }
    }
    public void floyd() {
        int len = vertex.length;
        int temp;
        //中间节点k
        for(int k=0; k<len; k++) {
            //起始节点i
            for(int i=0; i<len; i++) {
                //终点j
                for(int j=0; j<len; j++) {
                    temp = dis[i][k] + dis[k][j];
                    if(temp < dis[i][j]) {
                        dis[i][j] = temp;
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method st
        char[] arr = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] edges = new int[][] {
                {0,5,7,N,N,N,2},
                {5,0,N,9,N,N,3},
                {7,N,0,N,8,N,N},
                {N,9,N,0,N,4,N},
                {N,N,8,N,0,5,4},
                {N,N,N,4,5,0,6},
                {2,3,N,N,4,6,0}
        };
        Floyd f = new Floyd(arr, edges);
        f.floyd();
        for(int i=0; i<arr.length; i++) {
            System.out.println(Arrays.toString(f.pre[i]));
        }
    }
}

