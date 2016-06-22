package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.model.ContactData;
import kz.stqa.pft.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by xeniya on 6/22/16.
 */
public class DetailContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (! app.contact().isThereContact()) {
            if (!app.group().isThereAGroup()) {
                app.goTo().gotoGroupPage();
                app.group().createGroup(new GroupData().withName("test1"));
                app.goTo().gotoContactPage();
            }
            app.contact().createContact(new ContactData().withFirst_name("Петр").withSecond_name("Петрович").withLast_name("Кузьмин").withCompany("ложки.ком").withPhone("+89654123654"));
        }
    }

    @Test
    public void testDetailContact(){
        ContactData contact = app.contact().all().iterator().next();
        app.contact().initContactDetail(contact.getId());
        String info = app.contact().info().toString();
    }

    public static String cleaned(String email){
        return email.replaceAll("\\s", "");
    }
}
