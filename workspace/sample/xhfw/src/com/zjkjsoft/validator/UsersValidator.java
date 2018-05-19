package com.zjkjsoft.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.zjkjsoft.model.Suser;

/**
 * 用户校验
 */
public class UsersValidator extends Validator {
	
	protected void validate(Controller controller) {
		////validateRequiredString("personnel.name", "titleMsg", "请输入姓名!");
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Suser.class);		
		String actionKey = getActionKey();
		if (actionKey.equals("/Users/save"))
			controller.render("add.jsp");
	}
}
