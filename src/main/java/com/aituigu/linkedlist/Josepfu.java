package com.aituigu.linkedlist;

/**
 * @author aaa
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        // 加入五个小孩节点
        list.addBoy(125);
        list.showBoy();
        // 测试一个小孩出圈
        list.countBoy(10, 20, 125);
    }
}

// 创建一个环形的单向链表
class CircleSingleLinkedList {
    // 创建一个first节点，当前没有编号
    private Boy first = null;

    // 添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums) {
        // num 做一个数据校验
        if (nums < 1) {
            System.out.println("nums数据不正确");
            return;
        }
        // 辅助指针，帮助构建唤醒链表
        Boy curBoy = null;
        // 使用for来创建我们的唤醒链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            // 如果是第一个小孩
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

    // 遍历当前环形列表
    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        // 辅助指针
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少个在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据继续校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数有误，请重新输入！");
            return;
        }

        // 创建辅助指针，帮助完成小孩出圈
        Boy helper = first;
        // 需求创建一个辅助指针 helper，事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) {
                // 说明 helper指向最后一个小孩节点
                break;
            }
            helper = helper.getNext();
        }

        // 小孩报数前，先让first 和 helper 移动 startNo - 1 次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        // 小孩报数时 先让first 和 helper 指针同时移动 countNum - 1 次，然后出圈
        // 这里是一个循环操作，只到圈中只有一个节点
        while (true) {
            if (helper == first) {
                // 说明圈中只有一个节点
                break;
            }

            // 让first 和 helper 指针同时的移动 countNum - 1 
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 这时first 和 helper 指针同时的移动countNum - 1
            System.out.printf("小孩%d出圈\n", first.getNo());
            // 这时将first指向的小孩节点出圈
            first = first.getNext();
            // helper的下一个节点指向新的first的地址，即原first的下一个节点
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号为%d \n", first.getNo());
    }
}

// 创建一个Boy类，表示一个节点
class Boy {
    // 编号
    private int no;
    // 指向下一个节点，默认是null
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
