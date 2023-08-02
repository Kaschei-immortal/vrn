package com.storage.vrn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.storage.vrn.model.StorageAccountEntity;
import com.storage.vrn.repository.StorageRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/")
public class StorageController {

    @Autowired
    StorageRepository storageRepository;

    @GetMapping("/")
    public ResponseEntity<List<StorageAccountEntity>> getAllStorageAccountEntity(@RequestParam(required = false) String name) {
        try {
            List<StorageAccountEntity> accounts = new ArrayList<StorageAccountEntity>();

            if (name == null)
                storageRepository.findAll().forEach(accounts::add);
            else
                storageRepository.findByName(name).forEach(accounts::add);

            if (accounts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(accounts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<StorageAccountEntity> getAccountById(@PathVariable("id") long id) {
        Optional<StorageAccountEntity> accountData = storageRepository.findById(id);

        if (accountData.isPresent()) {
            return new ResponseEntity<>(accountData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/accounts/add")
    public ResponseEntity<StorageAccountEntity> createAccount(@RequestBody StorageAccountEntity storageAccountEntity) {
        try {
            StorageAccountEntity _storageAccountEntity = storageRepository
                    .save(new StorageAccountEntity(storageAccountEntity.getName(), storageAccountEntity.getSurname(),
                            storageAccountEntity.getPatronymic(), storageAccountEntity.getKab(), storageAccountEntity.getLogin(), storageAccountEntity.getPassword()));
            return new ResponseEntity<>(_storageAccountEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<StorageAccountEntity> updateAccount(@PathVariable("id") long id, @RequestBody StorageAccountEntity storageAccountEntity) {
        Optional<StorageAccountEntity> accountData = storageRepository.findById(id);

        if (accountData.isPresent()) {
            StorageAccountEntity _storageAccountEntity = accountData.get();
            _storageAccountEntity.setName(storageAccountEntity.getName());
            _storageAccountEntity.setSurname(storageAccountEntity.getSurname());
            _storageAccountEntity.setPatronymic(storageAccountEntity.getPatronymic());
            _storageAccountEntity.setKab(storageAccountEntity.getKab());
            _storageAccountEntity.setLogin(storageAccountEntity.getLogin());
            _storageAccountEntity.setPassword(storageAccountEntity.getPassword());
            return new ResponseEntity<>(storageRepository.save(_storageAccountEntity), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") long id) {
        try {
            storageRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/accounts")
    public ResponseEntity<HttpStatus> deleteAllAccounts() {
        try {
            storageRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/accounts/kab")
    public ResponseEntity<List<StorageAccountEntity>> findAccountByKab(String kab) {
        try {
            List<StorageAccountEntity> accounts = storageRepository.findByKab(kab);

            if (accounts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(accounts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
