import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NormaItemTest {

  private DecoratedItem item;

  @Before
  public void setUp() throws Exception {
    item = new NormalItem(null, -99, -99);
  }

  @Test
  public void reducesSellInByOne() {
    item.setSellIn(1);

    item.updateQuality();

    assertThat(item.getSellIn(), is(0));
  }

  @Test
  public void qualityNeverBelowZero() {
    item.setQuality(0);

    item.updateQuality();

    assertThat(item.getQuality(), is(0));
  }

  @Test
  public void qualityReducedByTwoWhenExpired() {
    item.expire();
    item.setQuality(2);

    item.updateQuality();

    assertThat(item.getQuality(), is(0));
  }
}
