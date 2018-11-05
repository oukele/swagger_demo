package com.oukele.test;

import com.oukele.dao.PetMapper;
import com.oukele.model.Pet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring_root.xml")
public class PetTest {

    @Autowired
    private PetMapper petMapper;

    @Test
    public void test1(){
        List<Pet> pets = petMapper.selectAll();
        for (Pet pet : pets) {
            System.out.println(pet);
        }

    }
}
