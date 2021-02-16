package day05_sort;

import java.util.Arrays;

/**
 * @author Yemeng
 * @create 2020-12-24-20:12
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, 20,-2};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);

    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;

        //时间复杂度O(n2)
        for (int i = 1; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i ; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟排序后的数组");
            System.out.println(Arrays.toString(arr));
            if (!flag) { // 在一趟排序中，一次交换都没有发生过
                break;
            } /**else {
                flag = false; // 重置flag!!!, 进行下次判断
            }*/
        }
    }
}
