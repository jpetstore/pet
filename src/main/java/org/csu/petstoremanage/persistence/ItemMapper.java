package org.csu.petstoremanage.persistence;

import org.csu.petstoremanage.domain.Inventory;
import org.csu.petstoremanage.domain.Item;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface ItemMapper {

    void updateInventory(Inventory inventory);//修改
    void updateItem(Item item);//修改

    Item getItem(String itemId);//查询
    Inventory getInventory(String itemId);//查询Inventory

    List<Item> getAllItem();//查询
    List<Inventory> getAllInventory();//查询

    void removeItemByItemId(String itemId);//删除
    void removeInventoryByItemId(String itemId);//删除IN

    boolean insertItemByItemid(Item item);//插入
    boolean insertInventory(Inventory inventory);//插入

}
