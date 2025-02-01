import java.util.ArrayList;
import java.util.Scanner;

class MenuOption {
    private String description;
    private Runnable action;

    MenuOption(String description, Runnable action) {
        this.description = description;
        this.action = action;
    }

    public Runnable getAction() {
        return action;
    }

    public String getDescription() {
        return description;
    }
}

public class App {
    private boolean running = true; // Indicator for program's running state

    private int[] array = null; // TODO: methods should manipulate this array

    public static void main(String[] args) throws Exception {
        new App().appHandler(args);
    }

    private void printMenu(ArrayList<MenuOption> optionList) {
        for (int optionId = 0; optionId < optionList.size(); optionId++) {
            MenuOption option = optionList.get(optionId);
            System.out.printf("%d. %s\n", optionId + 1, option.getDescription());
        }
    }

    // Create array (aka a.)
    private void createArray() {

    }

    // Print min and max of array(aka c.)
    private void minMaxOfArray() {

    }

    // Find the average of array and print the distances of all elements to (aka d.)
    private void findAverageAndDistances() {

    }

    // Find sums of even and odd indexed elements (aka e.)
    private void sumsOddEven() {

    }

    // Handle the exit condition
    private void handleExit() {
        System.err.printf("Exiting the app.\n");
        running = false;
    }

    // Handler for the main event loop
    private void appHandler(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<MenuOption> optionList = new ArrayList<>();
        optionList.add(new MenuOption("Create new array with inputted size", this::createArray));
        optionList.add(new MenuOption("Find the array's minimum and maximum", this::minMaxOfArray));
        optionList.add(new MenuOption("Find the average of the array and the distances of elements to the average",
                this::findAverageAndDistances));
        optionList
                .add(new MenuOption("Find the sums of odd and even indexed elements respectively", this::sumsOddEven));
        optionList.add(new MenuOption("Exit the app", this::handleExit));

        while (running) {
            printMenu(optionList);
            System.out.printf("Please select an option: ");
            while (!in.hasNextInt()) {
                in.next();
            }
            int selectedId = in.nextInt() - 1;
            if (selectedId < 0 || selectedId >= optionList.size()) {
                System.err.printf("[ERROR] Please input a valid option\n");
                continue;
            }
            MenuOption selectedOption = optionList.get(selectedId);
            selectedOption.getAction().run();
        }
        in.close();
    }
}
