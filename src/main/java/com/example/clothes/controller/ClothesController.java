package com.example.clothes.controller;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.clothes.model.Item;
import com.example.clothes.model.Item.Brand;
import com.example.clothes.repository.ItemRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/clothes")
public class ClothesController {

    @Autowired
    private ItemRepository itemRepository;

    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
    @GetMapping
    public String clothes(){
        return "clothes";
    }

    @ModelAttribute
    public void brands(Model model){
        var brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brands", brands);
        log.info("brands converted to string. {}", brands);
    }
    @ModelAttribute
    public Item item() {
        return Item.builder()
                .build();
    }


    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
    @PostMapping
    public String processItemAddition(@Valid Item item, Errors errors){
        if(errors.hasErrors()){
            return "clothes";
        }
        itemRepository.save(item);
        return "redirect:/clothesList";
    }
}