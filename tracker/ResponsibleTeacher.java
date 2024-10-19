
import java.util.ArrayList;
import java.util.List;

public class ResponsibleTeacher extends Employee implements Teacher, Payment{
    private List<DesignatedCourse> courses = new ArrayList<DesignatedCourse>();


    ResponsibleTeacher(String lname, String fname){
        super(lname, fname);
    }

    public String getEmployeeIdString(){
        return "OY_TEACHER_";
    }
    public String getCourses(){
        String cString = "";
        if (courses != null && courses.size() > 0){
           cString += "Responsible teacher: " + courses.get(0).toString();

           for (int i = 1; i < courses.size() - 1; i++){
              cString += "Teacher: " + courses.get(i).toString();
              i++;
           }
           cString += "Responsible teacher: " + courses.get(courses.size() - 1).toString();
        }
        return cString;
     }
    public void setCourses(List<DesignatedCourse> courses) {
        if (courses != null){
           this.courses = courses;
        }
    }
    
    
    
}
