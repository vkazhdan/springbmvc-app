package com.springb.controller;

import com.springb.domain.Bookmark;
import com.springb.domain.User;
import com.springb.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bookmarks")
public class BookmarksController {

    @Autowired
    private BookmarkService bookmarkService;

    @GetMapping
    public String list(Model model, @AuthenticationPrincipal User currentUser) {
        List<Bookmark> bookmarks = bookmarkService.getByUserId(currentUser.getId());
        model.addAttribute("bookmarks", bookmarks);
        return "bookmarks";
    }

    @PostMapping("/add")
    public String add(Bookmark bookmark, @AuthenticationPrincipal User currentUser, Model model) {
        bookmark.setUserId(currentUser.getId());
        bookmarkService.create(bookmark);
        return "redirect:/bookmarks";
    }

    @PostMapping("/delete")
    public String delete(Long bookmarkId, @AuthenticationPrincipal User currentUser, Model model) {
        bookmarkService.delete(bookmarkId);
        return "redirect:/bookmarks";
    }
}