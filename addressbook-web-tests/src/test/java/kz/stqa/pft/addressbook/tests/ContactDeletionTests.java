package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.model.ContactData;
import kz.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by xeniya on 6/2/16.
 */
public class ContactDeletionTests extends TestBase {

    @Test (enabled = false)
    public void  testContactDeletion(){

        if (! app.getContactHelper().isThereContact()) {
            if (!app.group().isThereAGroup()) {
                app.goTo().gotoGroupPage();
                app.group().createGroup(new GroupData("test1", null, null));
                app.goTo().gotoContactPage();
            }
                app.getContactHelper().createContact(new ContactData("Петр", "Петрович", "Кузьмин", "ложки.ком", "+89654123654", "test1"));

        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().initContactDeletion();
        app.getContactHelper().initOkDeletion();
        app.goTo().returnToMainPage();

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(before.size() - 1);

        Assert.assertEquals(before, after);
    }
}
