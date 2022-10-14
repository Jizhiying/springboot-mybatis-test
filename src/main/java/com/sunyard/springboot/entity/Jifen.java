package com.sunyard.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Jifen {
    private String id;
    private String userId;
    private Integer pointsBefore;
    private Integer PointsAfter;
    private Integer points;
    private String detail;
    private Date createTime;

}

