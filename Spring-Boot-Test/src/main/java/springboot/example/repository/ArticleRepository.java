package springboot.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.example.model.Article;
import springboot.example.model.Department;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

	
}