package com.storage.vrn.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.storage.vrn.model.StorageAccountinfo;
import org.springframework.jdbc.core.RowMapper;

public class StorageAccountMapper implements RowMapper<StorageAccountinfo> {
    public static final String BASE_SQL //
            = "Select storage.Id, storage.Name, storage.Kab From STORAGE_ACCOUNT storage ";
    @Override
    public StorageAccountinfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("Id");
        String name = rs.getString("Name");
        Integer kab = rs.getInt("Kab");

        return new StorageAccountinfo(id, name, kab);
    }

}
