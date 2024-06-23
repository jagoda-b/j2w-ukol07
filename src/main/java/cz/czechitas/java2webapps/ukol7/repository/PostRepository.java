package cz.czechitas.java2webapps.ukol7.repository;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findBySlug(String slug);
    Optional<Post> findById(Long id);
    Page<Post> findByPublishedBeforeOrderByPublishedDesc(LocalDate now, Pageable pageable);
    boolean existsBySlug(String slug);
    void deleteBySlug(String slug);
}
