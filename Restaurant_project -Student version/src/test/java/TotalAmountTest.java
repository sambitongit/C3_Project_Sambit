import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalAmountTest {

    LocalTime openingTime = LocalTime.parse("10:30:00");
    LocalTime closingTime = LocalTime.parse("22:00:00");
    Restaurant restaurant = new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);

    @Test
    public void return_total_amount_0_when_nothing_is_selected(){
        List<String> items = new ArrayList<>();
        assertEquals(0,restaurant.getTotalAmount(items));
    }

    @Test
    public void return_total_amount_119_when_sweet_corn_soup_is_selected(){
        restaurant.addToMenu("Sweet Corn Soup",119);
        List<String> items = new ArrayList<>();
        items.add("Sweet Corn Soup");
       assertEquals(119,restaurant.getTotalAmount(items));
    }

    @Test
    public void return_total_amount_388_if_selected_items_are_sweet_corn_and_Vegetable_lasagne(){
        restaurant.addToMenu("Sweet Corn Soup",119);
        List<String> items = new ArrayList<>();
        items.add("Sweet Corn Soup");
        items.add("Vegetable lasagne");
        assertEquals(388,restaurant.getTotalAmount(items));
    }

    @Test
    public void return_total_amount_707_if_all_three_items_are_selected(){
        restaurant.addToMenu("Sweet Corn Soup",119);
        List<String> items = new ArrayList<>();
        items.add("Sweet Corn Soup");
        items.add("Vegetable lasagne");
        items.add("Sizzling brownie");
        assertEquals(707,restaurant.getTotalAmount(items));
    }
}
