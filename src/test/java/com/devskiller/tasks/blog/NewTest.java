package com.devskiller.tasks.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class NewTest {

	static String testName(String name)
	{
		return name;
	}
	@Test
	void test()
	{
		String test=null;
		assertNull(test,"");
	}
}
