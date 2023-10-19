package com.uptc.frw.factory.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uptc.frw.factory.jpa.entity.key.MachineHistoryKey;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HISTORICO_MAQUINAS")
@IdClass(MachineHistoryKey.class)
public class MachineHistory {

    @Id
    @Column(name = "ID_TRABAJADOR")
    private Long workerId;

    @Id
    @Column(name = "ID_MAQUINA")
    private Long machineId;

    @Id
    @Column(name = "FECHA")
    private Date date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_MAQUINA", insertable = false, updatable = false)
    private Machine machine;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_TRABAJADOR", insertable = false, updatable = false)
    private Worker worker;

    public MachineHistory() {
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Long getMachineId() {
        return machineId;
    }

    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "MachineHistory{" +
                "workerId=" + workerId +
                ", machineId='" + machineId + '\'' +
                ", date=" + date +
                ", machine=" + machine +
                ", worker=" + worker +
                '}';
    }
}
