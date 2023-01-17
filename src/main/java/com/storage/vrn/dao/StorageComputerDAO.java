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

    public void setStation(Long id, String computer, String monitor, String printer, String ups) throws SetException {
        StorageComputerinfo computerInfo = this.findStorageComputer(id);
        if (computerInfo == null) {
            throw new SetException("Work station not found " + id);
        }
        computerInfo.setComputer(computer);
        computerInfo.setMonitor(monitor);
        computerInfo.setPrinter(printer);
        computerInfo.setUps(ups);

        // Update to DB
        String sqlUpdate = "Update storage_work_station set computer = ?, monitor = ?, printer = ?, ups = ? where Id = ?";
        this.getJdbcTemplate().update(sqlUpdate, computerInfo.getComputer(), computerInfo.getMonitor(), computerInfo.getPrinter(), computerInfo.getUps(), computerInfo.getId());
    }

    public void addStation(String computer, String monitor, String printer, String ups) throws SetException {
        // Add to DB new work station
        String sqlAdd = "Insert into storage_work_station (computer, monitor, printer, ups) values ('" + computer + "', '" + monitor + "', '" + printer + "', '" + ups + "')";
        this.getJdbcTemplate().execute(sqlAdd);
    }

    public void deleteStation(Long id) throws SetException {
        // Delete from DB station
        String sqlAdd = "DELETE from storage_work_station where Id = " + id;
        this.getJdbcTemplate().execute(sqlAdd);
    }

}