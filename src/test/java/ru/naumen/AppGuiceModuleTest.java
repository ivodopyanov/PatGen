package ru.naumen;

import org.junit.Test;

import com.google.inject.Guice;

public class AppGuiceModuleTest
{
	@Test
	public void test()
	{
		Guice.createInjector(new AppGuiceModule());
	}
}
