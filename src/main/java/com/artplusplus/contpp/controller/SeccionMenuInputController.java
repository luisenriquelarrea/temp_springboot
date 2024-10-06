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

import com.artplusplus.contpp.dto.SeccionMenuInputDto;
import com.artplusplus.contpp.model.SeccionMenuInput;
import com.artplusplus.contpp.repository.specifications.SeccionMenuInputSpecifications;
import com.artplusplus.contpp.service.SeccionMenuInputService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/seccion_menu_input") // This means URL's start with / (after Application path)
public class SeccionMenuInputController {
    @Autowired
    private SeccionMenuInputService seccionMenuInputService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<SeccionMenuInput> add(@RequestBody SeccionMenuInput seccionMenuInput) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        SeccionMenuInput obj = seccionMenuInputService.save(seccionMenuInput);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<SeccionMenuInput> update(@RequestBody SeccionMenuInput seccionMenuInput,
                     @PathVariable Long id){
        SeccionMenuInput obj = seccionMenuInputService.save(seccionMenuInput);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<SeccionMenuInput> all() {
        // This returns a JSON or XML
        return seccionMenuInputService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long seccionMenuInputId = Long.parseLong(id);
        if(seccionMenuInputService.existsById(seccionMenuInputId)){
            seccionMenuInputService.deleteById(seccionMenuInputId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<SeccionMenuInput> getById(@PathVariable Long id){
        if(seccionMenuInputService.existsById(id)){
            SeccionMenuInput seccionMenuInput = seccionMenuInputService.getById(id);
            return ResponseEntity.ok(seccionMenuInput);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path="/filteredList") // Map ONLY POST Requests
    public @ResponseBody List<SeccionMenuInputDto> filteredList(@RequestBody SeccionMenuInputDto seccionMenuInputDto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        Specification<SeccionMenuInput> specs = new SeccionMenuInputSpecifications(seccionMenuInputDto);
        int offset = seccionMenuInputDto.getOffset();
        int limit = seccionMenuInputDto.getLimit();
        int page = offset / limit;
        return seccionMenuInputService.filteredList(specs, PageRequest.of(page, limit));
    }

    @GetMapping(path="/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(seccionMenuInputService.count());
    }

    @PostMapping(path="/countFilteredList")
    public ResponseEntity<Long> countFilteredList(@RequestBody SeccionMenuInputDto seccionMenuInputDto) {
        Specification<SeccionMenuInput> specs = new SeccionMenuInputSpecifications(seccionMenuInputDto);
        return ResponseEntity.ok(seccionMenuInputService.countFilteredList(specs));
    }
}
