package ru.naumen.calculators.geometry;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import ru.naumen.calculators.algebra.LineCalculator;
import ru.naumen.calculators.algebra.system.SystemSolver;
import ru.naumen.model.Line;
import ru.naumen.model.Polynom;

public class GeometricCalculatorImplTest
{
	@Mock
	SystemSolver<Polynom>				systemSolver;
	@Mock
	LineCalculator<Polynom>				lineCalculator;
	@Mock
	Line<Polynom>						baseLine;
	@Mock
	Line<Polynom>						line1;
	@Mock
	Line<Polynom>						line2;
	@Mock
	Polynom								x;
	@Mock
	Polynom								y;

	GeometricCalculatorImpl<Polynom>	calc;

	@Test
	public void getIntersections()
	{
		// prepare
		when(baseLine.getFunctionX()).thenReturn(x);
		when(baseLine.getFunctionX()).thenReturn(y);

		List<Line<Polynom>> lines = new ArrayList<Line<Polynom>>();
		lines.add(line1);
		lines.add(line2);
		TreeSet<Double> expected = new TreeSet<Double>();
		expected.add(1.0);
		expected.add(2.0);
		expected.add(3.0);
		TreeSet<Double> intersections1 = new TreeSet<Double>();
		intersections1.add(1.0);
		TreeSet<Double> intersections2 = new TreeSet<Double>();
		intersections2.add(2.0);
		intersections2.add(3.0);
		when(lineCalculator.copy(baseLine)).thenReturn(baseLine);
		when(systemSolver.solve(Matchers.<List<Polynom>> any())).thenReturn(
				intersections1, intersections2);
		// call
		TreeSet<Double> actual = calc.getIntersections(baseLine, lines);
		// verify
		verify(lineCalculator, Mockito.times(2)).copy(baseLine);
		verify(lineCalculator).subtract(baseLine, line1);
		verify(lineCalculator).subtract(baseLine, line2);
		Assert.assertEquals(expected.size(), actual.size());
		Assert.assertTrue(expected.containsAll(actual));
		Assert.assertTrue(actual.containsAll(expected));
	}

	@Before
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
		calc = new GeometricCalculatorImpl<Polynom>();
		calc.lineCalculator = lineCalculator;
		calc.systemSolver = systemSolver;
	}

	@After
	public void tearDown() throws Exception
	{
	}

}
