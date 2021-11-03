package com.dmitry;

import com.dmitry.DataStructs.MyLinkedList;
import com.dmitry.UI.CLI.CommandLineInterface;

public class Main {

    public static void main(String[] args) {
	// write your code here
        if(args[0].equals("CLI")) {
            CommandLineInterface cli = new CommandLineInterface();
        }
    }
}
