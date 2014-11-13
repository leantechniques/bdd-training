package co.leantechniques.designpatterns;

import java.util.Arrays;
import java.util.List;

public class CommandExample {
  public interface Command{
    void execute();
  }

  public class CompileCommand implements Command{
    @Override
    public void execute() {
      System.out.println("Compile the Code");
    }
  }

  public class VerifyCodeCommand implements Command{
    @Override
    public void execute() {
      System.out.println("Running the tests");
    }
  }

  public class MainProgram{
    public void main(){
      List<Command> buildProcess = Arrays.asList(
              new CompileCommand(),
              new VerifyCodeCommand());

      for (Command buildStep : buildProcess) {
        buildStep.execute();
      }
    }
  }
}
