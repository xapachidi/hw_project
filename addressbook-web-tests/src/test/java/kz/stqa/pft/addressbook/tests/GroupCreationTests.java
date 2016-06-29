package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.model.GroupData;
import kz.stqa.pft.addressbook.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
        list.add(new Object[] {new GroupData().withName("test2").withHeader("header2").withFooter("footer2")});
        return list.iterator();

    }

    @Test(dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) {
        //GroupData group = new GroupData().withName(name).withHeader(header).withFooter(footer);
        app.goTo().gotoGroupPage();
        Groups before = (Groups) app.group().all();
        app.group().createGroup(group);
        assertThat(app.group().getGroupCount(), equalTo(before.size() + 1));
        Groups after = (Groups) app.group().all();

        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));

    }

    @Test (enabled = false)
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
