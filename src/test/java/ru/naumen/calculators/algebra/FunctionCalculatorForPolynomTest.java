/*$Id: FunctionCalculatorForPolynomTest.java 18 2011-08-21 10:34:42Z rx303303@gmail.com $*/
package ru.naumen.calculators.algebra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import ru.naumen.model.Polynom;

/**
 * @author ivodopyanov
 * @since 10.08.2011
 */
public class FunctionCalculatorForPolynomTest
{




	static List<List<Double>> linearCombinationKoeffs=new ArrayList<List<Double>>();
	static {
		for(int i=0;i<10;i++)
		{
			List<Double> koeffs=new ArrayList<Double>();
			for(double j=0;j<i;j++)
			{
				koeffs.add(j+1);
			}
			linearCombinationKoeffs.add(koeffs);
		}
	}


	FunctionalCalculatorForPolynom	calc;
	//@formatter:off
	Polynom[][] addTestData=new Polynom[][]{
			new Polynom[]{new Polynom(1,2,3), new Polynom(4,6,-8), new Polynom(5,8,-5)},
			new Polynom[]{new Polynom(3,4,5), new Polynom(), new Polynom(3,4,5)},
			new Polynom[]{new Polynom(1,2), new Polynom(-1,-2,-3,-4), new Polynom(0,0,-3,-4)}
	};
	Polynom[][] subtractTestData=new Polynom[][]{
			new Polynom[]{new Polynom(1,2,3), new Polynom(4,6,-8), new Polynom(-3,-4,11)},
			new Polynom[]{new Polynom(3,4,5), new Polynom(), new Polynom(3,4,5)},
			new Polynom[]{new Polynom(1,2), new Polynom(-1,-2,-3,-4), new Polynom(2,4,3,4)}
	};
	Polynom[][] multiplyTestData=new Polynom[][]{
			new Polynom[]{new Polynom(5,7,2.3), new Polynom(0,0,0)},
			new Polynom[]{new Polynom(5,7,2.3,4), new Polynom(5,7,2.3,4)},
			new Polynom[]{new Polynom(-5,4.5), new Polynom(-10,9)},
			new Polynom[]{new Polynom(1,2,3), new Polynom(3,6,9)}
	};
	Polynom[][] shiftTestData=new Polynom[][]{
			new Polynom[]{new Polynom(1,2,3), new Polynom(1,2,3)},
			new Polynom[]{new Polynom(new Double[]{1.1,2.2,3.3}), new Polynom(new Double[]{2.1,3.2,4.3})}
	};
	//SUM (i=1 to size-1) {Polynom_i*i} == Polynom_size
	Polynom[][] calcLinearCombinationTestData=new Polynom[][]{
			new Polynom[]{new Polynom(1,2,3), new Polynom(5,2,8), new Polynom(-3,-5,2), new Polynom(2, -9, 25)}
	};
	Polynom[] copyTestData=new Polynom[]{
		new Polynom(2,3,4,5)	
	};
	//@formatter:on

	@Test
	public void add()
	{
		for (int i = 0; i < addTestData.length; i++)
		{
			// setup
			Polynom summand1 = addTestData[i][0];
			Polynom summand2 = addTestData[i][1];
			Polynom expected = addTestData[i][2];
			// call
			Polynom actual = calc.add(summand1, summand2);
			// assert
			Assert.assertEquals("add result test #" + i + " failed", expected,
					actual);
			Assert.assertEquals(
					"result must be stored in first summand - didn't happen in test #"
							+ i, expected, summand1);
		}
	}

	@Test
	public void calcLinearCombination()
	{
		for (int i = 0; i < calcLinearCombinationTestData.length; i++)
		{
			Polynom[] testCase = calcLinearCombinationTestData[i];
			int size = testCase.length;
			Polynom actual = new Polynom();
			List<Polynom> polynoms = Arrays.asList(Arrays.copyOfRange(testCase,
					0, size - 1));
			Polynom expected = testCase[size - 1];
			calc.calcLinearCombination(polynoms,
					linearCombinationKoeffs.get(size - 1), actual);
			Assert.assertEquals(expected, actual);
		}
	}

	@Test
	public void copy()
	{
		for (int i = 0; i < copyTestData.length; i++)
		{
			Polynom source = copyTestData[i];
			Polynom copy = calc.copy(source);
			Assert.assertEquals(copy, source);
			copy.set(0, copy.get(0) + 1);
			Assert.assertEquals(copy.get(0), source.get(0) + 1);
		}
	}

	@Test
	public void multiply()
	{
		for (int i = 0; i < multiplyTestData.length; i++)
		{
			Polynom func = multiplyTestData[i][0];
			Polynom expected = multiplyTestData[i][1];
			Polynom actual = calc.multiply(func, i);
			Assert.assertEquals("multiply result test #" + i + " failed",
					expected, actual);
			Assert.assertEquals(
					"result must be stored in first summand - didn't happen in test #"
							+ i, actual, func);

		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
		setUpCalculator();
	}

	@Test
	public void shift()
	{
		for (int i = 0; i < shiftTestData.length; i++)
		{
			// setup
			Polynom func = shiftTestData[i][0];
			Polynom expected = shiftTestData[i][1];
			// call
			Polynom actual = calc.shift(func, i);
			// assert
			Assert.assertEquals("shift result test #" + i + " failed",
					expected, actual);
			Assert.assertEquals(
					"result must be stored in first summand - didn't happen in test #"
							+ i, expected, func);
		}
	}

	@Test
	public void subtract()
	{
		for (int i = 0; i < subtractTestData.length; i++)
		{
			// setup
			Polynom minuend = subtractTestData[i][0];
			Polynom subtrahend = subtractTestData[i][1];
			Polynom expected = subtractTestData[i][2];
			// call
			Polynom actual = calc.subtract(minuend, subtrahend);
			// assert
			Assert.assertEquals("add result test #" + i + " failed", expected,
					actual);
			Assert.assertEquals(
					"result must be stored in first summand - didn't happen in test #"
							+ i, expected, minuend);
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}

	private void setUpCalculator()
	{
		calc = new FunctionalCalculatorForPolynom();
	}

}
