package com.aituigu.java8;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;
import org.springframework.util.unit.DataUnit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/4 15:14
 */
public class StreamApiTest1 {
    String format = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();

        // filter() 接收lambda，从流中排除某些元素
        Stream<Employee> stream = list.stream();
        Stream<Employee> stream1 = stream.filter(employee -> employee.getSalary() > 7000);

        // limit(n) -- 截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);

        System.out.println();
        // skip(n) -- 跳过元素，返回一个扔掉前n个元素的流。
        list.stream().skip(3).forEach(System.out::println);

        System.out.println();
        // distinct() -- 筛选，通过所生成元素的hashCode() 和 equals() 去除去重复元素
        list.add(new Employee("刘强东", 80));
        list.add(new Employee("刘强东", 80));
        list.add(new Employee("刘强东", 80));
        list.stream().distinct().forEach(System.out::println);
    }

    // 映射
    @Test
    public void test2() {
        // map(Function f) -- 接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        System.out.println();

        // 练习：获取员工姓名长度大于3的员工的姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameStream = employees.stream().map(Employee::getName);
        nameStream.filter(name -> name.length() > 3).forEach(System.out::println);

        // flatMap(function f) -- 接收一个函数作为参数，将流中的每一个值都换成另一个流，然后把所有的流连成一个流
    }

    public Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3() {
        Calendar time = Calendar.getInstance();
        time.add(Calendar.MINUTE, 1);
        // 2020-11-04 09:31:32
        long l3 = 1604501774L;
        System.out.println(timeStamp2Date(l3 + "", ""));
        for (int i = 0; i < 1; i++) {
            continue;
        }
    }

    @Test
    public void test4(){
//        DateTime yesterday = DateUtil.yesterday();
//        DateTime yyyy = DateUtil.parse("2020", "YYYY");
//        String format = DateUtil.format(yyyy, this.format);
//        System.out.println(format);
//        System.out.println();
        String date1 = "2020-11-02 00:00:00";
        DateTime parse = DateUtil.parse(date1, "yyyy-MM-dd");
        System.out.println(DateUtil.format(parse, this.format));
//        String substring = DateUtil.now().substring(0, 10);
//        System.out.println(substring);
    }

    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    @Test
    public void test5() throws ParseException {
        String dateTime = "2020-11-10";
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        long time = sdf.parse(dateTime).getTime() / 1000;
        System.out.println(time);
        System.out.println(1605024000L - 1604937600L);
        // 1605024000 1604937600
    }
}
