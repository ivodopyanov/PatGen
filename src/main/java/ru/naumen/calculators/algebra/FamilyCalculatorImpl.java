/* $Id: FamilyCalculatorImpl.java 13 2011-08-10 09:47:21Z rx303303@gmail.com $ */
package ru.naumen.calculators.algebra;

import ru.naumen.model.Family;
import ru.naumen.model.Function;
import ru.naumen.model.Line;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class FamilyCalculatorImpl<T extends Function> implements FamilyCalculator<T>
{
    @Inject
    LineCalculator<T> lineCalculator;

    @Inject
    public FamilyCalculatorImpl()
    {
    }

    @Override
    public Line<T> getLine(Family<T> family, int index)
    {
        Line<T> totalDisp = lineCalculator.copy(family.getDisp());
        lineCalculator.multiply(totalDisp, index);
        Line<T> result = lineCalculator.copy(family.getBaseLine());
        lineCalculator.add(result, totalDisp);
        return result;
    }

}
