/* $Id: FamilyImpl.java 22 2011-08-26 03:14:49Z rx303303@gmail.com $ */
package ru.naumen.model;

import org.apache.commons.lang.ObjectUtils;

import com.google.inject.Inject;

public class FamilyImpl<T extends Function> implements Family<T>
{
	@Inject
	Line<T>	baseLine;
	@Inject
	Line<T>	disp;

	@Inject
	public FamilyImpl()
	{
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof FamilyImpl))
		{
			return false;
		}
		FamilyImpl<T> fam = (FamilyImpl<T>) o;
		return ObjectUtils.equals(fam.getBaseLine(), getBaseLine())
				&& ObjectUtils.equals(fam.getDisp(), getDisp());
	}

	@Override
	public Line<T> getBaseLine()
	{
		return baseLine;
	}

	@Override
	public Line<T> getDisp()
	{
		return disp;
	}

	@Override
	public int hashCode()
	{
		return (ObjectUtils.hashCode(getBaseLine()) + ObjectUtils
				.hashCode(getDisp())) / 2;
	}

	@Override
	public void setBaseLine(Line<T> line)
	{
		this.baseLine = line;
	}

	@Override
	public void setDisp(Line<T> disp)
	{
		this.disp = disp;
	}
}