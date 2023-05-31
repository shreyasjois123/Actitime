package com.acttime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	@FindBy(id="username")
	private WebElement untbx;
	
	@FindBy(name="pwd")
	private WebElement pwtbx;
	
	@FindBy(xpath = "//div[text()='Login ']")
	private WebElement lgbtn;

	public WebElement getUntbx() {
		return untbx;
	}
public loginpage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void setlogin(String un, String pw) {
	untbx.sendKeys(un);
	pwtbx.sendKeys(pw);
	lgbtn.click();
}}
	