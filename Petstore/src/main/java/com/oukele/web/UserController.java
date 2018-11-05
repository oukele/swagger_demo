package com.oukele.web;

import com.oukele.model.ApiResponse;
import com.oukele.model.User;
import com.oukele.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 添加一位用户
     */
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Object createUser(User user, Model model) {
        if (user == null)
            return new ApiResponse(414, "error", "参数错误");
        if( userService.insert(user) >0 ){
            model.addAttribute("msg", "添加成功");
        }else{
            model.addAttribute("msg","未知错误，请联系管理员");
        }
        return "user";
    }

    /**
     * 添加多位用户
     *
     * 暂时不考虑
     */
    @RequestMapping(path = "/createWithList", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse createWithList(@RequestBody List<User> userList) {
        boolean flag = false;

        for (User user : userList) {
            if (userService.insert(user) > 0) {
                flag = true;
            } else {
                return new ApiResponse(414, "error", "参数格式有错误");
            }
        }

        if (flag)
            return new ApiResponse(200, "success", "添加成功");

        return new ApiResponse(414, "error", "参数格式有错误");
    }

    /**
    * 用户注销
     *
    * */
    @RequestMapping(path = "/logout",method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse logout(User user, HttpSession session){
        session.removeAttribute("user");
        return new ApiResponse(200,"success","注销成功");
    }

    /**
     *  用户登录
     *
     * */
    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public String getUserName(String username,String password,Model model){

        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        User isUserName = userService.selectByUserName(user);

        if(isUserName == null ){
            model.addAttribute("msg","此用户不存在。");
            return "login";
        }
        User login = userService.login(user);
        if( login == null ){
            model.addAttribute("msg","密码错误。");
            return "login";
        }

        //重定向到宠物页面
        return "redirect:/pet";
    }

    /**
     * 根据账号修改信息
     *
     * */
    @RequestMapping(path = "/{username}",method = RequestMethod.PUT)
    @ResponseBody
    public Object update(@RequestBody User user){

        if( user.getUserName().isEmpty() )
            return new ApiResponse(500,"error","请输入账号");

        return user;
    }

    /**
     * 根据账号删除用户
     *
     * */
    @RequestMapping(path = "/{username}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable String username){

        if( username.isEmpty() )
            return new ApiResponse(500,"error","请输入账号");

//        if( userService.deleteByPrimaryKey(username) > 0 )
//            return new ApiResponse(200,"success","删除成功");

        return new ApiResponse(414,"error","未知错误");
    }


}
