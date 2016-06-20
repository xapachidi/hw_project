package kz.stqa.pft.addressbook.tests;


import kz.stqa.pft.addressbook.model.ContactData;
import kz.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by xeniya on 6/2/16.
 */
public class ContactModificationTests extends TestBase {

    @Test (enabled = false)
    public void testContactModification(){

        if (! app.getContactHelper().isThereContact()) {
            if (!app.group().isThereAGroup()) {
                app.goTo().gotoGroupPage();
                app.group().createGroup(new GroupData("test1", null, null));
                app.goTo().gotoContactPage();
            }
            app.getContactHelper().createContact(new ContactData("Петр", "Петрович", "Кузьмин", "ложки.ком", "+89654123654", "test1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().initContactModification(before.size()-1);

        ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Антон", "Петрович", "Кузьмин", "ложки.ком", "+89654123654", "test1");
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().buttonUpdateClick();
        app.getContactHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size());



        before.remove(before.size()-1);
        before.add(contact);

        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
