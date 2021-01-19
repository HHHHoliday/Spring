package com.HolidayXu.pojo;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Books {

    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;

}