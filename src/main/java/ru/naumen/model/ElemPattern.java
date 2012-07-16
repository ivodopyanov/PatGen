/* $Id: ElemPattern.java 18 2011-08-21 10:34:42Z rx303303@gmail.com $ */
package ru.naumen.model;

import java.util.List;

/**
 * Elementary pattern - pattern with single base line It defines a set of vector
 * elements, which are produced by intersections of line of base family and
 * lines of boundary families. Indexes of these lines are a linear combination
 * of core and displacements.
 * 
 * @author ivodopyanov
 * @since 10.08.2011
 * @param <T>
 */
public interface ElemPattern<T extends Function>
{
	Family<T> getBaseFamily();

	List<Family<T>> getBoundaryFamilies();

	/**
	 * @return Koefficients for core segment of the elementary pattern. Length
	 *         of polynom = N + 1, where N - number of boundary families
	 */
	Polynom getCore();

	/**
	 * @return List of koefficients of core displacements. Length of each
	 *         polynom = N + 1, where N - number of boundary families.
	 */
	List<Polynom> getDisps();

	void setBaseFamily(Family<T> baseFamily);

	void setBoundaryFamilies(List<Family<T>> boundaryFamilies);

	void setCore(Polynom core);

	void setDisps(List<Polynom> disps);

}
