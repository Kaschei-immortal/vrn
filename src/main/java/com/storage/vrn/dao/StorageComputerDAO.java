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


    public void addId(Long id, Integer idacc) throws SetException {
        StorageComputerinfo computerInfo = this.findStorageComputer(id);
        if (computerInfo == null) {
            throw new SetException("Work station not found " + id);
        }
        computerInfo.setIdacc(idacc);

        // Update to DB
        String sqlUpdate = "Update storage_work_station set idacc = ? where Id = ?";
        this.getJdbcTemplate().update(sqlUpdate, computerInfo.getIdacc(), computerInfo.getId());
    }

    public void addInfo(Long id, Integer computer, Integer monitor, Integer printer, Boolean mfp, Integer ups) throws SetException {
        StorageComputerinfo computerInfo = this.findStorageComputer(id);
        if (computerInfo == null) {
            throw new SetException("Work station not found " + id);
        }
        computerInfo.setComputer(computer);
        computerInfo.setMonitor(monitor);
        if (printer != null) computerInfo.setPrinter(printer); else computerInfo.setPrinter(0);
        computerInfo.setMfp(mfp);
        if (ups != null) computerInfo.setUps(ups); else computerInfo.setUps(0);

        // Update to DB
        String sqlUpdate = "Update storage_work_station set computer = ? where Id = ?";
        this.getJdbcTemplate().update(sqlUpdate, computerInfo.getComputer(), computerInfo.getId());
        String sqlUpdate1 = "Update storage_work_station set monitor = ? where Id = ?";
        this.getJdbcTemplate().update(sqlUpdate1, computerInfo.getMonitor(), computerInfo.getId());
        String sqlUpdate2 = "Update storage_work_station set printer = ? where Id = ?";
        this.getJdbcTemplate().update(sqlUpdate2, computerInfo.getPrinter(), computerInfo.getId());
        String sqlUpdate3 = "Update storage_work_station set mfp = ? where Id = ?";
        this.getJdbcTemplate().update(sqlUpdate3, computerInfo.getMfp(), computerInfo.getId());
        String sqlUpdate4 = "Update storage_work_station set ups = ? where Id = ?";
        this.getJdbcTemplate().update(sqlUpdate4, computerInfo.getUps(), computerInfo.getId());
    }

}