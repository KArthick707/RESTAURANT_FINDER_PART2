import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public final LocalTime openingTime;
    public final LocalTime closingTime;
    private final String name;
    private final String location;
    private final List<Item> menu = new ArrayList<>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen(LocalTime localTime) {
        return !getCurrentTime(localTime).isAfter(this.closingTime);
    }

    public LocalTime getCurrentTime(LocalTime localTime) {
        if (localTime == null) {
            return LocalTime.now();
        }
        return localTime;
    }

    public List<Item> getMenu() {
        return this.menu;
    }

    private Item findItemByName(String itemName) {
        for (Item item : menu) {
            if (item.getName().equals(itemName)) return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
    }

    public void removeFromMenu(String itemName) throws itemNotFoundException {
        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null) throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    public void displayDetails() {
        System.out.println(
                "Restaurant:"
                        + name
                        + "\n"
                        + "Location:"
                        + location
                        + "\n"
                        + "Opening time:"
                        + openingTime
                        + "\n"
                        + "Closing time:"
                        + closingTime
                        + "\n"
                        + "Menu:"
                        + "\n"
                        + getMenu());
    }

    public String getName() {
        return name;
    }
}