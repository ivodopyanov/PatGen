/* $Id: ModelGuiceModule.java 22 2011-08-26 03:14:49Z rx303303@gmail.com $ */
package ru.naumen.model;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class ModelGuiceModule extends AbstractModule
{
	static public interface Factory<T extends Function>
	{
		ElemPattern<T> elemPattern();

		Family<T> family();

		T function();

		Line<T> line();

		Pattern<T> pattern();

		VectorElement<T> vectorElement();
	}

	@Override
	protected void configure()
	{
		bindPolynomClasses();
	}

	private void bindPolynomClasses()
	{
		//@formatter:off
		bind(Polynom.class);
		bind(new TypeLiteral<Line<Polynom>>(){}).to(new TypeLiteral<LineImpl<Polynom>>(){});
		bind(new TypeLiteral<Family<Polynom>>(){}).to(new TypeLiteral<FamilyImpl<Polynom>>(){});
		bind(new TypeLiteral<Pattern<Polynom>>(){}).to(new TypeLiteral<PatternImpl<Polynom>>(){});
		bind(new TypeLiteral<ElemPattern<Polynom>>(){}).to(new TypeLiteral<ElemPatternImpl<Polynom>>(){});
		bind(new TypeLiteral<VectorElement<Polynom>>(){}).to(new TypeLiteral<VectorElementImpl<Polynom>>(){});
		
		install(new FactoryModuleBuilder()
				.implement(Polynom.class, Polynom.class)
				.implement(new TypeLiteral<Line<Polynom>>(){}, new TypeLiteral<LineImpl<Polynom>>(){})
				.implement(new TypeLiteral<Family<Polynom>>(){}, new TypeLiteral<FamilyImpl<Polynom>>(){})
				.implement(new TypeLiteral<ElemPattern<Polynom>>(){}, new TypeLiteral<ElemPatternImpl<Polynom>>(){})
				.implement(new TypeLiteral<Pattern<Polynom>>(){}, new TypeLiteral<PatternImpl<Polynom>>(){})
				.implement(new TypeLiteral<VectorElement<Polynom>>(){}, new TypeLiteral<VectorElementImpl<Polynom>>(){})
				.build(new TypeLiteral<Factory<Polynom>>(){})
		);
		//@formatter:on
	}
}