public class BackstagePass extends DecoratedItem {
  public BackstagePass(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void updateQuality() {
    incrementQuality();

    if (getSellIn() < 11) {
      incrementQuality();
    }

    if (getSellIn() < 6) {
      incrementQuality();
    }

    decreaseSellIn();

    if (this.isExpired()) {
      zeroQuantity();
    }
  }
}
