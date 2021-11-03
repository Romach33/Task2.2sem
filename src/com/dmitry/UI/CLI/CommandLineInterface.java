package com.dmitry.UI.CLI;

import com.dmitry.DataStructs.MyLinkedList;

import java.util.Scanner;

public class CommandLineInterface {
    private Scanner input;

    private MyLinkedList<Integer> firstLL;
    private MyLinkedList<Integer> secondLL;

    private void helpCall() {
        System.out.println(" LINKED LIST RANDOMIZER ");
        System.out.println();
        System.out.println("Usage:");
        System.out.println("'help' - calls help");
        System.out.println("'generateLL' - generates basic LL from 1 to 10");
        System.out.println("'insertLL' - u can insert ur own LL, obviously");
        System.out.println("'randomLL' - u can randomly snuffle this LL");
        System.out.println("'cardRandLL' - u can snuffle elements'");
        System.out.println("'exit' - u can shutdown app");
    }

    private void genLLCall() {
        firstLL = new MyLinkedList<>();
        MyLinkedList<Integer> current = new MyLinkedList<>();
        for (int i = 1; i < 11; i++) {
            current.addLast(i);

        }
        System.out.println(current.toString());
        firstLL = current;
    }

    private void insLLCall() {
        MyLinkedList<Integer> current = new MyLinkedList<>();
        System.out.print("ur inline array with ' ' split> ");
        String insertable = input.nextLine();
        for (int i = 0; i < insertable.split(" ").length; i++) {
            current.addLast(Integer.parseInt(insertable.split(" ")[i]));
            System.out.print("a[" + (i+1) + "]= " + current.getValue(i) + "  ");
        }
        firstLL = current;
    }

    private void randomLL(){
        firstLL.randomMe();

        System.out.println("randomized: ");
        System.out.println(firstLL.toString());
    }

    private void cardRLL() {
        firstLL.randomMeCard();

        System.out.println("randomized: ");
        System.out.println(firstLL.toString());
    }

    public CommandLineInterface() {
        helpCall();
        input = new Scanner(System.in);

        System.out.print("> ");
        String inp = input.nextLine();
        for (; !inp.equals("exit") ;) {
            switch (inp) {
                case "help":
                    helpCall();
                    break;
                case "generateLL":
                    genLLCall();
                    break;
                case "insertLL":
                    insLLCall();
                    break;
                case "randomLL":
                    randomLL();
                    break;
                case "cardRandLL":
                    cardRLL();
                    break;
            }
            System.out.print("> ");
            inp = input.nextLine();
        }
    }
}
