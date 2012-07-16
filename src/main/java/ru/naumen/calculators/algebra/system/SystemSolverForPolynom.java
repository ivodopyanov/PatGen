/* $Id: SystemSolverForPolynom.java 22 2011-08-26 03:14:49Z rx303303@gmail.com $ */
package ru.naumen.calculators.algebra.system;

import java.util.List;
import java.util.TreeSet;

import ru.naumen.model.Polynom;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class SystemSolverForPolynom implements SystemSolver<Polynom>
{
	@Inject
	public SystemSolverForPolynom()
	{

	}

	@Override
	public TreeSet<Double> solve(List<Polynom> system)
	{
		if (system.size() == 0)
		{
			return new TreeSet<Double>();
		}
		if (system.size() == 1)
		{
			return solveSingleEquation(system.get(0));
		}
		if (system.size() == 2)
		{
			return solveTwoEquations(system.get(0), system.get(1));
		}
		return null;
	}

	private TreeSet<Double> solveSingleEquation(Polynom equation)
	{
		TreeSet<Double> result = new TreeSet<Double>();
		if (equation.size() == 2)
		{
			if (equation.get(1) != 0)
			{
				// because Double have signed zero and -0 != 0
				if (equation.get(0) == 0)
					result.add(0.0);
				else
					result.add(-equation.get(0) / equation.get(1));
			}
		}
		else if (equation.size() == 3)
		{
			double D = equation.get(1) * equation.get(1) - 4 * equation.get(0)
					* equation.get(2);
			if (D >= 0)
			{
				result.add((-equation.get(1) + Math.sqrt(D))
						/ (2 * equation.get(2)));
			}
			if (D > 0)
			{
				result.add((-equation.get(1) - Math.sqrt(D))
						/ (2 * equation.get(2)));
			}
		}
		return result;
	}

	private TreeSet<Double> solveTwoEquations(Polynom eq1, Polynom eq2)
	{
		TreeSet<Double> roots1 = solveSingleEquation(eq1);
		TreeSet<Double> roots2 = solveSingleEquation(eq2);
		roots1.retainAll(roots2);
		return roots1;
	}
}
