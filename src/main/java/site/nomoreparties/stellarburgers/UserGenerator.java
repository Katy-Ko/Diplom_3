package site.nomoreparties.stellarburgers;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {

    public static User getDefaultCredentials(){
        final String email = "foo-foo@bk.ru";
        final String password = "000555000";
        final String name = "Алексей - Царь гусей";
        return new User(email, password, name);
    }

}
