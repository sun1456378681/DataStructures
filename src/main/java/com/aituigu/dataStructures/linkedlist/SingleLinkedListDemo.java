package com.aituigu.dataStructures.linkedlist;

import java.util.Stack;

/**
 * @author aaa
 */
public class SingleLinkedListDemo {
    /**
     * 链表
     * 1. 链表是以节点的方式来存储，是链式存储
     * 2. 每个节点包含data域，next域：指向下一个节点
     * 3. 链表的各个节点不一定是连续存储
     * 4. 链表分带头节点的链表和没有头节点的链表，根据实际情况来去确定
     */

    public static void main(String[] args) {
        // 进行测试
        // 先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        // 加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        // 创建要给链表
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();

        HeroNode hero11 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero22 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero33 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero44 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero55 = new HeroNode(5, "花荣", "小李广");

        // 加入
        singleLinkedList2.add(hero11);
        singleLinkedList2.add(hero22);
        singleLinkedList2.add(hero33);
        singleLinkedList2.add(hero44);
        singleLinkedList2.add(hero55);
//        singleLinkedList.list();

//        LinkedUtil.getSize(singleLinkedList.getHead());
//
//        LinkedUtil.findLastIndexNode(singleLinkedList.getHead(), 2);

//        LinkedUtil.reversalList(singleLinkedList.getHead());
//        System.out.println("反转之后：");

        LinkedUtil.mergeList(singleLinkedList.getHead(), singleLinkedList2.getHead());
//        singleLinkedList.list();
//        System.out.println("反转之前：");
//        singleLinkedList.list();

//        reversalList(singleLinkedList.getHead());
//        System.out.println("反转之后：");
//        singleLinkedList.list();

//        System.out.println("逆序打印:");
//        reversePrint(singleLinkedList.getHead());

        /**
         // 添加按照编号的操作
         singleLinkedList.addByOrder(hero1);
         singleLinkedList.addByOrder(hero4);
         singleLinkedList.addByOrder(hero2);
         singleLinkedList.addByOrder(hero3);

         singleLinkedList.list();
         System.out.println();

         // 修改
         HeroNode newHero = new HeroNode(2, "亚索", "疾风剑豪");
         singleLinkedList.update(newHero);
         // 显示一把
         singleLinkedList.list();
         System.out.println();

         //删除
         //        singleLinkedList.del(3);
         //        singleLinkedList.del(4);
         //        singleLinkedList.del(1);
         //        singleLinkedList.del(2);
         // 显示一把
         singleLinkedList.list();

         // 测试有效节点数
         System.out.println("有效的节点个数：" + getLength(singleLinkedList.getHead()));

         // 测试一下看看是否得到了倒数第k个节点
         HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 2);
         System.out.println("倒数第二个节点是：" + res);
         */
    }

