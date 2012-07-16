/* $Id: PolynomTest.java 18 2011-08-21 10:34:42Z rx303303@gmail.com $ */
package ru.naumen.model;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PolynomTest
{

	Polynom	polynom;

	@Test
	public void equals()
	{
		Polynom poly1 = new Polynom(1, -2, 1);
		Polynom poly2 = new Polynom(1, 2, 1);
		Polynom poly3 = new Polynom(1, 2);
		Assert.assertTrue(polynom.equals(poly1));
		Assert.assertFalse(polynom.equals(poly2));
		Assert.assertFalse(polynom.equals(poly3));
		Assert.assertFalse(polynom.equals(new Double(4)));
	}

	@Test
	public void getValue()
	{
		for (double i = -10; i <= 10; i++)
		{
			double expected = polynom.get(0) + polynom.get(1) * i
					+ polynom.get(2) * i * i;
			double actual = polynom.getValue(i);
			Assert.assertEquals(expected, actual);
		}
	}

	@Before
	public void setUp() throws Exception
	{
		polynom = new Polynom(1, -2, 1);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testToString()
	{
		Assert.assertEquals("t^2-2.0*t+1.0", polynom.toString());
	}
}
