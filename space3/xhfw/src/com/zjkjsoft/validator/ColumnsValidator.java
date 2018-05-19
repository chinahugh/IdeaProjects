package com.zjkjsoft.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.zjkjsoft.model.Srole;

/**
 * 新闻栏目校验
 */
public class ColumnsValidator extends Validator {
	
	protected void validate(Controller controller) {
		//validateRequiredString("personnel.name", "titleMsg", "请输入姓名!");
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Srole.class);		
		String actionKey = getActionKey();
		if (actionKey.equals("/js/save"))
			controller.render("add.jsp");
	}
}
