package org.example.test;

import io.github.burukeyou.dataframe.iframe.SDFrame;
import org.example.entity.Student;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |        补充条目
 * |        补充缺失的学校条目
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 15:46
 * @Version v2.0
 */
public class Test13 {
    public static void main(String[] args) {
        // 所有需要的学校条目
        List<String> allDim = Arrays.asList("一中", "二中", "三中", "四中");
        // 根据学校字段和allDim比较去补充缺失的条目， 缺失的学校按照ReplenishFunction生成补充条目作为结果一起返回
        SDFrame.read(Data.studentList).replenish(Student::getSchool, allDim, (school) -> new Student(8, "john", school, "六年级", 18, BigDecimal.TEN)).show();
    }
}
