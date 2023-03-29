package org.csu.petstoremanage.domain;
/*增删查商品，修改商品*/

public class InventoryAndItem {
    Item item;
    Inventory inventory;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
