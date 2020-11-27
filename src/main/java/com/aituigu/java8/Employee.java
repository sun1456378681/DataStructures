package com.aituigu.java8;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/4 15:15
 */
public class Employee {
    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    private String name;

    private Integer salary;

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
