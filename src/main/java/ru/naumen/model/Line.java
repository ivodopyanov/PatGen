/* $Id: Line.java 13 2011-08-10 09:47:21Z rx303303@gmail.com $ */
package ru.naumen.model;

/**
 * Line defined by two parametric equations x=x(t) and y=y(t)
 * @author ivodopyanov
 * @since 10.08.2011
 * @param <T>
 */
public interface Line<T extends Function>
{
    T getFunctionX();

    T getFunctionY();

    void setFunctionX(T func);

    void setFunctionY(T func);

    double x(double t);

    double y(double t);
}
