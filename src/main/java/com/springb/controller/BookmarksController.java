package com.springb.controller;

import com.springb.domain.Bookmark;
import com.springb.domain.User;
import com.springb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.Iterator;

@Controller
@RequestMapping("/bookmarks")
public class BookmarksController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String list(Model model, @AuthenticationPrincipal User currentUser) {
        User user = userService.getById(currentUser.getId());
        model.addAttribute("bookmarks", user.getBookmarks());
        return "bookmarks";
    }

    @PostMapping("/add")
    public String add(Bookmark bookmark, @AuthenticationPrincipal User currentUser, Model model) {
        User user = userService.getById(currentUser.getId());
        bookmark.setUser(user);
        user.getBookmarks().add(bookmark);
        userService.updateUser(user);

        return "redirect:/bookmarks";
    }

    @PostMapping("/delete")
    public String delete(Long bookmarkId, @AuthenticationPrincipal User currentUser, Model model) {
        User user = userService.getById(currentUser.getId());

        for (Iterator<Bookmark> i = user.getBookmarks().iterator(); i.hasNext();) {
            Bookmark next = i.next();
            if (next.getId() == bookmarkId) {
                i.remove();
                break;
            }
        }

        userService.updateUser(user);

        return "redirect:/bookmarks";
    }
}