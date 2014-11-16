public class LegendaryItem extends DecoratedItem {
  public LegendaryItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void updateQuality() {
    // Legendary Items are never sold or reduced in quality
  }
}
