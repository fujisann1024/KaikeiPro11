package com.example.demo.tutorial.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention( RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface Phone {
	
	String message() default "電話番号を入力してください";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	//メソッドを追加することでアノテーションに引数を渡せるようにする
	boolean onlyNumber() default false;
}
