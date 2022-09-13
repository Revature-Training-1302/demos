package com.revature.controller;

import com.revature.Validator.AccountValidator;
import com.revature.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// Don't use the RestController. We want to use the regular Controller in order to return the views:
@Controller
public class AccountController {

    @GetMapping("/account")
    public ModelAndView accountForm() {
        // the ModelAndView object allows us to return not just the view, but the model (Account object)
        //                      name of the JSP page    the name of the model  the object that we want to hold the data of the model
        return new ModelAndView("accountHome", "account", new Account());
    }

    @PostMapping("/addAccount")
    public String submit(@ModelAttribute("account") Account account, ModelMap modelMap, BindingResult bindingResult) {
        // Validate:
        DataBinder dataBinder = new DataBinder(account);
        dataBinder.setValidator(new AccountValidator());
        dataBinder.validate();
        // get the results of the errors:
        BindingResult result = dataBinder.getBindingResult();

        // if we have errors, redirect to error page:
        if(result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            String errorMessage = "";
            // construct an error message:
            for (ObjectError error : errors) {
                if (error.getDefaultMessage() != null) {
                    errorMessage += error.getDefaultMessage();
                }
                else {
                    errorMessage += error.getCode();
                }
                errorMessage += ", ";
            }
            // add message to model map, to be printed out on jsp page:
            modelMap.addAttribute("errorMessage", errorMessage);
            return "error";
        }

        // Instead of printing out the account, we can set up a view to show off the successful profile page
        modelMap.addAttribute("id", account.getId());
        modelMap.addAttribute("name", account.getName());
        modelMap.addAttribute("password", account.getPassword());
        return "accountView";

    }

}
