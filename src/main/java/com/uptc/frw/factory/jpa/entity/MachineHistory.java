package com.uptc.frw.factory.jpa.entity;

import com.uptc.frw.factory.jpa.entity.key.MachineHistoryKey;

import javax.persistence.*;

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
    private Long date;

    @ManyToOne
    @JoinColumn(name = "ID_MAQUINA")
    private Machine machine;

//    @ManyToOne
//    @JoinColumn(name = "ID_TRABAJADOR")
//    private Worker worker;

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

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    @Override
    public String toString() {
        return "MachineHistory{" +
                "workerId=" + workerId +
                ", machineId=" + machineId +
                ", date=" + date +
                '}';
    }
}
