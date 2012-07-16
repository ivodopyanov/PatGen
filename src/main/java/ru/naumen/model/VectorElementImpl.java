/* $Id: VectorElementImpl.java 22 2011-08-26 03:14:49Z rx303303@gmail.com $ */
package ru.naumen.model;

import org.apache.commons.lang.ObjectUtils;

import com.google.inject.Inject;

public class VectorElementImpl<T extends Function> implements VectorElement<T>
{
	Line<T>	line;
	Double	start;
	Double	end;

	@Inject
	public VectorElementImpl()
	{
	}

	public VectorElementImpl(Line<T> line, Double start, Double end)
	{
		setLine(line);
		setStart(start);
		setEnd(end);
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof VectorElementImpl))
		{
			return false;
		}
		VectorElementImpl<T> ve = (VectorElementImpl<T>) o;
		return ObjectUtils.equals(getStart(), ve.getStart())
				&& ObjectUtils.equals(getEnd(), ve.getEnd())
				&& ObjectUtils.equals(getLine(), ve.getLine());
	}

	@Override
	public Double getEnd()
	{
		return end;
	}

	@Override
	public Line<T> getLine()
	{
		return line;
	}

	@Override
	public Double getStart()
	{
		return start;
	}

	@Override
	public int hashCode()
	{
		return ObjectUtils.hashCode(getLine())
				+ ObjectUtils.hashCode(getStart())
				+ ObjectUtils.hashCode(getEnd());
	}

	@Override
	public void setEnd(Double end)
	{
		this.end = end;
	}

	@Override
	public void setLine(Line<T> line)
	{
		this.line = line;
	}

	@Override
	public void setStart(Double start)
	{
		this.start = start;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(line.toString()).append(" start:")
				.append(start.toString()).append(" end:")
				.append(end.toString());
		return builder.toString();
	}
}