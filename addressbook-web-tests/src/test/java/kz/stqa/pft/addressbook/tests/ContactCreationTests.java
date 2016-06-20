package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.model.ContactData;
import kz.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{
    
    @Test (enabled = false)
    public void testContactCreation() {
        app.goTo().gotoGroupPage();
        if(! app.group().isThereAGroup()){
            app.group().createGroup(new GroupData("test1", null, null));
        }
        app.goTo().returnToMainPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.goTo().gotoContactPage();
        ContactData contact = new ContactData("Артем", "Петрович", "Кузьмин", "ложки.ком", "+89654123654", "test1");
        app.getContactHelper().createContact(contact);
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() +1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }


}
