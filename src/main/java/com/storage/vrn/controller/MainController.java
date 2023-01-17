package com.storage.vrn.controller;

import java.util.List;
import com.storage.vrn.dao.StorageAccountDAO;
import com.storage.vrn.dao.StorageComputerDAO;
import com.storage.vrn.exception.SetException;
import com.storage.vrn.model.StorageComputerinfo;
import com.storage.vrn.setAcc.SetAccountForm;
import com.storage.vrn.model.StorageAccountinfo;
import com.storage.vrn.setStation.SetStationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MainController {

    @Autowired
    private StorageAccountDAO storageAccountDAO;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public List<StorageAccountinfo> showStorageAccounts() {
        List<StorageAccountinfo> list = storageAccountDAO.getStorageAccounts();
        return list;
    }

    @RequestMapping(value = "/setAccount", method = RequestMethod.PUT)
    public void processSetAccount(@RequestBody SetAccountForm setAccountForm) {

        System.out.println("Set Name::" + setAccountForm.getName());

        try {
            storageAccountDAO.editAccount(setAccountForm.getId(),setAccountForm.getName(), setAccountForm.getSurname(), setAccountForm.getPatronymic(), setAccountForm.getKab(), setAccountForm.getLogin(), setAccountForm.getPass());
        } catch (SetException e) {
            throw new RuntimeException("что-то пошло не так");
        }
    }

    @RequestMapping(value = "/addAccount", method = RequestMethod.PUT)
    public void processAddAccount(@RequestBody SetAccountForm setAccountForm) {

        System.out.println("Set New Name::" + setAccountForm.getName());
        System.out.println("Set New Login::" + setAccountForm.getLogin());
        try {
            storageAccountDAO.addAccount(setAccountForm.getName(), setAccountForm.getSurname(), setAccountForm.getPatronymic(), setAccountForm.getKab(), setAccountForm.getLogin(), setAccountForm.getPass());
        } catch (SetException e) {
            throw new RuntimeException("что-то пошло не так");
        }

    }

    @RequestMapping(value = "/delAccount", method = RequestMethod.PUT)
    public void processDelAccount(@RequestBody SetAccountForm setAccountForm) {

        System.out.println("Delete Id::" + setAccountForm.getId());

        try {
            storageAccountDAO.deleteAccount(setAccountForm.getId());
        } catch (SetException e) {
            throw new RuntimeException("что-то пошло не так");
        }
    }

    @Autowired
    private StorageComputerDAO storageComputerDAO;

    @RequestMapping(value = "/station", method = RequestMethod.GET)
    public List<StorageComputerinfo> showStorageStation() {
        List<StorageComputerinfo> list = storageComputerDAO.getStorageComputer();
        return list;
    }

    @RequestMapping(value = "/setStation", method = RequestMethod.PUT)
    public void processSetInventory(@RequestBody SetStationForm setStationForm) {

        System.out.println("Set Comp::" + setStationForm.getComputer());
        System.out.println("Set Mon::" + setStationForm.getMonitor());
        System.out.println("Set Print::" + setStationForm.getPrinter());
        System.out.println("Set UPS::" + setStationForm.getUps());

        try {
            storageComputerDAO.setStation(setStationForm.getId(), setStationForm.getComputer(), setStationForm.getMonitor(), setStationForm.getPrinter(), setStationForm.getUps());
        } catch (SetException e) {
            throw new RuntimeException("что-то пошло не так");
        }
    }

    @RequestMapping(value = "/addStation", method = RequestMethod.PUT)
    public void processAddStation(@RequestBody SetStationForm addStationForm) {

        System.out.println("Set New Computer::" + addStationForm.getComputer());
        try {
            storageComputerDAO.addStation(addStationForm.getComputer(), addStationForm.getMonitor(), addStationForm.getPrinter(), addStationForm.getUps());
        } catch (SetException e) {
            throw new RuntimeException("что-то пошло не так");
        }

    }

    @RequestMapping(value = "/delStation", method = RequestMethod.PUT)
    public void processSDelStation(@RequestBody SetStationForm setStationForm) {

        System.out.println("Delete Station::" + setStationForm.getId());

        try {
            storageComputerDAO.deleteStation(setStationForm.getId());
        } catch (SetException e) {
            throw new RuntimeException("что-то пошло не так");
        }
    }

}