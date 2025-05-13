package com.projectjava.demosclient.services.proveedorService;


import com.projectjava.demosclient.dao.ProveedorDao;
import com.projectjava.demosclient.entity.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProveedorServicesImpl implements ProveedorServices {

    @Autowired
    private ProveedorDao proveedorDao;

    @Override
    public List<Proveedor> listSupplier() {
        return proveedorDao.findAll();
    }

    @Override
    public void save(Proveedor proveedor) {
        proveedorDao.save(proveedor);
    }

    @Override
    public void delete(Long id) {
        proveedorDao.deleteById(id);
    }

    @Override
    public Proveedor editSupplier(Long id) {
      return proveedorDao.findById(id).orElse(null);
    }

}
