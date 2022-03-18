package com.storage.vrn.dao;

import com.storage.vrn.exception.SetException;
import com.storage.vrn.mapper.StorageAccountMapper;
import com.storage.vrn.mapper.StorageMapper;
import com.storage.vrn.model.StorageAccountinfo;
import com.storage.vrn.model.StorageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class StorageDAO extends JdbcDaoSupport {

    @Autowired
    public StorageDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<StorageInfo> getStorage() {
        String sql = StorageMapper.BASE_SQL;

        Object[] params = new Object[] {};
        StorageMapper mapper = new StorageMapper();
        List<StorageInfo> list = this.getJdbcTemplate().query(sql, params, mapper);

        return list;
    }

}