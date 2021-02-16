package day06_search;

import java.util.Arrays;

/**
 * @author Yemeng
 * @create 2020-12-28-10:40
 */
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int [] arr = {1,8, 10, 89, 1000};
        System.out.println("index=" + fibSearch(arr, 1000));
    }
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0; //表示斐波那契分割数值的下标
        int mid = 0; //存放mid 值
        int f[] = fib(); //获取到斐波那契数列
        //获取到斐波那契分割数值的下标
        while(high > f[k] - 2) {
            k++;
        }
        //因为f[k] 值可能大于a 的长度，因此我们需要使用Arrays 类，构造一个新的数组，并指向temp[]
        //不足的部分会使用0 填充
        int[] temp = Arrays.copyOf(a, f[k]-1);
        //实际上需求使用a 数组最后的数填充temp
        //举例:
        //temp = {1,8, 10, 89, 1000, 1234, 0, 0} => {1,8, 10, 89, 1000, 1234, 1234, 1234,}
        for(int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        while (low <= high) { // 只要这个条件满足，就可以找
            mid = low + f[k - 1] - 1;
            if(key < temp[mid]) { //我们应该继续向数组的前面查找(左边)
                high = mid - 1;
            //为甚是k--
            //说明
            //1. 全部元素= 前面的元素+ 后边元素
            //2. f[k] = f[k-1] + f[k-2]
            //因为前面有f[k-1]个元素,所以可以继续拆分f[k-1] = f[k-2] + f[k-3]
                //即在f[k-1] 的前面继续查找k--
                //即下次循环mid = f[k-1-1]-1
                k--;
            } else if ( key > temp[mid]) { // 我们应该继续向数组的后面查找(右边)
                low = mid + 1;
            //为什么是k -=2
            //说明
            //1. 全部元素= 前面的元素+ 后边元素
            //2. f[k] = f[k-1] + f[k-2]
            //3. 因为后面我们有f[k-2] 所以可以继续拆分f[k-1] = f[k-3] + f[k-4]
            //4. 即在f[k-2] 的前面进行查找k -=2
            //5. 即下次循环mid = f[k - 1 - 2] - 1
                k -= 2;
            } else { //找到
            //需要确定，返回的是哪个下标
                if(mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
