package com.storage.vrn.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "storage_work_station", schema = "public", catalog = "storage")
public class StorageWorkStationEntity {
    private long id;
    private String computer;
    private String monitor;
    private String printer;
    private String ups;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    //@Basic
    @Column(name = "computer")
    public String getComputer() {
        return computer;
    }
    public void setComputer(String computer) {
        this.computer = computer;
    }

    //@Basic
    @Column(name = "monitor")
    public String getMonitor() {
        return monitor;
    }
    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    //@Basic
    @Column(name = "printer")
    public String getPrinter() {
        return printer;
    }
    public void setPrinter(String printer) {
        this.printer = printer;
    }

    //@Basic
    @Column(name = "ups")
    public String getUps() {
        return ups;
    }
    public void setUps(String ups) {
        this.ups = ups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageWorkStationEntity that = (StorageWorkStationEntity) o;
        return id == that.id && Objects.equals(computer, that.computer) && Objects.equals(monitor, that.monitor) && Objects.equals(printer, that.printer) && Objects.equals(ups, that.ups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, computer, monitor, printer, ups);
    }
}