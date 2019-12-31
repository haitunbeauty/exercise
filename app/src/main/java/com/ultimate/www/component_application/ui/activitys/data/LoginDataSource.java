package com.ultimate.www.component_application.ui.activitys.data;

import com.ultimate.www.component_application.constant.Constant;
import com.ultimate.www.component_application.ui.activitys.data.model.LoggedInUser;
import com.ultimate.www.component_application.utils.ShareUtils;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication

//            LoggedInUser fakeUser =
//                    new LoggedInUser(
//                            java.util.UUID.randomUUID().toString(),
//                            "Jane Doe");
//            return new Result.Success<>(fakeUser);
            String[] test = new String[]{"1","2"};
            return new Result.Success<>(new LoggedInUser("1",test[1]));
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public boolean logout() {
        // TODO: revoke authentication
        String result = "data";
        if ("data".equals(result)){//模拟退出成功
            return true;
        }
        return false;
    }
}
