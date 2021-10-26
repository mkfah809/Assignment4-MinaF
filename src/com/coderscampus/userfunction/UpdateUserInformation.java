package com.coderscampus.userfunction;

import java.io.IOException;
import java.util.Scanner;

import com.coderscampus.user.User;
import com.coderscampus.user.UserRecordUpdate;

public class UpdateUserInformation {

	User getusertoUpdate(User[] users, User oldUser) throws IOException {
		Scanner useroptionList = new Scanner(System.in);
		UserRecordUpdate updateRecord = new UserRecordUpdate();
		Integer userOption = useroptionList.nextInt();
		while (userOption != 4) {
			if (userOption == 0) {
				oldUser = UserLogin.getloginasanyUser();
			} else if (userOption == 1) {
				updateRecord.updatingUsername(users, oldUser);
			} else if (userOption == 2) {
				updateRecord.updatingPassword(users, oldUser);
			} else if (userOption == 3) {
				updateRecord.updatingName(users, oldUser);
			} else if (userOption == 4) {
				System.out.println("Thank you for using me, Bye!");
				System.exit(0);
			} else if (userOption > 4) {
				System.out.println("Invalid Entry!, try again");
			}
			System.out.println();
			UserPrivileges.getnormaluserPrivilege();
			userOption = useroptionList.nextInt();
		}
		useroptionList.close();
		return oldUser;
	}

	public static void getuserprivilege() throws IOException {
		UserPrivileges.getsuperuserPrivilege();
		UserPrivileges.getnormaluserPrivilege();
	}

	public void updateUser(User oldUser, User newUser, User[] users) {
		//updating the user & the userArray
		for (int i = 0; i < users.length; i++) {
			User user = users[i];
			if (oldUser.getUsername().equals(user.getUsername()) || oldUser.getPassword().equals(user.getPassword())
					|| oldUser.getName().equals(user.getName())) {
				oldUser.setUsername(newUser.getUsername());
				oldUser.setPassword(newUser.getPassword());
				oldUser.setName(newUser.getName());
				oldUser.setRole(newUser.getRole());
				user.setUsername(newUser.getUsername());
				user.setPassword(newUser.getPassword());
				user.setName(newUser.getName());
				user.setRole(newUser.getRole());
			}

		}
	}
}
