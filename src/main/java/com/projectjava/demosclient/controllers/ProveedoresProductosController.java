package com.projectjava.demosclient.controllers;


import com.projectjava.demosclient.dao.ProveedorProductosDao;
import com.projectjava.demosclient.entity.ProveedoresProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProveedoresProductosController {

    @Autowired
    ProveedorProductosDao proveedoresProductosDao;


    @GetMapping("/proveedorproducto")
    public String listarTodo(Model model) {
        List<ProveedoresProductos> proveedoresProductosList = proveedoresProductosDao.findAll();
        model.addAttribute("proveedoresyproductos", proveedoresProductosList);
        return "/proveedorproducto";
    }
}
