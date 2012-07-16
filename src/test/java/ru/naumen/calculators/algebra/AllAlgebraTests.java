package ru.naumen.calculators.algebra;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ru.naumen.calculators.algebra.system.SystemSolverForPolynomTest;

@RunWith(Suite.class)
@SuiteClasses(
{ FamilyCalculatorImplTest.class, FunctionCalculatorForPolynomTest.class,
		LineCalculatorImplTest.class, SystemSolverForPolynomTest.class })
public class AllAlgebraTests
{

}
