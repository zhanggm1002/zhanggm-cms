package com.zhanggm.cms.respository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.zhanggm.cms.pojo.Article;

public interface ArticleRepositroy extends ElasticsearchRepository<Article, Integer>{

}
