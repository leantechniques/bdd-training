public class CheeseItem extends DecoratedItem {
  public CheeseItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void updateQuality() {
    incrementQuality();

    this.decreaseSellIn();

    if (this.isExpired()) {
      incrementQuality();
    }
  }
}
