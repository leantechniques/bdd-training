public abstract class DecoratedItem extends Item {
  public DecoratedItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public abstract void updateQuality();

  boolean isExpired() {
    return getSellIn() < 0;
  }

  void zeroQuantity() {
    setQuality(getQuality() - getQuality());
  }

  void decreaseSellIn() {
    setSellIn(getSellIn() - 1);
  }

  protected void incrementQuality() {
    if (getQuality() < 50) {
      setQuality(getQuality() + 1);
    }
  }

  void decreaseQuality() {
    if (getQuality() > 0) {
      setQuality(getQuality() - 1);
    }
  }

  public void expire() {
    setSellIn(0);
  }
}
