package org.example.test;

import io.github.burukeyou.dataframe.iframe.JDFrame;
import io.github.burukeyou.dataframe.iframe.item.FI2;
import io.github.burukeyou.dataframe.iframe.item.FI3;
import io.github.burukeyou.dataframe.iframe.item.FI4;
import org.example.entity.Student;

import java.math.BigDecimal;
import java.util.List;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |        简单分组聚合相关
 * |        类似sql的 group by语义 简化处理分组和聚合的逻辑， 如果用原生stream需要写可能一大串逻辑。
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 15:05
 * @Version v2.0
 */
public class Test06 {
    public static void main(String[] args) {
        JDFrame<Student> frame = JDFrame.read(Data.studentList);
        // 等价于 select school,sum(age) ... group by school
        List<FI2<String, BigDecimal>> a = frame.groupBySum(Student::getSchool, Student::getAge).toLists();
        // 等价于 select school,max(age) ... group by school
        List<FI2<String, Integer>> a2 = frame.groupByMaxValue(Student::getSchool, Student::getAge).toLists();
        //  与 groupByMaxValue 含义一致，只是返回的是最大的值对象
        List<FI2<String, Student>> a3 = frame.groupByMax(Student::getSchool, Student::getAge).toLists();
        // 等价于 select school,min(age) ... group by school
        List<FI2<String, Integer>> a4 = frame.groupByMinValue(Student::getSchool, Student::getAge).toLists();
        // 等价于 select school,count(*) ... group by school
        List<FI2<String, Long>> a5 = frame.groupByCount(Student::getSchool).toLists();
        // 等价于 select school,avg(age) ... group by school
        List<FI2<String, BigDecimal>> a6 = frame.groupByAvg(Student::getSchool, Student::getAge).toLists();

        // 等价于 select school,sum(age),count(age) group by school
        List<FI3<String, BigDecimal, Long>> a7 = frame.groupBySumCount(Student::getSchool, Student::getAge).toLists();

        // (二级分组)等价于 select school,level,sum(age),count(age) group by school,level
        List<FI3<String, String, BigDecimal>> a8 = frame.groupBySum(Student::getSchool, Student::getLevel, Student::getAge).toLists();

        // （三级分组）等价于 select school,level,name,sum(age),count(age) group by school,level,name
        List<FI4<String, String, String, BigDecimal>> a9 = frame.groupBySum(Student::getSchool, Student::getLevel, Student::getName, Student::getAge).toLists();
    }
}
