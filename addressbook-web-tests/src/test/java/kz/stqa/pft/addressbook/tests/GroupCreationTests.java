package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.model.GroupData;
import kz.stqa.pft.addressbook.model.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().gotoGroupPage();
        Groups before = (Groups) app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().createGroup(group);
        assertThat(app.group().getGroupCount(), equalTo(before.size() + 1));
        Groups after = (Groups) app.group().all();

        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));

    }

    @Test
    public void testBadGroupCreation() {
        app.goTo().gotoGroupPage();
        Groups before = (Groups) app.group().all();
        GroupData group = new GroupData().withName("test2'");
        //int before = app.group().getGroupCount();
        app.group().createGroup(group);
        //int after = app.group().getGroupCount();
        assertThat(app.group().getGroupCount(), equalTo(before.size()));
        Groups after = (Groups) app.group().all();
        assertThat(after, equalTo(before));

    }

}
