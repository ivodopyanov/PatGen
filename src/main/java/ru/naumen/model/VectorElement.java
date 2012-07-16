/* $Id: VectorElement.java 15 2011-08-10 15:43:48Z rx303303@gmail.com $ */
package ru.naumen.model;

/**
 * Element of a line. Its start and end is defined by values of parameter t in
 * line equation.
 * 
 * @author ivodopyanov
 * @since 10.08.2011
 * @param <T>
 */
public interface VectorElement<T extends Function>
{
	Double getEnd();

	Line<T> getLine();

	Double getStart();

	void setEnd(Double end);

	void setLine(Line<T> line);

	void setStart(Double start);
}
