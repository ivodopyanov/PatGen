/* $Id: ElemPatternImpl.java 22 2011-08-26 03:14:49Z rx303303@gmail.com $ */
package ru.naumen.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;

import com.google.inject.Inject;

public class ElemPatternImpl<T extends Function> implements ElemPattern<T>
{
	@Inject
	Family<T>		baseFamily;
	List<Family<T>>	boundaryFamilies;
	@Inject
	Polynom			core;
	List<Polynom>	disps;

	@Inject
	public ElemPatternImpl()
	{
		setBoundaryFamilies(new ArrayList<Family<T>>());
		setDisps(new ArrayList<Polynom>());
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof ElemPatternImpl))
		{
			return false;
		}
		ElemPatternImpl<T> pat = (ElemPatternImpl<T>) o;
		if (pat.getBoundaryFamilies().size() != getBoundaryFamilies().size())
		{
			return false;
		}
		if (pat.getDisps().size() != getDisps().size())
		{
			return false;
		}
		if (!ObjectUtils.equals(pat.getCore(), getCore()))
		{
			return false;
		}
		if (!ObjectUtils.equals(pat.getBaseFamily(), getBaseFamily()))
		{
			return false;
		}
		for (int i = 0; i < getDisps().size(); i++)
		{
			if (!ObjectUtils.equals(pat.getDisps().get(i), getDisps().get(i)))
			{
				return false;
			}
		}
		for (int i = 0; i < getBoundaryFamilies().size(); i++)
		{
			if (!ObjectUtils.equals(pat.getBoundaryFamilies().get(i),
					getBoundaryFamilies().get(i)))
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public Family<T> getBaseFamily()
	{
		return baseFamily;
	}

	@Override
	public List<Family<T>> getBoundaryFamilies()
	{
		return boundaryFamilies;
	}

	@Override
	public Polynom getCore()
	{
		return core;
	}

	@Override
	public List<Polynom> getDisps()
	{
		return disps;
	}

	@Override
	public int hashCode()
	{
		return ObjectUtils.hashCode(getBaseFamily())
				+ ObjectUtils.hashCode(getCore())
				+ ObjectUtils.hashCode(getBoundaryFamilies())
				+ getDisps().size();
	}

	@Override
	public void setBaseFamily(Family<T> baseFamily)
	{
		this.baseFamily = baseFamily;
	}

	@Override
	public void setBoundaryFamilies(List<Family<T>> boundaryFamilies)
	{
		this.boundaryFamilies = boundaryFamilies;
	}

	@Override
	public void setCore(Polynom core)
	{
		this.core = core;
	}

	@Override
	public void setDisps(List<Polynom> disps)
	{
		this.disps = disps;
	}
}