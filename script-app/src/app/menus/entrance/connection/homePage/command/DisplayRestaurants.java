package app.menus.entrance.connection.homePage.command;

import app.Navigator;
import app.menus.Menu;
import data.Restaurants;

import java.sql.*;
import java.util.NavigableMap;

public class DisplayRestaurants extends Menu {

    private DisplayMode displayMode;

    public enum DisplayMode {
        Rating,
        Categories,
        Schedule,
    }

    private class RestaurantHolder {
        public String email;
        public String name;

        public RestaurantHolder(String email, String name) {
            this.email = email;
            this.name = name;
        }
    }

    public DisplayRestaurants(DisplayMode mode) {
        super("Restaurants");
        displayMode = mode;
    }


    public void execute() {
        System.out.println("Liste des restaurants :\n\n");
        switch(displayMode) {
            case Rating : {
                // get restaurants
                int index = 0;
                int blockSize = 10;
                boolean displayRestaurants = true;
                RestaurantHolder[] restaurantHolders = new RestaurantHolder[blockSize];
                while(displayRestaurants) {
                    ResultSet restaurants = Restaurants.getRestaurants(index, blockSize);
                    try {
                        // build the restaurant display
                        int counter = 0;
                        while(restaurants.next() && counter < blockSize) {
                            restaurantHolders[counter] = new RestaurantHolder(restaurants.getString(2), restaurants.getString(1));
                            counter++;
                        }
                        // display the restaurant
                        System.out.println("Page " + index + "\n");
                        for(int i = 0; i < blockSize; i++) {
                            if(restaurantHolders[i] != null) {
                                System.out.println(" " + i + ". " + restaurantHolders[i].name);
                            }
                        }
                        System.out.println("\n " + counter + ". page précédente\n " + (counter + 1) + ". page suivante\n " + (counter + 2) + ". retour");
                        int input = Navigator.getNextChoice(counter + 3);
                        if(input == counter) {
                            // go back to prev page
                            if(index > 0) {
                                index -= 1;
                            }
                        }
                        else if(input == counter + 1) {
                            // go to next page
                            index++;
                        }
                        else if(input == counter + 2) {
                            // go back
                            displayRestaurants = false;
                            Navigator.popMenu();
                        }
                        else {
                            // go to selected restaurant
                            displayRestaurants = false;
                            Navigator.pushMenu(new Restaurant(restaurantHolders[input].email, restaurantHolders[input].name));
                        }
                    }
                    catch(SQLException e) {
                        displayRestaurants = false;
                        System.out.println("Le serveur a rencontré une erreur interne.");
                    }
                }
            }
        }
    }  
}
