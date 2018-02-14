package com.liaier.dao;

import com.liaier.entity.Content;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentDao {

    Integer add(Content content);
    Content query(Content content);
    List<Content> queryList(Content content);
    Integer delete(String id);
}
