package assignment.entity;

import assignment.adt.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopList {
    Database db = new Database();
    ResultSet sr = db.runQuery("SELECT COUNT(*) FROM shop");
    String[] shopNameList;
    ResultSet rs = db.runQuery("SELECT * FROM SHOP");
    ArrayList shopArrayList = new ArrayList();
    LinkedList<Shop> shopList = new LinkedList<Shop>();
    public ShopList() throws SQLException {
        int i = 0;
        while(sr.next()){
            shopNameList = new String[sr.getInt(1)];
            break;
        }

        while(rs.next()) {
            shopList.add(new Shop(
                    rs.getInt("id"),
                    rs.getInt("fk_city_id"),
                    rs.getString("shop_name"),
                    rs.getString("shop_category"),
                    rs.getString("shop_address"))
            );
            shopArrayList.add(new Shop(
                    rs.getInt("id"),
                    rs.getInt("fk_city_id"),
                    rs.getString("shop_name"),
                    rs.getString("shop_category"),
                    rs.getString("shop_address"))
            );
            shopNameList[i] = rs.getString("shop_name");
            i++;
        }

    }

    public ArrayList getShopArrayList() {
        return shopArrayList;
    }

    public void setShopArrayList(ArrayList shopArrayList) {
        this.shopArrayList = shopArrayList;
    }

    public String[] getShopNameList() {
        return shopNameList;
    }

    public void setShopNameList(String[] shopNameList) {
        this.shopNameList = shopNameList;
    }

    public LinkedList<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(LinkedList<Shop> shopList) {
        this.shopList = shopList;
    }


    public void sortByDesc() {
        // sort by desc algorithm 

        int shopID = 1;
        int listSize = shopList.getNumberOfEntries();
        LinkedStack<Shop> tempStack = new LinkedStack();

        while (tempStack.getSize() != listSize) {
            for (int i = 0; i < listSize; i++) {
                if (shopList.getEntry(i + 1).getShop_id() == shopID) {
                    tempStack.push(shopList.getEntry(i + 1));
                }
            }
            shopID++;
        }
        String displayStr = "Shop ID\t Shop Name\t Shop Category\t\t\t\tShop Address\n";
        int queueSize = tempStack.getSize();
        for (int i = 0; i < queueSize; i++) {
            Shop item = tempStack.pop();

            displayStr += String.format("%7d %-12s %-40s %30s\n",item.getShop_id(),item.getShop_name(),item.getShop_category(),item.getShop_address());

        }
        System.out.println(displayStr);
    }

    public void sortByAsc() {
        // sort by asc algorithm 
        int shopID = 1;
        int listSize = shopList.getNumberOfEntries();

        CircularLinkedQueue<Shop> tempQueue = new CircularLinkedQueue();

        while (tempQueue.getSize() != listSize) {
            for (int i = 0; i < listSize; i++) {

                if (shopList.getEntry(i + 1).getShop_id() == shopID) {
                    tempQueue.enqueue(shopList.getEntry(i + 1));
                }
            }
            shopID++;
        }
        String displayStr = "Shop ID\t Shop Name\t Shop Category\t\t\t\tShop Address\n";
        int queueSize = tempQueue.getSize();
        for (int i = 0; i < queueSize; i++) {
            Shop item = tempQueue.dequeue();

            
            displayStr += String.format("%7d %-12s %-40s %30s\n",item.getShop_id(),item.getShop_name(),item.getShop_category(),item.getShop_address());

        }
        System.out.println(displayStr);
    }

    /*public void searchResultStack() {
        // sort by desc algorithm 

         LinkedStack<Shop> tempStack = new LinkedStack();
         String displayStr = "Recent Search :";

        while (!tempStack.isEmpty()) 
              
            for (int i = 0; i < tempStack.getSize(); i++) {
                    tempStack.pop();
                
            }
        }
    }
  */  

}

