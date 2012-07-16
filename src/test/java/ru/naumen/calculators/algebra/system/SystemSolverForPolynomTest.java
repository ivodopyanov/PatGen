package ru.naumen.calculators.algebra.system;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.naumen.model.Polynom;

public class SystemSolverForPolynomTest
{
	static Double[][][][]									testDataArray;
	static LinkedHashMap<List<Polynom>, TreeSet<Double>>	testData;
	static
	{
		initTestDataArray();
		initTestDataMap();
	}

	static void initTestDataArray()
	{
		//@formatter:off
		testDataArray = new Double[][][][] {
				//Test case
				new Double[][][]{
						//Polynoms
						new Double[][]{
								new Double[]{2.0,-3.0,1.0},
								new Double[]{-1.0,1.0}
						},
						//Roots
						new Double[][]{
								new Double[]{1.0}
						}
				},
				//Test case
				new Double[][][]{
						//Polynoms
						new Double[][]{
								new Double[]{2.0,-3.0,1.0},
								new Double[]{-2.0,1.0}
						},
						//Roots
						new Double[][]{
								new Double[]{2.0}
						}
				},
				//Test case
				new Double[][][]{
						//Polynoms
						new Double[][]{
								new Double[]{2.0,-3.0,1.0}
						},
						//Roots
						new Double[][]{
								new Double[]{1.0, 2.0}
						}
				},
				//Test case
				new Double[][][]{
						//Polynoms
						new Double[][]{
						},
						//Roots
						new Double[][]{
								new Double[]{}
						}
				}
		};
		//@formatter:on
	}

	static void initTestDataMap()
	{
		testData = new LinkedHashMap<List<Polynom>, TreeSet<Double>>();
		for (int i = 0; i < testDataArray.length; i++)
		{
			Double[][] polynoms = testDataArray[i][0];
			Double[] result = testDataArray[i][1][0];
			List<Polynom> polynomList = new ArrayList<Polynom>();
			for (Double[] polynomKoeffs : polynoms)
			{
				polynomList.add(new Polynom(polynomKoeffs));
			}
			TreeSet<Double> resultSet = new TreeSet<Double>();
			for (Double res : result)
			{
				resultSet.add(res);
			}
			testData.put(polynomList, resultSet);
		}
	}

	SystemSolverForPolynom	solver;

	@Before
	public void setUp() throws Exception
	{
		solver = new SystemSolverForPolynom();

	}

	@Test
	public void solve()
	{
		for (Entry<List<Polynom>, TreeSet<Double>> entry : testData.entrySet())
		{
			TreeSet<Double> expected = entry.getValue();
			TreeSet<Double> actual = solver.solve(entry.getKey());
			Assert.assertArrayEquals(expected.toArray(), actual.toArray());
		}
	}

	@After
	public void tearDown() throws Exception
	{
	}

}
