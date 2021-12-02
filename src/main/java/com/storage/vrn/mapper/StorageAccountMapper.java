package com.storage.vrn.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.storage.vrn.model.StorageAccountinfo;
import org.springframework.jdbc.core.RowMapper;

public class StorageAccountMapper implements RowMapper<StorageAccountinfo> {
    public static final String BASE_SQL = "Select ID, NAME, KAB, LOGIN, PASSWORD From STORAGE_ACCOUNT storage";

    @Override
    public StorageAccountinfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("Id");
        String name = rs.getString("Name");
        Integer kab = rs.getInt("Kab");
        String login = rs.getString("Login");
        String pass = rs.getString("Password");

        return new StorageAccountinfo(id, name, kab, login, pass);
    }

}
