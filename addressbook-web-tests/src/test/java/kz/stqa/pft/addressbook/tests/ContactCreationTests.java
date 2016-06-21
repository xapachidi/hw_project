package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.model.ContactData;
import kz.stqa.pft.addressbook.model.Contacts;
import kz.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().gotoGroupPage();
        if (!app.group().isThereAGroup()) {
            app.group().createGroup(new GroupData().withName("test1"));
        }
        app.goTo().returnToMainPage();
    }
    
    @Test
    public void testContactCreation() {
        Contacts before = (Contacts) app.contact().all();
        app.goTo().gotoContactPage();
        ContactData contact = new ContactData().withFirst_name("Артем").withSecond_name("Петрович").withLast_name("Кузьмин").withCompany("ложки.ком").withPhone("+89654123654").withGroup("test1");
        app.contact().createContact(contact);
        Contacts after = app.contact().all();

        assertThat(after.size(), equalTo(before.size() +1));
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }
}
