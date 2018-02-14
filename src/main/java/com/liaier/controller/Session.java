package com.liaier.controller;

import com.liaier.entity.User;
import com.liaier.service.IUserService;
import com.liaier.utils.CommTools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/session")
public class Session {

    @Resource(name = "userService")
    private IUserService userService;

    @RequestMapping(value = "",method = {RequestMethod.POST})
    public @ResponseBody
    Map<String,Object> loginByPassword(@RequestParam(value = "device_id",required=false) String device_id,
                                       @RequestParam(value = "password",required=false) String password
    ){
        Map<String,Object> result = new HashMap<String, Object>();

        User user  = new User();
        try {
            user.setPassword(CommTools.EncoderByMd5(password));
            user.setDeviceId(device_id);

            user = userService.query(user);
            user.setPassword("");

            result.put("code","1");
            result.put("msg","查询用户成功");
            result.put("user_info",user);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code","0");
            result.put("msg","查询用户失败");
        }

        return result;
    }
}
