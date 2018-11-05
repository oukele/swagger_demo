package com.oukele.test;

import com.oukele.dao.CategoryMapper;
import com.oukele.dao.PetMapper;
import com.oukele.dao.TagMapper;
import com.oukele.model.Category;
import com.oukele.model.Pet;
import com.oukele.model.Tag;
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
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TagMapper tagMapper;

    @Test
    public void test1(){
//        List<Pet> pets = petMapper.selectAll();
//        for (Pet pet : pets) {
//            System.out.println(pet);
//        }
//        List<Category> categories = categoryMapper.selectAll();
//        for (Category category : categories) {
//            System.out.println(category.getcName());
//        }
        List<Tag> tags = tagMapper.selectAll();
        for (Tag tag : tags) {
            System.out.println(tag.gettName());
        }
    }
}
