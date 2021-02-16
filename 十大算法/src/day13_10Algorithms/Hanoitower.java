package day13_10Algorithms;

/**
 * @author Yemeng
 * @create 2021-01-06-15:37
 */
public class Hanoitower {
    public static void main(String[] args) {
//        Hanoitower sb = new  Hanoitower();
        new Hanoitower().hanoiTower(3,'A','B','C');
//        sb.hanoiTower(3,'A','B','C');
//        System.out.println(count);
    }
    int count = 0;
    public void hanoiTower(int num, char a, char b, char c) {
        //如果只有一个盘
        if(num == 1) {
            System.out.println("第1 个盘从" + a + "->" + c);
            count++;
        } else {
        //如果我们有n >= 2 情况，我们总是可以看做是两个盘1.最下边的一个盘2. 上面的所有盘
            //1. 先把最上面的所有盘A->B， 移动过程会使用到c
            hanoiTower(num - 1, a, c, b);
            //2. 把最下边的盘A->C
            System.out.println("第" + num + " 个盘从" + a + "->" + c);
            count++;
            //3. 把B 塔的所有盘从B->C , 移动过程使用到a 塔
            hanoiTower(num - 1, b, a, c);
        }
    }
}
