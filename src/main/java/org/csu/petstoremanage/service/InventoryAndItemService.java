package org.csu.petstoremanage.service;

import org.csu.petstoremanage.domain.Inventory;
import org.csu.petstoremanage.domain.InventoryAndItem;
import org.csu.petstoremanage.domain.Item;
import org.csu.petstoremanage.persistence.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InventoryAndItemService {
@Autowired
    ItemMapper itemMapper;

public void updateInventoryAndItem(InventoryAndItem inventoryAndItem)
{
    Item item=inventoryAndItem.getItem();
    Inventory inventory=inventoryAndItem.getInventory();
    itemMapper.updateInventory(inventory);
    itemMapper.updateItem(item);
}
public void inserInventoryAndItem(InventoryAndItem inventoryAndItem)
{
    Item item=inventoryAndItem.getItem();
    Inventory inventory=inventoryAndItem.getInventory();
    itemMapper.insertItemByItemid(item);
    itemMapper.insertInventory(inventory);
}

public void removeInventoryAndItem(String itemid)
{
itemMapper.removeItemByItemId(itemid);
itemMapper.removeInventoryByItemId(itemid);
}
  public InventoryAndItem getInventoryAndItemByid(String itemid)
  {
      Inventory inventory= itemMapper.getInventory(itemid);
      Item item=itemMapper.getItem(itemid);
        InventoryAndItem inventoryAndItem=new InventoryAndItem();
        inventoryAndItem.setInventory(inventory);
        inventoryAndItem.setItem(item);
        return inventoryAndItem;
  }
public List<InventoryAndItem> getAllInventoryAndItem()
{
    List<InventoryAndItem> inventoryAndItems=new ArrayList<>();
   List<Item> items=  itemMapper.getAllItem();
    List<Inventory>inventories=itemMapper.getAllInventory();
    System.out.println(items.size());
    for(Item item:items)
    {
        for(Inventory inventory:inventories)
        {
            if(item.getItemId().equals(inventory.getItemId()))
            {
                //如果两个相等证明找到相同的了
            InventoryAndItem inventoryAndItem=new InventoryAndItem();
            inventoryAndItem.setInventory(inventory);
            inventoryAndItem.setItem(item);
            inventoryAndItems.add(inventoryAndItem);
            break;
            }
        }
    }
    return inventoryAndItems;
}




}
