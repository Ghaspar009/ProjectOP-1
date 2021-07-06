package Project1;

public class Resident {

    private String city;
    private String forename;
    private String surname;
    private String pesel;

    Resident(String city, String forename, String surname, String pesel){
        this.city = city;
        this.forename = forename;
        this.surname = surname;
        this.pesel = pesel;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getCity() {
        return city;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public String getPesel() {
        return pesel;
    }

    @Override
    public boolean equals(Object aThat) { //nie jest to potrzebne w tym programie, ale wydaje mi sie, ze to dobra praktyka
        if (this == aThat)
            return true;
        if (!(aThat instanceof Resident))
            return false;
        Resident r = (Resident) aThat;
        return (r.forename == this.forename && r.city == this.city && r.surname == this.surname && r.pesel == this.pesel);
    }
}
