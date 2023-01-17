package com.storage.vrn.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.storage.vrn.model.StorageAccountinfo;
import org.springframework.jdbc.core.RowMapper;

public class StorageAccountMapper implements RowMapper<StorageAccountinfo> {
    public static final String BASE_SQL = "Select ID, NAME, SURNAME, PATRONYMIC, KAB, LOGIN, PASSWORD From STORAGE_ACCOUNT storage";

    @Override
    public StorageAccountinfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("Id");
        String name = rs.getString("Name");
        String surname = rs.getString("Surname");
        String patronymic = rs.getString("Patronymic");
        String kab = rs.getString("Kab");
        String login = rs.getString("Login");
        String pass = rs.getString("Password");

        return new StorageAccountinfo(id, name, surname, patronymic, kab, login, pass);
    }

}
