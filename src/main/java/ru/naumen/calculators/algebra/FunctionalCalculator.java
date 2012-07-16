/* $Id: FunctionalCalculator.java 15 2011-08-10 15:43:48Z rx303303@gmail.com $ */
package ru.naumen.calculators.algebra;

import java.util.List;

import ru.naumen.model.Function;

/**
 * Class for calculations with functions
 * 
 * @author ivodopyanov
 * @since 10.08.2011
 * @param <T>
 */
public interface FunctionalCalculator<T extends Function>
{
	T add(T summand1, T summand2);

	/**
	 * Вычисляет линейную комбинацию N функций functions с коэффициентами koeffs
	 * и сохраняет результат в dest
	 */
	void calcLinearCombination(List<T> functions, List<Double> koeffs, T dest);

	T copy(T source);

	T multiply(T func, double value);

	T shift(T func, double value);

	T subtract(T minuend, T subtrahend);
}
