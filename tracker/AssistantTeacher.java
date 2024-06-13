
import java.util.ArrayList;
import java.util.List;



class AssistantTeacher extends Employee implements Teacher, Payment{
    private List<DesignatedCourse> courses = new ArrayList<DesignatedCourse>();

    AssistantTeacher(String lname, String fname){
        super(lname, fname);
    }
    protected String getEmployeeIdString(){
        return "OY_ASSISTANT_"; 
    }
    public String getCourses(){
        String total = "";
        int i = 0;
        while (i < courses.size() ){
           total += courses.get(i).toString();
           i++;
        }
        return total;
     }
    public void setCourses(List<DesignatedCourse> courses){
        if(courses != null){
            this.courses = courses;
        }
    

    }
    public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append("Teacher id: ").append(getEmployeeIdString()).append(super.getRandomId(2001, 3000)).append( "\n");
       sb.append("First name:" ).append(super.getFirstName()).append(", Last name:").append(super.getLastName()).append("\n");
       sb.append("Birthdate: ").append(super.getBirthDate()).append("\n");
       sb.append("Salary: ").append(super.calculatePayment()).append("\n");
       sb.append("Assistant for courses: ").append("\n");
       sb.append(getCourses()).append("\n");
       return sb.toString();
    }
    
}