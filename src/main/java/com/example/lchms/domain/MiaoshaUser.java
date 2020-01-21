package com.example.lchms.domain;

import lombok.Data;

import java.sql.Date;

/**
 * @author kuangfeng
 * @date 2020-01-21 11:57
 */
@Data
public class MiaoshaUser {
  private Long id;
  private String nickname;
  private String password;
  private String salt;
  private String head;
  private Date registerDate;
  private Date lastLoginData;
  private Integer LoginCount;
}
