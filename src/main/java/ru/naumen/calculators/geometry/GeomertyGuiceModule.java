/* $Id: GeomertyGuiceModule.java 19 2011-08-22 12:56:55Z rx303303@gmail.com $ */
package ru.naumen.calculators.geometry;

import ru.naumen.model.Polynom;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class GeomertyGuiceModule extends AbstractModule
{

	@Override
	protected void configure()
	{
		//@formatter:off
		bind(new TypeLiteral<GeometricCalculator<Polynom>>(){}).to(new TypeLiteral<GeometricCalculatorImpl<Polynom>>(){});
		//@formatter:on
	}
}
