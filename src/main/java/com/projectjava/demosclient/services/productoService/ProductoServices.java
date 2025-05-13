package com.projectjava.demosclient.services.productoService;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.projectjava.demosclient.entity.Productos;
import com.projectjava.demosclient.excel.UserExcelImport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface ProductoServices{

//    List<Productos> listProductos(String palabraClave);
    Page<Productos> findAll(Pageable pageable, String palabraClave);
    void guardarProducto(Productos producto);

    public void eliminarProducto(Long id);

    public Productos editarProducto(Long id);

    //List<Productos> importExcel(MultipartFile file) throws Exception;
}
