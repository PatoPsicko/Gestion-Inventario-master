package com.projectjava.demosclient.controllers;


import com.projectjava.demosclient.dao.ProductoDao;
import com.projectjava.demosclient.entity.Productos;
import com.projectjava.demosclient.excel.UserExcelImport;
import com.projectjava.demosclient.paginator.PageRender;
import com.projectjava.demosclient.services.productoService.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class ProductoController {

    @Autowired
    ProductoServices productoServices;

    @Autowired
    ProductoDao productoDao;


    @GetMapping("/productos")
    public String listarProductos(@RequestParam(name="page", defaultValue= "0") int page , Model model,@Param("palabraClave") String palabraClave){
        Pageable pageRequest =  PageRequest.of(page,4);
        Page<Productos> listProductos = productoServices.findAll(pageRequest, palabraClave);
        PageRender pageRender = new PageRender<>("/productos", listProductos);

        model.addAttribute("titulo", "SISTEMA INVENTARIO");


        model.addAttribute("productos",listProductos);

        model.addAttribute("page", pageRender);


        model.addAttribute("palabraClave",palabraClave);
       // model.addAttribute("productos", listProductos);
        return "/productos";
    }


    @RequestMapping("/crearproducto")
    public String crear(Map<String, Object> model){
        Productos producto = new Productos();
        model.put("producto", producto);
        return "/crearproducto";
    }
    @PostMapping("/crearproducto")
    public String crearProducto(Productos producto){
        productoServices.guardarProducto(producto);

        return "redirect:/productos";
    }

    @RequestMapping("/productos")
    public String importarExcel(Model model){
        UserExcelImport excel = new UserExcelImport();
        model.addAttribute("userexcelimport", excel);
        return "/productos";
    }

    @PostMapping("/upload")
    public String importExcel(@RequestParam("file") MultipartFile file, Model model, UserExcelImport excel) throws Exception {

        HashSet<Productos> listProductos = excel.excelImport(file);

        productoDao.saveAll(listProductos);


        model.addAttribute("productos", listProductos);

        return "/productos";
        }


        @GetMapping("/eliminarprod/{id}")
        public String eliminarProducto(@PathVariable(value = "id") Long id){
        productoServices.eliminarProducto(id);
        return "redirect:/productos";
        }

        @GetMapping("/crearproducto/{id}")
        public String editarProducto(@PathVariable(value = "id") Long id, Model model){
        Productos producto2 = productoServices.editarProducto(id);

        model.addAttribute("producto", producto2);
        return "/editarproducto";
        }
}

