package com.liaier.controller;

import com.liaier.entity.User;
import com.liaier.service.IUserService;
import com.liaier.utils.CommTools;
import com.liaier.utils.DateTools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource(name = "userService")
    private IUserService userService;

    @RequestMapping(value = "",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> add(@RequestParam(value = "name",required=false) String name,
                                                @RequestParam(value = "nickname",required=false) String nickname,
                                                @RequestParam(value = "device_id",required=false) String device_id,
                                                @RequestParam(value = "password",required=false) String password
                             ){
        Map<String,String> result = new HashMap<String, String>();

        User user  = new User();
        try {
            user.setCreateTime(DateTools.getCurrentTime("yyyyMMdd HH:mm:ss"));
            user.setId(CommTools.getUUID());
            user.setName(name);
            user.setNickname(nickname);
            user.setPassword(CommTools.EncoderByMd5(password));
            user.setDeviceId(device_id);

            userService.add(user);
            result.put("code","1");
            result.put("msg","新增用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code","0");
            result.put("msg","新增用户失败");
        }

          return result;
    }


}
