package com.projectjava.demosclient;


import com.projectjava.demosclient.dao.ProductoDao;
import com.projectjava.demosclient.dao.ProveedorDao;
import com.projectjava.demosclient.entity.Productos;
import com.projectjava.demosclient.entity.Proveedor;
import com.projectjava.demosclient.entity.ProveedoresProductos;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProductosTest {
    @Autowired
    private TestEntityManager tem;

    @Autowired
    ProductoDao productoDao;

    @Autowired
    ProveedorDao proveedorDao;

    @Test
    public void añadirProducto() {
        Productos producto2 = new Productos(2L, 2323, "PEDIGREE", "FORRAJERIA", "LOS CANES");

        productoDao.save(producto2);
    }

    @Test
    public void añadirProveedor(){
        Proveedor proveedor1 = new Proveedor( 222332335521232112L, "MANUEL");
        proveedorDao.save(proveedor1);
    }

    @Test
    public void listarProductos(){
        List<Productos> productosList = productoDao.findAll();

        productosList.forEach(System.out::println);
    }

}
