package com.storage.vrn.controller;

import java.util.List;

import com.storage.vrn.dao.StorageAccountDAO;
import com.storage.vrn.dao.StorageComputerDAO;
import com.storage.vrn.dao.StorageCreateTableDAO;
import com.storage.vrn.exception.SetException;
import com.storage.vrn.getId.GetIdForm;
import com.storage.vrn.model.StorageComputerinfo;
import com.storage.vrn.setInventoryNumber.SetInventoryForm;
import com.storage.vrn.setKab.AddKabForm;
import com.storage.vrn.setKab.SetKabForm;
import com.storage.vrn.setPass.SetPassForm;
import com.storage.vrn.model.StorageAccountinfo;
import com.storage.vrn.setStation.AddStationForm;
import com.storage.vrn.setStation.SetStationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MainController {

    Long id = 1L;

    @Autowired
    private StorageAccountDAO storageAccountDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<StorageAccountinfo> showStorageAccounts() {
        List<StorageAccountinfo> list = storageAccountDAO.getStorageAccounts();
        return list;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void processGetId(@RequestBody GetIdForm getIdForm) {

        System.out.println("Get Id::" + getIdForm.getAccountId());

        this.id = getIdForm.getAccountId();
    }

    @RequestMapping(value = "/setKab", method = RequestMethod.GET)
    public SetKabForm viewKabPage() {
        StorageAccountinfo s = storageAccountDAO.findStorageAccount(this.id);
        SetKabForm form = new SetKabForm(s.getId(), s.getKab());
        return form;
    }

    @RequestMapping(value = "/setKab", method = RequestMethod.PUT)
    public void processSetKab(@RequestBody SetKabForm setKabForm) {

        System.out.println("Set Kab::" + setKabForm.getKab());

        try {
            storageAccountDAO.editKab(setKabForm.getAccountId(),setKabForm.getKab());
        } catch (SetException e) {
            throw new RuntimeException("что-то пошло не так");
        }
    }

    @RequestMapping(value = "/setPass", method = RequestMethod.GET)
    public SetPassForm viewPassPage() {
        StorageAccountinfo s = storageAccountDAO.findStorageAccount(this.id);

        return new SetPassForm(s.getId(), s.getLogin(), s.getPass());
    }

    @RequestMapping(value = "/setPass", method = RequestMethod.PUT)
    public void processSetPass(@RequestBody SetPassForm setPassForm) {

        System.out.println("Set Login::" + setPassForm.getLogin());
        System.out.println("Set Pass::" + setPassForm.getPass());

        try {
            storageAccountDAO.editPass(setPassForm.getAccountId(),setPassForm.getLogin(),setPassForm.getPass());
        } catch (SetException e) {
            throw new RuntimeException("что-то пошло не так");
        }
    }

    @RequestMapping(value = "/addKab", method = RequestMethod.PUT)
    public void processAddKab(@RequestBody AddKabForm addKabForm) {

        System.out.println("Set New Name::" + addKabForm.getName());
        System.out.println("Set New Login::" + addKabForm.getLogin());
        try {
            storageAccountDAO.addAccount(addKabForm.getName(), addKabForm.getKab(), addKabForm.getLogin(), addKabForm.getPass());
        } catch (SetException e) {
            throw new RuntimeException("что-то пошло не так");
        }

    }

    @Autowired
    private StorageComputerDAO storageComputerDAO;

    @RequestMapping(value = "/Station", method = RequestMethod.GET)
    public List<StorageComputerinfo> showStorageStation() {
        List<StorageComputerinfo> list = storageComputerDAO.getStorageComputer();
        return list;
    }

    @RequestMapping(value = "/setStation", method = RequestMethod.GET)
    public SetStationForm viewStationPage() {
        StorageComputerinfo s = storageComputerDAO.findStorageComputer(this.id);
        SetStationForm form = new SetStationForm(s.getId(), s.getIdacc());
        return form;
    }

    @RequestMapping(value = "/setStation", method = RequestMethod.PUT)
    public void processSetStation(@RequestBody SetStationForm setStationForm) {

        System.out.println("Set Station on::" + setStationForm.getIdAccount());

        try {
            storageComputerDAO.editId(setStationForm.getStationId(),setStationForm.getIdAccount());
        } catch (SetException e) {
            throw new RuntimeException("что-то пошло не так");
        }
    }

    @RequestMapping(value = "/setInventoryNumber", method = RequestMethod.GET)
    public SetInventoryForm viewInventoryPage() {
        StorageComputerinfo s = storageComputerDAO.findStorageComputer(this.id);
        return new SetInventoryForm(s.getId(), s.getComputer(), s.getMonitor(), s.getPrinter(), s.getMfp(), s.getUps());
    }

    @RequestMapping(value = "/setInventoryNumber", method = RequestMethod.PUT)
    public void processSetInventory(@RequestBody SetInventoryForm setInventoryForm) {

        System.out.println("Set Comp::" + setInventoryForm.getComputer());
        System.out.println("Set Mon::" + setInventoryForm.getMonitor());
        System.out.println("Set Print::" + setInventoryForm.getPrinter());
        System.out.println("Set MFP::" + setInventoryForm.getMfp());
        System.out.println("Set UPS::" + setInventoryForm.getUps());

        try {
            storageComputerDAO.editInfo(setInventoryForm.getStationId(), setInventoryForm.getComputer(), setInventoryForm.getMonitor(), setInventoryForm.getPrinter(), setInventoryForm.getMfp(), setInventoryForm.getUps());
        } catch (SetException e) {
            throw new RuntimeException("что-то пошло не так");
        }
    }

    @RequestMapping(value = "/addStation", method = RequestMethod.PUT)
    public void processAddStation(@RequestBody AddStationForm addStationForm) {

        System.out.println("Set New Computer::" + addStationForm.getComputer());
        System.out.println("Set New Account::" + addStationForm.getIdAccount());
        try {
            storageComputerDAO.addStation(addStationForm.getComputer(), addStationForm.getMonitor(), addStationForm.getPrinter(), addStationForm.getMfp(), addStationForm.getUps(), addStationForm.getIdAccount());
        } catch (SetException e) {
            throw new RuntimeException("что-то пошло не так");
        }

    }

}