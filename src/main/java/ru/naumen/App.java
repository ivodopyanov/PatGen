/* $Id: App.java 16 2011-08-13 16:52:55Z rx303303@gmail.com $ */
package ru.naumen;

import ru.naumen.calculators.CommonUtils;

/**
 * @author ivodopyanov
 * @since 10.08.2011
 */
public class App
{
	public static void main(String[] args)
	{
		Workspace workspace = CommonUtils.getInstance(Workspace.class);
		workspace.init();
		workspace.run();
	}
}