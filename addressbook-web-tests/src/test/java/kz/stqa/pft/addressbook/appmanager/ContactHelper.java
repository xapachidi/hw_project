package kz.stqa.pft.addressbook.appmanager;

import kz.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by xeniya on 6/2/16.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirst_name());
        type(By.name("middlename"), contactData.getSecond_name());
        type(By.name("lastname"), contactData.getLast_name());
        type(By.name("company"), contactData.getCompany());
        type(By.name("home"), contactData.getPhone());

        if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }


    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactModification() {
        //click(By.name("Edit"));
       click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void buttonOkClick() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
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


    public boolean isThereContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void returnToContactPage() {
        click(By.cssSelector("div.msgbox"));
        click(By.linkText("home page"));
    }

    public void createContact(ContactData contact) {
        fillContactForm(contact, true);
        buttonOkClick();
        returnToContactPage();
    }
}