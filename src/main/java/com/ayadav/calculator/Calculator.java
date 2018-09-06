package com.ayadav.calculator;
import org.springframework.stereotype.Service;

/**
 * Puclic class calculator
 */

@Service
public class Calculator {
	int sum(int a, int b) {
		return a + b;
	}
}
