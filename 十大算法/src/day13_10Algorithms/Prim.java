package day13_10Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Yemeng
 * @create 2021-01-07-20:44
 */
public class Prim {
    public static void prim(Graph graph) {
        int len = graph.vertex.size();
        int[][] edges = graph.edges;
        ArrayList<String> vertex = graph.vertex;
        //保存顶点是否被标记过
        boolean[] flag = new boolean[len];
        for(int i=0; i<len; i++) {
            flag[i] = false;
        }
        //以第0个元素作为起始点
        flag[0] = true;
        int count, h1=-1, h2=-1;
        for(int k=1; k<len; k++) {
            count = 10000;
            for(int i=0; i<len; i++) {
                for(int j=0; j<len; j++) {
                    if(flag[i] && !flag[j] && count > edges[i][j]) {
                        count = edges[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //遍历一次邻接矩阵后找到最短的连接路线
            flag[h2] = true;
            System.out.print(vertex.get(h1) + "->" + vertex.get(h2) + edges[h1][h2] + "    ");
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String[] arr = {"A", "B", "C", "D", "E", "F", "G"};
        Graph graph = new Graph(arr);
        int[][] edges = new int[][] {
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };
        graph.edges = edges;
        prim(graph);
    }
}

class Graph{
    ArrayList<String> vertex;
    int[][] edges;
    public Graph(String[] arr) {
        int n = arr.length;
        vertex = new ArrayList<String>(n);
        for(int i=0; i<n; i++) {
            vertex.add(arr[i]);
        }
        edges = new int[n][n];
    }
    //用邻接矩阵展示图
    public void show() {
        for(int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }
}