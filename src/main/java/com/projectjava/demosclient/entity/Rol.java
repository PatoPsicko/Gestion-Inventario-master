package com.projectjava.demosclient.entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String nombrerol;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "rol_has_usuarios", joinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "usuarios_id", referencedColumnName = "id"))
    Set<Usuario> listUsuarios;


    public Rol() {
    }

    public Rol(Long id, String nombrerol) {
        this.id = id;
        this.nombrerol = nombrerol;
        this.listUsuarios = new HashSet<>();
    }

    public Rol(Long id) {
        this.id = id;
    }

    public Rol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void añadirUser(Usuario user){
        listUsuarios.add(user);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rol rol = (Rol) o;
        return id.equals(rol.id);
    }

    @Override
    public String toString() {
        return nombrerol.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
