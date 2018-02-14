package com.liaier.serviceImpl;

import com.liaier.dao.ContentDao;
import com.liaier.entity.Content;
import com.liaier.service.IContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "contentService")
public class ContentService implements IContentService {

    @Resource
    private ContentDao contentDao;

    public Integer add(Content content) {
        return contentDao.add(content);
    }

    public Content query(Content content) {
        return contentDao.query(content);
    }

    public List<Content> queryList(Content content) {
        return contentDao.queryList(content);
    }

    public Integer delete(String id) {
        return contentDao.delete(id);
    }
}
