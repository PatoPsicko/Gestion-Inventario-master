package com.projectjava.demosclient.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "productos")
public class Productos {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(nullable = false, length = 60)
    private int codigo;
    @Column(nullable = false, length = 60)
    private String descripcion;
    @Column(nullable = false, length = 60)
    private String categoria;
    @Column(nullable = false, length = 60)
    private String almacen;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "proveedores_has_productos", joinColumns = @JoinColumn(name = "productos_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "proveedores_id", referencedColumnName = "id"))
    Set<Proveedor> proveedorSet;

    public Productos(){

    }
    public Productos(Long id, int codigo, String descripcion, String categoria, String almacen ){
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.almacen = almacen;
        proveedorSet = new HashSet<>();
    }

    public Productos(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAlmacen() {
        return almacen;
    }

    public Set<Proveedor> getProveedorSet() {
        return proveedorSet;
    }

    public void setProveedorSet(Set<Proveedor> proveedorSet) {
        this.proveedorSet = proveedorSet;
    }

    public void agregarProveedor(Proveedor proveedor){
        proveedorSet.add(proveedor);
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }


    @Override
    public String toString() {
        return "Productos{" +
                "id=" + id +
                ", codigo=" + codigo +
                ", descripcion='" + descripcion.toString() + '\'' +
                ", categoria='" + categoria.toString() + '\'' +
                ", almacen='" + almacen.toString() + '\'' +
                '}';
    }
}
