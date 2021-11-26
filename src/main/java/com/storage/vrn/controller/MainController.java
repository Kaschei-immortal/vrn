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

//    @RequestMapping(value = "/sendMoney", method = RequestMethod.GET)
//    public String viewSendMoneyPage(Model model) {
//
//        SendMoneyForm form = new SendMoneyForm(1L, 2L, 700d);
//
//        model.addAttribute("sendMoneyForm", form);
//
//        return "sendMoneyPage";
//    }
//
//   @RequestMapping(value = "/sendMoney", method = RequestMethod.POST)
//   public String processSendMoney(Model model, SendMoneyForm sendMoneyForm) {
//
//       System.out.println("Send Money::" + sendMoneyForm.getAmount());
//
//       try {
//           bankAccountDAO.sendMoney(sendMoneyForm.getFromAccountId(), //
//                   sendMoneyForm.getToAccountId(), //
//                   sendMoneyForm.getAmount());
//       } catch (BankTransactionException e) {
//           model.addAttribute("errorMessage", "Error: " + e.getMessage());
//           return "/sendMoneyPage";
//       }
//       return "redirect:/";
//   }

}