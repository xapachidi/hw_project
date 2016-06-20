package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().gotoGroupPage();

        if(! app.group().isThereAGroup()){
            app.group().createGroup(new GroupData("test1", null, null));
        }
    }
    
    @Test
    public void testGroupDeletion() {
        //int before = app.group().getGroupCount();
        List<GroupData> before = app.group().list();
        int index = before.size()-1;
        app.group().deleteGroup(index);

        //int after = app.group().getGroupCount();
        List<GroupData> after = app.group().list();

        Assert.assertEquals(after.size(), before.size()-1);

        before.remove(index);

        Assert.assertEquals(before, after);

    }


}
