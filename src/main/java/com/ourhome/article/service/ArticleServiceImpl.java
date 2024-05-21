package com.ourhome.article.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourhome.article.dao.ArticleDao;
import com.ourhome.article.entity.ArticleEntity;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public int writeArticle(ArticleEntity article) {
		return articleDao.writeArticle(article);
	}

}
