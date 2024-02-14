package db;

import db.service.UserTable;
import org.testng.annotations.Test;

public class DBTest {

    private final UserTable userTable = new UserTable();

    @Test
    void shouldBeAddedAndDeleteAlice() {
        userTable.insertAlice();
        userTable.updateAlice();
        userTable.deleteAlice();
        userTable.selectAllUsers();
    }
    @Test
    void HWTest1(){
        userTable.insertBilly();
        userTable.updateBilly();
        userTable.selectAllUsers();
    }
    @Test
    void HWTest2(){
        userTable.insertBilly();
        userTable.deleteBilly();
        userTable.selectAllUsers();
    }

}
