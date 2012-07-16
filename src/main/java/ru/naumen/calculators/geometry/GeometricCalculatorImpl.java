/* $Id: GeometricCalculatorImpl.java 19 2011-08-22 12:56:55Z rx303303@gmail.com $ */
package ru.naumen.calculators.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import ru.naumen.calculators.algebra.LineCalculator;
import ru.naumen.calculators.algebra.system.SystemSolver;
import ru.naumen.model.Function;
import ru.naumen.model.Line;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class GeometricCalculatorImpl<T extends Function> implements
		GeometricCalculator<T>
{
	@Inject
	SystemSolver<T>		systemSolver;
	@Inject
	LineCalculator<T>	lineCalculator;

	@Inject
	public GeometricCalculatorImpl()
	{
	}

	@Override
	public TreeSet<Double> getIntersections(Line<T> baseLine,
			Collection<Line<T>> lines)
	{
		TreeSet<Double> result = new TreeSet<Double>();
		for (Line<T> intersection : lines)
		{
			Line<T> line = lineCalculator.copy(baseLine);
			lineCalculator.subtract(line, intersection);
			List<T> system = new ArrayList<T>();
			system.add(line.getFunctionX());
			system.add(line.getFunctionY());
			result.addAll(systemSolver.solve(system));
		}
		return result;
	}

}
