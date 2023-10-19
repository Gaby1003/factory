package com.uptc.frw.factory.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TRABAJADORES")
public class Worker {
    @Id
    @Column(name = "ID_TRABAJADOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOMBRE")
    private String name;
    @Column(name = "APELLIDO")
    private String lastName;
    @Column(name = "FECHA_NACIMIENTO")
    private Date birthday;
    @Column(name = "DIRECCION")
    private String address;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "HABILIDADES_TRABAJADOR",
            joinColumns = {@JoinColumn(name = "ID_TRABAJADOR")},
            inverseJoinColumns = {@JoinColumn(name = "ID_HABILIDAD")}
    )
    private List<Skill> skillList;

    @JsonIgnore
    @OneToMany(mappedBy = "worker")
    private List<MachineHistory> machineHistoryList;

    public Worker() {
    }

    public Worker(String name, String lastName, Date birthday, String address, List<Skill> skillList, List<MachineHistory> machineHistoryList) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.skillList = skillList;
        this.machineHistoryList = machineHistoryList;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public List<MachineHistory> getMachineHistoryList() {
        return machineHistoryList;
    }

    public void setMachineHistoryList(List<MachineHistory> machineHistoryList) {
        this.machineHistoryList = machineHistoryList;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}
