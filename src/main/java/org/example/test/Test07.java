package org.example.test;

import io.github.burukeyou.dataframe.iframe.SDFrame;

import java.util.Comparator;
import org.example.entity.Student;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |       排序相关
 * |        简化原生stream的排序方式，直接指定字段即可，不用使用Comparator还要去关注升序还是降序
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 15:20
 * @Version v2.0
 */
public class Test07 {
    public static void main(String[] args) {
        // 等价于 order by age desc
        SDFrame.read(Data.studentList).sortDesc(Student::getAge).show();
        //  等价于 order by age desc, level asc
        SDFrame.read(Data.studentList).sortDesc(Student::getAge).sortAsc(Student::getLevel).show();
        // 等价于 order by age asc
        SDFrame.read(Data.studentList).sortAsc(Student::getAge).show();
        // 使用Comparator 排序
        SDFrame.read(Data.studentList).sortAsc(Comparator.comparing(e -> e.getLevel() + e.getId())).show();
    }
}
