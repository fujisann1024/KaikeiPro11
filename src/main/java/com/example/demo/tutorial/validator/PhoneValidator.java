package com.example.demo.tutorial.validator;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	private boolean onlyNumber = false;
	
	//初期化処理
	@Override
	public void initialize(Phone phone) {
		//アノテーションからうけとった値をセット
		onlyNumber = phone.onlyNumber();
	}
	
	/**
	 * 
	 */
	@Override
	public boolean isValid(String input, ConstraintValidatorContext context) {
		if(Objects.isNull(input)) {
			return true;
		}
		
		if(this.onlyNumber) {
			return input.matches("[0-9]*");
		}
		return input.matches("[0-9()-]*");
	}

}
