package com.example.demo.kaikei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DailyTrialBalanceSheetController {
	
	private final static String root = "/View/DailyTrialBalanceSheet/";
	
	private final static String GYOMU10001R = "GYOMU10001R";
	
	@GetMapping(root + GYOMU10001R)
	public String disp() {
		return root + GYOMU10001R;
	}
}
