package org.example.test;

import io.github.burukeyou.dataframe.iframe.SDFrame;
import org.example.entity.Student;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |        生成序号
 * |        按照age排序，然后根据当前顺序生成排序号到rank字段 （序号从0开始）
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 15:42
 * @Version v2.0
 */
public class Test11 {
    public static void main(String[] args) {
        SDFrame.read(Data.studentList)
                .sortDesc(Student::getAge)
                .addSortNoCol(Student::setRank)
                .show(30);
    }
}
