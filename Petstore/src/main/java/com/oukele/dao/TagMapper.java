package com.oukele.dao;

import com.oukele.model.Tag;
import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(Tag record);

    Tag selectByPrimaryKey(Integer tId);

    List<Tag> selectAll();

    int updateByPrimaryKey(Tag record);
}