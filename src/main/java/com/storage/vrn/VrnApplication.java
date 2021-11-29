package com.storage.vrn;

import com.storage.vrn.dao.StorageAccountDAO;
import com.storage.vrn.mapper.StorageAccountMapper;
import com.storage.vrn.model.StorageAccountinfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VrnApplication {

	public static void main(String[] args) {
		SpringApplication.run(VrnApplication.class, args);
	}


}
