package org.penguin.study.boot.api.controller;

import org.penguin.study.boot.domain.Article;
import org.penguin.study.boot.wrapper.CustomGenericException;
import org.penguin.study.boot.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

/**
 * Created by terry on 14/10/2016.
 */

@RestController
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;

	@RequestMapping(method= RequestMethod.GET)
	public Page<Article> getEntryByPageable(@PageableDefault(value = 10, sort ={"articleId"}, direction = Sort.Direction.DESC)Pageable pageable, @RequestParam(value = "personId", defaultValue = "") Long personId) {
		return articleRepository.findByAuthor(personId, pageable);
	}

	@ExceptionHandler(Throwable.class)
	public CustomGenericException handleAllException(Throwable e) {
		return new CustomGenericException("-200", e.getLocalizedMessage());
	}

	@RequestMapping(method = RequestMethod.POST)
	public Article createOrUpdate(@RequestBody Article article) {
		Article saveArticle = articleRepository.save(article);
		return saveArticle;
	}
}
