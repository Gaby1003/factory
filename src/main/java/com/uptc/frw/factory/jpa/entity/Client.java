package com.uptc.frw.factory.jpa.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Clientes")
public class Client {

    @Id
    @Column(name = "ID_CLIENTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "DIRECCION")
    private String address;

    @Column(name = "TELEFONO")
    private String phone;

    @Column(name = "NOMBRE_CONTACTO")
    private String contactName;

    public Client() {
    }

    public Client(String name, String address, String phone, String contactName) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.contactName = contactName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", contactName='" + contactName + '\'' +
                '}';
    }
}
