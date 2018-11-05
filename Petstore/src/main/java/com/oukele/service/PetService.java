package com.oukele.service;

import com.oukele.dao.PetMapper;
import com.oukele.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService implements PetMapper {

    @Autowired
    private PetMapper petMapper;

    @Override
    public int deleteByPrimaryKey(Integer pId) {
        return petMapper.deleteByPrimaryKey(pId);
    }

    @Override
    public int insert(Pet record) {
        return petMapper.insert(record);
    }

    @Override
    public Pet selectByPrimaryKey(Integer pId) {
        return petMapper.selectByPrimaryKey(pId);
    }

    @Override
    public List<Pet> selectAll() {
        return petMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Pet record) {
        return petMapper.updateByPrimaryKey(record);
    }
}
