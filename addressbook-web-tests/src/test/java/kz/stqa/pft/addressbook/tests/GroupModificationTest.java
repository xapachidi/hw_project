package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

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
        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        int index = before.size()-1;
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modifyGroup(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);

    }


}
