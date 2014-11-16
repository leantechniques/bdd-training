import java.util.ArrayList;
import java.util.List;


public class GildedRose {

  public static void main(String[] args) {

    System.out.println("OMGHAI!");

    List<DecoratedItem> items = new ArrayList<DecoratedItem>();
    items.add(new NormalItem("+5 Dexterity Vest", 10, 20));
    items.add(new CheeseItem("Aged Brie", 2, 0));
    items.add(new NormalItem("Elixir of the Mongoose", 5, 7));
    items.add(new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new ConjuredItem("Conjured Mana Cake", 3, 6));

    updateQuality(items);
  }


  public static void updateQuality(List<DecoratedItem> items1) {
    for (int i = 0; i < items1.size(); i++) {
      DecoratedItem item = items1.get(i);
      item.updateQuality();
    }
  }

}