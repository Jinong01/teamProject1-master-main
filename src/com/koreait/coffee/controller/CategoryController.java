package com.koreait.coffee.controller;

import com.koreait.coffee.config.MysqlConfig;
import com.koreait.coffee.model.dto.Category;
import com.koreait.coffee.model.mapper.CategoryMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryController{
    public SqlSession sqlSession = MysqlConfig.mysqlConnect();
    public CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);

    /**
     * 카테고리 id로 카테고리 가져오는기능
     * @param id
     * @return
     */
    public Category getCategoryById(Integer id){
        
        return mapper.getCategoryById(id);
    }

    /**
     * 카테고리 다 조회하는 기능
     * @return
     */
    public List<Category> getAllCategory(){
        return mapper.getAllCategory();
    }
}
