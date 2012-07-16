/* $Id: Family.java 13 2011-08-10 09:47:21Z rx303303@gmail.com $ */
package ru.naumen.model;

/**
 * Family of lines defined by a single line with a single displacement of koefficients 
 * @author ivodopyanov
 * @since 10.08.2011
 * @param <T>
 */
public interface Family<T extends Function>
{
    Line<T> getBaseLine();

    Line<T> getDisp();

    void setBaseLine(Line<T> line);

    void setDisp(Line<T> disp);
}
