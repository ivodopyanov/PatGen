/* $Id: Polynom.java 18 2011-08-21 10:34:42Z rx303303@gmail.com $ */
package ru.naumen.model;

import java.util.ArrayList;

import com.google.inject.Inject;

/**
 * Polynomial implementation of function.
 * 
 * @author ivodopyanov
 * @since 10.08.2011
 */
public class Polynom extends ArrayList<Double> implements Function
{
	private static final long	serialVersionUID	= 2323058532367407007L;

	@Inject
	public Polynom()
	{
	}

	public Polynom(double... koeffs)
	{
		super();
		Double[] buf = new Double[koeffs.length];
		for (int i = 0; i < koeffs.length; i++)
		{
			buf[i] = koeffs[i];
		}
		init(buf);
	}

	public Polynom(Double... koeffs)
	{
		super();
		init(koeffs);
	}

	public Polynom(Polynom source)
	{
		super(source);
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Polynom))
		{
			return false;
		}
		Polynom poly = (Polynom) o;
		if (poly.size() != size())
		{
			return false;
		}
		for (int i = 0; i < size(); i++)
		{
			if (!poly.get(i).equals(get(i)))
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public Double getValue(Double t)
	{
		Double result = new Double(0);
		for (int i = 0; i < size(); i++)
		{
			result += Math.pow(t, i) * get(i);
		}
		return result;
	}

	@Override
	public int hashCode()
	{
		int hash = size();
		if (hash > 0)
		{
			hash += get(0);
		}
		return hash;
	}

	@Override
	public void init(Double[] koeffs)
	{
		clear();
		for (Double koeff : koeffs)
		{
			add(koeff);
		}
	}

	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		for (int i = size() - 1; i >= 0; i--)
		{
			double value = get(i);
			if (value == 0)
			{
				continue;
			}
			if (i != size() - 1 && value > 0)
			{
				result.append("+");
			}
			if (value != 1 || i == 0)
			{
				result.append(value);
				if (i != 0)
				{
					result.append("*");
				}
			}
			if (i == 1)
			{
				result.append("t");
			}
			else if (i != 0)
			{
				result.append("t^").append(i);
			}
		}
		return result.toString();
	}
}