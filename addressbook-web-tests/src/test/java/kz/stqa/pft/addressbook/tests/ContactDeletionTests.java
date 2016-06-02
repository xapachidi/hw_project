package kz.stqa.pft.addressbook.tests;

import kz.stqa.pft.addressbook.appmanager.HelperBase;
import org.testng.annotations.Test;

/**
 * Created by xeniya on 6/2/16.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void  testContactDeletion(){
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactDeletion();
        app.getContactHelper().initOkDeletion();
        app.getContactHelper().returnToMainPage();

    }
}
