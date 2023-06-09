public class Actor {
    private String name;
    private String gender;
    private String nationality;

    public Actor() {
        this.name = null;
        this.gender = null;
        this.nationality = null;
    }

    public Actor(String name, String gender, String nationality) {
        this.name = name;
        this.gender = gender;
        this.nationality = nationality;
    }
    public Actor(Actor a){
        this.name=a.name;
        this.gender = a.gender;
        this.nationality = a.nationality;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "( " +
                name +","+
                gender +","+
                nationality+
                ")";
    }
}
