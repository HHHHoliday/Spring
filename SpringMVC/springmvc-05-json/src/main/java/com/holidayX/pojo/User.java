package com.holidayX.pojo;

import lombok.*;

//需要导入lombok
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private int age;
    private String sex;

}