package com.projectjava.demosclient.entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 25, nullable = false)
    private String nombre;
    @Column(length = 25, nullable = false)
    private String apellido;

    @Column(length = 25, nullable = false)
    private String email;
    @Column(length = 25, nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "rol_has_usuarios", joinColumns = @JoinColumn(name = "usuarios_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
    Set<Rol> listRoles;


    public Usuario() {
    }

    public Usuario(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        listRoles = new HashSet<>();

    }

    public Usuario(Long id, String nombre, String apellido, String email, String password, Set<Rol> listRoles) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.listRoles = listRoles;
    }



    public Usuario(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void añadirRol(Rol rol){
       listRoles.add(rol);
    }

    public void eliminarRol(Rol rol){
        listRoles.remove(rol);
    }

    public Set<Rol> getListRoles() {
        return listRoles;
    }

    public void setListRoles(Set<Rol> listRoles) {
        this.listRoles = listRoles;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}




