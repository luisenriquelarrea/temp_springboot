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

import com.artplusplus.contpp.dto.StyledColumnDto;
import com.artplusplus.contpp.model.StyledColumn;
import com.artplusplus.contpp.repository.specifications.StyledColumnSpecifications;
import com.artplusplus.contpp.service.StyledColumnService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/styled_column") // This means URL's start with / (after Application path)
public class StyledColumnController {
    @Autowired
    private StyledColumnService styledColumnService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<StyledColumn> add(@RequestBody StyledColumn styledColumn) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        StyledColumn obj = styledColumnService.save(styledColumn);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<StyledColumn> update(@RequestBody StyledColumn styledColumn,
                     @PathVariable Long id){
        StyledColumn obj = styledColumnService.save(styledColumn);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<StyledColumn> all() {
        // This returns a JSON or XML
        return styledColumnService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long styledColumnId = Long.parseLong(id);
        if(styledColumnService.existsById(styledColumnId)){
            styledColumnService.deleteById(styledColumnId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<StyledColumn> getById(@PathVariable Long id){
        if(styledColumnService.existsById(id)){
            StyledColumn styledColumn = styledColumnService.getById(id);
            return ResponseEntity.ok(styledColumn);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path="/filteredList") // Map ONLY POST Requests
    public @ResponseBody List<StyledColumnDto> filteredList(@RequestBody StyledColumnDto styledColumnDto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        Specification<StyledColumn> specs = new StyledColumnSpecifications(styledColumnDto);
        int offset = styledColumnDto.getOffset();
        int limit = styledColumnDto.getLimit();
        int page = offset / limit;
        return styledColumnService.filteredList(specs, PageRequest.of(page, limit));
    }

    @GetMapping(path="/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(styledColumnService.count());
    }

    @PostMapping(path="/countFilteredList")
    public ResponseEntity<Long> countFilteredList(@RequestBody StyledColumnDto styledColumnDto) {
        Specification<StyledColumn> specs = new StyledColumnSpecifications(styledColumnDto);
        return ResponseEntity.ok(styledColumnService.countFilteredList(specs));
    }
}
