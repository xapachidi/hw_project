package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class GroupDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().gotoGroupPage();
        if(! app.group().isThereAGroup()){
            app.group().createGroup(new GroupData().withName("test1"));
        }
    }
    
    @Test
    public void testGroupDeletion() {
        //int before = app.group().getGroupCount();
        Set<GroupData> before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().deleteGroup(deletedGroup);
        //int after = app.group().getGroupCount();
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size()-1);
        before.remove(deletedGroup);
        Assert.assertEquals(before, after);

    }


}
