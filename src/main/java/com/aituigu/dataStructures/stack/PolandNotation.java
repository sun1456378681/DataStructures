package com.aituigu.dataStructures.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author aaa
 */
public class PolandNotation {

    public static void main(String[] args) {
        // 先定义给逆波兰表达式
        // (3+4)*5-6 => 3 4 + 5 * 6 - =>
        // 说明为了方便，逆波兰表达式的数字和符号使用空格隔开
//        String suffixExpression = "3 4 + 5 * 6 -";
//        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        // 思路
        // 先将"3 4 + 5 * 6 -" 放到ArrayList中
        // 将ArrayList 传递给一个方法，遍历ArrayList配合栈完成计算

//        List<String> listString = getListString(suffixExpression);
//        calculator(listString);
        String expression = "1+((2+3)*4)-5";
        List<String> list = toInfixExpressionList(expression);
        System.out.println("中缀表达式：" + list);
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(list);
        System.out.println("后缀表达式：" + parseSuffixExpressionList);
        calculator(parseSuffixExpressionList);
    }

    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = Arrays.asList(split);
        return list;
    }

    public static List<String> toInfixExpressionList(String s) {
        // 定义一个List，放入中缀表达式对应的内容
        List<String> list = new ArrayList<String>();
        int i = 0;
        String str;
        char c;
        do {
            // 如果是一个非数字
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else {
                String num = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    num += c;
                    i++;
                }
                list.add(num);
            }
        } while (i < s.length());
        return list;
    }

    public static List<String> parseSuffixExpressionList(List<String> ls) {
        // 定义两个栈
        Stack<String> s1 = new Stack<>();
        // 说明：因为s2这个栈，在转换过程中没有pop操作，而且后面我们还需要逆序输出
        // 因此比较麻烦，这里我们就不用stack 直接使用list
        List<String> s2 = new ArrayList<>();
        for (String item : ls) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                // 如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，知道遇到左括号为止，此时丢弃这一对括号
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                // !!! 将 ( 弹出s1栈，消除小括号
                s1.pop();
            } else {
                // 当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中，再次与s1中新的栈顶运算符相比较
                // 问题：我们缺少一个比较运算符高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }

        while (s1.size() > 0) {
            s2.add(s1.pop());
        }
        // 按顺序输入就是逆波兰表达式
        return s2;
    }

    public static void calculator(List<String> list) {
        Stack<Integer> stack = new Stack<>();
        for (String s : list) {
            if (s.matches("\\d+")) {
                stack.push(Integer.parseInt(s));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = 0;
                if (s.equals("+")) {
                    res = num1 + num2;
                } else if (s.equals("-")) {
                    res = num2 - num1;
                } else if (s.equals("*")) {
                    res = num1 * num2;
                } else if (s.equals("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("不是别的字符！");
                }
                stack.push(res);
            }
        }
        System.out.println("计算结果为：" + stack.pop());
    }

    static class Operation {
        public static int ADD = 1;
        public static int SUB = 1;
        public static int MUL = 2;
        public static int DIV = 2;

        public static int getValue(String oper) {
            int result = 0;
            switch (oper) {
                case "+":
                    result = ADD;
                    break;
                case "-":
                    result = SUB;
                    break;
                case "*":
                    result = MUL;
                    break;
                case "/":
                    result = DIV;
                    break;
                default:
                    System.out.println("不存在该运算符");
                    break;
            }
            return result;
        }
    }


}
