/* $Id: LineCalculator.java 13 2011-08-10 09:47:21Z rx303303@gmail.com $ */
package ru.naumen.calculators.algebra;

import ru.naumen.model.Function;
import ru.naumen.model.Line;

/**
 * Class for calculations with lines
 * @author ivodopyanov
 * @since 10.08.2011
 * @param <T>
 */
public interface LineCalculator<T extends Function>
{
    Line<T> add(Line<T> summand1, Line<T> summand2);

    Line<T> copy(Line<T> source);

    Line<T> multiply(Line<T> line, double value);

    Line<T> subtract(Line<T> minuend, Line<T> subtrahend);
}
