package co.leantechniques.designpatterns;

public class StrategyExample {

  public static final String GROWTH="GROWTH";
  public static final String CONSERVE="CONSERVE";

  public class Bad{
    public void main(int ageOfInvestor, String strategy){
      Boolean shouldIBuy = false;
      if( ageOfInvestor < 50 && strategy == GROWTH){
        shouldIBuy = true;
      } else if(ageOfInvestor < 25 && strategy == CONSERVE){
        shouldIBuy = true;
      }

      if(shouldIBuy) System.out.println("Yes! Buy!");
      else System.out.println("NO WAY! Save your money!");
    }
  }

  /*
  Create investment strategies for Growth and Conservative
   */
  public interface InvestmentStrategy{
    Boolean shouldIBuy(int age);
  }

  public class GrowthInvestmentStrategy implements InvestmentStrategy{
    @Override
    public Boolean shouldIBuy(int age) {
      return (age < 50);
    }
  }

  public class ConservativeInvestmentStrategy implements InvestmentStrategy{
    @Override
    public Boolean shouldIBuy(int age) {
      return (age < 25);
    }
  }

  public class Better{
    public void main(int ageOfInvestor, InvestmentStrategy strategy){
      if(strategy.shouldIBuy(ageOfInvestor)) System.out.println("Yes! Buy!");
      else System.out.println("NO WAY! Save your money!");
    }
  }
}
