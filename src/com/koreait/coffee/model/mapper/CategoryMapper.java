package com.koreait.coffee.model.mapper;

import com.koreait.coffee.model.dto.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryMapper {

    @Select("select * from category where id = #{id}")
    Category getCategoryById(Integer id);

    @Select("select * from category")
    List<Category> getAllCategory();

}
