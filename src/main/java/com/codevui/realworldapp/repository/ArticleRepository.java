package com.codevui.realworldapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codevui.realworldapp.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    public Article findBySlug(String slug);

}
