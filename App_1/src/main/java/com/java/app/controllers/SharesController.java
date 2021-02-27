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

    @GetMapping("/share/{company}")
    public String edit(@PathVariable("company") String company, Model model) {
        model.addAttribute("share", shareDAO.getShare(company));
        return "shares/share";
    }

    @PatchMapping("/edit/{company}")
    public String update(@ModelAttribute("share") Share share, @PathVariable("company") String company) {
        shareDAO.update(company, share);
        return "redirect:/shares";
    }

    @DeleteMapping("/delete/{company}")
    public String delete(@PathVariable("company") String company) {
        shareDAO.delete(company);
        return "redirect:/shares";
    }
}
