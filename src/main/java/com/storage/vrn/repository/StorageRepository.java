package com.storage.vrn.repository;

import com.storage.vrn.model.StorageAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StorageRepository extends JpaRepository<StorageAccountEntity, Long> {
    List<StorageAccountEntity> findByKab(String kab);
    List<StorageAccountEntity> findByName(String name);
}
