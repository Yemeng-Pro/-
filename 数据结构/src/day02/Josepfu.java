package day02;

/**
 * @author Yemeng
 * @create 2020-12-22-16:25
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,2,5);
    }
}


class CircleSingleLinkedList {
    private Boy first = null;

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不准确");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }

        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("没有任何小孩");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号" + curBoy.getNo());
            if (curBoy.getNext() == first)
                break;
            curBoy = curBoy.getNext();
        }
    }

    /**
     *
     * @param startNo
     * @param countNum
     * @param nums
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }

        Boy helper = first;
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        while (true) {
            // 说明helper 指向最后小孩节点
            if (helper.getNext() == first) break;
            helper = helper.getNext();
        }
        for(int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while(true) {
            if(helper == first) { //说明圈中只有一个节点
                break;
            }
            //让first 和helper 指针同时的移动countNum - 1
            for(int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first 指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d 出圈\n", first.getNo());
            //这时将first 指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first); //
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
    }
}
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}