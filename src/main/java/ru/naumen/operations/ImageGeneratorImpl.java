/* $Id: ImageGeneratorImpl.java 22 2011-08-26 03:14:49Z rx303303@gmail.com $ */
package ru.naumen.operations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ru.naumen.calculators.CommonUtils;
import ru.naumen.calculators.algebra.FamilyCalculator;
import ru.naumen.calculators.algebra.FunctionalCalculator;
import ru.naumen.calculators.geometry.GeometricCalculator;
import ru.naumen.model.ElemPattern;
import ru.naumen.model.Function;
import ru.naumen.model.Line;
import ru.naumen.model.Pattern;
import ru.naumen.model.Polynom;
import ru.naumen.model.VectorElement;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Singleton;

@Singleton
public class ImageGeneratorImpl<T extends Function> implements
		ImageGenerator<T>
{
	@Inject
	GeometricCalculator<T>			geomCalc;
	@Inject
	FunctionalCalculator<T>			funcCalc;
	@Inject
	FunctionalCalculator<Polynom>	polyFuncCalc;
	@Inject
	FamilyCalculator<T>				famCalc;
	@Inject
	Injector						injector;

	private long					lineCount;

	public ImageGeneratorImpl()
	{
	}

	@Override
	public Set<VectorElement<T>> generateImage(ElemPattern<T> pattern)
	{
		Set<VectorElement<T>> result = new HashSet<VectorElement<T>>();
		if (pattern.getDisps().size() == 0)
		{
			return result;
		}
		long limit = (long) Math.pow(getLineCount() * 2 + 1, pattern.getDisps()
				.size());
		List<Double> dispKoeffs = new ArrayList<Double>(pattern.getDisps()
				.size());
		for (int i = 0; i < pattern.getDisps().size(); i++)
			dispKoeffs.add(0.0);
		Polynom resultDisp = injector.getInstance(Polynom.class);
		resultDisp.ensureCapacity(pattern.getBoundaryFamilies().size() + 1);
		for (int i = 0; i < pattern.getBoundaryFamilies().size() + 1; i++)
			resultDisp.add(0.0);

		for (long counter = 0; counter < limit; counter++)
		{
			CommonUtils.longToFunction(counter, getLineCount(), dispKoeffs);
			polyFuncCalc.calcLinearCombination(pattern.getDisps(), dispKoeffs,
					resultDisp);
			Line<T> baseLine = famCalc.getLine(pattern.getBaseFamily(),
					resultDisp.get(0).intValue());
			List<Line<T>> intersectingLines = new ArrayList<Line<T>>();
			for (int i = 1; i < resultDisp.size(); i++)
			{
				intersectingLines.add(famCalc.getLine(pattern
						.getBoundaryFamilies().get(i - 1), resultDisp.get(i)
						.intValue()));
			}
			TreeSet<Double> lineKoeffs = geomCalc.getIntersections(baseLine,
					intersectingLines);
			// Collections.sort(lineKoeffs);
			Iterator<Double> iterator = lineKoeffs.iterator();
			while (iterator.hasNext())
			{
				Double start = iterator.next();
				Double end = null;
				if (iterator.hasNext())
					end = iterator.next();
				//@formatter:off
				VectorElement<T> ve = injector.getInstance(new Key<VectorElement<T>>(){});
				//@formatter:on
				ve.setLine(baseLine);
				ve.setStart(start);
				ve.setEnd(end);
				result.add(ve);
			}
		}
		return result;
	}

	@Override
	public Set<VectorElement<T>> generateImage(Pattern<T> pattern)
	{
		Set<VectorElement<T>> result = new HashSet<VectorElement<T>>();
		for (ElemPattern<T> elemPattern : pattern.getPatterns())
		{
			result.addAll(generateImage(elemPattern));
		}
		return result;
	}

	@Override
	public long getLineCount()
	{
		return lineCount;
	}

	@Override
	public void setLineCount(long lineCount)
	{
		this.lineCount = lineCount;
	}
}