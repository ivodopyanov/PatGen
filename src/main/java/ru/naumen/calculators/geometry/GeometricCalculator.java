/* $Id: GeometricCalculator.java 19 2011-08-22 12:56:55Z rx303303@gmail.com $ */
package ru.naumen.calculators.geometry;

import java.util.Collection;
import java.util.TreeSet;

import ru.naumen.model.Function;
import ru.naumen.model.Line;

/**
 * Class for geometric calculations
 * 
 * @author ivodopyanov
 * @since 10.08.2011
 * @param <T>
 */
public interface GeometricCalculator<T extends Function>
{
	TreeSet<Double> getIntersections(Line<T> baseLine, Collection<Line<T>> lines);
}
