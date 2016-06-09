package kz.stqa.pft.addressbook.tests;


import kz.stqa.pft.addressbook.model.ContactData;
import kz.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by xeniya on 6/2/16.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){

        if (! app.getContactHelper().isThereContact()) {
            if (!app.getGroupHelper().isThereAGroup()) {
                app.getNavigationHelper().gotoGroupPage();
                app.getGroupHelper().createGroup(new GroupData("test1", null, null));
                app.getNavigationHelper().gotoContactPage();
            }
            app.getContactHelper().createContact(new ContactData("Петр", "Петрович", "Кузьмин", "ложки.ком", "+89654123654", "test1"));
        }

        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Петр", "Петрович", "Кузьмин", "ложки.ком", "+89654123654", null), false);
        app.getContactHelper().buttonUpdateClick();
        app.getContactHelper().returnToContactPage();
    }
}
