package ru.naumen.model;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class ElemPatternImplTest
{

	Polynom	polynom1	= new Polynom(1, 2, 3);
	Polynom	polynom2	= new Polynom(1, 2, 3);
	Polynom	polynom3	= new Polynom(1, 2);
	Polynom	polynom4	= new Polynom(1, 2, 3);
	Polynom	polynom5	= new Polynom(1, 2, 3);

	@Test
	public void equals()
	{
		ElemPatternImpl<Polynom> pat1 = generateElemPattern();
		ElemPatternImpl<Polynom> pat2 = generateElemPattern();
		ElemPatternImpl<Polynom> pat3 = generateElemPattern();
		pat3.core = polynom2;
		ElemPatternImpl<Polynom> pat4 = generateElemPattern();
		ElemPatternImpl<Polynom> pat5 = generateElemPattern();
		pat4.getBoundaryFamilies().add(new FamilyImpl<Polynom>());
		pat5.getDisps().add(new Polynom());
		Assert.assertTrue(pat1.equals(pat2));
		Assert.assertFalse(pat1.equals(pat3));
		Assert.assertFalse(pat1.equals(new Double(3)));
		Assert.assertFalse(pat1.equals(pat4));
		Assert.assertFalse(pat1.equals(pat5));
		pat1.getBoundaryFamilies().add(new FamilyImpl<Polynom>());
		Assert.assertTrue(pat1.equals(pat4));
		pat1.getDisps().add(new Polynom());
		pat5.getBoundaryFamilies().add(new FamilyImpl<Polynom>());
		Assert.assertTrue(pat1.equals(pat5));
	}

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testHashCode()
	{
		ElemPatternImpl<Polynom> pat1 = generateElemPattern();
		ElemPatternImpl<Polynom> pat2 = generateElemPattern();
		Assert.assertEquals(pat1.hashCode(), pat2.hashCode());
	}

	private ElemPatternImpl<Polynom> generateElemPattern()
	{
		ElemPatternImpl<Polynom> result = new ElemPatternImpl<Polynom>();
		result.baseFamily = new FamilyImpl<Polynom>();
		result.core = new Polynom();
		return result;
	}
}