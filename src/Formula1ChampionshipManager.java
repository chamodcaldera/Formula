import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.io.*;
import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager {

    public static List<Formula1Driver> formula1Drivers = new ArrayList<>();
    public static List<Race> raceList = new ArrayList<>();

    @Override
    public void createDriver(Formula1Driver fDriver) {
        if (formula1Drivers.contains(fDriver)) {
            System.out.println("Driver already exist");
        } else {
            formula1Drivers.add(fDriver);
            System.out.println("Driver successfully added.");
            System.out.println(fDriver);
//            System.out.println(formula1Drivers);
        }
    }

    @Override
    public void deleteDriver(String fDriver) {                      //Delete f driver
        for (Formula1Driver fDrivername : formula1Drivers) {
            if (fDrivername.getName().equals(fDriver)) {
                formula1Drivers.remove(fDrivername);
                System.out.println("Driver successfully removed ");
                break;
            }
        }
    }

    @Override
    public void changeTheDriverForTeam(String fTeam, String newDriver) {            //Changing driver from the team
        for (Formula1Driver fDrivername : formula1Drivers) {
            if (fDrivername.getTeam().equals(fTeam)) {
                fDrivername.setName(newDriver);
            }
        }
    }

    @Override
    public void displayStatForDriver(String fDriver) {              //Display driver details when enter driver name
        for (Formula1Driver sClub : formula1Drivers) {
            if (sClub.getName().equals(fDriver)) {
                System.out.println(sClub);
                break;
            } else {
                System.out.println("Driver doesn't exist");
            }
        }
    }

    @Override

    //Display All stats in season on console

    public void displayStatInSeason() {
        Collections.sort(formula1Drivers);

        System.out.println("------------------------------------------------------------------------------------------" +
                "---------------------------------------------------------------------");
        System.out.printf("%10s %1s %12s %1s %2s %1s %10s %1s %5s %1s %5s %1s %5s %1s %5s %1s %5s %1s", "Driver Name", "|", "Driver Location", "|", "Driver Age",
                "|", "Driver Team", "|", "First Places", "|", "Second Places", "|", "Third Places Scored", "|", "Points", "|", "Num of Races", "|\n");
        System.out.println("------------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------------");

        for (Formula1Driver fD : formula1Drivers) {
            System.out.printf("%11s %1s %9s %7s %9s %2s %8s %4s %10s %3s %7s %7s %14s %6s %1s %5s %7s %6s %n",
                    fD.getName(), "|", fD.getLocation(), "|", fD.getAge(),
                    "|", fD.getTeam(), "|", fD.getNumOfFirstPos(), "|",
                    fD.getNumOfSecondPos(), "|", fD.getNumOfThirdPos(), "|",
                    fD.getNumOfPoints(), "|", fD.getNumOfRaces(), "|");

        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");


    }

    @Override
    public void addRace(Race race) {            //Function for Add new Race
        if (raceList.contains(race)) {
            System.out.println("race already exist");
        } else {
            raceList.add(race);
            System.out.println("Race successfully added.");

            for (Formula1Driver fDriver : formula1Drivers) {
                int points = 0;
                int numOfRace = 0;
                int numOfFirstPlaces = 0;
                int numOfSecondPlaces = 0;
                int numOfThirdPlaces = 0;


                if (fDriver.getName().equals(race.getFirstPosition())) {                //adding points by driver positions
                    points = fDriver.getNumOfPoints();
                    points += 25;
                    fDriver.setNumOfPoints(points);

                    numOfRace = fDriver.getNumOfRaces();
                    numOfRace += 1;
                    fDriver.setNumOfRaces(numOfRace);

                    numOfFirstPlaces = fDriver.getNumOfFirstPos();
                    numOfFirstPlaces += 1;
                    fDriver.setNumOfFirstPos(numOfFirstPlaces);
                } else if (fDriver.getName().equals(race.getSecondPosition())) {

                    points = fDriver.getNumOfPoints();
                    points += 18;
                    fDriver.setNumOfPoints(points);

                    numOfRace = fDriver.getNumOfRaces();
                    numOfRace += 1;
                    fDriver.setNumOfRaces(numOfRace);

                    numOfSecondPlaces = fDriver.getNumOfSecondPos();
                    numOfSecondPlaces += 1;
                    fDriver.setNumOfSecondPos(numOfSecondPlaces);
                } else if (fDriver.getName().equals(race.getThirdPosition())) {
                    points = fDriver.getNumOfPoints();
                    points += 15;
                    fDriver.setNumOfPoints(points);

                    numOfRace = fDriver.getNumOfRaces();
                    numOfRace += 1;
                    fDriver.setNumOfRaces(numOfRace);

                    numOfThirdPlaces = fDriver.getNumOfThirdPos();
                    numOfThirdPlaces += 1;
                    fDriver.setNumOfThirdPos(numOfThirdPlaces);
                } else if (fDriver.getName().equals(race.getFourthPosition())) {
                    numOfRace = fDriver.getNumOfRaces();
                    numOfRace += 1;
                    fDriver.setNumOfRaces(numOfRace);
                } else if (fDriver.getName().equals(race.getFifthPosition())) {
                    numOfRace = fDriver.getNumOfRaces();
                    numOfRace += 1;
                    fDriver.setNumOfRaces(numOfRace);

                } else if (fDriver.getName().equals(race.getSixthPosition())) {
                    numOfRace = fDriver.getNumOfRaces();
                    numOfRace += 1;
                    fDriver.setNumOfRaces(numOfRace);

                } else if (fDriver.getName().equals(race.getSeventhPosition())) {
                    numOfRace = fDriver.getNumOfRaces();
                    numOfRace += 1;
                    fDriver.setNumOfRaces(numOfRace);

                } else if (fDriver.getName().equals(race.getEightPosition())) {
                    numOfRace = fDriver.getNumOfRaces();
                    numOfRace += 1;
                    fDriver.setNumOfRaces(numOfRace);

                } else if (fDriver.getName().equals(race.getNinthPosition())) {
                    numOfRace = fDriver.getNumOfRaces();
                    numOfRace += 1;
                    fDriver.setNumOfRaces(numOfRace);

                } else if (fDriver.getName().equals(race.getTenthPosition())) {
                    numOfRace = fDriver.getNumOfRaces();
                    numOfRace += 1;
                    fDriver.setNumOfRaces(numOfRace);
                }
            }
        }

    }

    @Override
    public void writeAllData(String x) throws IOException {         //write formula1 championship data into file
        //create a file called FormulaChampionshipList
        File file = new File("FormulaChampionshipList.txt");

        FileOutputStream fo = new FileOutputStream(x);
        ObjectOutputStream o = new ObjectOutputStream(fo);

        for (Formula1Driver fDriver : formula1Drivers) {
            System.out.println(fDriver);
            o.writeObject(fDriver);
        }

        o.flush();
        o.close();
        fo.close();

    }

    @Override
    public void readAllData(String y) throws IOException {          //load formula1 championship data into program
        FileInputStream fi = new FileInputStream(y);
        ObjectInputStream ois = new ObjectInputStream(fi);

        for (; ; ) {
            try {
                Formula1Driver fDriver = (Formula1Driver) ois.readObject();
                formula1Drivers.add(fDriver);
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }
    }

    @Override
    public void writeRaceData(String x) throws IOException {            //write Race data into file
        File file = new File("FormulaChampionshipRaceList.txt");

        FileOutputStream fo = new FileOutputStream(x);
        ObjectOutputStream o = new ObjectOutputStream(fo);

        for (Race races : raceList) {
            System.out.println(races);
            o.writeObject(races);
        }

        o.flush();
        o.close();
        fo.close();


    }

    @Override
    public void readRaceData(String y) throws IOException {             //load Rcae data into program
        FileInputStream fi = new FileInputStream(y);
        ObjectInputStream ois = new ObjectInputStream(fi);

        for (; ; ) {
            try {
                Race race = (Race) ois.readObject();
                raceList.add(race);
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }
    }

    public void generateRace() {                // function for Generate race randomly

        Random randomGenerator = new Random();
        List<Formula1Driver> raceDrivers = new ArrayList<>();
        String firstPlace, secondPlace, thirdPlace, fourthPlace, fifthPlace, sixthPlace, seventhPlace, eightPlace, ninethPlace, tenthPlace;

        for (int i = 0; i < formula1Drivers.size(); i++) {
            raceDrivers.add(i, formula1Drivers.get(i));

        }


        Collections.shuffle(raceDrivers);

        if (raceDrivers.size() < 10) {
            int driversHave = raceDrivers.size();
            Formula1Driver fDriver = new Formula1Driver("null", "null", 0, "null", 0, 0, 0, 0, 0);

            for (int i = driversHave; i < 10; i++) {
                raceDrivers.add(i, fDriver);
            }
        }

        firstPlace = raceDrivers.get(0).getName();
        secondPlace = raceDrivers.get(1).getName();
        thirdPlace = raceDrivers.get(2).getName();
        fourthPlace = raceDrivers.get(3).getName();
        fifthPlace = raceDrivers.get(4).getName();
        sixthPlace = raceDrivers.get(5).getName();
        seventhPlace = raceDrivers.get(6).getName();
        eightPlace = raceDrivers.get(7).getName();
        ninethPlace = raceDrivers.get(8).getName();
        tenthPlace = raceDrivers.get(9).getName();

        int day = randomGenerator.nextInt(30) + 1;
        int month = randomGenerator.nextInt(11) + 1;

        int year=2021;
        Date randDate = new Date(day, month, year);

        for (int i = 0; i < raceDrivers.size(); i++) {
            System.out.println(raceDrivers.get(i));
        }
        Race randomRace = new Race(randDate, firstPlace, secondPlace, thirdPlace, fourthPlace, fifthPlace, sixthPlace, seventhPlace, eightPlace, ninethPlace, tenthPlace);
        addRace(randomRace);
        System.out.println(randomRace);
    }

    public void createTableModel() {            //Display race details in gui jtable2

        String[] header = {"Race Date", "First Place", "Second Place", "Third Place", "Fourth Place", "Fifth place", "sixth Place", "Seventh Place", "Eight Place","Ninth place","Tenth Place"};

        DefaultTableModel model1 = new DefaultTableModel(header,0);
        System.out.println(raceList.size());

        for (int i = 0; i < raceList.size(); i++) {
            model1.addRow( new Object[]{ raceList.get(i).getDate(),raceList.get(i).getFirstPosition(),raceList.get(i).getSecondPosition(), raceList.get(i).getThirdPosition(),
                   raceList.get(i).getFourthPosition(), raceList.get(i).getFifthPosition(), raceList.get(i).getSixthPosition(), raceList.get(i).getSeventhPosition(),raceList.get(i).getEightPosition(),raceList.get(i).getNinthPosition(),raceList.get(i).getTenthPosition()} );
        }




        new jtable2(model1);
    }
}
