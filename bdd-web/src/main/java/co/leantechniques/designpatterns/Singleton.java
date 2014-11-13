package co.leantechniques.designpatterns;

public class Singleton {
  private static Singleton instance;

  public static synchronized Singleton getInstance(){
    if(instance == null) instance = new Singleton();
    return instance;
  }
}
