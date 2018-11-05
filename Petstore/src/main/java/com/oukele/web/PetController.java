package com.oukele.web;

import com.oukele.model.ApiResponse;
import com.oukele.model.Pet;
import com.oukele.service.PetService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(path = "/pet")
public class PetController {
    @Autowired
    private PetService petService;

    /*
    * 得到所有宠物的数据
    * */
    @RequestMapping(path = "",method = RequestMethod.GET)
    public String getList(Model model){

        List<Pet> pets = petService.selectAll();
        model.addAttribute("pets",pets);

        return "pet";
    }

    /**
     * 添加一只宠物
     * */
    @RequestMapping(path = "",method = RequestMethod.POST)
    public Object add(@RequestBody Pet pet){

        if( pet == null ) {
            return  new ApiResponse(500,"error","错误的格式");
        }
        if( petService.insert(pet) > 0 )
            return  new ApiResponse(200,"success","添加成功");
        return new ApiResponse(514,"error","未知错误");
    }

}
