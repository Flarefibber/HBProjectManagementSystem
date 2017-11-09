package hibernateProject;

import hibernateProject.controller.MainController;

public class Main {
    public static void main(String[] args) {
        try {
            new MainController().startMenu();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
