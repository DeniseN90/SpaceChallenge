
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Simulation {



    /*  this method takes a string as parameter, creates a file object,
     * reads the file, and creates Items accordingly,
     * which are than sored in the array
     */

    /**
     * Creates an ArrayList of Item
     * @param file the .txt file
     * @return itemList ArrayList<Item>
     */



    public ArrayList loadItems (String file) {
        ArrayList<Item> itemList = new ArrayList<>();

        File itemFile = new File(file);

        Scanner scanner  = null;

        try{
            scanner = new Scanner(itemFile);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String [] oneItem = line.split("=");
            itemList.add(new Item(oneItem[0],Integer.parseInt(oneItem[1])));
        }


            return itemList;
    }



    /* This method takes the ArrayList of <Item> returned from
     * loadItems and creates U1 rockets. It fills them up with
     * Items. Returns an ArrayList<U1>.
     */

    /**
     * Creates an ArrayList of U1 Rockets
     * @param list ArrayList<Item>
     * @return fleet ArrayList<U1>
     */

    public ArrayList<Rocket>loadU1(ArrayList<Item>list){
        ArrayList<Rocket> fleet = new ArrayList<>();
        int totalBudget = 0;
        Rocket U1Rocket = new U1();

        for(Item item:list){
            while(!U1Rocket.canCarry(item)){

                fleet.add(U1Rocket);
                U1Rocket = new U1();
            }
            U1Rocket.carry(item);


        }

        return fleet;
    }

    /* This method takes the ArrayList of <Item> returned from
     * loadItems and creates U2 rockets. It fills them up with
     * Items. Returns an ArrayList<U1>.
     */

    /**
     * Creates an ArrayList of U2 Rockets
     * @param list ArrayList<Item>
     * @return fleet ArrayList<U2>
     */

    public ArrayList<Rocket>loadU2(ArrayList<Item>list){
        ArrayList<Rocket> fleet = new ArrayList<>();
        int totalBudget = 0;
        Rocket U2Rocket = new U2();

        for(Item item:list){
            while(!U2Rocket.canCarry(item)){
                fleet.add(U2Rocket);
                U2Rocket = new U2();
            }
            U2Rocket.carry(item);

        }
        return fleet;
    }


    /* This method takes an ArrayList<Rocket> and calls
     * the launch/land methods for each rocket.
     * If the rocket explodes it will send another
     * rocket. The  return the total budget spent.
     */

    /**
     * Takes each rocket in the array and
     * calls the land() and lauch() methods for each.
     * Updates the total budget. Gives the number of failed rockets.
     * @param list ArrayList<Rocket>
     * @return double totalBudget
     */




    public double runSimulation(ArrayList<Rocket>list){
        int totalBudget = 0;
        int sentRocket = 0;
        int explodedRocket= 0;
        int successRocket = 0;
            for(Rocket rocket:list){
                if(!rocket.launch() || !rocket.land()) {
                    sentRocket++;
                    explodedRocket++;
                    totalBudget += rocket.rocketCost;
                } else {
                    sentRocket++;
                    successRocket++;
                    totalBudget += rocket.rocketCost;
                }
            }

        System.out.println("Total number of rockets sent "+sentRocket);
        System.out.println("Total number of exploded rockets "+explodedRocket);

        return totalBudget;

    }












}
