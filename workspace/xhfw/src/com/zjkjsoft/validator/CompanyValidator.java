package com.zjkjsoft.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
//import com.zjkjsoft.model.Company;

/**
 * 勘察单位承建单位校验
 */
public class CompanyValidator extends Validator {
	
	protected void validate(Controller controller) {
		//validateRequiredString("personnel.name", "titleMsg", "请输入姓名!");
	}
	
	protected void handleError(Controller controller) {
	//	controller.keepModel(Company.class);		
		String actionKey = getActionKey();
		if (actionKey.equals("/js/save"))
			controller.render("add.jsp");
	}
}
