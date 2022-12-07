package app;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

import app.menus.Menu;

/**
 * Class for menu navigation.
 */
public class Navigator {

    private static Stack<Menu> menus = new Stack<>();
    private static Scanner inputScanner = new Scanner(System.in);

    private static void displayPath() {
        System.out.println("");

        for(Menu menu: menus) {
            System.out.print(" > " + menu.name());
        }

        System.out.println("");
    } 

    /**
     * Adds a menu to the navigation.
     * This is like navigating to the given menu, and display it.
     * @param menu The menu we want to navigate to.
     */
    public static void pushMenu(Menu menu) {
        menus.push(menu);
        displayPath();
        menu.execute();
    }

    /**
     * Removes the last menu. This is like going back to the previous menu.
     */
    public static void popMenu() {
        menus.pop();
        if(menus.size() > 0) {
            displayPath();
            menus.lastElement().execute();
        }
    }

    /**
     * Display again the last menu element.
     * This can be used for input failure for example.
     */
    public static void reRoll() {
        if(menus.size() > 0) {
            menus.lastElement().execute();
        }
    }

    /**
     * Reset the list of menus and put the given menu as new first menu
     */
    public static void reset(Menu newRoot) {
        menus = new Stack<>();
        menus.push(newRoot);
        newRoot.execute();
    }

    /**
     * Get the user input as an integer. This is used for menu navigation and choices.
     * @param choiceNumber The max allowed input (exclusive).
     * @return The user input.
     */
    public static int getNextChoice(int choiceNumber) {
        while(true) {
            try {
                int result = inputScanner.nextInt();
                if(result < choiceNumber) {
                    // consume the \n not consumed by next int
                    inputScanner.nextLine();
                    return result;
                }
                else {
                    System.out.println("Veuillez entrer un nombre compris entre zéro et " + choiceNumber + " (exclusif).");
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Veuillez entrer un nombre entier.");
            }
            catch(Exception e) {
                System.out.println("System was exited : closing.");
                return 0;
            }
        }
    }

    /**
     * Read the next line of the input.
     * @return The user next line.
     */
    public static String getNextLine() {
        while(true) {
            try {
                return inputScanner.nextLine();
            }
            catch(Exception e) {
                System.out.println("System was exited : closing.");
                return "";
            }
        }
    }


}
