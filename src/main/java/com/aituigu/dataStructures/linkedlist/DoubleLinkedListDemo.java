package com.aituigu.dataStructures.linkedlist;

/**
 * @author aaa
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList linkedList = new DoubleLinkedList();

//        linkedList.add(hero1);
//        linkedList.add(hero2);
//        linkedList.add(hero3);
//        linkedList.add(hero4);

        linkedList.addOrderByNo(hero2);
        linkedList.addOrderByNo(hero1);
        linkedList.addOrderByNo(hero4);
        linkedList.addOrderByNo(hero3);

        linkedList.list();
    }

}

class DoubleLinkedList {
    HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void add(HeroNode2 node) {
        if (head.next == null) {
            head.next = node;
            node.pre = head;
            return;
        }

        HeroNode2 temp = head.next;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void addOrderByNo(HeroNode2 node) {
        if (head.next == null) {
            head.next = node;
            node.pre = head;
            return;
        }
        HeroNode2 temp = head;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.next.no >= node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            node.pre = temp;
            node.next = temp.next;
            temp.next = node;
            node.next.pre = node;
        }else {
            node.pre = temp;
            temp.next = node;
        }
    }

    public void list() {
        HeroNode2 temp = this.head.next;
        while (temp != null) {
            System.out.println("列表：" + temp);
            temp = temp.next;
        }
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    // 指向下一个节点
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + "}";
    }
}
