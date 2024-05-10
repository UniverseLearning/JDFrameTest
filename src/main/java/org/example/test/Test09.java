package org.example.test;

import io.github.burukeyou.dataframe.iframe.SDFrame;
import org.example.entity.Student;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |       百分数转换                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 15:39
 * @Version v2.0
 */
public class Test09 {
    public static void main(String[] args) {
        // 等价于 select round(score*100,2) from student
        SDFrame<Student> map2 = SDFrame.read(Data.studentList).mapPercent(Student::getScore, Student::setScore,2);
        map2.show();
    }
}
