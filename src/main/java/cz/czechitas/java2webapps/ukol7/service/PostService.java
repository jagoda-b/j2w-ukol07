package cz.czechitas.java2webapps.ukol7.service;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post singlePost(String slug) {
        return postRepository.findBySlug(slug).orElse(null);
    }

    public Page<Post> list(Pageable pageable) {
        return postRepository.findByPublishedBeforeOrderByPublishedDesc(LocalDate.now(), pageable);
    }

    public void save(Post form) throws Exception {
        Objects.requireNonNull(form);
        if (postRepository.existsBySlug(form.getSlug())) {
            throw new Exception("A post with the same slug already exists.");
        }
        postRepository.save(form);
    }

    public void update(Post post) {

    if (postRepository.existsBySlug(post.getSlug())) {
        post.setSlug(post.getSlug());
        post.setId(post.getId());
        postRepository.save(post);
    } else {
        throw new IllegalArgumentException("Post with slug " + post.getSlug() + " does not exist");
    }
}

    public Page<Post> allList() {
        return postRepository.findAll(PageRequest.of(0, 20));
    }

    @Transactional
    public void delete(String slug) {
    postRepository.deleteBySlug(slug);
}
}
