package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
    
    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().fillContactForm(new ContactData("Петр", "Петрович", "Кузьмин", "ложки.ком", "+89654123654", "test1"), true);
        app.getContactHelper().buttonOkClick();
        app.getNavigationHelper().returnToContactPage();
    }


}
