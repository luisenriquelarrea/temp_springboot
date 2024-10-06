package com.artplusplus.contpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artplusplus.contpp.dto.MenuDto;
import com.artplusplus.contpp.model.Menu;
import com.artplusplus.contpp.repository.specifications.MenuSpecifications;
import com.artplusplus.contpp.service.MenuService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/menu") // This means URL's start with / (after Application path)
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Menu> add(@RequestBody Menu menu) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Menu obj = menuService.save(menu);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Menu> update(@RequestBody Menu menu,
                     @PathVariable Long id){
        Menu obj = menuService.save(menu);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<Menu> all() {
        // This returns a JSON or XML
        return menuService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long menuId = Long.parseLong(id);
        if(menuService.existsById(menuId)){
            menuService.deleteById(menuId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Menu> getById(@PathVariable Long id){
        if(menuService.existsById(id)){
            Menu menu = menuService.getById(id);
            return ResponseEntity.ok(menu);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path="/filteredList") // Map ONLY POST Requests
    public @ResponseBody List<MenuDto> filteredList(@RequestBody MenuDto menuDto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        Specification<Menu> specs = new MenuSpecifications(menuDto);
        int offset = menuDto.getOffset();
        int limit = menuDto.getLimit();
        int page = offset / limit;
        return menuService.filteredList(specs, PageRequest.of(page, limit));
    }

    @GetMapping(path="/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(menuService.count());
    }

    @PostMapping(path="/countFilteredList")
    public ResponseEntity<Long> countFilteredList(@RequestBody MenuDto menuDto) {
        Specification<Menu> specs = new MenuSpecifications(menuDto);
        return ResponseEntity.ok(menuService.countFilteredList(specs));
    }
}
