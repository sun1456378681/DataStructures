package com.paogu.template.course;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/20 10:48
 */
public class NetworkCourseTest {

    public static void main(String[] args) {
        System.out.println("---Java 架构师课程---");
        NetworkCourse javaCourse = new JavaCourse();
        javaCourse.createCourse();

        System.out.println("---大数据课程---");
        NetworkCourse bigDataCourse = new BigDataCourse(true);
        bigDataCourse.createCourse();
    }
}
