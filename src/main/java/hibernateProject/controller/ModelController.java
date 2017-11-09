package hibernateProject.controller;

public abstract class ModelController extends AbstractController{

    @Override
    public void startMenu()  {
        while (true) {
            viewTotal.printControllerMenu();
            int menuNumber = viewTotal.inputChoice();
            if (menuNumber == 0) {
                break;
            }
            choiceOfMenu(menuNumber);
        }
    }
}
