package com.uptc.frw.factory.jpa.entity.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MachineHistoryKey implements Serializable {

    @Column(name = "ID_TRABAJADOR")
    private Long workerId;

    @Column(name = "ID_MAQUINA")
    private Long machineId;

    @Column(name = "FECHA")
    private Long date;


    public MachineHistoryKey() {
    }

    public MachineHistoryKey(Long workerId, Long machineId, Long date) {
        this.workerId = workerId;
        this.machineId = machineId;
        this.date = date;
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

    @Override
    public String toString() {
        return "MachineHistoryKey{" +
                "workerId=" + workerId +
                ", machineId=" + machineId +
                ", date=" + date +
                '}';
    }
}
