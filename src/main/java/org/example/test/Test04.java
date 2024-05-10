package org.example.test;

import io.github.burukeyou.dataframe.iframe.JDFrame;
import io.github.burukeyou.dataframe.iframe.support.MaxMin;
import org.example.entity.Student;

import java.math.BigDecimal;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |     汇总相关                            |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 14:49
 * @Version v2.0
 */
public class Test04 {
    public static void main(String[] args) {
        JDFrame<Student> frame = JDFrame.read(Data.studentList);
        Student s1 = frame.max(Student::getAge);                // 获取年龄最大的学生
        Integer s2  = frame.maxValue(Student::getAge);          // 获取学生里最大的年龄
        Student s3 = frame.min(Student::getAge);                // 获取年龄最小的学生
        Integer s4  = frame.minValue(Student::getAge);          // 获取学生里最小的年龄
        BigDecimal s5 = frame.avg(Student::getAge);             // 获取所有学生的年龄的平均值
        BigDecimal s6 = frame.sum(Student::getAge);             // 获取所有学生的年龄合计
        MaxMin<Student> s7 = frame.maxMin(Student::getAge);     // 同时获取年龄最大和最小的学生
        MaxMin<Integer> s8 = frame.maxMinValue(Student::getAge); // 同时获取学生里最大和最小的年龄

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.print(s7.getMax());System.out.println(s7.getMin());
        System.out.print(s8.getMax());System.out.println(s8.getMin());
    }
}
