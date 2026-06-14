import java.time.LocalDate;

public class Employee {
	private int       id;
    private String    name;
    private String    department;
    private double    salary;
    private LocalDate dateOfBirth;

 // Constructor
    public Employee(int id, String name, String department,
                   double salary, LocalDate dateOfBirth) {
        this.id          = id;
        this.name        = name;
        this.department  = department;
        this.salary      = salary;
        this.dateOfBirth = dateOfBirth;
    }

    
 // Getters
    public int       getId()          { return id; }
    public String    getName()        { return name; }
    public String    getDepartment()  { return department; }
    public double    getSalary()      { return salary; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
}