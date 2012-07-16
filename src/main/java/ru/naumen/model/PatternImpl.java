/* $Id: PatternImpl.java 18 2011-08-21 10:34:42Z rx303303@gmail.com $ */
package ru.naumen.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;

import com.google.inject.Inject;

/**
 * 
 * @author ivodopyanov
 * @since 10.08.2011
 * @param <T>
 */
public class PatternImpl<T extends Function> implements Pattern<T>
{
	List<Family<T>>			families;
	List<ElemPattern<T>>	patterns;

	@Inject
	public PatternImpl()
	{
		setFamilies(new ArrayList<Family<T>>());
		setPatterns(new ArrayList<ElemPattern<T>>());
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof PatternImpl))
		{
			return false;
		}
		PatternImpl<T> pattern = (PatternImpl<T>) o;
		if (pattern.getFamilies().size() != getFamilies().size())
		{
			return false;
		}
		if (pattern.getPatterns().size() != getPatterns().size())
		{
			return false;
		}
		for (int i = 0; i < getFamilies().size(); i++)
		{
			if (!ObjectUtils.equals(getFamilies().get(i), pattern.getFamilies()
					.get(i)))
			{
				return false;
			}
		}
		for (int i = 0; i < getPatterns().size(); i++)
		{
			if (!ObjectUtils.equals(getPatterns().get(i), pattern.getPatterns()
					.get(i)))
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public List<Family<T>> getFamilies()
	{
		return families;
	}

	@Override
	public List<ElemPattern<T>> getPatterns()
	{
		return patterns;
	}

	@Override
	public int hashCode()
	{
		return ObjectUtils.hashCode(getFamilies())
				+ ObjectUtils.hashCode(getPatterns());
	}

	@Override
	public void setFamilies(List<Family<T>> families)
	{
		this.families = families;
	}

	@Override
	public void setPatterns(List<ElemPattern<T>> patterns)
	{
		this.patterns = patterns;
	}
}
