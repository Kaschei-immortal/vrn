package com.storage.vrn.controller;

import java.util.List;

import com.storage.vrn.dao.StorageAccountDAO;
import com.storage.vrn.exception.SetException;
import com.storage.vrn.setKab.SetKabForm;
import com.storage.vrn.setPass.SetPassForm;
import com.storage.vrn.model.StorageAccountinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MainController {

    @Autowired
    private StorageAccountDAO storageAccountDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<StorageAccountinfo> showStorageAccounts() {
        List<StorageAccountinfo> list = storageAccountDAO.getStorageAccounts();
        return list;
    }

    @RequestMapping(value = "/setKab", method = RequestMethod.GET)
    public SetKabForm viewKabPage() {
        StorageAccountinfo s = storageAccountDAO.findStorageAccount(1l);
        SetKabForm form = new SetKabForm(s.getId(), s.getKab());
        return form;
    }

    @RequestMapping(value = "/setKab", method = RequestMethod.POST)
    public void processSetKab(SetKabForm setKabForm) {

        System.out.println("Set Kab::" + setKabForm.getKab());

        try {
            storageAccountDAO.addKab(setKabForm.getAccountId(),setKabForm.getKab());
        } catch (SetException e) {
            throw new RuntimeException("что-то пошло не так");
        }
    }

    @RequestMapping(value = "/setPass", method = RequestMethod.GET)
    public SetPassForm viewPassPage() {
        StorageAccountinfo s = storageAccountDAO.findStorageAccount(1l);

        return new SetPassForm(s.getId(), s.getLogin(), s.getPass());
    }

    @RequestMapping(value = "/setPass", method = RequestMethod.POST)
    public void processSetPass(SetPassForm setPassForm) {

        System.out.println("Set Login::" + setPassForm.getLogin());
        System.out.println("Set Pass::" + setPassForm.getPass());

        try {
            storageAccountDAO.addPass(setPassForm.getAccountId(),setPassForm.getLogin(),setPassForm.getPass());
        } catch (SetException e) {
            throw new RuntimeException("что-то пошло не так");
        }
    }
}