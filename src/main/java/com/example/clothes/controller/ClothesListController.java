package com.example.clothes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.clothes.model.Item;
import com.example.clothes.repository.ItemRepository;

@Controller
@RequestMapping("/clothesList")
public class ClothesListController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public String showItems(Model model) {
        return "clothesList";
    }

    @ModelAttribute
    public void items(Model model) {
        Iterable<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
    }

    @GetMapping("/sortByBrand")
    public String sortByBrand(Model model) {
        List<Item> items = itemRepository.findAll(Sort.by("brand"));
        model.addAttribute("items", items);
        return "clothesList";
    }

    @PostMapping("/deleteItem")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteItem(@RequestParam("id") Long id) {
        itemRepository.deleteById(id);
        return "redirect:/clothesList";
    }

}
