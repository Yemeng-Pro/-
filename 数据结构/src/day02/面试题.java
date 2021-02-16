package day02;

import day02.HeroNode;

import java.util.Stack;

/**
 * @author Yemeng
 * @create 2020-12-19-13:15
 */
public class 面试题 {

    /**
     * 求单链表中有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }


    /**
     * 链表中倒数第K个节点
     */
    //思路
    //1. 编写一个方法，接收head 节点，同时接收一个index
    //2. index 表示是倒数第index 个节点
    //3. 先把链表从头到尾遍历，得到链表的总的长度getLength
    //4. 得到size 后，我们从链表的第一个开始遍历(size-index)个，就可以得到
    //5. 如果找到了，则返回该节点，否则返回nulll
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 翻转链表  头插法
     */
    public static void reversetList(HeroNode head) {
//如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if(head.next == null || head.next.next == null) {
            return ;
        }
//定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;// 指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
//遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
//动脑筋
        while(cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur 的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur 连接到新的链表上
            cur = next;//让cur 后移
        }
//将head.next 指向reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }

    /**
     *从尾到头打印单链表
     */
    public static void reversePrint(HeroNode head) {
        if(head.next == null) {
            return;//空链表，不能打印
        }
        //创建要给一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈
        while(cur != null) {
            stack.push(cur);
            cur = cur.next; //cur 后移，这样就可以压入下一个节点
        }
        //将栈中的节点进行打印,pop 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop()); //stack 的特点是先进后出
        }
    }

    /**
     * 合并两个有序列表
     */
    public HeroNode mergeTwoLists(HeroNode l1, HeroNode l2){
        HeroNode dum = new HeroNode(0), cur = dum;
        while(l1 != null && l2 != null){
            if (l1.no < l2.no) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;

    }
}
