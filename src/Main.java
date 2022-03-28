import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.*;

public class Main {



    public static Formula1ChampionshipManager fManager = new Formula1ChampionshipManager();     //create object of Formula1ChampionshipManager
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        int choice;

        try {
            fManager.readAllData("FormulaChampionshipList.txt");
            fManager.readRaceData("FormulaChampionshipRaceList.txt");

        }catch (IOException error){
            System.out.println("File not Found! ");
        }

        while (true){                 //Display menu
            try{

                System.out.println("Press [1] to add a new Driver: ");
                System.out.println("Press [2] to Delete a Driver: ");
                System.out.println("Press [3] to Change the driver for an existing team: ");
                System.out.println("Press [4] to Display Driver Details: ");
                System.out.println("Press [5] to Display Championship details: ");
                System.out.println("Press [6] to Add a Race:");
                System.out.println("Press [7] to write  file: ");
                System.out.println("Press [8] to Load file: ");
                System.out.println("Enter [9] to GUI: ");
                System.out.println("Enter [10] to Quit : ");
                choice = scanner.nextInt();

                if (choice==1) {
                    addDriver();
                } else if (choice==2) {
                    dltDriver();
                }else if (choice==3) {
                    changeDriverName();
                }else if (choice==4) {
                    displayDriverDetails();
                }else if (choice==5) {
                    displayAllDetail();
                }else if (choice==6) {
                    generateRace();
                } else if (choice==7) {
                    writeFile();
                }else if (choice==8) {
                    readFile();
                }else if (choice==9) {
                    openGui();
                }else if (choice==10){

                    break;
                }

            }catch (InputMismatchException exception) {            //error handling
                System.out.println("Invalid Input! Try again.");
            }
        }

    }

    private static void openGui() {         //function for open GUI

        Collections.sort(fManager.formula1Drivers);
        String[] header = {"Driver Name", "Driver Location", "Driver Age", "Driver Team", "First Places", "Second Places", "Third Places", "Points", "Num of Races"};

        DefaultTableModel model = new DefaultTableModel(header,0);

        for (int i = 0; i < fManager.formula1Drivers.size(); i++) {
            model.addRow( new Object[]{ fManager.formula1Drivers.get(i).getName(),fManager.formula1Drivers.get(i).getLocation(),fManager.formula1Drivers.get(i).getAge(), fManager.formula1Drivers.get(i).getTeam(),
            fManager.formula1Drivers.get(i).getNumOfFirstPos(), fManager.formula1Drivers.get(i).getNumOfSecondPos(), fManager.formula1Drivers.get(i).getNumOfThirdPos(), fManager.formula1Drivers.get(i).getNumOfPoints(),fManager.formula1Drivers.get(i).getNumOfRaces()} );
        }

        new jtable(model);



    }

    private static void generateRace() {                //Add race manually

        System.out.println(" Enter null for positions if there are not valid driver to add");

        System.out.println("Enter Race date");
        System.out.println("Enter race date day: ");
        int  day = scanner.nextInt();
        System.out.println("Enter race date month: ");
        int month = scanner.nextInt();
        System.out.println("Enter race date year: ");
        int year = scanner.nextInt();

        System.out.println("Enter 1st place Name: ");
        String firstPlace = scanner.next();
        System.out.println("Enter 2st place Name: ");
        String secondPlace = scanner.next();
        System.out.println("Enter 3st place Name: ");
        String thirdPlace = scanner.next();
        System.out.println("Enter 4th place Name: ");
        String forthPlace = scanner.next();
        System.out.println("Enter 5th place Name: ");
        String fifthPlace = scanner.next();
        System.out.println("Enter 6th place Name: ");
        String sixthPlace = scanner.next();
        System.out.println("Enter 7th place Name: ");
        String seventhPlace = scanner.next();
        System.out.println("Enter 8th place Name: ");
        String eightPlace = scanner.next();
        System.out.println("Enter 9th place Name: ");
        String ninthPlace = scanner.next();
        System.out.println("Enter 10th place Name: ");
        String tenthPlace = scanner.next();

        Date date =new Date(day,month,year);
        Race race = new Race(date,firstPlace,secondPlace,thirdPlace,forthPlace,fifthPlace,sixthPlace,seventhPlace,eightPlace,ninthPlace,tenthPlace);
        fManager.addRace(race);

    }

    private static void displayAllDetail() {
        fManager.displayStatInSeason();
    }

    private static void readFile() throws IOException {
        fManager.readAllData("FormulaChampionshipList.txt");
        fManager.readRaceData("FormulaChampionshipRaceList.txt");
    }

    private static void writeFile() throws IOException {
        fManager.writeAllData("FormulaChampionshipList.txt");
        fManager.writeRaceData("FormulaChampionshipRaceList.txt");
    }

    private static void displayDriverDetails() {
        System.out.println("Enter driver name for statistics: ");
        String dName = scanner.next();
        fManager.displayStatForDriver(dName);
    }

    private static void changeDriverName() {
        System.out.println("Enter team name to change driver: ");
        String teamName = scanner.next();
        System.out.println("Enter new Driver name for" + teamName + "team: ");
        String drivername = scanner.next();
        fManager.changeTheDriverForTeam(teamName,drivername);
    }

    private static void dltDriver() {
        System.out.println("Enter driver name to delete: ");
        String driverName = scanner.next();
        fManager.deleteDriver(driverName);

    }

    private static void addDriver() {               //Add driver for Formula1

        Scanner input =new Scanner(System.in);

        System.out.println("Enter Driver Name  :");
        String dname  =input.next();

        System.out.println("Enter Driver Location :");
        String dloc=input.next();

        System.out.println("Enter Driver Age :");
        int dage=input.nextInt();

        System.out.println("Enter number of achieved first positions:  ");
        int fpos= input.nextInt();

        System.out.println("Enter number of achieved second positions : ");
        int secpos=input.nextInt();

        System.out.println("Enter number of achieved third positions : ");
        int tpos=input.nextInt();

        System.out.println("Enter number of points :");
        int numpoints=input.nextInt();

        System.out.println("Enter number Races :");
        int numrace=input.nextInt();

        System.out.println("Enter racing team :");
        String teamName=input.next();

        Formula1Driver formula1Driver = new Formula1Driver(dname,dloc,dage,teamName, fpos,secpos,tpos,numpoints,numrace);
        fManager.createDriver(formula1Driver);


    }






}
