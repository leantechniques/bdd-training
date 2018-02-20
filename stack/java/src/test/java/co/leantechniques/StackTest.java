package co.leantechniques;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class StackTest {
    @Test
    public void isNotNull() {
        assertThat(new Stack(), is(notNullValue()));
    }

    @Test
    public void emptyListHasSizeOfZero() {
        assertThat(new Stack().size(), is(0));
    }

    @Test
    public void putItemIncreasesSize() {
        Stack stack = new Stack();
        stack.put("1");
        stack.put("2");

        assertThat(stack.size(), is(2));
    }

    @Test
    public void popReturnsLastItem() {
        Stack<String> stack = new Stack<>();
        stack.put("1");
        stack.put("2");

        assertThat(stack.pop(), is("2"));
    }

    @Test()
    public void popEmptyStackThrowsException(){
        Stack<String> stack = new Stack<>();

        try {
            stack.pop();
            fail("expected exception");
        } catch (Exception e) {
            assertThat(e, instanceOf(IndexOutOfBoundsException.class));
        }
    }
}
