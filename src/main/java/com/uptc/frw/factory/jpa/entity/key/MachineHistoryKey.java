package com.uptc.frw.factory.jpa.entity.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class MachineHistoryKey implements Serializable {

    @Column(name = "ID_TRABAJADOR")
    private Long workerId;

    @Column(name = "ID_MAQUINA")
    private Long machineId;

    @Column(name = "FECHA")
    private Date date;

    public MachineHistoryKey() {
    }

    public MachineHistoryKey(Long workerId, Long machineId, Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MachineHistoryKey{" +
                "workerId=" + workerId +
                ", machineId='" + machineId + '\'' +
                ", date=" + date +
                '}';
    }
}
