/* $Id: FamilyCalculator.java 13 2011-08-10 09:47:21Z rx303303@gmail.com $ */
package ru.naumen.calculators.algebra;

import ru.naumen.model.Family;
import ru.naumen.model.Function;
import ru.naumen.model.Line;

/**
 * Class for calculations with families
 * @author ivodopyanov
 * @since 10.08.2011
 * @param <T>
 */
public interface FamilyCalculator<T extends Function>
{
    Line<T> getLine(Family<T> family, int index);
}
