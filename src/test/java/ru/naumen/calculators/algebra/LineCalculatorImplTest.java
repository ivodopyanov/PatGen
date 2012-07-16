package ru.naumen.calculators.algebra;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ru.naumen.model.Line;
import ru.naumen.model.ModelGuiceModule.Factory;
import ru.naumen.model.Polynom;

public class LineCalculatorImplTest
{
	@Mock
	FunctionalCalculator<Polynom>	funcCalc;
	@Mock
	Factory<Polynom>				factory;
	@Mock
	Line<Polynom>					line1;
	@Mock
	Line<Polynom>					line2;
	@Mock
	Polynom							func1x;
	@Mock
	Polynom							func1y;
	@Mock
	Polynom							func2x;
	@Mock
	Polynom							func2y;
	@Mock
	Line<Polynom>					lineCopy;
	@Mock
	Polynom							funcCopy1;
	@Mock
	Polynom							funcCopy2;

	LineCalculatorImpl<Polynom>		calc;

	@Test
	public void add()
	{
		Line<Polynom> actual = calc.add(line1, line2);
		verify(funcCalc).add(func1x, func2x);
		verify(funcCalc).add(func1y, func2y);
		Assert.assertEquals(line1, actual);
	}

	@Test
	public void copy()
	{
		Line<Polynom> result = calc.copy(line1);
		verify(result).setFunctionX(funcCopy1);
		verify(result).setFunctionY(funcCopy2);
	}

	@Test
	public void multiply()
	{
		double value = 5;
		Line<Polynom> result = calc.multiply(line1, value);
		verify(funcCalc).multiply(func1x, value);
		verify(funcCalc).multiply(func1y, value);
		Assert.assertEquals(line1, result);
	}

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		setUpLines();
		setUpFuncCalc();
		setUpInjector();
		setUpCalc();

	}

	@Test
	public void subtract()
	{
		Line<Polynom> result = calc.subtract(line1, line2);
		verify(funcCalc).subtract(func1x, func2x);
		verify(funcCalc).subtract(func1y, func2y);
		Assert.assertEquals(line1, result);
	}

	private void setUpCalc()
	{
		calc = new LineCalculatorImpl<Polynom>();
		calc.functionalCalculator = funcCalc;
		calc.factory = factory;
	}

	private void setUpFuncCalc()
	{
		when(funcCalc.copy(func1x)).thenReturn(funcCopy1);
		when(funcCalc.copy(func1y)).thenReturn(funcCopy2);
	}

	private void setUpInjector()
	{
		when(factory.line()).thenReturn(lineCopy);
	}

	private void setUpLines()
	{
		when(line1.getFunctionX()).thenReturn(func1x);
		when(line1.getFunctionY()).thenReturn(func1y);
		when(line2.getFunctionX()).thenReturn(func2x);
		when(line2.getFunctionY()).thenReturn(func2y);
	}

}
