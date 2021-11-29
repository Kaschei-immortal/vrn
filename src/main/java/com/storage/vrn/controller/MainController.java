package com.storage.vrn.controller;


import java.util.List;

import com.storage.vrn.dao.StorageAccountDAO;
import com.storage.vrn.exception.SetException;
import com.storage.vrn.setKab.SetKabForm;
import com.storage.vrn.model.StorageAccountinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    private StorageAccountDAO storageAccountDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showStorageAccounts(Model model) {
        List<StorageAccountinfo> list = storageAccountDAO.getStorageAccounts();

        model.addAttribute("accountInfos", list);

        return "accountsPage";
    }

    @RequestMapping(value = "/setKab", method = RequestMethod.GET)
    public String viewKabPage(Model model) {
        StorageAccountinfo s = storageAccountDAO.findStorageAccount(1l);

        SetKabForm form = new SetKabForm(s.getId(), s.getKab());

        model.addAttribute("setKabForm", form);

        return "setKabPage";
    }

    @RequestMapping(value = "/setKab", method = RequestMethod.POST)
    public String processSetKab(Model model, SetKabForm setKabForm) {
        try {
            StorageAccountinfo s = storageAccountDAO.findStorageAccount(1l);
            setKabForm.setAccountId(s.getId());
            setKabForm.setKab(s.getKab());
        } catch (NullPointerException e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "/setKabPage";
        }

        System.out.println("Set Kab::" + setKabForm.getKab());

        try {
            storageAccountDAO.addKab(setKabForm.getAccountId(),setKabForm.getKab());
        } catch (SetException e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "/setKabPage";
        }
        return "redirect:/";
    }

}