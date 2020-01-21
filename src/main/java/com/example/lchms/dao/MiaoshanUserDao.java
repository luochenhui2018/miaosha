package com.example.lchms.dao;

import com.example.lchms.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author kuangfeng
 * @date 2020-01-21 15:03
 */
@Mapper
public interface MiaoshanUserDao {
    @Select("select * from miaosha_user where id = #{id}")
    public MiaoshaUser getById(@Param("id") long id);
}
