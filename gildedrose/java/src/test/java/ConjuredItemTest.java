import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConjuredItemTest {
  final static int originalQuality = 6;

  @Test
  public void qualityDecreasesTwiceAsFastAsNormalItems() {
    DecoratedItem item = new ConjuredItem(null, 3, originalQuality);
    NormalItem normal = new NormalItem(null, 3, originalQuality);
    normal.updateQuality();

    item.updateQuality();

    int actualConjuredQualityGrowth = originalQuality - item.getQuality();
    int actualNormalQualityGrowth = originalQuality - normal.getQuality();

    assertThat(actualConjuredQualityGrowth, is(actualNormalQualityGrowth * 2));
  }
}
