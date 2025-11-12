package com.artplusplus.contpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

import com.artplusplus.contpp.dto.AccionGrupoDto;
import com.artplusplus.contpp.model.Accion;
import com.artplusplus.contpp.model.SeccionMenu;
import com.artplusplus.contpp.model.AccionGrupo;
import com.artplusplus.contpp.specifications.AccionGrupoSpecifications;
import com.artplusplus.contpp.service.AccionGrupoService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/accion_grupo") // This means URL's start with / (after Application path)
public class AccionGrupoController {
    @Autowired private AccionGrupoService accionGrupoService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<AccionGrupo> add(@RequestBody AccionGrupo accionGrupo) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        AccionGrupo obj = accionGrupoService.save(accionGrupo);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<AccionGrupo> update(@RequestBody AccionGrupo accionGrupo,
                     @PathVariable Long id){
        AccionGrupo obj = accionGrupoService.save(accionGrupo);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(path="/")
    public @ResponseBody List<AccionGrupo> all() {
        // This returns a JSON or XML with the users
        return accionGrupoService.list();
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        Long accionGrupoId = Long.parseLong(id);
        if(accionGrupoService.existsById(accionGrupoId)){
            accionGrupoService.deleteById(accionGrupoId);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.ok("ID not found");
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<AccionGrupo> getById(@PathVariable Long id){
        if(accionGrupoService.existsById(id)){
            AccionGrupo accionGrupo = accionGrupoService.getById(id);
            return ResponseEntity.ok(accionGrupo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path="/filteredList") // Map ONLY POST Requests
    public @ResponseBody List<AccionGrupoDto> filteredList(@RequestBody AccionGrupoDto accionGrupoDto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        Specification<AccionGrupo> specs = new AccionGrupoSpecifications(accionGrupoDto);
        int offset = accionGrupoDto.getOffset();
        int limit = accionGrupoDto.getLimit();
        int page = offset / limit;
        List<Sort.Order> order = new ArrayList<Sort.Order>();
        order.add(new Sort.Order(Sort.Direction.ASC, "grupo.id"));
        order.add(new Sort.Order(Sort.Direction.ASC, "accion.seccionMenu.id"));
        return accionGrupoService.filteredList(specs, 
            PageRequest.of(page, limit, 
            Sort.by(order)));
    }

    @GetMapping(path="/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(accionGrupoService.count());
    }

    @PostMapping(path="/countFilteredList")
    public ResponseEntity<Long> countFilteredList(@RequestBody AccionGrupoDto accionGrupoDto) {
        Specification<AccionGrupo> specs = new AccionGrupoSpecifications(accionGrupoDto);
        return ResponseEntity.ok(accionGrupoService.countFilteredList(specs));
    }

    @PostMapping(path="/allowed_menus") // Map ONLY POST Requests
    public List<SeccionMenu> getAllowedMenus(@RequestBody AccionGrupoDto accionGrupoDto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return accionGrupoService.getAllowedMenus(accionGrupoDto.getGrupo().getId());
    }

    @PostMapping(path="/allowed_breadcrumbs") // Map ONLY POST Requests
    public List<Accion> getAllowedBreadcrumbs(@RequestBody AccionGrupoDto accionGrupoDto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return accionGrupoService.getAllowedBreadcrumbs(accionGrupoDto.getGrupo().getId(), 
            accionGrupoDto.getSeccionMenu().getId());
    }

    @PostMapping(path="/allowed_navbar") // Map ONLY POST Requests
    public List<Accion> getAllowedExportData(@RequestBody AccionGrupoDto accionGrupoDto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return accionGrupoService.getAllowedNavbar(accionGrupoDto.getGrupo().getId(), 
            accionGrupoDto.getSeccionMenu().getId());
    }

    @PostMapping(path="/allowed_table_actions") // Map ONLY POST Requests
    public List<Accion> getAllowedTableActions(@RequestBody AccionGrupoDto accionGrupoDto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return accionGrupoService.getAllowedTableActions(accionGrupoDto.getGrupo().getId(), 
            accionGrupoDto.getSeccionMenu().getId());
    }
}