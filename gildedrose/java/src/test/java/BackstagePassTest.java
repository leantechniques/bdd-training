import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BackstagePassTest {

  private DecoratedItem item;

  @Before
  public void setup() {
    item = new BackstagePass(null, -99, -99);
  }

  @Test
  public void qualityIncreasesByOneWhenConcertIsInMoreThanTenDays() {
    item.setSellIn(11);
    item.setQuality(0);

    item.updateQuality();

    assertThat(item.getQuality(), is(1));
  }

  @Test
  public void qualityIncreasesByTwoWhenConcertIsInTenOrFewerDays() {
    item.setSellIn(10);
    item.setQuality(0);

    item.updateQuality();

    assertThat(item.getQuality(), is(2));
  }

  @Test
  public void qualityIncreasesByThreeWhenConcertIsInLessThanSixDays() {
    item.setSellIn(5);
    item.setQuality(0);

    item.updateQuality();

    assertThat(item.getQuality(), is(3));
  }

  @Test
  public void qualityDropsToZeroAfterConcert() {
    item.expire();
    item.setQuality(20);

    item.updateQuality();

    assertThat(item.getQuality(), is(0));
  }
}
