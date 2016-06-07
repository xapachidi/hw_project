package kz.stqa.pft.addressbook.tests;


import kz.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by xeniya on 6/2/16.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Петр", "Петрович", "Кузьмин", "ложки.ком", "+89654123654", null), false);
        app.getContactHelper().buttonUpdateClick();
        app.getNavigationHelper().returnToContactPage();
    }
}
