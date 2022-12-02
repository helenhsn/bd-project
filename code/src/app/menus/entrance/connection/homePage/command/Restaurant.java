package app.menus.entrance.connection.homePage.command;

import app.menus.Menu;

public class Restaurant extends Menu {

    String email; // useful for requests ?

    public Restaurant(String email, String nom){
        super(nom);
        this.email = email;
    }

    public void execute() {
        
    }
}
