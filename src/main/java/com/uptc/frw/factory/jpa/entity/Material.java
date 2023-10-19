package com.uptc.frw.factory.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MATERIALES")
public class Material {
    @Id
    @Column(name = "ID_MATERIAL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaterial;
    @Column(name = "NOMBRE")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "material")
    private List<ProductType> productTypes;

    public Material() {
    }

    public Material(String name) {
        this.name = name;
    }

    public Material(Long idMaterial, String name) {
        this.idMaterial = idMaterial;
        this.name = name;
    }

    public Material(String name, List<ProductType> productTypes) {
        this.name = name;
        this.productTypes = productTypes;
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductType> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<ProductType> productTypes) {
        this.productTypes = productTypes;
    }

    @Override
    public String toString() {
        return "Material{" +
                "idMaterial=" + idMaterial +
                ", name='" + name + '\'' +
                '}';
    }
}
