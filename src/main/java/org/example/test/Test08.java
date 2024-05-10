package org.example.test;

import io.github.burukeyou.dataframe.iframe.SDFrame;
import io.github.burukeyou.dataframe.iframe.item.FI2;
import io.github.burukeyou.dataframe.iframe.item.FI3;
import org.example.entity.Student;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |        连接矩阵相关                      |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 15:26
 * @Version v2.0
 */
public class Test08 {
    public static void main(String[] args) {
        /**
         * append(T t);                    // 等价于集合 add
         * union(IFrame<T> other);         //  等价于集合 addAll
         * join(IFrame<K> other, JoinOn<T,K> on, Join<T,K,R> join);   // 等价于 sql内连接
         * leftJoin(IFrame<K> other, JoinOn<T,K> on, Join<T,K,R> join);   // 等价于sql左连接，如果左连接失败，K值为null，需手动判断
         * rightJoin(IFrame<K> other, JoinOn<T,K> on, Join<T,K,R> join);    // 等价于sql右连接，如果右连接失败，T值为null，需手动判断
         */

        System.out.println("======== 矩阵1 =======");

        SDFrame<Student> sdf = SDFrame.read(Data.studentList);

        sdf.show(20);

        // 获取学生年龄在9到16岁的学学校合计分数最高的前10名
        SDFrame<FI2<String, BigDecimal>> sdf2 = SDFrame.read(Data.studentList)
                .whereNotNull(Student::getAge)
                .whereBetween(Student::getAge,9,16)
                .groupBySum(Student::getSchool, Student::getScore)
                .sortDesc(FI2::getC2)
                .cutFirst(10);

        System.out.println("======== 矩阵2 =======");
        sdf2.show();

        SDFrame<FI3> frame = sdf.join(sdf2, (a, b) -> a.getSchool().equals(b.getC1()), (a, b) -> {
            FI3 userInfo = new FI3();
            userInfo.setC1(a.getSchool());
            userInfo.setC2(b.getC2().intValue());
            userInfo.setC3(String.valueOf(a.getId()));
            return userInfo;
        });

        System.out.println("======== 连接后结果 =======");
        frame.show(100);

    }
}
