package com.java.app.controllers;

import com.java.app.DAO.ShareDAO;
import com.java.app.models.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shares")
public class SharesController {
    private ShareDAO shareDAO;

    @Autowired
    public SharesController(ShareDAO shareDAO) {
        this.shareDAO = shareDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("shares", shareDAO.showAll());
        return "shares/index";
    }

    @GetMapping("/new")
    public String newShare(Model model) {
        model.addAttribute("share", new Share());
        return "shares/new";
    }

    @PostMapping()
    public String addShare(@ModelAttribute("share") Share share) {
        shareDAO.add(share);
        return "redirect:/shares";
    }

    @GetMapping("/share/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("share", shareDAO.getShare(id));
        model.addAttribute("shareID", id);
        return "shares/share";
    }

    @PatchMapping("/edit/{id}")
    public String update(@ModelAttribute("share") Share share, @PathVariable("id") int id) {
        shareDAO.update(id, share);
        return "redirect:/shares";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        shareDAO.delete(id);
        return "redirect:/shares";
    }
}