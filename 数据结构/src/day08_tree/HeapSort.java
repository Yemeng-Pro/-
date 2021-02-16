package day08_tree;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Yemeng
 * @create 2020-12-30-21:05
 */
public class HeapSort {

    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] arr) {
        int temp;
        System.out.println("堆排序");
        for(int i = arr.length / 2 -1; i >=0; i--) {
            adjustHeap(arr, i, arr.length);
        }


        for(int j = arr.length-1;j >0; j--) {
        //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }


    public static void adjustHeap(int arr[], int i, int lenght) {
        int temp = arr[i];
        for(int k = i * 2 + 1; k < lenght; k = k * 2 + 1) {
            if(k+1 < lenght && arr[k] < arr[k+1]) { //说明左子结点的值小于右子结点的值
                k++; // k 指向右子结点
            }
            if (arr[k] > temp) { //如果子结点大于父结点
                arr[i] = arr[k]; //把较大的值赋给当前结点
                i = k; //!!! i 指向k,继续循环比较
            } else {
                break;
            }
        }
        //当for 循环结束后，我们已经将以i 为父结点的树的最大值，放在了最顶(局部)
        arr[i] = temp;//将temp 值放到调整后的位置
    }

}

