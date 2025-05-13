package com.projectjava.demosclient.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "proveedores_has_productos")
public class ProveedoresProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productos_id")
    private Productos productos;

    @ManyToOne
    @JoinColumn(name = "proveedores_id")
    private Proveedor proveedor;


    private int costos;
    private int impuestos;

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }


    public ProveedoresProductos() {
    }

    public ProveedoresProductos(Long id, int costos, int impuestos, Productos productos, Proveedor proveedores) {
        this.id = id;
        this.costos = costos;
        this.impuestos = impuestos;
        this.productos = productos;
        this.proveedor = proveedores;
    }

    public ProveedoresProductos(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public int getCostos() {
        return costos;
    }

    public void setCostos(int costos) {
        this.costos = costos;
    }

    public int getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(int impuestos) {
        this.impuestos = impuestos;
    }

    @Override
    public String toString() {
        return "ProveedoresProductos{" +
                "id=" + id +
                ", costos=" + costos +
                ", impuestos=" + impuestos +
                '}';
    }
}
