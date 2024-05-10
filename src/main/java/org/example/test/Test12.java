package org.example.test;

import io.github.burukeyou.dataframe.iframe.SDFrame;
import org.example.entity.Student;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |        生成排名号
 * |        按照age降序排序，然后根据当前顺序生成排名号到rank字段 （排名从0开始）
 * |        与序号不同的是， 排名是如果值相同认为排名一样。
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 15:44
 * @Version v2.0
 */
public class Test12 {
    public static void main(String[] args) {
        SDFrame<Student> df = SDFrame.read(Data.studentList).addRankingSameColDesc(Student::getAge, Student::setRank);
        df.show(20);
    }
}
