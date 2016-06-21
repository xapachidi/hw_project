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
        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modifyGroup(group);
        Groups after = app.group().all();
        assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

    }


}
