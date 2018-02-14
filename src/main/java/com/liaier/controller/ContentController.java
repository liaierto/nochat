package com.liaier.controller;

import com.liaier.entity.Content;
import com.liaier.entity.User;
import com.liaier.service.IContentService;
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
@RequestMapping(value = "/content")
public class ContentController {
    @Resource(name = "contentService")
    private IContentService contentService;

    @RequestMapping(value = "",method = {RequestMethod.POST})
    public @ResponseBody
    Map<String,String> add(@RequestParam(value = "title",required=false) String title,
                           @RequestParam(value = "body",required=false) String body,
                           @RequestParam(value = "user_id",required=false) String userId
    ){
        Map<String,String> result = new HashMap<String, String>();

        Content content  = new Content();
        try {
            content.setCreateTime(DateTools.getCurrentTime("yyyyMMdd HH:mm:ss"));
            content.setId(CommTools.getUUID());
            content.setBody(title);
            content.setTitle(body);
            content.setUserId(userId);

            contentService.add(content);
            result.put("code","1");
            result.put("msg","新增内容成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code","0");
            result.put("msg","新增内容失败");
        }

        return result;
    }
}
