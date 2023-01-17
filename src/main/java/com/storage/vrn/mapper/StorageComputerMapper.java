package com.storage.vrn.mapper;

import com.storage.vrn.model.StorageComputerinfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StorageComputerMapper implements RowMapper<StorageComputerinfo> {
    public static final String BASE_SQL = "Select ID, COMPUTER, MONITOR, PRINTER, UPS From STORAGE_WORK_STATION storage";

    @Override
    public StorageComputerinfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("Id");
        String computer = rs.getString("computer");
        String monitor = rs.getString("monitor");
        String printer = rs.getString("printer");
        String ups = rs.getString("ups");

        return new StorageComputerinfo(id, computer, monitor, printer, ups);
    }

}
