package ru.naumen.operations;

import ru.naumen.model.Polynom;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class OperationsGuiceModule extends AbstractModule
{

	@Override
	protected void configure()
	{
		//@formatter:off
		bind(new TypeLiteral<ImageGenerator<Polynom>>(){}).to(new TypeLiteral<ImageGeneratorImpl<Polynom>>(){});
		//@formatter:on
	}
}
