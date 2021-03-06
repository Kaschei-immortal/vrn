package com.storage.vrn.dao;

import java.util.List;

import javax.sql.DataSource;

import com.storage.vrn.exception.SetException;
import com.storage.vrn.mapper.StorageAccountMapper;
import com.storage.vrn.model.StorageAccountinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class StorageAccountDAO extends JdbcDaoSupport {

    @Autowired
    public StorageAccountDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<StorageAccountinfo> getStorageAccounts() {
        String sql = StorageAccountMapper.BASE_SQL;

        Object[] params = new Object[] {};
        StorageAccountMapper mapper = new StorageAccountMapper();
        List<StorageAccountinfo> list = this.getJdbcTemplate().query(sql, params, mapper);

        return list;
    }

    public StorageAccountinfo findStorageAccount(Long id) {
        String sql = StorageAccountMapper.BASE_SQL + " where Id = ? ";

        Object[] params = new Object[] { id };
        StorageAccountMapper mapper = new StorageAccountMapper();
        try {
            StorageAccountinfo storageAccount = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return storageAccount;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void editName(Long id, String name) throws SetException {
        StorageAccountinfo accountInfo = this.findStorageAccount(id);
        if (accountInfo == null) {
            throw new SetException("Account not found " + id);
        }
        accountInfo.setName(name);

        // Update to DB
        String sqlUpdate = "Update storage_account set name = ? where Id = ?";
        this.getJdbcTemplate().update(sqlUpdate, accountInfo.getName(), accountInfo.getId());
    }

    public void editKab(Long id, Integer kab) throws SetException {
        StorageAccountinfo accountInfo = this.findStorageAccount(id);
        if (accountInfo == null) {
            throw new SetException("Account not found " + id);
        }
        accountInfo.setKab(kab);

        // Update to DB
        String sqlUpdate = "Update storage_account set kab = ? where Id = ?";
        this.getJdbcTemplate().update(sqlUpdate, accountInfo.getKab(), accountInfo.getId());
    }

    public void editPass(Long id, String login, String pass) throws SetException {
        StorageAccountinfo accountInfo = this.findStorageAccount(id);
        if (accountInfo == null) {
            throw new SetException("Account not found " + id);
        }
        accountInfo.setLogin(login);
        accountInfo.setPass(pass);

        // Update to DB
        String sqlUpdate = "Update storage_account set login = ?, password = ? where Id = ?";
        this.getJdbcTemplate().update(sqlUpdate, accountInfo.getLogin(), accountInfo.getPass(), accountInfo.getId());
    }

    public void addAccount(String name, Integer kab, String login, String pass) throws SetException {
        // Add to DB new account
        String sqlAdd = "Insert into storage_account (name, kab, login, password) values ('" + name + "', " + kab + ", '" + login + "', '" + pass + "')";
        this.getJdbcTemplate().execute(sqlAdd);
    }
    public void deleteKab(Long id) throws SetException {
        // Delete from DB account
        String sqlAdd = "DELETE from storage_account where Id = " + id;
        this.getJdbcTemplate().execute(sqlAdd);
    }

}