package org.example.test;

import io.github.burukeyou.dataframe.iframe.SDFrame;
import org.example.entity.Student;

import java.util.List;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |        分区
 * |        将每个5个元素分成一个小集合，用于将大任务拆成小任务
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 15:40
 * @Version v2.0
 */
public class Test10 {
    public static void main(String[] args) {
        List<List<Student>> t = SDFrame.read(Data.studentList).partition(5).toLists();
        System.out.println(t);
    }
}
