package com.storage.vrn.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "storage_work_station", schema = "public", catalog = "storage")
public class StorageWorkStationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //@Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }
    /*public void setId(long id) {
        this.id = id;
    }*/

    //@Basic
    @Column(name = "computer")
    private String computer;
    public String getComputer() {
        return computer;
    }
    public void setComputer(String computer) {
        this.computer = computer;
    }

    //@Basic
    @Column(name = "monitor")
    private String monitor;
    public String getMonitor() {
        return monitor;
    }
    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    //@Basic
    @Column(name = "printer")
    private String printer;
    public String getPrinter() {
        return printer;
    }
    public void setPrinter(String printer) {
        this.printer = printer;
    }

    //@Basic
    @Column(name = "ups")
    private String ups;
    public String getUps() {
        return ups;
    }
    public void setUps(String ups) {
        this.ups = ups;
    }

    //@Basic
    @Column(name = "kab")
    private String kab;
    public String getKab() {
        return kab;
    }
    public void setKab(String kab) {
        this.kab = kab;
    }

    public StorageWorkStationEntity() {}

    public StorageWorkStationEntity(String computer, String monitor, String printer, String ups, String kab) {
        this.computer = computer;
        this.monitor =monitor;
        this.printer =printer;
        this.ups = ups;
        this.kab = kab;
    }

    @Override
    public String toString() {
        return "computer = " + computer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageWorkStationEntity that = (StorageWorkStationEntity) o;
        return id == that.id && Objects.equals(computer, that.computer) && Objects.equals(monitor, that.monitor) && Objects.equals(printer, that.printer) && Objects.equals(ups, that.ups) && Objects.equals(kab, that.kab);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, computer, monitor, printer, ups, kab);
    }
}