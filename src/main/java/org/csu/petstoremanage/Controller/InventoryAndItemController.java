package org.csu.petstoremanage.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.csu.petstoremanage.domain.Inventory;
import org.csu.petstoremanage.domain.Item;
import org.csu.petstoremanage.service.InventoryAndItemService;

import org.csu.petstoremanage.domain.InventoryAndItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/Item")
public class InventoryAndItemController {
    @Autowired
    InventoryAndItemService inventoryAndItemService;
    @GetMapping("/viewItem")
    public String viewSignin(Model model){
       List<InventoryAndItem> inventoryAndItems= inventoryAndItemService.getAllInventoryAndItem();
        System.out.println(inventoryAndItems.size());
        model.addAttribute("IAIList",inventoryAndItems);//查找相应数据
        return "item/item";
    }


    //            @RequestParam String itemId,
//                             @RequestParam String productid,
//                             @RequestParam BigDecimal listPrice,
//                             @RequestParam BigDecimal unitCost,
//                             @RequestParam int supplierId,
//                             @RequestParam String attr1,
//                             @RequestParam int qty,
//                             @RequestParam int qty_sold,
//                             @RequestParam int qty_pre,
//                             @RequestParam int qty_order,
//            InventoryAndItem inventoryAndItem,


    @GetMapping("/changeItem")
    public String changeItem(Model model){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String itemId =request.getParameter("item.itemId");
        int qty = Integer.valueOf(request.getParameter("inventory.qty"));
        int qty_sold=Integer.valueOf(request.getParameter("inventory.qty_sold"));
        int qty_order=Integer.valueOf(request.getParameter("inventory.qty_order"));
        String attr1=request.getParameter("item.attribute1");
        int qty_pre=Integer.valueOf(request.getParameter("inventory.qty_pre"));
        int supplierId =Integer.valueOf(request.getParameter("item.supplierId"));
        String productid =request.getParameter("item.productId");
        BigDecimal listPrice=BigDecimal.valueOf(Double.valueOf(request.getParameter("item.listPrice")));
        BigDecimal unitCost =BigDecimal.valueOf(Double.valueOf(request.getParameter("item.unitCost")));
        Inventory inventory=new Inventory(itemId,qty,qty_sold,qty_pre,qty_order);
        Item item=new Item(itemId,productid,listPrice,unitCost,supplierId,attr1);
        InventoryAndItem inventoryAndItem=new InventoryAndItem();
        inventoryAndItem.setInventory(inventory);
        inventoryAndItem.setItem(item);
        inventoryAndItemService.updateInventoryAndItem(inventoryAndItem);//更新数据
        System.out.println(listPrice);
        List<InventoryAndItem> inventoryAndItems= inventoryAndItemService.getAllInventoryAndItem();
        System.out.println(inventoryAndItems.size());
        model.addAttribute("IAIList",inventoryAndItems);//查找相应数据
        return "item/item";
    }
    @GetMapping("/insertItem")
    public String insertItem( Model model){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String itemId =request.getParameter("item.itemId");
        int qty = Integer.valueOf(request.getParameter("inventory.qty"));
        int qty_sold=Integer.valueOf(request.getParameter("inventory.qty_sold"));
        int qty_order=Integer.valueOf(request.getParameter("inventory.qty_order"));
        String attr1=request.getParameter("item.attribute1");
        int qty_pre=Integer.valueOf(request.getParameter("inventory.qty_pre"));
        int supplierId =Integer.valueOf(request.getParameter("item.supplierId"));
        String productid =request.getParameter("item.productId");
        BigDecimal listPrice=BigDecimal.valueOf(Double.valueOf(request.getParameter("item.listPrice")));
        BigDecimal unitCost =BigDecimal.valueOf(Double.valueOf(request.getParameter("item.unitCost")));
        Inventory inventory=new Inventory(itemId,qty,qty_sold,qty_pre,qty_order);
        Item item=new Item(itemId,productid,listPrice,unitCost,supplierId,attr1);
        InventoryAndItem inventoryAndItem=new InventoryAndItem();
        inventoryAndItem.setInventory(inventory);
        inventoryAndItem.setItem(item);
        inventoryAndItemService.inserInventoryAndItem(inventoryAndItem);//插入需要插入的元素
        List<InventoryAndItem> inventoryAndItems= inventoryAndItemService.getAllInventoryAndItem();
        System.out.println(inventoryAndItems.size());
        model.addAttribute("IAIList",inventoryAndItems);//查找相应数据
        return "item/item";
    }
    @GetMapping("/deleteItem")
    public String deleteItem(String itemid,Model model){
        inventoryAndItemService.removeInventoryAndItem(itemid);//删除所选的id
        List<InventoryAndItem> inventoryAndItems= inventoryAndItemService.getAllInventoryAndItem();
        System.out.println(inventoryAndItems.size());
        model.addAttribute("IAIList",inventoryAndItems);//查找相应数据
        return "item/item";
    }


}
