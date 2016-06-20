package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by xeniya on 6/2/16.
 */
public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().gotoGroupPage();

        if(! app.group().isThereAGroup()){
            app.group().createGroup(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification(){
        //int before = app.group().getGroupCount();
        List<GroupData> before = app.group().list();
        int index = before.size()-1;
        GroupData group = new GroupData().withId(before.get(index).getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modifyGroup(index, group);

        // int after = app.group().getGroupCount();

        List<GroupData> after = app.group().list();

        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }


}
