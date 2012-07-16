/* $Id: ImageGeneratorImplTest.java 22 2011-08-26 03:14:49Z rx303303@gmail.com $ */
package ru.naumen.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import ru.naumen.AppGuiceModule;
import ru.naumen.model.ElemPattern;
import ru.naumen.model.Family;
import ru.naumen.model.Line;
import ru.naumen.model.Pattern;
import ru.naumen.model.Polynom;
import ru.naumen.model.VectorElement;
import ru.naumen.model.VectorElementImpl;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;

public class ImageGeneratorImplTest
{
	interface FamilyCode
	{
		String	HOR		= "horFamily";
		String	VERT	= "vertFamily";
	}

	interface LineCode
	{
		String	HOR			= "horLine";	// y=0
		String	VERT		= "vertLine";	// x=0
		String	HOR_DISP	= "horDisp";	// y(+0)=0(+1)
		String	VERT_DISP	= "vertDisp";	// x(+0)=0(+1)
	}

	ImageGenerator<Polynom>			generator;
	int								lineCount	= 2;
	Injector						injector;
	Pattern<Polynom>				pattern;
	ElemPattern<Polynom>			elemPattern;

	Map<String, Line<Polynom>>		lines;
	Map<String, Family<Polynom>>	families;

	@Test
	public void generateImage()
	{
		Set<VectorElement<Polynom>> expected = new HashSet<VectorElement<Polynom>>();
		for (double j = -2; j <= 2; j++)
		{
			//@formatter:off
			Line<Polynom> l=injector.getInstance(new Key<Line<Polynom>>(){});
			//@formatter:on
			l.setFunctionX(new Polynom());
			l.setFunctionY(new Polynom(j, 1));
			for (double i = -4; i <= 4; i += 2)
				expected.add(new VectorElementImpl<Polynom>(l, i, i + 1));
		}
		Set<VectorElement<Polynom>> actual = generator.generateImage(pattern);
		Assert.assertTrue(actual.containsAll(expected));
		Assert.assertTrue(expected.containsAll(actual));
	}

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		setUpInjector();
		setUpLines();
		setUpFamilies();
		setUpElemPattern(FamilyCode.HOR, Arrays.asList(FamilyCode.VERT,
				FamilyCode.VERT), new Polynom(0, 0, 1), generateDisps());
		setUpPattern(generateElemPatternList());
		setUpGenerator();
	}

	private List<Polynom> generateDisps()
	{
		List<Polynom> result = new ArrayList<Polynom>();
		result.add(new Polynom(1, 0, 0));
		result.add(new Polynom(0, 2, 2));
		return result;
	}

	private List<ElemPattern<Polynom>> generateElemPatternList()
	{
		List<ElemPattern<Polynom>> result = new ArrayList<ElemPattern<Polynom>>();
		result.add(elemPattern);
		return result;
	}

	private Family<Polynom> generateFamily(String baseLineCode,
			String dispLineCode)
	{
		//@formatter:off
		Family<Polynom> fam=injector.getInstance(new Key<Family<Polynom>>(){});
		//@formatter:on
		fam.setBaseLine(lines.get(baseLineCode));
		fam.setDisp(lines.get(dispLineCode));
		return fam;
	}

	private Line<Polynom> generateLine(Polynom xFunc, Polynom yFunc)
	{
		//@formatter:off
		Line<Polynom> line=injector.getInstance(new Key<Line<Polynom>>(){});
		//@formatter:on
		line.setFunctionX(xFunc);
		line.setFunctionY(yFunc);
		return line;
	}

	private List<Family<Polynom>> getFamilyList(List<String> codes)
	{
		List<Family<Polynom>> result = new ArrayList<Family<Polynom>>();
		for (String code : codes)
			result.add(families.get(code));
		return result;
	}

	private void setUpElemPattern(String baseFamilyCode,
			List<String> boundaryFamilyCodes, Polynom core, List<Polynom> disps)
	{
		//@formatter:off
		elemPattern=injector.getInstance(new Key<ElemPattern<Polynom>>(){});
		//@formatter:on
		elemPattern.setDisps(disps);
		elemPattern.setBaseFamily(families.get(baseFamilyCode));
		elemPattern.setBoundaryFamilies(getFamilyList(boundaryFamilyCodes));
		elemPattern.setCore(core);
	}

	private void setUpFamilies()
	{
		families = new HashMap<String, Family<Polynom>>();
		families.put(FamilyCode.HOR,
				generateFamily(LineCode.HOR, LineCode.HOR_DISP));
		families.put(FamilyCode.VERT,
				generateFamily(LineCode.VERT, LineCode.VERT_DISP));
	}

	private void setUpGenerator()
	{
		//@formatter:off
		generator = injector.getInstance(new Key<ImageGenerator<Polynom>>(){});
		generator.setLineCount(lineCount);
		//@formatter:on

	}

	private void setUpInjector()
	{
		injector = Guice.createInjector(new AppGuiceModule());
	}

	private void setUpLines()
	{
		lines = new HashMap<String, Line<Polynom>>();
		lines.put(LineCode.HOR, generateLine(new Polynom(), new Polynom(0, 1)));
		lines.put(LineCode.VERT, generateLine(new Polynom(0, 1), new Polynom()));
		lines.put(LineCode.HOR_DISP,
				generateLine(new Polynom(), new Polynom(1)));
		lines.put(LineCode.VERT_DISP,
				generateLine(new Polynom(1), new Polynom()));
	}

	private void setUpPattern(List<ElemPattern<Polynom>> elemPatterns)
	{
		//@formatter:off
		pattern=injector.getInstance(new Key<Pattern<Polynom>>(){});
		//@formatter:on
		pattern.setPatterns(elemPatterns);

	}
}
