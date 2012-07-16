package ru.naumen.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ru.naumen.operations.ImageGeneratorImplTest;

@RunWith(Suite.class)
@SuiteClasses(
{ ElemPatternImplTest.class, LineImplTest.class, PatternImplTest.class,
		PolynomTest.class, VectorElementImplTest.class,
		ImageGeneratorImplTest.class })
public class AllModelTests
{

}
