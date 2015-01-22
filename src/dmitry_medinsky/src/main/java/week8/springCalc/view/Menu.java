package week8.springCalc.view;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import week8.springCalc.domain.Operation;
import week8.springCalc.service.OperService;
import week8.springCalc.service.OperServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Дмитрий on 12.03.14.
 */
public class Menu {

        private static final int EXIT_ITEM = 0;
        private static final int SHOW_ALL_OPER_ITEM = 1;
        private static final int ADD_NEW_OPER_ITEM = 2;

        private OperServiceImpl operService;
        private Scanner scan;

        public Menu() {
            scan = new Scanner(System.in);
        }

        public Menu(OperServiceImpl operService) {
            this.operService = operService;

        }

    public void main() {
        int choise = EXIT_ITEM;

        do {
            showMenu();
            choise = getInput();

            switch (choise) {
                case EXIT_ITEM:
                    System.exit(0);
                    break;
                case SHOW_ALL_OPER_ITEM:
                    showAllOper();
                    break;
                case ADD_NEW_OPER_ITEM:
                    addNewOper();

            }
        } while (choise != EXIT_ITEM);

    }

    private void showAllOper() {
//        for (Operation oper : operService.getAllOper()) {
//            System.out.println(oper);
//        }
    }

    private void addNewOper() {
        System.out.println("Input name operation");
        String nameOper = scan.nextLine();
        System.out.println("Input code operation");
        String codeOper = scan.nextLine();
        Operation oper = new Operation(null, nameOper, codeOper);
        System.out.println("Added operation " + oper);
        operService.addNewOper(oper);
    }


    private int getInput() {
        int res = -1;
        String inputStr = "1";
        try {
            res = Integer.parseInt(inputStr);
        } catch (NumberFormatException nfe) {
            System.out.println("String " + inputStr + " is not a number");
        }

        return res;
    }

    public void showMenu() {
        System.out.println("Calculator");
        System.out.println("1. Show all operation");
        System.out.println("2. Add new user");
        System.out.println("0. Exit");
    }
}
