import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        for (Restaurant restaurant : restaurants) {
            try {
                if (restaurant.getName().equals(restaurantName))
                    return restaurant;
                else {
                    System.out.println("Error: Restaurant not found");
                    throw new restaurantNotFoundException(restaurantName);
                }
            } catch (Exception e) {
            }
        }
        throw new restaurantNotFoundException(restaurantName);
    }

        public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
