package com.griffith;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DummyTest {
	Dummy dummy;
	List<Thing> spy;
	String name;

	@Before
	public void setUp() throws Exception {
		dummy = mock(Dummy.class);
		when(dummy.isDay()).thenReturn(true);
		when(dummy.getName()).thenReturn("acme");
		spy = spy(dummy.getThings());
	}
	
	@Test
	public void testIsDay() {
		assertEquals(dummy.isDay(), true);
	}

	@Test
	public void testGetName() {
		assertEquals(dummy.getName(), "acme");
	}

	@Test
	public void testGetThings() {
		doReturn(new Thing("alpha")).when(spy).get(0);
		doReturn(new Thing("beta")).when(spy).get(1);
		assertEquals(spy.get(0).getName(), "alpha");
		assertEquals(spy.get(1).getName(), "beta");
	}

	@Test
	public void testVerify() {
		dummy.getName();
		dummy.getName();
		verify(dummy, times(2)).getName();
	}
}
