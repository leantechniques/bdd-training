package co.leantechniques;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StackTest {
  @Test
  public void isNotNull() {
    assertThat(new Stack(), is(notNullValue()));
  }
}
