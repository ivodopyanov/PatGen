/*$Id: FamilyCalculatorImplTest.java 14 2011-08-10 11:54:26Z rx303303@gmail.com $*/
package ru.naumen.calculators.algebra;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ru.naumen.model.Family;
import ru.naumen.model.Line;
import ru.naumen.model.Polynom;

/**
 * @author ivodopyanov
 * @since 10.08.2011
 */
public class FamilyCalculatorImplTest
{
    @Mock
    LineCalculator<Polynom> lineCalculator;
    @Mock
    Family<Polynom> family;
    @Mock
    Line<Polynom> disp;
    @Mock
    Line<Polynom> copyOfDisp;
    @Mock
    Line<Polynom> base;
    @Mock
    Line<Polynom> copyOfBase;

    FamilyCalculatorImpl<Polynom> calc;

    @Test
    public void asd()
    {
        //setup
        int INDEX = 5;
        //call
        Line<Polynom> result = calc.getLine(family, INDEX);
        //test
        verify(lineCalculator).multiply(copyOfDisp, INDEX);
        verify(lineCalculator).add(copyOfBase, copyOfDisp);
        Assert.assertEquals(copyOfBase, result);
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

        setUpFamily();
        setUpLineCalculator();
        setUpFamilyCalculator();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {

    }

    private void setUpFamily()
    {
        when(family.getBaseLine()).thenReturn(base);
        when(family.getDisp()).thenReturn(disp);
    }

    private void setUpFamilyCalculator()
    {
        calc = new FamilyCalculatorImpl<Polynom>();
        calc.lineCalculator = lineCalculator;
    }

    private void setUpLineCalculator()
    {
        when(lineCalculator.copy(disp)).thenReturn(copyOfDisp);
        when(lineCalculator.copy(base)).thenReturn(copyOfBase);
    }

}
