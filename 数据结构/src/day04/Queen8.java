package day04;

/**
 * @author Yemeng
 * @create 2020-12-24-16:32
 */
public class Queen8 {
    int max = 8;
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    //写一个方法，可以将皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    //编写一个方法，放置第n 个皇后
    //特别注意： check 是每一次递归时，进入到check 中都有for(int i = 0; i < max; i++)，因此会有回溯
    private void check(int n) {
        if(n == max) { //n = 8 , 其实8 个皇后就既然放好
            print();
            return;
        }
    //依次放入皇后，并判断是否冲突
        for(int i = 0; i < max; i++) {
    //先把当前这个皇后n , 放到该行的第1 列
            array[n] = i;
    //判断当放置第n 个皇后到i 列时，是否冲突
            if(judge(n)) { // 不冲突
//接着放n+1 个皇后,即开始递归
                check(n+1); //
            }
//如果冲突，就继续执行array[n] = i; 即将第n 个皇后，放置在本行得后移的一个位置
        }
    }
    //查看当我们放置第n 个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突
    /**
     *
     * @param n 表示第n 个皇后
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        for(int i = 0; i < n; i++) {
// 说明
//1. array[i] == array[n] 表示判断第n 个皇后是否和前面的n-1 个皇后在同一列
//2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n 个皇后是否和第i 皇后是否在同一斜线
// n = 1 放置第2 列1 n = 1 array[1] = 1
// Math.abs(1-0) == 1 Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
//3. 判断是否在同一行, 没有必要，n 每次都在递增
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i]) ) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
    //测试一把， 8 皇后是否正确
        Queen8 queue8 = new Queen8();
        queue8.check(0);
        System.out.printf("一共有%d 解法", count);
        System.out.printf("一共判断冲突的次数%d 次", judgeCount); // 1.5w
    }
}
