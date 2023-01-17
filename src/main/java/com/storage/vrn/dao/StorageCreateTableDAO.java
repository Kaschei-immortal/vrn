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
                "    surname character varying COLLATE pg_catalog.\"default\",\n" +
                "    patronymic character varying COLLATE pg_catalog.\"default\",\n" +
                "    kab character varying COLLATE pg_catalog.\"default\",\n" +
                "    login character varying COLLATE pg_catalog.\"default\",\n" +
                "    password character varying COLLATE pg_catalog.\"default\" \n" +
                ")";
        this.getJdbcTemplate().execute(sqlAdd);
    }

    public void addStationTable() throws SetException {
        // Create Work station Table
        String sqlAdd = "CREATE TABLE IF NOT EXISTS public.storage_work_station\n" +
                "(\n" +
                "    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),\n" +
                "    computer character varying COLLATE pg_catalog.\"default\",\n" +
                "    monitor character varying COLLATE pg_catalog.\"default\",\n" +
                "    printer character varying COLLATE pg_catalog.\"default\",\n" +
                "    ups character varying COLLATE pg_catalog.\"default\" \n" +
                ")";
        this.getJdbcTemplate().execute(sqlAdd);
    }

}