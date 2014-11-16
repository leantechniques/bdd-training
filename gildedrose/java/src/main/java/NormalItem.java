public class NormalItem extends DecoratedItem {
  public NormalItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void updateQuality() {
    this.decreaseQuality();
    this.decreaseSellIn();
    if (this.isExpired()) {
      this.decreaseQuality();
    }
  }
}
