package com.storage.vrn.dao;

import com.storage.vrn.exception.SetException;
import com.storage.vrn.mapper.StorageComputerMapper;
import com.storage.vrn.model.StorageComputerinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class StorageComputerDAO extends JdbcDaoSupport {

    @Autowired
    public StorageComputerDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<StorageComputerinfo> getStorageComputer() {
        String sql = StorageComputerMapper.BASE_SQL;

        Object[] params = new Object[] {};
        StorageComputerMapper mapper = new StorageComputerMapper();
        List<StorageComputerinfo> list = this.getJdbcTemplate().query(sql, params, mapper);

        return list;
    }

    public StorageComputerinfo findStorageComputer(Long id) {
        String sql = StorageComputerMapper.BASE_SQL + " where Id = ? ";

        Object[] params = new Object[] { id };
        StorageComputerMapper mapper = new StorageComputerMapper();
        try {
            StorageComputerinfo storageComputer = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return storageComputer;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public void editId(Long id, Long idacc) throws SetException {
        StorageComputerinfo computerInfo = this.findStorageComputer(id);
        if (computerInfo == null) {
            throw new SetException("Work station not found " + id);
        }
        computerInfo.setIdacc(idacc);

        // Update to DB
        String sqlUpdate = "Update storage_work_station set idacc = ? where Id = ?";
        this.getJdbcTemplate().update(sqlUpdate, computerInfo.getIdacc(), computerInfo.getId());
    }

    public void editInfo(Long id, Integer computer, Integer monitor, Integer printer, Boolean mfp, Integer ups) throws SetException {
        StorageComputerinfo computerInfo = this.findStorageComputer(id);
        if (computerInfo == null) {
            throw new SetException("Work station not found " + id);
        }
        computerInfo.setComputer(computer);
        computerInfo.setMonitor(monitor);
        computerInfo.setPrinter(printer);
        computerInfo.setMfp(mfp);
        computerInfo.setUps(ups);

        // Update to DB
        String sqlUpdate = "Update storage_work_station set computer = ?, monitor = ?, printer = ?, mfp = ?, ups = ? where Id = ?";
        this.getJdbcTemplate().update(sqlUpdate, computerInfo.getComputer(), computerInfo.getMonitor(), computerInfo.getPrinter(), computerInfo.getMfp(), computerInfo.getUps(), computerInfo.getId());
    }

    public void addStation(Integer computer, Integer monitor, Integer printer, Boolean mfp, Integer ups, Long idacc) throws SetException {
        // Add to DB new work station
        String sqlAdd = "Insert into storage_work_station (computer, monitor, printer, mfp, ups, idacc) values (" + computer + ", " + monitor + ", " + printer + ", " + mfp + ", " + ups + ", " + idacc + ")";
        this.getJdbcTemplate().execute(sqlAdd);
    }

}