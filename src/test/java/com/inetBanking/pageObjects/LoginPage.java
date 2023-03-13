package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver ldriver; //local driver
public LoginPage(WebDriver rdriver){
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}
@FindBy(name="uid")
@CacheLookup
WebElement textUserName;

@FindBy(name="password")
@CacheLookup
WebElement textPassword;

@FindBy(name="btnLogin")
@CacheLookup
WebElement btnLogin;

@FindBy(xpath="//a[text()='Log out']")
@CacheLookup
WebElement lnkLogout;

public void setUserName(String username) {
	textUserName.sendKeys(username);
}
public void setPassword(String pwd) {
	textPassword.sendKeys(pwd);
	
}
public void clickSubmit() {
	btnLogin.click();
} 
public void clickLogout() {
	lnkLogout.click();
}
}
