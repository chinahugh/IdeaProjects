package com.zjkjsoft.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.zjkjsoft.model.Srole;

/**
 * 编码校验.
 */
public class CatlogValidator extends Validator {
	/**
	 * 编码校验
	 */
	protected void validate(Controller controller) {
		//validateRequiredString("personnel.name", "titleMsg", "请输入姓名!");
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Srole.class);		
		String actionKey = getActionKey();
		if (actionKey.equals("/catlog/save"))
			controller.render("add.jsp");
	}
}
