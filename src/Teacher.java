public class Teacher {
    private int id;
    private String fname;
    private String lname;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    public Teacher(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }
}
