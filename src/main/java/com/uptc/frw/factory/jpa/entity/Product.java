package com.uptc.frw.factory.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCTOS")
public class Product {
    @Id
    @Column(name = "ID_PRODUCTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    @Column(name = "NOMBRE")
    private String name;
    @Column(name = "DESCRIPCION")
    private String description;
    @Column(name = "PRECIO_UNITARIO")
    private Double unitPrice;
    @Column(name = "ID_TIPO")
    private Long idType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_TIPO", insertable = false, updatable = false)
    private ProductType productType;

    @JsonIgnore
    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
    private List<PurchaseDetail> purchaseDetails;


    public Product() {
    }

    public Product(String name, String description, Double unitPrice, Long idType) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.idType = idType;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public List<PurchaseDetail> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", idType=" + idType +
                '}';
    }
}
