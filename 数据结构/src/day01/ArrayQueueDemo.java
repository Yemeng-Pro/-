package day01;

import java.util.Scanner;

/**
 * @author Yemeng
 * @create 2020-12-17-20:25
 */
public class ArrayQueueDemo {
    //测试
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):从队列取数据");
            key = scanner.next().charAt(0); //接收一个字符

            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    try {
                        System.out.println("请输入一个数");
                        int value = scanner.nextInt();
                        arrayQueue.addQueue(value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出的数据是"+res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    int res2 = arrayQueue.headQueue();
                    System.out.println("队列头的数据是"+res2);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }
        System.out.println("程序退出");

    }
}


//用数组实现队列
class ArrayQueue {
    private int maxSize; //数组容量
    private int head;    //队列头
    private int tail;    //队列尾
    private int[] arr;   //用于存放数据,模拟队列
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        head = -1;
        tail = -1;
    }

    //判断队列是否满
    public boolean isFull() {
        return tail == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return tail == head;
    }

    //添加数据
    /*public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("队列满");
        }
        tail++;
        arr[tail] = n;
    }*/
    //优化代码
    public boolean addQueue(int n) {
        if (tail == 2) {
            if (head == -1) return false;
            for (int i = head + 1; i <= tail; i++){
                arr[i - head - 1] = arr[i];
            }
            tail -= head+1;
            head = -1;
        }
        tail++;
        arr[tail] = n;
        return true;
    }

    //获取数据
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }

        head++;
        return arr[head];

    }

    //显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空的，没有数据");
            return;
        }
        for (int i = head + 1; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列头的数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列是空的");
        }
        return arr[head + 1];
    }














}