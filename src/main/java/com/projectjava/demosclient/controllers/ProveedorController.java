package com.projectjava.demosclient.controllers;


import com.projectjava.demosclient.entity.Proveedor;
import com.projectjava.demosclient.services.proveedorService.ProveedorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping("")
@Controller
public class ProveedorController {
    @Autowired
    ProveedorServices proveedorServices;



    @GetMapping("/listarproveedores")
    public String listarProveedores(Model model){

        List<Proveedor> listProveedores = proveedorServices.listSupplier();

        model.addAttribute("proveedor", listProveedores);

        return "/listarproveedores";
    }

    @RequestMapping("/crearproveedor")
    public String crear(Map<String, Object> model){
        Proveedor proveedor = new Proveedor();
        model.put("proveedor", proveedor);
        return "/crearproveedor";
    }
    @PostMapping("/crearproveedor")
    public String crearProducto(Proveedor proveedor){
       proveedorServices.save(proveedor);

        return "redirect:/listarproveedores";
    }

}


