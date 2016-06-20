package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().gotoGroupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        //int before = app.group().getGroupCount();
        app.group().createGroup(group);
        //int after = app.group().getGroupCount();
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);

    }

}
