package com.ol.fractions.core.util;



import org.junit.Assert;
import org.junit.Test;


public class MathUtilsTest {

	@Test
	public void testLcm() {
		Assert.assertEquals(99,MathUtils.lcm(99, 33));
		Assert.assertEquals(33,MathUtils.lcm( 33,1));
		Assert.assertEquals(114,MathUtils.lcm(38, 6));
		Assert.assertEquals(114,MathUtils.lcm(6, 38));
	}

	@Test
	public void testEuclidGcd() {
		Assert.assertEquals(33,MathUtils.euclidGcd(99, 33));
		Assert.assertEquals(1,MathUtils.euclidGcd( 33,1));
		Assert.assertEquals(2,MathUtils.euclidGcd(38, 6));
		Assert.assertEquals(2,MathUtils.euclidGcd(6, 38));
		Assert.assertEquals(2,MathUtils.euclidGcd(38, 6));
		Assert.assertEquals(2,MathUtils.euclidGcd(-38, 6));
	}
}
