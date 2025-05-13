package com.projectjava.demosclient.dao;

import com.projectjava.demosclient.entity.ProveedoresProductos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorProductosDao extends JpaRepository<ProveedoresProductos, Long> {
}
