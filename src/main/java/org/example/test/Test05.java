package org.example.test;

import io.github.burukeyou.dataframe.iframe.SDFrame;
import org.example.entity.Student;

import java.util.List;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |       去重相关
 * |        原生steam只支持对象去重，不支持按特定字段去重
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 14:53
 * @Version v2.0
 */
public class Test05 {
    public static void main(String[] args) {
        List<Student> std = null;
        std = SDFrame.read(Data.studentList).distinct().toLists();                                                  // 根据对象hashCode去重
        System.out.println(std);
        std = SDFrame.read(Data.studentList).distinct(Student::getSchool).toLists();                                // 根据学校名去重
        System.out.println(std);
        std = SDFrame.read(Data.studentList).distinct(e -> e.getSchool() + e.getLevel()).toLists();                 // 根据学校名拼接级别去重复
        System.out.println(std);
        std =SDFrame.read(Data.studentList).distinct(Student::getSchool).distinct(Student::getLevel).toLists();     // 先根据学校名去除重复再根据级别去除重复
        System.out.println(std);
    }
}
