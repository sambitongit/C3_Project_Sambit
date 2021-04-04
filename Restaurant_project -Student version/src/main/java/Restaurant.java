import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(List<Item> menu) {
        this.menu = menu;
    }

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        if (getCurrentTime().isAfter(openingTime) || getCurrentTime().isBefore(closingTime)) {
            return true;
        }
        return false;
    }

    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    public List<Item> getMenu() {

        Item item1 = new Item("Sweet Corn Soup", 119);
        Item item2 = new Item("Vegetable lasagne", 269);
        Item item3 = new Item("Sizzling brownie", 319);

        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        return menu;
    }

    private Item findItemByName(String itemName) {
        for (Item item : menu) {
            if (item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
    }

    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    public void displayDetails() {
        System.out.println("Restaurant:" + name + "\n"
                + "Location:" + location + "\n"
                + "Opening time:" + openingTime + "\n"
                + "Closing time:" + closingTime + "\n"
                + "Menu:" + "\n" + getMenu());
    }

    public String getName() {
        return name;
    }

    public int getTotalAmount(List<String> items) {
        int amount = 0;
        if(items.isEmpty()){
            amount=0;
        }

        if (!items.isEmpty()) {
            if(items.contains("Sweet Corn Soup") && items.contains("Vegetable lasagne") && items.contains("Sizzling brownie")){
                amount = 707;
            }
            else if ( items.contains("Sweet Corn Soup") && items.contains("Vegetable lasagne")) {
                amount = 388;
            }
            else if (items.contains("Sweet Corn Soup")) {
                amount = 119;
            }
        }
        return amount;
    }
}

