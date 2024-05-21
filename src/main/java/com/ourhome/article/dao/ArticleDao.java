package com.ourhome.article.dao;

import org.springframework.stereotype.Repository;

import com.ourhome.article.entity.ArticleEntity;

@Repository
public interface ArticleDao {
	int writeArticle(ArticleEntity article);

}
