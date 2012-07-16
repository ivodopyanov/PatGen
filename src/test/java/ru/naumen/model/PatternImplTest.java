package ru.naumen.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PatternImplTest
{
	PatternImpl<Polynom>	pattern;

	@Test
	public void equals()
	{
		Family<Polynom> family = Mockito.mock(Family.class);
		List<Family<Polynom>> families = new ArrayList<Family<Polynom>>();
		families.add(family);
		PatternImpl<Polynom> pattern2 = new PatternImpl<Polynom>();
		PatternImpl<Polynom> pattern3 = new PatternImpl<Polynom>();
		pattern3.setFamilies(families);
		Assert.assertTrue(pattern.equals(pattern2));
		Assert.assertFalse(pattern.equals(pattern3));
		Assert.assertFalse(pattern.equals(new Double(3)));
	}

	@Before
	public void setUp() throws Exception
	{
		pattern = new PatternImpl<Polynom>();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testHashCode()
	{
		PatternImpl<Polynom> pattern2 = new PatternImpl<Polynom>();
		Assert.assertTrue(pattern.hashCode() == pattern2.hashCode());
	}

}
