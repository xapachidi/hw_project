package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.model.ContactData;
import kz.stqa.pft.addressbook.model.Contacts;
import kz.stqa.pft.addressbook.model.GroupData;
import kz.stqa.pft.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Xeniya on 03.08.2016.
 */
public class ContactWithoutGroupTests extends TestBase{
    private ContactData needContact;
    private GroupData needGroup;

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.contact().isThereContact()) {
            if (!app.group().isThereAGroup()) {
                app.goTo().gotoGroupPage();
                app.group().createGroup(new GroupData().withName("test1"));
                app.goTo().gotoContactPage();
            }
            app.contact().createContact(new ContactData().withFirst_name("Петр").withSecond_name("Петрович").withLast_name("Кузьмин").withCompany("ложки.ком").withPhone("+89654123654").withCompany("test1"));
        }
        Contacts allcontacts = app.db().contacts();
        needContact = allcontacts.iterator().next();
        Groups contactGroup = needContact.getGroups();
        needGroup = contactGroup.iterator().next();
        needContact.getId();
    }

    @Test
    public void testContactAddGroup() {
        Groups beforeGroup = needContact.getGroups();
        app.contact().deleteGroup(needContact, needGroup);
        ContactData newContact = app.db().contactWitnId(needContact.getId());
        Groups afterGroup = newContact.getGroups();
        assertThat(afterGroup.size(), equalTo(beforeGroup.size()-1));
    }
}
