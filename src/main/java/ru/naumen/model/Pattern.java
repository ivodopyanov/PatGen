/* $Id: Pattern.java 13 2011-08-10 09:47:21Z rx303303@gmail.com $ */
package ru.naumen.model;

import java.util.List;

/**
 * Pattern - collection of families and elementary patterns, based on these families
 * @author ivodopyanov
 * @since 10.08.2011
 * @param <T>
 */
public interface Pattern<T extends Function>
{
    List<Family<T>> getFamilies();

    List<ElemPattern<T>> getPatterns();

    void setFamilies(List<Family<T>> families);

    void setPatterns(List<ElemPattern<T>> patterns);
}
