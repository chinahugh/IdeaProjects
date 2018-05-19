package com.zjkjsoft.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.zjkjsoft.model.Srcd;

/**
 * 角色功能校验
 */
public class RolfunValidator extends Validator {
	
	protected void validate(Controller controller) {
		//validateRequiredString("personnel.name", "titleMsg", "请输入姓名!");
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Srcd.class);		
		String actionKey = getActionKey();
		if (actionKey.equals("/jscd/save"))
			controller.render("add.jsp");
	}
}
