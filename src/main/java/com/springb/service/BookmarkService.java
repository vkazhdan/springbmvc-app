package com.springb.service;

import com.springb.domain.Bookmark;
import com.springb.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {

	@Autowired
	private BookmarkRepository bookmarkRepository;

	public Bookmark getById(Long id) {
		return bookmarkRepository.findById(id).orElse(null);
	}

	public List<Bookmark> getByUserId(Long userId) {
		return bookmarkRepository.findByUserIdOrderByIdAsc(userId);
	}

	public Bookmark create(Bookmark bookmark) {
		return bookmarkRepository.save(bookmark);
	}

	public Bookmark update(Bookmark bookmark) {
		return bookmarkRepository.save(bookmark);
	}

	public void delete(Long id) {
		bookmarkRepository.deleteById(id);
	}
}
