package com.aituigu.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/4 15:15
 */
public class EmployeeData {

    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        Employee employee1 = new Employee("张三1", 1000);
        Employee employee2 = new Employee("张三2", 10001);
        Employee employee3 = new Employee("张三3", 6000);
        Employee employee4 = new Employee("张三422", 11000);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        return list;
    }

}
