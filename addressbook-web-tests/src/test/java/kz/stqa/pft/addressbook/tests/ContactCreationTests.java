package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.model.ContactData;
import kz.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
    
    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoGroupPage();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().createContact(new ContactData("Петр", "Петрович", "Кузьмин", "ложки.ком", "+89654123654", "test1"));

    }


}
