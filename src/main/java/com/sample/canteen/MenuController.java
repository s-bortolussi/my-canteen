package com.sample.canteen;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MenuController {

    private MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping("/menus")
    public List<Menu> listMenus() {
        return menuRepository.findAll();
    }

    @GetMapping("/menus/{date}")
    public Menu listMenus(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return menuRepository.findByDate(date);
    }


}

