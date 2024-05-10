package org.example.test;

import io.github.burukeyou.dataframe.iframe.SDFrame;
import io.github.burukeyou.dataframe.iframe.item.FI2;
import org.example.entity.Student;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |  统计每个学校的里学生年龄不为空并且年龄在9到16岁间的合计分数，并且获取合计分前2名的学校  |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 14:25
 * @Version v2.0
 */
public class Test01 {
    public static void main(String[] args) {
        // 等价于SQL:
        // select school,sum(score)
        // from students
        // where age is not null and age >=9 and age <= 16
        // group by school
        // order by sum(score) desc
        // limit 2
        SDFrame<FI2<String, BigDecimal>> sdf2 = SDFrame.read(Data.studentList)
                .whereNotNull(Student::getAge)
                .whereBetween(Student::getAge,9,16)
                .groupBySum(Student::getSchool, Student::getScore)
                .sortDesc(FI2::getC2)
                .cutFirst(2);

        sdf2.show();
    }
}
