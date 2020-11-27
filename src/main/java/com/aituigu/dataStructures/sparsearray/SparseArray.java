package com.aituigu.dataStructures.sparsearray;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author aaa
 */
public class SparseArray {

    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0：表示没有棋子，1：表示黑子，2：表示篮子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        //输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 将二维数组转化为稀疏数组
        // 1.先遍历二维数组得到非0 的数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            int[] rows = chessArr1[i];
            for (int j = 0; j < rows.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);

        // 2. 创建对应的稀疏数组
        int[][] spareArray = new int[sum + 1][3];
        spareArray[0][0] = chessArr1.length;
        spareArray[0][1] = chessArr1[0].length;
        spareArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            int[] rows = chessArr1[i];
            for (int j = 0; j < rows.length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    spareArray[count][0] = i;
                    spareArray[count][1] = j;
                    spareArray[count][2] = chessArr1[i][j];
                }
            }
        }

        // 输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为~~");
        for (int[] ints : spareArray) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }
        saveSpareFile(spareArray);

        // 将稀疏数组恢复到二维数组

        int totalRow = spareArray[0][0];
        int totalCol = spareArray[0][1];
        int[][] chessArr2 = new int[totalRow][totalCol];
        //读稀缺数组的后几行数据（从第二行开始），并赋值给原始的二维数组
        for (int i = 1; i < spareArray.length; i++) {
            int row = spareArray[i][0];
            int col = spareArray[i][1];
            int num = spareArray[i][2];
            chessArr2[row][col] = num;
        }

        //输出由稀疏数组恢复后的的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        readNIO();
    }
    static String path = "E:\\test\\test.txt";
    public static void saveSpareFile(int[][] array) {
        StringBuffer buffer = new StringBuffer();
        for (int[] ints : array) {
            buffer.append(ints[0] + " " + ints[1] + " " + ints[2] + "\r\n");
        }

        FileOutputStream fos = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            FileChannel channel = fos.getChannel();
            ByteBuffer src = Charset.forName("utf8").encode(buffer.toString());
            int length = 0;
            while ((length = channel.write(src)) != 0) {
                /*
                 * 注意，这里不需要clear，将缓冲中的数据写入到通道中后 第二次接着上一次的顺序往下读
                 */
                System.out.println("写入长度:" + length);
            }
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void readNIO(){
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(new File(path));
            FileChannel channel = fin.getChannel();
            int capacity = 1000;
            ByteBuffer bf = ByteBuffer.allocate(capacity);
            System.out.println("限制是：" + bf.limit() + ",容量是：" + bf.capacity() + " ,位置是：" + bf.position());
            int length = -1;
            while ((length = channel.read(bf)) != -1) {
                bf.clear();
                byte[] bytes = bf.array();
                System.out.println("start.......");

                String str = new String (bytes, 0, length);
                System.out.println(str);
                System.out.println("end................");
                System.out.println("限制是：" + bf.limit() + "容量是：" + bf.capacity() + "位置是：" + bf.position());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
