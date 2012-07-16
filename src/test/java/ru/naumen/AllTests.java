package ru.naumen;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ru.naumen.calculators.algebra.AllAlgebraTests;
import ru.naumen.calculators.geometry.AllGeometryTests;
import ru.naumen.model.AllModelTests;

@RunWith(Suite.class)
@SuiteClasses(
{ AllAlgebraTests.class, AllGeometryTests.class, AllModelTests.class,
		AppGuiceModuleTest.class })
public class AllTests
{

}
