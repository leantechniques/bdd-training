import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LegendaryItemTest {
  @Test
  public void neverSoldOrReduceInQuality() {
    DecoratedItem item = new LegendaryItem(null, 1, 80);

    item.updateQuality();

    assertThat(item.getSellIn(), is(1));
    assertThat(item.getQuality(), is(80));
  }
}
