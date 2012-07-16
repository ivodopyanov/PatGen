package ru.naumen.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class VectorElementImplTest
{
	@Mock
	Line<Polynom>				line;

	Double						start	= -10.0;
	Double						end		= 10.0;
	VectorElementImpl<Polynom>	element;

	@Test
	public void equals()
	{
		VectorElementImpl<Polynom> element2 = new VectorElementImpl<Polynom>(
				line, start, end);
		VectorElementImpl<Polynom> element3 = new VectorElementImpl<Polynom>(
				line, start, end + 1);
		Assert.assertTrue(element.equals(element2));
		Assert.assertFalse(element.equals(element3));
		Assert.assertFalse(element.equals(start));
	}

	@Before
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
		element = new VectorElementImpl<Polynom>(line, start, end);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testHashCode()
	{
		VectorElementImpl<Polynom> element2 = new VectorElementImpl<Polynom>(
				line, start, end);
		Assert.assertTrue(element.hashCode() == element2.hashCode());
	}
}