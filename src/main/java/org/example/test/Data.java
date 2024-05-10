package org.example.test;

import org.example.entity.Student;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 14:32
 * @Version v2.0
 */
public class Data {

    static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1,"a","一中","一年级",11, new BigDecimal(1)));
        studentList.add(new Student(2,"a","一中","一年级",11, new BigDecimal(1)));
        studentList.add(new Student(3,"b","一中","三年级",12, new BigDecimal(2)));
        studentList.add(new Student(4,"c","二中","一年级",13, new BigDecimal(3)));
        studentList.add(new Student(5,"d","二中","一年级",14, new BigDecimal(4)));
        studentList.add(new Student(6,"e","三中","二年级",14, new BigDecimal(5)));
        studentList.add(new Student(7,"e","三中","二年级",15, new BigDecimal(5)));
    }
}
