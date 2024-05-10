package org.example.test;

import io.github.burukeyou.dataframe.iframe.SDFrame;
import org.example.entity.Student;

import java.math.BigDecimal;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |        分组补充组内缺失的条目
 * |        按照学校进行分组， 汇总所有年级allDim. 然后与allDim比较补充每个分组内缺失的年级，缺失的年级按照ReplenishFunction生成补充条目
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 15:50
 * @Version v2.0
 */
public class Test14 {
    public static void main(String[] args) {
        SDFrame.read(Data.studentList).replenish(Student::getSchool, Student::getLevel, (school, level) -> new Student(8, "john", school, level, 18, BigDecimal.TEN)).show(30);
    }
}
