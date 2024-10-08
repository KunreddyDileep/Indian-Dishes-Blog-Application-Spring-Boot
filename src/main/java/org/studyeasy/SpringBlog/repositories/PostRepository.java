package org.studyeasy.SpringBlog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.studyeasy.SpringBlog.models.Account;
import org.studyeasy.SpringBlog.models.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    long countByAccount(Account account);
    @SuppressWarnings("null")
    List<Post> findAll();
    
}
