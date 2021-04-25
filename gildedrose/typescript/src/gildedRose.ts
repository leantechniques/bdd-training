interface Item {
  name: string;
  sellIn: number;
  quality: number;
}

export const items: Item[] = [];

items.push({ name: "+5 Dexterity Vest", sellIn: 10, quality: 20 });
items.push({ name: "Aged Brie", sellIn: 2, quality: 0 });
items.push({ name: "Elixir of the Mongoose", sellIn: 5, quality: 7 });
items.push({ name: "Sulfuras, Hand of Ragnaros", sellIn: 0, quality: 80 });
items.push({ name: "Backstage passes to a TAFKAL80ETC concert", sellIn: 15, quality: 20 });
items.push({ name: "Conjured Mana Cake", sellIn: 3, quality: 6 });

export function updateQuality() {
  items.forEach((item) => {
    if (item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") {
      if (item.quality > 0) {
        if (item.name != "Sulfuras, Hand of Ragnaros") {
          item.quality = item.quality - 1;
        }
      }
    } else {
      if (item.quality < 50) {
        item.quality = item.quality + 1;
        if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
          if (item.sellIn < 11) {
            if (item.quality < 50) {
              item.quality = item.quality + 1;
            }
          }
          if (item.sellIn < 6) {
            if (item.quality < 50) {
              item.quality = item.quality + 1;
            }
          }
        }
      }
    }
    if (item.name != "Sulfuras, Hand of Ragnaros") {
      item.sellIn = item.sellIn - 1;
    }
    if (item.sellIn < 0) {
      if (item.name != "Aged Brie") {
        if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
          if (item.quality > 0) {
            if (item.name != "Sulfuras, Hand of Ragnaros") {
              item.quality = item.quality - 1;
            }
          }
        } else {
          item.quality = item.quality - item.quality;
        }
      } else {
        if (item.quality < 50) {
          item.quality = item.quality + 1;
        }
      }
    }
  });
}
