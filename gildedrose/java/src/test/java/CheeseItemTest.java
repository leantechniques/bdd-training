import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheeseItemTest {

  private DecoratedItem cheese;

  @Before
  public void setUp() throws Exception {
    cheese = new CheeseItem("Aged Brie", -99, -99);
  }

  @Test
  public void qualityIncreasesByOneWhenNotExpired() {
    cheese.setSellIn(1);
    cheese.setQuality(0);

    cheese.updateQuality();

    assertThat(cheese.getQuality(), is(1));
  }

  @Test
  public void qualityNeverExceedsFifty() {
    cheese.setQuality(50);

    cheese.updateQuality();

    assertThat(cheese.getQuality(), is(50));
  }

  @Test
  public void qualityIncreasesByTwoWhenExpired() {
    cheese.expire();
    cheese.setQuality(0);

    cheese.updateQuality();

    assertThat(cheese.getQuality(), is(2));
  }
}
