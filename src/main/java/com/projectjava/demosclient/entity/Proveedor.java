package com.projectjava.demosclient.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "proveedores", uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long numtransferencia;
    private String nombre;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "proveedores_has_productos", joinColumns = @JoinColumn(name = "proveedores_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "productos_id", referencedColumnName = "id"))
     Set<Productos> listProductos;

    public Proveedor(){

    }
    public Proveedor( Long numTransferencia, String nombre){
        this.numtransferencia = numTransferencia;
        this.nombre = nombre;

        listProductos = new HashSet<>();
    }

    public Proveedor(Long id) {
        this.id = id;
    }

    public Set<Productos> getListProductos() {
        return listProductos;
    }

    public void setListProductos(Set<Productos> listProductos) {
        this.listProductos = listProductos;
    }

    public void addProductos(Productos producto){
        listProductos.add(producto);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumtransferencia() {
        return numtransferencia;
    }

    public void setNumtransferencia(Long numtransferencia) {
        this.numtransferencia = numtransferencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


//Este metodo puede ser agregar inventario por inventario en el caso de que el proveedor ofrezca
    //Multiples servicios

}

