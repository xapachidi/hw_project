package kz.stqa.pft.addressbook.appmanager;

import kz.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by xeniya on 6/2/16.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirst_name());
        type(By.name("middlename"), contactData.getSecond_name());
        type(By.name("lastname"), contactData.getLast_name());
        type(By.name("company"), contactData.getCompany());
        type(By.name("home"), contactData.getPhone());
    }


    public void buttonOkClick() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void returnToContactPage() {
        click(By.cssSelector("div.msgbox"));
        click(By.linkText("home page"));
    }
}