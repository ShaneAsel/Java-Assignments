import java.util.ArrayList;
@SuppressWarnings("unchecked")
// I was recieving an "unchecked" warning. 
// But by using @SuppressWarnings("unchecked") I can bypass this warning.
public class ArrayList_7_1 { 
    private final String courseName;
    private final ArrayList students; 

    public ArrayList_7_1 (String courseName){
        this.courseName = courseName;
        students = new ArrayList();			
    }
	
    public void addStudent (String student){
        students.add(student);
    }
	
    public ArrayList getStudents (){
        return students;
    }
	
    public int getNumberOfStudents (){
        return students.size();
    }
	
    public String getCourseName (){
        return courseName;
    }
	
    public void dropStudent (){
        //TODO: left as exercise in programming exercise 10.9
    }

    public static void main(String[] args) {
	ArrayList_7_1 course1 = new ArrayList_7_1 ("Course 1");
        ArrayList_7_1 course2 = new ArrayList_7_1 ("Course 2");
		
        // Adding the 3 specific students to course1
	course1.addStudent ("Peter Jones");
	course1.addStudent ("Brian Smith");
	course1.addStudent ("Anne Kennedy");
		
	// Adding 2 students to course2
	course2.addStudent ("Peter Jones");
	course2.addStudent ("Brian Smith");
		
        // Display number of students in course1
	System.out.println("Number of students in course1: " + course1.getNumberOfStudents());
	
        ArrayList names = course1.getStudents();
	for (int i = 0; i < course1.getNumberOfStudents(); i++)
            // Displaying student names of course1
            System.out.print(names.get(i) + ", ");
        System.out.println ();
        
        // Display number of students in course2
	System.out.print("Number of students in course2: " + course2.getNumberOfStudents());	
	}
}
