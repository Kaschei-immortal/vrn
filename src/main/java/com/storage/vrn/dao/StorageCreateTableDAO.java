package com.storage.vrn.dao;

import com.storage.vrn.exception.SetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class StorageCreateTableDAO extends JdbcDaoSupport {

    @Autowired
    public StorageCreateTableDAO(DataSource dataSource) throws SetException {
        this.setDataSource(dataSource);
        addAccountTable();
        addStationTable();
    }

    public void addAccountTable() throws SetException {
        // Create Accounts Table
        String sqlAdd = "CREATE TABLE IF NOT EXISTS public.storage_account\n" +
                "(\n" +
                "    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),\n" +
                "    name character varying COLLATE pg_catalog.\"default\",\n" +
                "    kab integer,\n" +
                "    login character varying COLLATE pg_catalog.\"default\",\n" +
                "    password character varying COLLATE pg_catalog.\"default\",\n" +
                "    CONSTRAINT storage_account_pkey PRIMARY KEY (id)\n" +
                ")";
        this.getJdbcTemplate().execute(sqlAdd);
    }

    public void addStationTable() throws SetException {
        // Create Work station Table
        String sqlAdd = "CREATE TABLE IF NOT EXISTS public.storage_work_station\n" +
                "(\n" +
                "    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),\n" +
                "    computer integer,\n" +
                "    monitor integer,\n" +
                "    printer integer,\n" +
                "    mfp boolean,\n" +
                "    ups integer,\n" +
                "    idacc bigint,\n" +
                "    CONSTRAINT storage_work_station_pkey PRIMARY KEY (id),\n" +
                "    CONSTRAINT idacc FOREIGN KEY (idacc)\n" +
                "        REFERENCES public.storage_account (id) MATCH SIMPLE\n" +
                "        ON UPDATE NO ACTION\n" +
                "        ON DELETE NO ACTION\n" +
                "        NOT VALID\n" +
                ")";
        this.getJdbcTemplate().execute(sqlAdd);
    }

}