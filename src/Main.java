import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Simulation simulation = new Simulation();












        System.out.println("Loading phase 1...");
        ArrayList<Item> arrItem1 = simulation.loadItems("phase-1.txt");  //load phase1




        System.out.println("Loading phase 2..."+"\n");
        ArrayList<Item> arrItem2 = simulation.loadItems("phase-2.txt"); //load phase 2



        System.out.println("Loading U1 rockets for phase 1...");
        ArrayList<Rocket> arrU1phase1 = simulation.loadU1(arrItem1);
        System.out.println("Number of U1 rockets loaded: "+arrU1phase1.size()+"\n");


        System.out.println("Loading U1 for phase 2...");
        ArrayList<Rocket> arrU1phase2 = simulation.loadU1(arrItem2);
        System.out.println("Number of U1 rockets loaded: "+arrU1phase2.size()+"\n");


        System.out.println("Running simulation U1-phase1...");
        double totBudU1phase1 = simulation.runSimulation(arrU1phase1);
        System.out.println("Total budget U1 phase 1 "+totBudU1phase1+"\n");

        System.out.println("Running simulation U1-phase2...");
        double totBudU1phase2 = simulation.runSimulation(arrU1phase2);
        System.out.println("Total budget U1 phase 2 "+totBudU1phase2+"\n");




        System.out.println("Loading U2 for phase 1...");
        ArrayList<Rocket> arrU2phase1 = simulation.loadU2(arrItem1);
        System.out.println("Number of U2 rockets loaded: "+arrU2phase1.size()+"\n");


        System.out.println("Loading U2 for phase 2...");
        ArrayList<Rocket> arrU2phase2 = simulation.loadU2(arrItem2);
        System.out.println("Number of U2 rockets loaded: "+arrU2phase2.size()+"\n");


        System.out.println("Running simulation U2-phase1...");
        double totBudU2phase1 = simulation.runSimulation(arrU2phase1);
        System.out.println("Total budget U2 phase 1 "+totBudU2phase1+"\n");

        System.out.println("Running simulation U2-phase2...");
        double totBudU2phase2 = simulation.runSimulation(arrU2phase2);
        System.out.println("Total budget U2 phase 2 "+totBudU2phase2);












    }


}
