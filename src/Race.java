import java.io.Serializable;

public class Race implements Serializable {
    private Date date;
    private String firstPosition;
    private String secondPosition;
    private String thirdPosition;
    private String fourthPosition;
    private String fifthPosition;
    private String sixthPosition;
    private String seventhPosition;
    private String eightPosition;
    private String ninthPosition;
    private String tenthPosition;


    //overloaded constructor
    public Race(Date date, String firstPosition, String secondPosition, String thirdPosition, String fourthPosition, String fifthPosition, String sixthPosition, String seventhPosition, String eightPosition, String ninthPosition, String tenthPosition) {
        this.date = date;
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.thirdPosition = thirdPosition;
        this.fourthPosition = fourthPosition;
        this.fifthPosition = fifthPosition;
        this.sixthPosition = sixthPosition;
        this.seventhPosition = seventhPosition;
        this.eightPosition = eightPosition;
        this.ninthPosition = ninthPosition;
        this.tenthPosition = tenthPosition;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFirstPosition() {
        return firstPosition;
    }

    public void setFirstPosition(String firstPosition) {
        this.firstPosition = firstPosition;
    }

    public String getSecondPosition() {
        return secondPosition;
    }

    public void setSecondPosition(String secondPosition) {
        this.secondPosition = secondPosition;
    }

    public String getThirdPosition() {
        return thirdPosition;
    }

    public void setThirdPosition(String thirdPosition) {
        this.thirdPosition = thirdPosition;
    }

    public String getFourthPosition() {
        return fourthPosition;
    }

    public void setFourthPosition(String fourthPosition) {
        this.fourthPosition = fourthPosition;
    }

    public String getFifthPosition() {
        return fifthPosition;
    }

    public void setFifthPosition(String fifthPosition) {
        this.fifthPosition = fifthPosition;
    }

    public String getSixthPosition() {
        return sixthPosition;
    }

    public void setSixthPosition(String sixthPosition) {
        this.sixthPosition = sixthPosition;
    }

    public String getSeventhPosition() {
        return seventhPosition;
    }

    public void setSeventhPosition(String seventhPosition) {
        this.seventhPosition = seventhPosition;
    }

    public String getEightPosition() {
        return eightPosition;
    }

    public void setEightPosition(String eightPosition) {
        this.eightPosition = eightPosition;
    }

    public String getNinthPosition() {
        return ninthPosition;
    }

    public void setNinthPosition(String ninthPosition) {
        this.ninthPosition = ninthPosition;
    }

    public String getTenthPosition() {
        return tenthPosition;
    }

    public void setTenthPosition(String tenthPosition) {
        this.tenthPosition = tenthPosition;
    }

    @Override
    public String toString() {
        return "Race{" +
                "date=" + date +
                ", firstPosition='" + firstPosition + '\'' +
                ", secondPosition='" + secondPosition + '\'' +
                ", thirdPosition='" + thirdPosition + '\'' +
                ", fourthPosition='" + fourthPosition + '\'' +
                ", fifthPosition='" + fifthPosition + '\'' +
                ", sixthPosition='" + sixthPosition + '\'' +
                ", seventhPosition='" + seventhPosition + '\'' +
                ", eightPosition='" + eightPosition + '\'' +
                ", ninthPosition='" + ninthPosition + '\'' +
                ", tenthPosition='" + tenthPosition + '\'' +
                '}';
    }
}






