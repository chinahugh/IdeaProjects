package com.zjkjsoft.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.zjkjsoft.model.Sfucn;

/**
 * 系统菜单校验
 */
public class FucnValidator extends Validator {
	
	protected void validate(Controller controller) {
		validateRequiredString("sfucn.mc", "titleMsg", "请输入姓名!");
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Sfucn.class);		
		String actionKey = getActionKey();
		if (actionKey.equals("/sfucn/save"))
			controller.render("add.jsp");
	}
}
