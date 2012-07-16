/* $Id: SystemSolver.java 13 2011-08-10 09:47:21Z rx303303@gmail.com $ */
package ru.naumen.calculators.algebra.system;

import java.util.List;
import java.util.Set;

import ru.naumen.model.Function;

/**
 * Class for solving a system of equations (like instance of T = 0)
 * @author ivodopyanov
 * @since 10.08.2011
 * @param <T>
 */
public interface SystemSolver<T extends Function>
{
    Set<Double> solve(List<T> system);
}
