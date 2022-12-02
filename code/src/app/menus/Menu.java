package app.menus;

/**
 * Abstract class for menu.
 */
public abstract class Menu {
    /**
     * The name of the menu is the display name in the path.
     */
    private String name;
    public Menu(String name) {
        this.name = name;
    }

    /**
     * Displays the menu to the console.
     */
    public abstract void execute();

    /**
     * Getter for the menu name.
     * @return the name of the menu.
     */
    public String name() {
        return name;
    }
}
