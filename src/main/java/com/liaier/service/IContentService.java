package com.liaier.service;

import com.liaier.entity.Content;

import java.util.List;

public interface IContentService {

    Integer add(Content content);
    Content query(Content content);
    List<Content> queryList(Content content);
    Integer delete(String id);
}
