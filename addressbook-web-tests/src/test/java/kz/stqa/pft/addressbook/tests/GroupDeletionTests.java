package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.model.GroupData;
import kz.stqa.pft.addressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().gotoGroupPage();
        if (app.group().all().size() == 0){
            app.group().createGroup(new GroupData().withName("test1"));
        }
    }
    
    @Test (enabled = false)
    public void testGroupDeletion() {
        //int before = app.group().getGroupCount();
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().deleteGroup(deletedGroup);
        //int after = app.group().getGroupCount();
        assertEquals(app.group().getGroupCount(), before.size()-1);
        Groups after = app.group().all();
        assertThat(after, equalTo(before.without(deletedGroup)));


    }


}
