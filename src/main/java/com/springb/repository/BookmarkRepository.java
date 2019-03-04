package com.springb.repository;

import com.springb.domain.Bookmark;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookmarkRepository extends CrudRepository<Bookmark, Long> {

    List<Bookmark> findByUserIdOrderByIdAsc(Long userId);
}
