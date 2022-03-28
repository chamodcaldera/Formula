import java.io.FileNotFoundException;
import java.io.IOException;

public interface ChampionshipManager {

    void createDriver(Formula1Driver fDriver);
    void deleteDriver(String fDriver);
    void changeTheDriverForTeam(String fTeam,String newDriver);
    void displayStatForDriver(String fDriver);
    void displayStatInSeason();
    void addRace(Race race);
    void writeAllData(String x) throws IOException;
    void readAllData(String y) throws IOException;
    void writeRaceData(String x) throws IOException;
    void readRaceData(String y) throws IOException;
}
