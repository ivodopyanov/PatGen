/* $Id: LineImpl.java 22 2011-08-26 03:14:49Z rx303303@gmail.com $ */
package ru.naumen.model;

import org.apache.commons.lang.ObjectUtils;

import com.google.inject.Inject;

public class LineImpl<T extends Function> implements Line<T>
{

	@Inject
	T	koeffX;
	@Inject
	T	koeffY;

	@Inject
	public LineImpl()
	{
	}

	public LineImpl(T koeffX, T koeffY)
	{
		setFunctionX(koeffX);
		setFunctionY(koeffY);
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof LineImpl))
		{
			return false;
		}
		LineImpl<T> line = (LineImpl<T>) o;
		return ObjectUtils.equals(getFunctionX(), line.getFunctionX())
				&& ObjectUtils.equals(getFunctionY(), line.getFunctionY());
	}

	@Override
	public T getFunctionX()
	{
		return koeffX;
	}

	@Override
	public T getFunctionY()
	{
		return koeffY;
	}

	@Override
	public int hashCode()
	{
		return (ObjectUtils.hashCode(getFunctionX()) + ObjectUtils
				.hashCode(getFunctionY())) / 2;
	}

	@Override
	public void setFunctionX(T func)
	{
		koeffX = func;
	}

	@Override
	public void setFunctionY(T func)
	{
		koeffY = func;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("X: ").append(koeffX).append("Y: ").append(koeffY);
		return builder.toString();
	}

	@Override
	public double x(double t)
	{
		return getFunctionX().getValue(t);
	}

	@Override
	public double y(double t)
	{
		return getFunctionY().getValue(t);
	}
}