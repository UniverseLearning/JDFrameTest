package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @Author Administrator
 * @Date 2024-05-10 14:24
 * @Version v2.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int id;
    private String name;
    private String school;
    private String level;
    private Integer age;
    private BigDecimal score;

    private Integer rank;

    public Student(String level, BigDecimal score) {
        this.level = level;
        this.score = score;
    }

    public Student(int id, String name, String school, String level, Integer age, BigDecimal score) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.level = level;
        this.age = age;
        this.score = score;
    }
}
