package com.edittw;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrderTest {

	@Test
	public void evaluatesExpressionSuccess() {
		Order o = new Order();
		int sum = o.evaluateSuccess("1+2+3");
		assertEquals(6, sum);
	}

//	@Test
//	public void evaluatesExpressionFail() {
//		Order o = new Order();
//		int sum = o.evaluateFail("1+2+3");
//		assertEquals(6, sum);
//	}

}
