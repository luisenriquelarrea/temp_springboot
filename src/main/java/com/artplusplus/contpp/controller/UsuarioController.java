package com.artplusplus.contpp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // This means that this class is a Controller
@RequestMapping(path="/api/usuario") // This means URL's start with /Usuario (after Application path)
public class UsuarioController { }