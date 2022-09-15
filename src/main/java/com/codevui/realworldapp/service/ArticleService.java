package com.codevui.realworldapp.service;

import java.util.Map;

import com.codevui.realworldapp.model.article.dto.ArticleDTOCreate;
import com.codevui.realworldapp.model.article.dto.ArticleDTOFilter;
import com.codevui.realworldapp.model.article.dto.ArticleDTOResponse;

public interface ArticleService {

    public Map<String, ArticleDTOResponse> createArticle(Map<String, ArticleDTOCreate> articleDTOCreateMap);

    public Map<String, ArticleDTOResponse> getArticleBySlug(String slug);

    public Map<String, Object> getListArticles(ArticleDTOFilter filter);

}
