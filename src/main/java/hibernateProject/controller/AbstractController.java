package hibernateProject.controller;

import hibernateProject.view.ViewTotal;

import java.util.Scanner;

public abstract class AbstractController {
    protected ViewTotal viewTotal = new ViewTotal();
    protected static final Scanner SCANNER = new Scanner(System.in);

    public void startMenu()  {
        while (true) {
            viewTotal.printMainMenu();
            int menuNumber = viewTotal.inputChoice();
            if (menuNumber == 0) {
                break;
            }
            choiceOfMenu(menuNumber);
        }
    }
    protected abstract void choiceOfMenu(int menuNumber);
}
