package day13_10Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Yemeng
 * @create 2021-01-08-20:06
 */
public class Kruskal {
    ArrayList<EData> edgeSet = new ArrayList<>();
    int[][] edges;
    ArrayList<String> vertex;
    private static final int INF = Integer.MAX_VALUE;

    public Kruskal(String[] arr, int[][] edges) {
        int n = arr.length;
        vertex = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            vertex.add(arr[i]);
        }
        this.edges = edges;
        //将图中所有的边放入edgeSet
        for(int i=0; i<vertex.size(); i++) {
            for(int j=i+1; j<vertex.size(); j++) {
                if(edges[i][j] != INF) {
                    edgeSet.add(new EData(vertex.get(i), vertex.get(j), edges[i][j]));
                }
            }
        }
        System.out.println(edgeSet);
        //排序
        Collections.sort(edgeSet);
    }

    //返回顶点STR的下标
    public int getNum(String str) {
        for (int i = 0; i < vertex.size(); i++) {
            if (str.equals(vertex.get(i))) {
                return i;
            }
        }
        return -1;
    }
    /**
     *  获得顶点k的终点，很简洁高效的方法
     * @param end 存储每个顶点终点的数组
     * @param k
     * @return k的终点
     */
    public int getEnd(int[] end, int k) {
        while(end[k] != 0) {
            k = end[k];
        }
        return k;
    }
    public void show() {
        for(int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }
    public void kruskal() {
        int len = edgeSet.size();
        ArrayList<EData> finalSet = new ArrayList<EData>();
        EData temp;
        //存放顶点的终点
        int[] end = new int[vertex.size()];
        int v1, v2, n1, n2;
        //遍历所有边
        for(int i=0; i<len; i++) {
            //每次都选权值最小的边
            temp = edgeSet.get(i);
            v1 = getNum(temp.v1);
            v2 = getNum(temp.v2);
            n1 = getEnd(end, v1);
            n2 = getEnd(end, v2);
            //如果边temp的两个顶点的终点相等，从edgeSet中删除temp，跳出本次循环
            if(n1 == n2) {
//                edgeSet.remove(temp);
            }else {
                //也可以换成end[n1] = v2;
                //这样保证出现新的靠后的顶点后，可以保证之前的顶点的终点都指向新出现的顶点，不理解可以debug 权重8到9时end的变化
                end[n1] = n2;
//                edgeSet.remove(temp);
                finalSet.add(temp);
            }
        }
        System.out.println("弄完后" + finalSet);
    }
    public static void main(String[] args) {
        String[] arr = {"A","B","C","D","E","F","G"};
        int[][] edges = {
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0}
        };
        Kruskal k = new Kruskal(arr, edges);
        k.kruskal();
        System.out.println();
    }

}
class EData implements Comparable<EData>{
    String v1;
    String v2;
    int weigth;
    public EData(String v1, String v2, int weigth) {
        this.v1 = v1;
        this.v2 = v2;
        this.weigth = weigth;
    }
    @Override
    public String toString() {
        return "<" + v1 + ", " + v2 + ">=" + weigth;
    }
    @Override
    public int compareTo(EData o) {
        // TODO Auto-generated method stub
        return this.weigth - o.weigth;
    }

}