    /**
     * 查找单链表中的倒数第k个节点【新浪面试题】
     * 思路
     * 1. 编写一个方法，接受head节点，同时接收一个index
     * 2. index表示是倒数第index个节点
     * 3. 先把链表从头到尾遍历，得到链表的长度getLength
     * 4. 得到size的值后，我们从链表的第一个开始遍历（size - index）个，就可以得到
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        // 判断链表是否为空
        if (head.next == null) {
            // 没有找到
            return null;
        }
        // 第一次遍历得到链表的长度（节点个数）
        int size = getLength(head);
        // 第二次遍历 size - index 位置，就是我们倒数的第k个节点
        // 先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        // 定义给辅助变量， for循环定位到倒数的index位置
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 获取到单链表的节点的个数（如果是带头节点的链表，需求不统计头节点）
     *
     * @param head 链表的头节点
     * @return 返回的是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        // 定义一个辅助的变量,不统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    // 将单链表反转
    public static void reversalList(HeroNode head) {
        // 如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }

        // 定义一个辅助的指针，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        // 指向当前节点[cur]的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        // 遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        // 动脑筋
        while (cur != null) {
            // 先暂时保存当前节点的下一个节点，因为后面需要使用
            next = cur.next;
            // 将cur的下一个节点指向新的链表的最前端
            cur.next = reverseHead.next;
            // 将cur 连接到新的链表上
            reverseHead.next = cur;
            // 将cur后移
            cur = next;
        }
        // 将head.next 指向reverseHead.next, 实现单链表的反转
        head.next = reverseHead.next;
    }

    // 将列表逆序打印
    public static void reversePrint(HeroNode head) {
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size() > 0) {
            // stack的特点是先进后出
            System.out.println(stack.pop());
        }
    }

    public static void mergeList(HeroNode head1, HeroNode head2) {
        if (head2.next == null) {
            return;
        }
        HeroNode temp2 = head2.next;
        while (temp2 != null) {
            HeroNode temp = head1;
            boolean flag = false;
            while (temp.next != null) {
                if(temp.next.no >= temp2.no) {
                    HeroNode temp3 = temp2.next;
                    HeroNode temp1_1 = temp.next;

                    temp.next = temp2;
                    temp = temp3;
                    flag = true;
                }
            }
        }
    }
}

// 定义 SingleLinkedList 管理我们的英雄
//class SingleLinkedList {
//    // 先初始化一个头节点，头节点不要动， 不存放具体的数据
//    private HeroNode head = new HeroNode(0, "", "");
//
//    public HeroNode getHead() {
//        return head;
//    }
//
//    // 添加节点到单向链表
//    // 思路不考虑编号顺序时
//    // 1. 找到当前链表的最后节点
//    // 2. 将最后这个节点的next 指向新的节点
//    public void add(HeroNode heroNode) {
//
//        // 因为head节点不能动，因此我们需要一个辅助变量 temp
//        HeroNode temp = head;
//        // 遍历链表，找到最后
//        while (true) {
//            // 找到链表的最后
//            if (temp.next == null) {
//                break;
//            }
//            // 如果没有找到最后，将temp后移
//            temp = temp.next;
//        }
//        // 当退出while循环时，temp就指向了链表的最后
//        temp.next = heroNode;
//    }
//
//    // 第二种方式再添加英雄时，根据排名将英雄插入到指定位置
//    // （如果有这个排名，则添加失败，并给出提示）
//    public void addByOrder(HeroNode heroNode) {
//        // 因为头节点不能动，因此我们仍然通过一个辅助指针来帮助我们找到添加的位置
//        // 因为时单链表，因此我们找的temp 是位于添加位置的前一个节点，否则插入不了
//        HeroNode temp = head;
//        // flag 标志添加的编号是否存在，默认为false
//        boolean flag = false;
//        while (true) {
//            if (temp.next == null) {
//                // 说明temp已经在链表最后
//                break;
//            }
//            if (temp.next.no > heroNode.no) {
//                // 位置找到，就在temp的后面插入
//                break;
//            } else if (temp.next.no == heroNode.no) {
//                // 说明希望添加的heroNode的编号已经存在
//                flag = true;
//                break;
//            }
//            temp = temp.next;
//        }
//        // 判断flag的值
//        if (flag) {
//            // 不能添加说明编号存在
//            System.out.printf("准备插入的英雄的编号%d已经存在了，不能加入\n", heroNode.no);
//        } else {
//            // 插入到链表中，temp的后面
//            heroNode.next = temp.next;
//            temp.next = heroNode;
//        }
//    }
//
//    // 修改节点的信息，根据no编号来修改，即no编号不能修改
//    public void update(HeroNode newHeroNode) {
//        // 判断是否为空
//        if (head.next == null) {
//            System.out.println("链表为空！");
//            return;
//        }
//        // 定义一个辅助变量
//        HeroNode temp = head.next;
//        // 表示是否找到该节点
//        Boolean flag = false;
//        while (true) {
//            if (temp == null) {
//                // 已经遍历完链表
//                break;
//            }
//            if (temp.no == newHeroNode.no) {
//                // 找到
//                flag = true;
//                break;
//            }
//            temp = temp.next;
//        }
//        // 根据flag判断是否找到要修改的节点
//        if (flag) {
//            temp.name = newHeroNode.name;
//            temp.nickname = newHeroNode.nickname;
//        } else {
//            //没有找到对应节点
//            System.out.printf("没有找到 编号%d的节点，修改失败\n", newHeroNode.no);
//        }
//    }
//
//    public void del(int no) {
//        HeroNode temp = head;
//        // 标志是福哦找到待删除的节点
//        boolean flag = false;
//        while (true) {
//            if (temp.next == null) {
//                // 已经到达链表的尾部
//                break;
//            }
//            if (temp.next.no == no) {
//                // 找到的待删除的节点的前一个节点temp
//                flag = true;
//                break;
//            }
//            temp = temp.next;
//        }
//
//        if (flag) {
//            // 可以删除
//            temp.next = temp.next.next;
//        } else {
//            System.out.printf("要删除的 %d 节点不存在\n", no);
//        }
//    }
//
//    // 显示链表[遍历]
//    public void list() {
//        // 判断链表是否为空
//        if (head.next == null) {
//            System.out.println("链表为空！");
//            return;
//        }
//
//        // 因为头节点，不能动，因此我们需要一个辅助变量来遍历
//        HeroNode temp = head.next;
//        while (true) {
//            if (temp == null) {
//                break;
//            }
//            // 输出节点信息
//            System.out.println(temp);
//            // 将temp后移，一定小心
//            temp = temp.next;
//        }
//    }
//
//}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    // 指向下一个节点
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + "}";
    }
}
