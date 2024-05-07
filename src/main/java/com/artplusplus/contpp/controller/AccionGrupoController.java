package com.artplusplus.contpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artplusplus.contpp.dto.PostDto;
import com.artplusplus.contpp.model.AccionGrupo;
import com.artplusplus.contpp.service.AccionGrupoService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/accion_grupo") // This means URL's start with / (after Application path)
public class AccionGrupoController {
    @Autowired private AccionGrupoService accionGrupoService;

    @GetMapping(path="/")
    public @ResponseBody List<AccionGrupo> all() {
        // This returns a JSON or XML with the users
        return accionGrupoService.list();
    }

    @PostMapping(path="/grupo") // Map ONLY POST Requests
    public List<AccionGrupo> getByGrupo(@RequestBody PostDto postDto) {
        // @ResponseBody means the returned Entity is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return accionGrupoService.listByGrupo(postDto.getGrupoId());
    }
}
