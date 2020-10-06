package assignment;

import assignment.entity.*;
import assignment.adt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void indexingModule(Database db, Scanner sc) throws SQLException {

        for (int count = 0; count < 10; count++) {
            long startTime = System.nanoTime();
            //    Class.forName("com.mysql.jdbc.Driver");
            ResultSet countShop = db.runQuery("SELECT COUNT(*) FROM shop");
            ResultSet countCity = db.runQuery("SELECT COUNT(*) FROM city");
            ResultSet countState = db.runQuery("SELECT COUNT(*) FROM state");
            ResultSet rsShop = db.runQuery("SELECT * FROM shop");
            ResultSet rsCity = db.runQuery("SELECT * FROM city");
            ResultSet rsState = db.runQuery("SELECT * FROM state");

            countCity.next();
            countShop.next();
            countState.next();

            Shop[] shop = new Shop[countShop.getInt(1)];
            City[] city = new City[countCity.getInt(1)];
            State[] state = new State[countState.getInt(1)];

            DictionaryInterface<Integer, City> cityTable = new HashedDictionary<Integer, City>(countCity.getInt(1));
            DictionaryInterface<Integer, State> stateTable = new HashedDictionary<Integer, State>(countState.getInt(1));
            DictionaryInterface<Integer, Shop> shopTable = new HashedDictionary<Integer, Shop>(countShop.getInt(1));
            int i = 0, j = 0, k = 0;
            int cityKey = 1000, shopKey = 2000, stateKey = 3000;
            while (rsShop.next()) {
                shop[i] = new Shop(rsShop.getInt("id"), rsShop.getInt("fk_city_id"), rsShop.getString("shop_name"), rsShop.getString("shop_category"), rsShop.getString("shop_address"));
                shopTable.add(shopKey, shop[i]);
                shopKey++;
                i++;
            }
            while (rsCity.next()) {
                city[j] = new City(rsCity.getInt("id"), rsCity.getInt("fk_state_id"), rsCity.getString("city_name"), rsCity.getInt("city_postcode"));
                cityTable.add(cityKey, city[j]);
                cityKey++;
                j++;
            }
            while (rsState.next()) {
                state[k] = new State(rsState.getInt("id"), rsState.getString("state_name"));
                stateTable.add(stateKey, state[k]);
                stateKey++;
                k++;
            }

            System.out.println("Menu:");
            System.out.println("1.Listing");
            System.out.println("2.Searching");
            int select = sc.nextInt();
            switch (select) {
                case 1: {
                    System.out.println("1: City Listing\n2: State Listing\n3: Shop Listing");
                    int select2 = sc.nextInt();
                    switch (select2) {
                        case 1: {
                            System.out.println("\nCityTable: \n" + cityTable);
                            System.out.println("Total entries = " + cityTable.getSize());
                            long endTime = System.nanoTime();
                            long runTime = endTime - startTime;
                            System.out.println("The running time in round" + count + "is :" + runTime+ "ns.");

                            break;
                        }
                        case 2: {
                            System.out.println("\nStateTable: \n" + stateTable);
                            System.out.println("Total entries = " + stateTable.getSize());

                            break;
                        }
                        case 3: {
                            System.out.println("\nShopTable: \n" + shopTable);
                            System.out.println("Total entries = " + shopTable.getSize());
                            break;
                        }
                        default: {
                            System.out.println("Error selection");
                        }
                    }
                }

                case 2: {
                    System.out.println("1: Search City \n2: Search State\n3: Search Shop");
                    int select3 = sc.nextInt();
                    switch (select3) {
                        case 1: {
                            System.out.println("Search By CITY (1001):");
                            int cityId = sc.nextInt();
                            System.out.println(cityTable.getValue(cityId));
                            break;
                        }
                        case 2: {
                            System.out.println("Search By STATE (2001):");
                            int stateId = sc.nextInt();
                            System.out.println(stateTable.getValue(stateId));
                            break;
                        }
                        case 3: {
                            System.out.println("Search By SHOP ID(3001):");
                            int shopId = sc.nextInt();
                            System.out.println(shopTable.getValue(shopId));
                            break;
                        }
                        default: {
                            System.out.println("Invalid Selection");
                        }
                    }
                }

            }

        }
    }

    public static void filterModule(Database db, Scanner sc, LinkedStack prevSearch, ArrayList searchHistory) throws SQLException {
        // Filter Algorithm
        
        int input = -1;
        do {

            System.out.println("Search for shop name: ");
            String searchShop = sc.nextLine();
            prevSearch.push(searchShop);
            searchHistory.add(searchShop);

            System.out.println("Filter by category: ");
            String searchFilter = sc.nextLine(); // bosco
            ResultSet sr = db.runQuery("SELECT COUNT(*) FROM shop");
            Shop[] shops;
            sr.next();
            shops = new Shop[sr.getInt(1)];
            ResultSet rs = db.runQuery("SELECT * FROM SHOP");
            int i = 0;
            while (rs.next()) {
                shops[i] = new Shop(rs.getInt("id"), rs.getInt("fk_city_id"), rs.getString("shop_name"), rs.getString("shop_category"), rs.getString("shop_address"));
                i++;
            }

            // filter
            for (Shop s : shops) {
                if (s.getShop_name().toLowerCase().contains(searchShop) && s.getShop_category().toLowerCase().contains(searchFilter)) {
                    System.out.println(s.getShop_name() + "\t" + s.getShop_category());
                }
            }

            // display
            System.out.println("Display search history:");
            System.out.println("1. Previous search term");
            System.out.println("2. Search History");
            System.out.println("3. Search again");
            System.out.println("4. back to main");
            input = sc.nextInt();
            sc.nextLine();
            if(input == 1){
                System.out.println(prevSearch.pop());
            } else if (input == 2){
                for (int j = 0; j < searchHistory.size(); j++) {
                    System.out.println(searchHistory.getEntry(j + 1));
                }
            }
        } while (input != 4);
    }

    public static void checkDuplicateModule() throws SQLException {
        ShopList shopList = new ShopList();
        ArrayList shopArrayList = shopList.getShopArrayList();
        System.out.println(shopArrayList);
        shopArrayList.checkDuplicate();
        System.out.println(shopArrayList);
    }

    public static void sortModule(ShopList shopList, Scanner sc) throws SQLException {
        System.out.println("Sort by:");
        System.out.println("1. ASC");
        System.out.println("2. DESC");
        int input = sc.nextInt();
        sc.nextLine();
        if (input == 1) {
            shopList.sortByAsc();
        } else {
            shopList.sortByDesc();
        }
    }

    public static void binaryTree(ShopList shopList, Scanner sc) throws SQLException {
        System.out.println("Search for: ");
        String searchQ = sc.nextLine();
        SearchTreeInterface<String> bTree = new BinarySearchTree<String>();
        String[] shopNameList = shopList.getShopNameList();
        for (int i = 0; i < shopNameList.length; ++i) {
            System.out.println("\nAdding: " + shopNameList[i] + "...");
            bTree.add(shopNameList[i]);
            System.out.println("\nbTree contains: ");
            bTree.displayTree();
        }
        System.out.printf("\nbTree.contains(%s): " + bTree.contains(searchQ), searchQ);
        System.out.printf("\nbTree.getEntry(%s): " + bTree.getEntry(searchQ), searchQ);
        System.out.printf("\nbTree.remove(%s): " + bTree.remove(searchQ), searchQ);
        System.out.print("\nbTree contains      : ");
        bTree.displayTree();
    }

    public static void menu(String[] args, Database db, Scanner sc, LinkedStack prevSearch, ArrayList searchHistory, ShopList shopList) throws SQLException {
        //Start
        System.out.println("Modules");
        System.out.println("1. Search & Filter Module (search and list)");
        System.out.println("2. Duplicate Module (check duplicate)");
        System.out.println("3. Tree Search Module (Binary Tree Search)");
        System.out.println("4. Indexing Module (Add and Search new location with hashing)");
        System.out.println("5. Sorting Module (Sort objects based on criteria)");
        
        int input = sc.nextInt();
        sc.nextLine();
        switch (input) {
            case 1:
                filterModule(db, sc, prevSearch, searchHistory);
                menu(args, db, sc, prevSearch, searchHistory, shopList);
                break;
            case 2:
                checkDuplicateModule();
                menu(args, db, sc, prevSearch, searchHistory, shopList);
                break;
            case 3:
                binaryTree(shopList, sc);
                menu(args, db, sc, prevSearch, searchHistory, shopList);
                break;
            case 4:
                indexingModule(db, sc);
                menu(args, db, sc, prevSearch, searchHistory, shopList);
                break;
            case 5:
                sortModule(shopList, sc);
                menu(args, db, sc, prevSearch, searchHistory, shopList);
                break;
            case 6:
                System.exit(-1);
            default:
                main(args);
        }
    }
    
    public static void main(String[] args) throws SQLException {
        Database db = new Database();
        Scanner sc = new Scanner(System.in);
        ShopList shopList = new ShopList();
        LinkedStack<String> prevSearch = new LinkedStack<String>();
        ArrayList<String> searchHistory = new ArrayList<String>();
     
        menu(args, db, sc, prevSearch, searchHistory, shopList);
    }

}
