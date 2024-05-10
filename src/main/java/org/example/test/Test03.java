package org.example.test;

import io.github.burukeyou.dataframe.iframe.SDFrame;

import java.util.Arrays;
import org.example.entity.Student;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |     筛选相关                            |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 14:46
 * @Version v2.0
 */
public class Test03 {
    public static void main(String[] args) {
        SDFrame.read(Data.studentList)
                .whereBetween(Student::getAge,3,6)          // 过滤年龄在[3，6]岁的
                .whereBetweenR(Student::getAge,3,6)         // 过滤年龄在(3，6]岁的, 不含3岁
                .whereBetweenL(Student::getAge,3,6)         // 过滤年龄在[3，6)岁的, 不含6岁
                .whereNotNull(Student::getName)                       // 过滤名字不为空的数据， 兼容了空字符串''的判断
                .whereGt(Student::getAge,3)                     // 过滤年龄大于3岁
                .whereGe(Student::getAge,3)                     // 过滤年龄大于等于3岁
                .whereLt(Student::getAge,3)                     // 过滤年龄小于3岁的
                .whereIn(Student::getAge, Arrays.asList(3,7,8))       // 过滤年龄为3岁 或者7岁 或者 8岁的数据
                .whereNotIn(Student::getAge, Arrays.asList(3,7,8))    // 过滤年龄不为为3岁 或者7岁 或者 8岁的数据
                .whereEq(Student::getAge,3)                     // 过滤年龄等于3岁的数据
                .whereNotEq(Student::getAge,3)                  // 过滤年龄不等于3岁的数据
                .whereLike(Student::getName,"jay")              // 模糊查询，等价于 like "%jay%"
                .whereLikeLeft(Student::getName,"jay")          // 模糊查询，等价于 like "jay%"
                .whereLikeRight(Student::getName,"jay");        // 模糊查询，等价于 like "%jay"
    }
}
