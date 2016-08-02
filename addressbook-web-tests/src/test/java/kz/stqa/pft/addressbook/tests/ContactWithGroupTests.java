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
 * Created by Xeniya on 29.07.2016.
 */
public class ContactWithGroupTests extends TestBase {

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
        Groups allgroups = app.db().groups();
        needGroup = allgroups.iterator().next();
        needContact = allcontacts.iterator().next();
        Groups contactGroup = needContact.getGroups();
        needContact.getId();

        if (contactGroup.size() == allgroups.size()){
            app.goTo().gotoGroupPage();
            app.group().createGroup(new GroupData().withName("test2"));
            app.goTo().gotoContactPage();
            Groups allgroupsAfter = app.db().groups();
            needGroup = allgroupsAfter.iterator().next().withName("test2");
        }
        else if (allgroups.size() > contactGroup.size()) {
            needGroup = null;
            Groups difGroup = new Groups(allgroups);
            for (GroupData g : contactGroup) {
                difGroup = new Groups(allgroups.without(g));
                allgroups = new Groups(allgroups.without(g));
            }
            needGroup = difGroup.iterator().next();
        }
    }

    @Test
    public void testContactAddGroup() {
        Groups beforeGroup = needContact.getGroups();
        app.contact().addGroup(needContact, needGroup);
        ContactData newContact = app.db().contactWitnId(needContact.getId());
        Groups afterGroup = newContact.getGroups();
        assertThat(afterGroup.size(), equalTo(beforeGroup.size()+1));
    }
}
