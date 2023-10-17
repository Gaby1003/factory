package com.uptc.frw.factory.jpa.entity;

import com.uptc.frw.factory.jpa.entity.key.PurchaseDetailKey;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DETALLE_COMPRAS")
@IdClass(PurchaseDetailKey.class)
public class PurchaseDetail {

    @Id
    @Column(name = "ID_PRODUCTO", insertable = false, updatable = false)
    private Long productId;

    @Id
    @Column(name = "ID_ORDEN", insertable = false, updatable = false)
    private Long orderId;

    @Column(name = "CANTIDAD")
    private int quantity;

    @Column(name = "PRECIO_UNITARIO")
    private int unitPrice;

    @ManyToOne
    @JoinColumn(name = "ID_ORDEN", nullable = false)
    private PurchaseOrder order;

    /*@ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", nullable = false)
    private Product product;*/

    public PurchaseDetail() {
    }

    public PurchaseDetail(int quantity, int unitPrice, PurchaseOrder order) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.order = order;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public PurchaseOrder getOrder() {
        return order;
    }

    public void setOrder(PurchaseOrder order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "PurchaseDetail{" +
                "quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
