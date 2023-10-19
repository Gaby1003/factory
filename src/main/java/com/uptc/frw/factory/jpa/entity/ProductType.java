package com.uptc.frw.factory.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TIPO_PRODUCTOS")
public class ProductType {
    @Id
    @Column(name = "ID_TIPO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;
    @Column(name = "TIPO")
    private String Type;
    @Column(name = "ID_MATERIAL", insertable = false, updatable = false)
    private Long idMaterial;
    @Column(name = "ID_MAQUINA", insertable = false, updatable = false)
    private Long idMachine;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_MATERIAL")
    private Material material;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_MAQUINA")
    private Machine machine;

    @JsonIgnore
    @OneToMany(mappedBy = "productType")
    private List<Product> products;

    public ProductType() {
    }

    public ProductType(String type, Long idMaterial, Long idMachine) {
        Type = type;
        this.idMaterial = idMaterial;
        this.idMachine = idMachine;
    }

    public ProductType(Long idType, String type, Long idMaterial, Long idMachine) {
        this.idType = idType;
        Type = type;
        this.idMaterial = idMaterial;
        this.idMachine = idMachine;
    }

    public ProductType(String type, Long idMaterial, Long idMachine, Material material, Machine machine, List<Product> products) {
        Type = type;
        this.idMaterial = idMaterial;
        this.idMachine = idMachine;
        this.material = material;
        this.machine = machine;
        this.products = products;
    }

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Long getIdMachine() {
        return idMachine;
    }

    public void setIdMachine(Long idMachine) {
        this.idMachine = idMachine;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "idType=" + idType +
                ", Type='" + Type + '\'' +
                ", idMaterial=" + idMaterial +
                ", idMachine=" + idMachine +
                '}';
    }
}
