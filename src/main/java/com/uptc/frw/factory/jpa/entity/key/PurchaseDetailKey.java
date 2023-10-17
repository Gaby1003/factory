package com.uptc.frw.factory.jpa.entity.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PurchaseDetailKey implements Serializable {

    @Column(name = "ID_PRODUCTO")
    private Long productId;

    @Column(name = "ID_ORDEN")
    private Long orderId;

    public PurchaseDetailKey() {
    }

    public PurchaseDetailKey(Long productId, Long orderId) {
        this.productId = productId;
        this.orderId = orderId;
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

    @Override
    public String toString() {
        return "PurchaseDetailKey{" +
                "productId=" + productId +
                ", orderId=" + orderId +
                '}';
    }
}
