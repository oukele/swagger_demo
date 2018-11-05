package com.oukele.web;

import com.oukele.model.ApiResponse;
import com.oukele.model.Category;
import com.oukele.model.Pet;
import com.oukele.model.Tag;
import com.oukele.service.CategoryService;
import com.oukele.service.PetService;
import com.oukele.service.TagService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/pet")
public class PetController {
    @Autowired
    private PetService petService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CategoryService categoryService;

    /*
     * 得到所有宠物的数据
     * */
    @RequestMapping(path = "", method = RequestMethod.GET)
    public String getList(Model model, Pet pet) {
        //宠物
        List<Pet> pets = petService.selectAll();
        model.addAttribute("pets", pets);
        //标检
        List<Tag> tags = tagService.selectAll();
        model.addAttribute("tags", tags);
        //类型
        List<Category> categories = categoryService.selectAll();
        model.addAttribute("type", categories);

        return "pet";
    }

    /**
     * 添加一只宠物
     */
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Object add(Pet pet) {

        if (petService.insert(pet) > 0) {
            return "redirect:/pet";
        }
        ;
        return "error";
    }

    /*
    * 删除宠物
    * */
    @RequestMapping(path = "/del/{pId}",method = RequestMethod.GET)
    public String del(@PathVariable("pId") int pId){
       if( petService.deleteByPrimaryKey(pId)>0 )
           return "redirect:/pet";
       return "error";
    }

    /*
    * 修改宠物信息
    * */
    @RequestMapping(path = "/update",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Pet update(@Param("pid") int pid){
        Pet pet = petService.selectByPrimaryKey(pid);
        return pet;
    }

}
