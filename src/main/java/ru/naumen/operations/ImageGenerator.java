/* $Id: ImageGenerator.java 22 2011-08-26 03:14:49Z rx303303@gmail.com $ */
package ru.naumen.operations;

import java.util.Set;

import ru.naumen.model.ElemPattern;
import ru.naumen.model.Function;
import ru.naumen.model.Pattern;
import ru.naumen.model.VectorElement;

/**
 * Class for generating vector elements from pattern.
 * @author ivodopyanov
 * @since 10.08.2011
 * @param <T>
 */
public interface ImageGenerator<T extends Function>
{
    Set<VectorElement<T>> generateImage(ElemPattern<T> pattern);

    Set<VectorElement<T>> generateImage(Pattern<T> pattern);

    long getLineCount();

    void setLineCount(long lineCount);
}
