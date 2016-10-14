package org.penguin.study.boot.repository;

import org.penguin.study.boot.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by terry on 14/10/2016.
 */
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

	@Query("select article from Article article join article.author author where author.personId = ?1")
	Page<Article> findByAuthor(Long personId, Pageable pageable);
}
