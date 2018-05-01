package aleph.ops.account.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import aleph.ops.account.entity.Account;
import aleph.ops.account.service.AccountService;

@Controller
@RequestMapping("/aleph")
public class AccountController {
	
	@Autowired
    AccountService accountService;
 
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ModelAndView listAccounts() {
        ModelAndView modelAndView = new ModelAndView("accounts"); // i.e
                                                                    // accounts.jsp
        List<Account> accounts = accountService.getAccounts();
        System.out.println(accounts);
        modelAndView.addObject("accounts", accounts);
        return modelAndView;
    }
 
    @RequestMapping(value = "/displayForm", method = RequestMethod.GET)
    public ModelAndView displayNewAccountForm(ModelMap model) {
        return new ModelAndView("newAccount", "new-account-form", new Account());
    }
 
    @RequestMapping(value = "/newAccount", method = RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute("new-account-form") Account account, ModelMap model) {
        accountService.saveAccount(account);
        List<Account> accounts = accountService.getAccounts();
 
        ModelAndView modelAndView = new ModelAndView("accounts");
        modelAndView.addObject("accounts", accounts);
        return modelAndView;
    }
 
    @RequestMapping(value = "/accountDetails/{accountId}", method = RequestMethod.GET)
    public ModelAndView accountDetail(@PathVariable("accountId") Long id) {
        Account account = accountService.getAccount(id);
        ModelAndView modelAndView = new ModelAndView("accountDetails"); //i.e accountDetail.jsp
                                                                    
        modelAndView.addObject("account", account);
       return modelAndView;
    }

}
