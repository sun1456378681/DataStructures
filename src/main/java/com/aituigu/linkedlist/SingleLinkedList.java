package com.aituigu.linkedlist;

/**
 * @author aaa
 */
public class SingleLinkedList {

    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void list() {
        HeroNode temp = head.next;
        if (temp == null) {
            System.out.println("空链表！");
        }
        int num = 0;
        while (temp != null) {
            System.out.println("arr[" + num + "] = " + temp);
            temp = temp.next;
            num++;
        }
    }
}

class LinkedUtil {

    /**
     * 1. 求单链表中有效节点的个数
     * 2. 查找单链表中的倒数第 k 个节点
     * 3. 单链表的反转
     * 4. 从尾到头打印单链表
     * 5. 合并两个有序的单链表，合并之后的链表依然有序
     */

    /**
     * 获取有效节点个数
     *
     * @param head
     */
    public static int getSize(HeroNode head) {
        int num = 0;
        if (head.next == null) {
            System.out.println("有效个数：" + num);
            return num;
        }
        HeroNode temp = head;
        while (temp.next != null) {
            num++;
            temp = temp.next;
        }
        System.out.println(head.next);
        System.out.println("有效个数：" + num);
        return num;
    }

    /**
     * 获取倒数第k个节点
     *
     * @param head
     * @param index
     */
    public static void findLastIndexNode(HeroNode head, int index) {
        int length = getSize(head);
        int num = length - index;
        HeroNode temp = head;
        while (num >= 0) {
            temp = temp.next;
            num--;
        }
        System.out.println("倒数第" + index + "个节点的数据为：" + temp);
    }

    public static void reversalList(HeroNode head) {
        HeroNode head2 = new HeroNode(0, "", "'");
        HeroNode temp = head.next;
        while (temp != null) {
            HeroNode aaa = temp.next;
            temp.next = head2.next;
            head2.next = temp;
            temp = aaa;
        }
        head.next = head2.next;
    }

    public static void mergeList(HeroNode head1, HeroNode head2) {
        HeroNode temp2 = head2.next;
        while (temp2 != null) {
            HeroNode temp1 = head1.next;
            boolean flag = false;
            while (temp1.next != null) {
                if (temp1.next.no >= temp2.no) {
                    flag = true;
                    break;
                }
                temp1 = temp1.next;
            }
            if (flag) {
                HeroNode temp2Next = temp2.next;
                temp2.next = temp1.next;
                temp1.next = temp2;
                temp2 = temp2Next;
            }else {
                temp1.next = temp2;
                temp2 = temp2.next;
            }
        }
        HeroNode temp = head1.next;
        if (temp == null) {
            System.out.println("空链表！");
        }
        int num = 0;
        while (temp != null) {
            System.out.println("arr[" + num + "] = " + temp);
            temp = temp.next;
            num++;
        }
    }
}
