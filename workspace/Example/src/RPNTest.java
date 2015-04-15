import static org.junit.Assert.*;

import java.util.Stack;

import labs.Postfix;
import org.junit.Test;


public class RPNTest {

	@Test
	public void testEvaluate() {
		Postfix calculator = new Postfix();
		Stack stack;
		stack = calculator.evaluate("25 7 32 + *");
		assertEquals(975.0,stack.peek());
	}

}
