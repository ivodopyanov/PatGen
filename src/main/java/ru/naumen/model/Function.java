/* $Id: Function.java 17 2011-08-17 11:32:26Z rx303303@gmail.com $ */
package ru.naumen.model;

/**
 * Well, a function. F=F(t).
 * 
 * @author ivodopyanov
 * @since 10.08.2011
 */
public interface Function
{
	Double getValue(Double t);

	void init(Double[] koeffs);
}
