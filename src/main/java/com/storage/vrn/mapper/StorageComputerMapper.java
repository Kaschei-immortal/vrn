package com.storage.vrn.mapper;

import com.storage.vrn.model.StorageComputerinfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StorageComputerMapper implements RowMapper<StorageComputerinfo> {
    public static final String BASE_SQL = "Select ID, COMPUTER, MONITOR, PRINTER, MFP, UPS, IDACC From STORAGE_WORK_STATION storage";

    @Override
    public StorageComputerinfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("Id");
        Integer computer = rs.getInt("computer");
        Integer monitor = rs.getInt("monitor");
        Integer printer = rs.getInt("printer");
        Boolean mfp = rs.getBoolean("mfp");
        Integer ups = rs.getInt("ups");
        Long idacc = rs.getLong("idacc");

        return new StorageComputerinfo(id, computer, monitor, printer, mfp, ups, idacc);
    }

}
