package com.uptc.frw.factory.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MAQUINAS")
public class Machine {

    @Id
    @Column(name = "NUMERO_SERIE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String serialNumber;

    @Column(name = "MARCA")
    private String brand;

    @Column(name = "MODELO")
    private String model;

    @Column(name = "FECHA_COMPRA")
    private Date purchaseDate;

    @JsonIgnore
    @OneToMany(mappedBy = "machine")
    private List<MachineHistory> machineHistories;

    @JsonIgnore
    @OneToMany(mappedBy = "machine")
    private List<ProductType> productTypes;

    public Machine() {
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public List<MachineHistory> getMachineHistories() {
        return machineHistories;
    }

    public void setMachineHistories(List<MachineHistory> machineHistories) {
        this.machineHistories = machineHistories;
    }

    public List<ProductType> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<ProductType> productTypes) {
        this.productTypes = productTypes;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "serialNumber='" + serialNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
