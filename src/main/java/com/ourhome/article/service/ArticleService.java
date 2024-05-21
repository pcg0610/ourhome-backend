package com.ourhome.article.service;

import com.ourhome.article.entity.ArticleEntity;

public interface ArticleService {
	/**
	 * 게시글을 등록
	 * @param article : POST요청으로 가져온 article
	 * @return : 1 성공, 0 실패
	 */
	int writeArticle(ArticleEntity article);
}
