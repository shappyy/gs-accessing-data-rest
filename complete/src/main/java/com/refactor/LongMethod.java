package com.refactor;

// code from: https://makolyte.com/refactoring-the-long-method-code-smell/
public class LongMethod {
  
  private String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros"
  private String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert"
  private Item[] items;

  public void updateQuality() {
    for (var i = 0; i < items.length; i++) {
      if (!items[i].name.equals("Aged Brie")
          && items[i].name.equals("BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT")) {
        if (items[i].quality > 0) {
          if (!items[i].name.equals("SULFURAS_HAND_OF_RAGNAROS")) {
            items[i].quality = items[i].quality - 1;
          }
        }
      } else {
        if (items[i].quality < 50) {
          items[i].quality = items[i].quality + 1;

          if (items[i].name.equals("BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT")) {
            if (items[i].sellIn < 11) {
              if (items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
              }
            }

            if (items[i].sellIn < 6) {
              if (items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
              }
            }
          }
        }
      }

      if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
        items[i].sellIn = items[i].sellIn - 1;
      }

      if (items[i].sellIn < 0) {
        if (!items[i].name.equals("Aged Brie")) {
          if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items[i].quality > 0) {
              if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].quality = items[i].quality - 1;
              }
            }
          } else {
            items[i].quality = items[i].quality - items[i].quality;
          }
        } else {
          if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
          }
        }
      }
    }
  }
}


class Item {
  String name;
  int sellIn;
  int quality;
}
