package day05_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Yemeng
 * @create 2020-12-24-21:43
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000); // 生成一个[0, 8000000) 数
        }
//        int[] arr = new int[]{3,4,2,1,8,6};
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
        selectSort(arr);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

    }
    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.println("第"+(i+1)+"轮后~~");
//            System.out.println(Arrays.toString(arr));


//            for (int i = 0; i < arr.length - 1; i++) {
//                int minIndex = i;
//                int min = arr[i];
//                for (int j = i + 1; j < arr.length; j++) {
//                    if (min > arr[j]) { // 说明假定的最小值，并不是最小
//                        min = arr[j]; // 重置min
//                        minIndex = j; // 重置minIndex
//                    }
//                }
//                if (minIndex != i) {
//                    arr[minIndex] = arr[i];
//                    arr[i] = min;
//                }

        }
    }
}
