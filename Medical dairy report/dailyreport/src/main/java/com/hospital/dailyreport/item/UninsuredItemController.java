package com.hospital.dailyreport.item;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UninsuredItemController {

    @GetMapping("/items")
    public String list(Model model) {
        List<UninsuredItem> items = List.of(
                new UninsuredItem(1L, "주사(린코)", null, 2200, "주사", true),
                new UninsuredItem(2L, "IV", "H40", 40000, "IV", true),
                new UninsuredItem(3L, "NSR", "도구", 10000, "NSR", true)
        );
        model.addAttribute("items", items);
        return "items/list";
    }
}