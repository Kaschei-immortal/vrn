package com.storage.vrn.mapper;

import com.storage.vrn.model.StorageInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StorageMapper implements RowMapper<StorageInfo> {
    public static final String BASE_SQL = "select * from storage_account, storage_work_station where storage_account.id = storage_work_station.idacc";

    @Override
    public StorageInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        // ida = ids, error
        Long ida = rs.getLong("Id");
        String name = rs.getString("Name");
        Integer kab = rs.getInt("Kab");
        String login = rs.getString("Login");
        String pass = rs.getString("Password");
        Long ids = rs.getLong("Id");
        Integer computer = rs.getInt("computer");
        Integer monitor = rs.getInt("monitor");
        Integer printer = rs.getInt("printer");
        Boolean mfp = rs.getBoolean("mfp");
        Integer ups = rs.getInt("ups");
        Long idacc = rs.getLong("idacc");

        return new StorageInfo(ida, name, kab, login, pass, ids, computer, monitor, printer, mfp, ups, idacc);
    }

}
