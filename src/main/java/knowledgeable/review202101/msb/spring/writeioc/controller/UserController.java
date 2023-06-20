package knowledgeable.review202101.msb.spring.writeioc.controller;

import knowledgeable.review202101.msb.spring.writeioc.annoation.AutoWired;
import knowledgeable.review202101.msb.spring.writeioc.service.UserService;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-02-22 Time: 20:45:51
 * Description:
 */
public class UserController {
	@AutoWired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
