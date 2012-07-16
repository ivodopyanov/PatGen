/* $Id: LineCalculatorImpl.java 22 2011-08-26 03:14:49Z rx303303@gmail.com $ */
package ru.naumen.calculators.algebra;

import ru.naumen.model.Function;
import ru.naumen.model.Line;
import ru.naumen.model.ModelGuiceModule.Factory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class LineCalculatorImpl<T extends Function> implements
		LineCalculator<T>
{
	@Inject
	FunctionalCalculator<T>	functionalCalculator;
	@Inject
	Factory<T>				factory;

	@Inject
	public LineCalculatorImpl()
	{

	}

	@Override
	public Line<T> add(Line<T> summand1, Line<T> summand2)
	{
		functionalCalculator.add(summand1.getFunctionX(),
				summand2.getFunctionX());
		functionalCalculator.add(summand1.getFunctionY(),
				summand2.getFunctionY());
		return summand1;
	}

	@Override
	public Line<T> copy(Line<T> source)
	{
		T xCopy = functionalCalculator.copy(source.getFunctionX());
		T yCopy = functionalCalculator.copy(source.getFunctionY());
		Line<T> result = factory.line();
		result.setFunctionX(xCopy);
		result.setFunctionY(yCopy);
		return result;
	}

	@Override
	public Line<T> multiply(Line<T> line, double value)
	{
		functionalCalculator.multiply(line.getFunctionX(), value);
		functionalCalculator.multiply(line.getFunctionY(), value);
		return line;
	}

	@Override
	public Line<T> subtract(Line<T> minuend, Line<T> subtrahend)
	{
		functionalCalculator.subtract(minuend.getFunctionX(),
				subtrahend.getFunctionX());
		functionalCalculator.subtract(minuend.getFunctionY(),
				subtrahend.getFunctionY());
		return minuend;
	}

}
