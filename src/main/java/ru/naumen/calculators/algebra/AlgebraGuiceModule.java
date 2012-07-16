/*$Id: AlgebraGuiceModule.java 18 2011-08-21 10:34:42Z rx303303@gmail.com $*/
package ru.naumen.calculators.algebra;

import ru.naumen.calculators.algebra.system.SystemSolver;
import ru.naumen.calculators.algebra.system.SystemSolverForPolynom;
import ru.naumen.model.Polynom;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class AlgebraGuiceModule extends AbstractModule
{

	@Override
	protected void configure()
	{
		bindPolynomClasses();
	}

	private void bindPolynomClasses()
	{
		//@formatter:off
		bind(new TypeLiteral<FunctionalCalculator<Polynom>>(){}).to(FunctionalCalculatorForPolynom.class);
		bind(new TypeLiteral<LineCalculator<Polynom>>(){}).to(new TypeLiteral<LineCalculatorImpl<Polynom>>(){});
		bind(new TypeLiteral<FamilyCalculator<Polynom>>(){}).to(new TypeLiteral<FamilyCalculatorImpl<Polynom>>(){});
		bind(new TypeLiteral<SystemSolver<Polynom>>(){}).to(SystemSolverForPolynom.class);
		//@formatter:on		
	}
}
