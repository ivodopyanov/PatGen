/* $Id: CommonUtils.java 16 2011-08-13 16:52:55Z rx303303@gmail.com $ */
package ru.naumen.calculators;

import java.util.List;

import ru.naumen.AppGuiceModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

/**
 * Class for common calculations
 * 
 * @author ivodopyanov
 * @since 10.08.2011
 */
public class CommonUtils
{
	private static Injector	INJECTOR	= Guice.createInjector(new AppGuiceModule());

	public static <T> T getInstance(Class<T> type)
	{
		return INJECTOR.getInstance(type);
	}

	public static <T> T getInstance(Class<T> type, String named)
	{
		return INJECTOR.getInstance(Key.<T> get(type, Names.named(named)));
	}

	/**
	 * Translates a number in decimal numeral system to limit-nary numeral
	 * system and puts digits to list dest (with shift=limit\2 so that values
	 * were symmetric relatively to 0)
	 * 
	 * @param value
	 * @param limit
	 * @param func
	 */
	public static void longToFunction(long value, long limit, List<Double> dest)
	{
		for (int i = 0; i < dest.size(); i++)
		{
			long digit = value % (2 * limit + 1);
			dest.set(i, (double) (digit - limit));
			value = value - digit * limit;
		}
	}
}
