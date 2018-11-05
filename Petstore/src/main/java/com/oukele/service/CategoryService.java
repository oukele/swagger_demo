package com.oukele.service;

import com.oukele.dao.CategoryMapper;
import com.oukele.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer cId) {
        return 0;
    }

    @Override
    public int insert(Category record) {
        return 0;
    }

    @Override
    public Category selectByPrimaryKey(Integer cId) {
        return null;
    }

    @Override
    public List<Category> selectAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return 0;
    }
}
