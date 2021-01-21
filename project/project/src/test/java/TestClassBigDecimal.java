import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestClassBigDecimal {
public BigDecimal testValue;
public BigDecimal helperValue;
	@Before
public void initTestClass(){
	testValue = new BigDecimal("104");
	helperValue = new BigDecimal("10"); }

	@Test
public void testAddBigDecimal() {
	assertEquals(new BigDecimal(114), testValue.add(helperValue));
	assertEquals(new BigDecimal(84),  testValue.add(new BigDecimal(-20)));}
@Test
public void testSubtractBigDecimal() {
	assertEquals(new BigDecimal(94), testValue.subtract(helperValue));	
	assertEquals(new BigDecimal(134), testValue.subtract(new BigDecimal(-30)));	}
@Test
public void testMultiplyBigDecimal() {
	assertEquals(new BigDecimal(1040), testValue.multiply(helperValue));	
	assertEquals(new BigDecimal(120), new BigDecimal(12).multiply(helperValue));
	assertEquals(new BigDecimal("12.0"), new BigDecimal("1.2").multiply(helperValue));}

@Test(expected=ArithmeticException.class)
public void testDivideBigDecimalByZero() { 
	testValue.divide(new BigDecimal(0));	}
	
@Test(expected=ArithmeticException.class)
public void testDivideToIntegralValueBigDecimalByZero() { 
	testValue.divideToIntegralValue(new BigDecimal(0));	}

@Test
public void testDivideBigDecimal() {
	assertEquals(new BigDecimal(10), new BigDecimal(100).divide(helperValue));
	assertEquals(new BigDecimal("10.4"), testValue.divide(helperValue, 
MathContext.DECIMAL64));
	assertEquals(new BigDecimal("10.4"), testValue.divide(helperValue));}
@Test
public void testDivideBigDecimalRoundingMode() {
	assertEquals(new BigDecimal(11), testValue.divide(helperValue, RoundingMode.CEILING));
	assertEquals(new BigDecimal(10), testValue.divide(helperValue, RoundingMode.DOWN));
	assertEquals(new BigDecimal(10), testValue.divide(helperValue, RoundingMode.HALF_UP));}
	@Test
public void testDivideToIntegralValueBigDecimal() {
	assertEquals(new BigDecimal(10), testValue.divideToIntegralValue(helperValue));}
@Test
public void testRemainderBigDecimal() {
	assertEquals(new BigDecimal(4), testValue.remainder(helperValue));}
@Test
public void testPowInt() {
	assertEquals(new BigDecimal(10816), testValue.pow(2));}
@Test
public void testAbs() {
	assertEquals(new BigDecimal(104), testValue.abs());
	assertEquals(testValue, new BigDecimal(-104).abs());}
@Test
public void testNegate() {
	assertEquals(new BigDecimal(-104), testValue.negate());
	assertEquals(testValue, new BigDecimal(-104).negate());}
@Ignore("Showcasing ability to ignore running test inside test suite")
@Test
public void testPlus() {
	assertEquals(testValue, testValue.plus());}
@Test
public void testScale() {
	assertEquals(0, testValue.scale());
	assertEquals(4, new BigDecimal("1.2345").scale());}
@Test
public void testPrecision() {
	assertEquals(3, testValue.precision());
	assertEquals(2, new BigDecimal(10).precision());
	assertEquals(5, new BigDecimal("1.2345").precision());}
@Test
public void testRound() {
	assertEquals(new BigDecimal("104"), testValue.round(new MathContext(5)));
	assertEquals(new BigDecimal("1.2346"), new BigDecimal("1.234567").round(new 
MathContext(5)));}
@Test
public void testMovePointLeft() {
	assertEquals(new BigDecimal("10.4"), testValue.movePointLeft(1));}
@Test
public void testMovePointRight() {
	assertEquals(new BigDecimal("1040"), testValue.movePointRight(1));}}

