package day07_HashTable;

import java.util.Scanner;

/**
 * @author Yemeng
 * @create 2020-12-28-16:38
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
//        Emp emp1 = new Emp(1,"a");
//        Emp emp2 = new Emp(8,"b");
//        Emp emp3 = new Emp(2,"c");
//
//        hashTab.add(emp1);
//        hashTab.add(emp2);
//        hashTab.add(emp3);
//        hashTab.list();
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            System.out.println("del: 删除系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                case "del":
                    System.out.println("输入id");
                    int id2 = scanner.nextInt();
                    hashTab.del(id2);
                default:
                    break;

            }
        }
    }

}

class HashTab {
    private EmpLinkedList[] empLinkedListsArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedListsArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int empLinkedListNO = hashFun(emp.id);
        empLinkedListsArray[empLinkedListNO].add(emp);
    }

    public void list() {
        for(int i = 0; i < size; i++) {
            empLinkedListsArray[i].list(i);
        }
    }

    public void findEmpById(int id) {
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListsArray[empLinkedListNO].findEmpById(id);
        if(emp != null) {//找到
            System.out.printf("在第%d 条链表中找到雇员id = %d\n", (empLinkedListNO + 1), id);
        }else{
            System.out.println("在哈希表中，没有找到该雇员~");
        }

    }

    public void del(int id) {
        int empLinkedListNO = hashFun(id);
        empLinkedListsArray[empLinkedListNO].del(id);
    }
    public int hashFun(int id) {
        return id % size;
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(int no) {
        if (head == null) { //说明链表为空
            System.out.println("第" + (no + 1) + " 链表为空");
            return;
        }
        System.out.print("第" + (no + 1) + " 链表的信息为");
        Emp curEmp = head; //辅助指针
        while (true) {
            System.out.print(" => id=" + curEmp.id + " " + "name=" + curEmp.name);
            if (curEmp.next == null) {//说明curEmp 已经是最后结点
                break;
            }
            curEmp = curEmp.next; //后移，遍历
        }
        System.out.println();
    }

    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {//找到
                break;//这时curEmp 就指向要查找的雇员
            }
            //退出
            if (curEmp.next == null) {//说明遍历当前链表没有找到该雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;//以后
        }
        return curEmp;
    }

    public void del(int id) {
        if (head.next == null) {
            head = null;
            return;
        }
        Emp curEmp = head;
        boolean flag = false;
        while (true) {
            if (curEmp.next.id == id) {//找到
                flag = true;
                break;//这时curEmp 就指向要删除的雇员前一个
            }
            //退出
            if (curEmp.next == null) {//说明遍历当前链表没有找到该雇员
                break;
            }
            curEmp = curEmp.next;//以后
        }
        if (flag) {
            curEmp.next = curEmp.next.next;
        } else {
            System.out.println("要删除的雇员id = " + id + "不存在");
        }
    }
}

