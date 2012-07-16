/* $Id: Constants.java 16 2011-08-13 16:52:55Z rx303303@gmail.com $ */
package ru.naumen;

/**
 * @author ivodopyanov
 * @since 10.08.2011
 */
public interface Constants
{
	public interface Samples
	{
		public interface Line
		{
			String	HORIZONTAL_X	= "horizontalX";

			String	HORIZONTAL_Y	= "horizontalY";

			String	VERTICAL_X		= "verticalX";

			String	VERTICAL_Y		= "verticalY";
		}
	}

	public interface Type
	{
		public interface Line
		{
			String	POLYNOM	= "polynom";
		}
	}
}
