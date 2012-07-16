package ru.naumen;

import static ru.naumen.Constants.Type.Line.POLYNOM;
import ru.naumen.calculators.CommonUtils;
import ru.naumen.model.Function;
import ru.naumen.model.Pattern;
import ru.naumen.model.Polynom;

import com.google.inject.Inject;

public class Workspace
{
	@Inject
	Pattern<Polynom>	pattern;

	@Inject
	public Workspace()
	{
		CommonUtils.getInstance(Function.class, POLYNOM);
	}

	public void init()
	{

	}

	public void run()
	{
		pattern.getFamilies();
	}
}
