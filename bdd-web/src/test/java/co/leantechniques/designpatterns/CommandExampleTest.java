package co.leantechniques.designpatterns;

import org.junit.Test;

public class CommandExampleTest {

  @Test
  public void RunCommandExample() {
    CommandExample commandExample = new CommandExample();
    commandExample.new MainProgram().main();
  }

}