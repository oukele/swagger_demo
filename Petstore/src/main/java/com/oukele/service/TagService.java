package com.oukele.service;

import com.oukele.dao.TagMapper;
import com.oukele.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService implements TagMapper {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public int deleteByPrimaryKey(Integer tId) {
        return 0;
    }

    @Override
    public int insert(Tag record) {
        return 0;
    }

    @Override
    public Tag selectByPrimaryKey(Integer tId) {
        return null;
    }

    @Override
    public List<Tag> selectAll() {
        return tagMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Tag record) {
        return 0;
    }
}
