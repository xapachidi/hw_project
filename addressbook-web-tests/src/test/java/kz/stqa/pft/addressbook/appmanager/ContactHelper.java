package kz.stqa.pft.addressbook.appmanager;

import kz.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by xeniya on 6/2/16.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirst_name());
        type(By.name("middlename"), contactData.getSecond_name());
        type(By.name("lastname"), contactData.getLast_name());
        type(By.name("company"), contactData.getCompany());
        type(By.name("home"), contactData.getPhone());
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[4]/td[8]/a/img"));
    }

    public void buttonOkClick() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void returnToContactPage() {
        click(By.cssSelector("div.msgbox"));
        click(By.linkText("home page"));
    }

    public void buttonUpdateClick() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void initContactDeletion() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void initOkDeletion() {
        wd.switchTo().alert().accept();
    }

    public void returnToMainPage() {
        click(By.linkText("home"));
    }
}