package day02;

import javax.crypto.interfaces.PBEKey;

/**
 * @author Yemeng
 * @create 2020-12-18-19:40
 */
public class linkedList {
    public static void main(String[] args) {
    }

}
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    public HeroNode pre;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public HeroNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
class SingleLinkedList{
    //头节点
    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }


    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null)
                break;
            if (temp.next.no > heroNode.no){
                break;
            }else if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的英雄的编号%d 已经存在了, 不能加入\n", heroNode.no);
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    //修改节点信息
    public void update(HeroNode heroNode){
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while(true) {
            if (temp == null) {
                break; //已经遍历完链表
            }
            if(temp.no == heroNode.no) {
//找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        } else { //没有找到
            System.out.printf("没有找到编号%d 的节点，不能修改\n", heroNode.no);
        }
    }

    //删除节点
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false; // 标志是否找到待删除节点的
        while(true) {
            if(temp.next == null) { //已经到链表的最后
                break;
            }
            if(temp.next.no == no) {
            //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; //temp 后移，遍历
        }
            //判断flag
        if(flag) { //找到
            //可以删除
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的%d 节点不存在\n", no);
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp 后移， 一定小心
            temp = temp.next;

        }
    }
}