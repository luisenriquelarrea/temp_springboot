package com.artplusplus.contpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artplusplus.contpp.model.SeccionMenuInput;
import com.artplusplus.contpp.service.SeccionMenuInputService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path="/api/seccion_menu_input") // This means URL's start with / (after Application path)
public class SeccionMenuInputController {
    @Autowired private SeccionMenuInputService seccionMenuInputService;

    @GetMapping(path="/")
    public @ResponseBody List<SeccionMenuInput> all() {
        // This returns a JSON or XML with the users
        return seccionMenuInputService.list();
    }
}
