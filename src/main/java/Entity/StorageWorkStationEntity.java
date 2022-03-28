package Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "storage_work_station", schema = "public", catalog = "storage")
public class StorageWorkStationEntity {
    private long id;
    private Integer computer;
    private Integer monitor;
    private Integer printer;
    private Boolean mfp;
    private Integer ups;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "computer")
    public Integer getComputer() {
        return computer;
    }

    public void setComputer(Integer computer) {
        this.computer = computer;
    }

    @Basic
    @Column(name = "monitor")
    public Integer getMonitor() {
        return monitor;
    }

    public void setMonitor(Integer monitor) {
        this.monitor = monitor;
    }

    @Basic
    @Column(name = "printer")
    public Integer getPrinter() {
        return printer;
    }

    public void setPrinter(Integer printer) {
        this.printer = printer;
    }

    @Basic
    @Column(name = "mfp")
    public Boolean getMfp() {
        return mfp;
    }

    public void setMfp(Boolean mfp) {
        this.mfp = mfp;
    }

    @Basic
    @Column(name = "ups")
    public Integer getUps() {
        return ups;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageWorkStationEntity that = (StorageWorkStationEntity) o;
        return id == that.id && Objects.equals(computer, that.computer) && Objects.equals(monitor, that.monitor) && Objects.equals(printer, that.printer) && Objects.equals(mfp, that.mfp) && Objects.equals(ups, that.ups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, computer, monitor, printer, mfp, ups);
    }
}
