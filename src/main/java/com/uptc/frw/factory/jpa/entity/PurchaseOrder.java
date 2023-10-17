package com.uptc.frw.factory.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDEN_COMPRAS")
public class PurchaseOrder {

    @Id
    @Column(name = "ID_ORDEN")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FECHA_COMPRA")
    private Date purchaseDate;

    @Column(name = "ENTREGA_ESTIMADA")
    private Date estimatedDelivery;

    @Column(name = "ENTREGA_REAL")
    private Date realDelivery;

    @JsonIgnore
    @Column(name = "ID_CLIENTE", insertable = false, updatable = false)
    private Long idClient;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Client client;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Date purchaseDate, Date estimatedDelivery, Date realDelivery, Client client) {
        this.purchaseDate = purchaseDate;
        this.estimatedDelivery = estimatedDelivery;
        this.realDelivery = realDelivery;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery(Date estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }

    public Date getRealDelivery() {
        return realDelivery;
    }

    public void setRealDelivery(Date realDelivery) {
        this.realDelivery = realDelivery;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", purchaseDate=" + purchaseDate +
                ", estimatedDelivery=" + estimatedDelivery +
                ", realDelivery=" + realDelivery +
                '}';
    }
}
