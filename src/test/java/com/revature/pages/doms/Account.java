package com.revature.pages.doms;

import com.revature.pages.Page;
import com.revature.components.LoginComponent;

public class Account {
    private String username;
    private String password;
    private String type;
    private String first;
    private String last;
    public static Account[] validAccounts = {
        new Account("g8tor", "chomp!", "manager", "Patty", "Pastiche"),
        new Account("ryeGuy", "coolbeans", "tester", "Fakey", "McFakeface")
    };
    public static Account getAccountOfRole(String role) {
        for (Account account : validAccounts) {
            if (account.type.equals(role)) return account;
        }
        throw new Error("Account not found, was role correct?");
    }
    public Account(String username, String password, String type, String first, String last) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.first = first;
        this.last = last;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public void login(LoginComponent component, Page target) {
        String currentURL = component.getDriver().getCurrentUrl();
        component.getUserNameInput().sendKeys(username);
        component.getPasswordInput().sendKeys(password);
        component.getLoginButton().click();
        target.awaitURL();
    }
}
