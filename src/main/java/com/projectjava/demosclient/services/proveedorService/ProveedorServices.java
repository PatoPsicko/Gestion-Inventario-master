package com.projectjava.demosclient.services.proveedorService;


import com.projectjava.demosclient.entity.Proveedor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ProveedorServices {

    List<Proveedor> listSupplier();
    void save(Proveedor proveedor);
    void delete(Long id);
    Proveedor editSupplier(Long id);

}
