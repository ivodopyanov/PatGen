/* $Id: FunctionalCalculatorForPolynom.java 18 2011-08-21 10:34:42Z rx303303@gmail.com $ */
package ru.naumen.calculators.algebra;

import java.util.List;

import ru.naumen.model.Polynom;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Class for operations with functions. Result is stored in first parameter.
 * 
 * @author ivodopyanov
 * @since 10.08.2011
 */
@Singleton
public class FunctionalCalculatorForPolynom implements
		FunctionalCalculator<Polynom>
{

	@Inject
	public FunctionalCalculatorForPolynom()
	{

	}

	@Override
	public Polynom add(Polynom summand1, Polynom summand2)
	{
		doAdd(summand1, summand2, 1);
		return summand1;
	}

	@Override
	public void calcLinearCombination(List<Polynom> polynoms,
			List<Double> koeffs, Polynom dest)
	{
		for (int i = 0; i < koeffs.size(); i++)
		{
			for (int j = 0; j < polynoms.get(i).size(); j++)
			{

				Double value = polynoms.get(i).get(j) * koeffs.get(i);
				if (dest.size() <= j)
				{
					dest.add(value);
				}
				else
				{
					dest.set(j, dest.get(j) + value);
				}
			}
		}
	}

	@Override
	public Polynom copy(Polynom source)
	{
		Polynom result = new Polynom(source);
		return result;
	}

	@Override
	public Polynom multiply(Polynom func, double value)
	{
		for (int i = 0; i < func.size(); i++)
		{
			func.set(i, func.get(i) * value);
		}
		return func;
	}

	@Override
	public Polynom shift(Polynom func, double value)
	{
		for (int i = 0; i < func.size(); i++)
		{
			func.set(i, func.get(i) + value);
		}
		return func;
	}

	@Override
	public Polynom subtract(Polynom minuend, Polynom subtrahend)
	{
		doAdd(minuend, subtrahend, -1);
		return minuend;
	}

	private void doAdd(Polynom summand1, Polynom summand2, double koeff2)
	{
		int size = Math.max(summand1.size(), summand2.size());
		int summand1size = summand1.size();
		for (int i = 0; i < size; i++)
		{
			double value1 = 0;
			double value2 = 0;
			if (i < summand1.size())
			{
				value1 = summand1.get(i);
			}
			if (i < summand2.size())
			{
				value2 = summand2.get(i);
			}
			if (i >= summand1size)
			{
				summand1.add(value1 + koeff2 * value2);
			}
			else
			{
				summand1.set(i, value1 + koeff2 * value2);
			}
		}
	}

}
