package org.example.test;

import io.github.burukeyou.dataframe.iframe.SDFrame;
import org.example.entity.Student;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |    矩阵信息相关                          |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 14:35
 * @Version v2.0
 */
public class Test02 {

    public static void main(String[] args) {
        /**
         * void show(int n);                        // 打印矩阵信息到控制台
         * List<String> columns();                  // 获取矩阵的表头字段名
         * List<R> col(Function<T, R> function);    // 获取矩阵某一列值
         * T head();                                // 获取第一个元素
         * List<T> head(int n);                     // 获取前n个元素
         * T tail();                                // 获取最后一个元素
         * List<T> tail(int n);                     // 获取后n个元素
         */

        // 打印矩阵信息到控制台
        SDFrame.read(Data.studentList).show(3);

        // 获取矩阵的表头字段名
        System.out.println(SDFrame.read(Data.studentList).columns());

        // 获取矩阵某一列值
        System.out.println(SDFrame.read(Data.studentList).col(Student::getId));

        // 获取第一个元素
        System.out.println(SDFrame.read(Data.studentList).head());

        // 获取前n个元素
        System.out.println(SDFrame.read(Data.studentList).head(3));

        // 获取最后一个元素
        System.out.println(SDFrame.read(Data.studentList).tail());

        // 获取后n个元素
        System.out.println(SDFrame.read(Data.studentList).tail(4));


    }
}
