import java.io.Serializable;

public class Formula1Driver extends Driver implements Comparable<Formula1Driver> ,Serializable {
    private String team;
    private int numOfFirstPos;
    private int numOfSecondPos;
    private int numOfThirdPos;
    private int numOfPoints;
    private int numOfRaces;


    //overloaded constructor
    public Formula1Driver(String name, String location, int age, String team, int numOfFirstPos, int numOfSecondPos, int numOfThirdPos, int numOfPoints, int numOfRaces) {
        super(name, location, age);
        this.team = team;
        this.numOfFirstPos = numOfFirstPos;
        this.numOfSecondPos = numOfSecondPos;
        this.numOfThirdPos = numOfThirdPos;
        this.numOfPoints = numOfPoints;
        this.numOfRaces = numOfRaces;
    }

    //getters and setter for access private variables
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getNumOfFirstPos() {
        return numOfFirstPos;
    }

    public void setNumOfFirstPos(int numOfFirstPos) {
        this.numOfFirstPos = numOfFirstPos;
    }

    public int getNumOfSecondPos() {
        return numOfSecondPos;
    }

    public void setNumOfSecondPos(int numOfSecondPos) {
        this.numOfSecondPos = numOfSecondPos;
    }

    public int getNumOfThirdPos() {
        return numOfThirdPos;
    }

    public void setNumOfThirdPos(int numOfThirdPos) {
        this.numOfThirdPos = numOfThirdPos;
    }

    public int getNumOfPoints() {
        return numOfPoints;
    }

    public void setNumOfPoints(int numOfPoints) {
        this.numOfPoints = numOfPoints;
    }

    public int getNumOfRaces() {
        return numOfRaces;
    }

    public void setNumOfRaces(int numOfRaces) {
        this.numOfRaces = numOfRaces;
    }

    @Override
    public String toString() {
        return "Formula1Driver{" +
                "Driver name= " + getName() +
                ", Driver Location " + getLocation() +
                ", Driver Age " + getAge() +
                "team='" + team + '\'' +
                ", numOfFirstPos=" + numOfFirstPos +
                ", numOfSecondPos=" + numOfSecondPos +
                ", numOfThirdPos=" + numOfThirdPos +
                ", numOfPoints=" + numOfPoints +
                ", numOfRaces=" + numOfRaces +
                '}';
    }

    @Override
    public int compareTo(Formula1Driver o) {                        //Sorting method for details table
        if(this.getNumOfPoints() != o.getNumOfPoints()) {
            if(this.getNumOfPoints() < o.getNumOfPoints()){
                return 1;
            }
            else {
                return -1;
            }
        }else {
            if (this.getNumOfPoints() == o.getNumOfPoints()) {
                if (getNumOfFirstPos() < getNumOfFirstPos()) {
                    return 1;
                }else {
                    return -1;
                }
            }
            return -1;
        }
    }
}
