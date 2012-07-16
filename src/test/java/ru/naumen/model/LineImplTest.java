package ru.naumen.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LineImplTest
{
	@Mock
	Polynom				xFunc;
	@Mock
	Polynom				yFunc;
	@Mock
	Polynom				yFunc2;

	LineImpl<Polynom>	line;

	@Test
	public void equals()
	{
		LineImpl<Polynom> line2 = new LineImpl<Polynom>(xFunc, yFunc);
		LineImpl<Polynom> line3 = new LineImpl<Polynom>(xFunc, yFunc2);
		Assert.assertTrue(line.equals(line2));
		Assert.assertFalse(line.equals(line3));
		Assert.assertFalse(line.equals(xFunc));
	}

	@Before
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
		line = new LineImpl<Polynom>();
		line.koeffX = xFunc;
		line.koeffY = yFunc;
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testHashcode()
	{
		LineImpl<Polynom> line2 = new LineImpl<Polynom>(xFunc, yFunc);
		Assert.assertTrue(line.hashCode() == line2.hashCode());
	}

}
