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

import com.artplusplus.contpp.dto.SeccionMenuDto;
import com.artplusplus.contpp.model.SeccionMenu;
import com.artplusplus.contpp.repository.specifications.SeccionMenuSpecifications;
import com.artplusplus.contpp.service.SeccionMenuService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/seccion_menu") // This means URL's start with / (after Application path)
public class SeccionMenuController {
    @Autowired
    private SeccionMenuService seccionMenuService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<SeccionMenu> add(@RequestBody SeccionMenu seccionMenu) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        SeccionMenu obj = seccionMenuService.save(seccionMenu);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<SeccionMenu> update(@RequestBody SeccionMenu seccionMenu,
                     @PathVariable Long id){
        SeccionMenu obj = seccionMenuService.save(seccionMenu);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<SeccionMenu> all() {
        // This returns a JSON or XML
        return seccionMenuService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long seccionMenuId = Long.parseLong(id);
        if(seccionMenuService.existsById(seccionMenuId)){
            seccionMenuService.deleteById(seccionMenuId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<SeccionMenu> getById(@PathVariable Long id){
        if(seccionMenuService.existsById(id)){
            SeccionMenu seccionMenu = seccionMenuService.getById(id);
            return ResponseEntity.ok(seccionMenu);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path="/filteredList") // Map ONLY POST Requests
    public @ResponseBody List<SeccionMenuDto> filteredList(@RequestBody SeccionMenuDto seccionMenuDto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        Specification<SeccionMenu> specs = new SeccionMenuSpecifications(seccionMenuDto);
        int offset = seccionMenuDto.getOffset();
        int limit = seccionMenuDto.getLimit();
        int page = offset / limit;
        return seccionMenuService.filteredList(specs, PageRequest.of(page, limit));
    }

    @GetMapping(path="/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(seccionMenuService.count());
    }

    @PostMapping(path="/countFilteredList")
    public ResponseEntity<Long> countFilteredList(@RequestBody SeccionMenuDto seccionMenuDto) {
        Specification<SeccionMenu> specs = new SeccionMenuSpecifications(seccionMenuDto);
        return ResponseEntity.ok(seccionMenuService.countFilteredList(specs));
    }
}
