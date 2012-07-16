/* $Id: AppGuiceModule.java 22 2011-08-26 03:14:49Z rx303303@gmail.com $ */
package ru.naumen;

import ru.naumen.calculators.algebra.AlgebraGuiceModule;
import ru.naumen.calculators.geometry.GeomertyGuiceModule;
import ru.naumen.model.ModelGuiceModule;
import ru.naumen.operations.OperationsGuiceModule;

import com.google.inject.AbstractModule;

/**
 * Top-level Guice module
 * 
 * @author ivodopyanov
 * @since 10.08.2011
 */
public class AppGuiceModule extends AbstractModule
{
	@Override
	protected void configure()
	{
		install(new ModelGuiceModule());
		install(new OperationsGuiceModule());
		install(new AlgebraGuiceModule());
		install(new GeomertyGuiceModule());
	}
}