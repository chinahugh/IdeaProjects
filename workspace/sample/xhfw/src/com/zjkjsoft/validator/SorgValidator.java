package com.zjkjsoft.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.zjkjsoft.model.Sorg;

/**
 * 部门校验
 */
public class SorgValidator extends Validator {
	
	protected void validate(Controller controller) {
		validateRequiredString("bm.mc", "titleMsg", "请输入姓名!");
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Sorg.class);		
		String actionKey = getActionKey();
		if (actionKey.equals("/bm/save"))
			controller.render("/bm/add");
	}
}
