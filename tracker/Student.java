
import java.util.List;
import java.util.ArrayList;
import java.time.Year;

public class Student extends Person {
    private int id;
    private int startYear =  Year.now().getValue();
    private int graduationYear;
    private List<Degree> degrees = new ArrayList<Degree>();


    Student(String lname, String fname) {
       super(lname, fname);
       id = getRandomId(0, 101);
       Degree bachelor = new Degree();
       Degree master = new Degree();
       Degree doctoral = new Degree();
       degrees.add(bachelor);
       degrees.add(master);
       degrees.add(doctoral);
    }



    public int getId(){
        return id;
     }
     
     public void setId(final int id){
        if (id >= 1 && id <= 100){
           this.id = id;
        }
     }
     
     public int getStartYear(){
        return startYear;
        
     }
     
     public void setStartYear(final int startYear){
        if (startYear > 2000 && startYear <= Year.now().getValue()){
           this.startYear = startYear;
        }
     }
     
     public int getGraduationYear(){
        if (!canGraduate()){
           graduationYear = 0;
           return graduationYear;
        }
        return graduationYear;
     }
     
     public String setGraduationYear(final int graduationYear) {
        if (canGraduate()) {
            if (isValidGraduationYear(graduationYear)) {
                this.graduationYear = graduationYear;
                return "OK";
            } else {
                return "Check graduation year";
            }
  
        } else {
            return "Check amount of required credits";
        }
  
    }
  
     private boolean isValidGraduationYear(int year) {
          return year >= startYear && year <= Year.now().getValue();
     }
     public void setDegreeTitle(final int i, String dName){
        if (i >= 0 && i < degrees.size() && dName != null){
           degrees.get(i).setDegreeTitle(dName);
        }
     }
     
     public boolean addCourse(final int i, StudentCourse course) {
        if (i >= 0 && i <= degrees.size() && course != null) {
            degrees.get(i).addStudentCourse(course);
            return true;
        } else {
            return false;
        }
    }
  
     public int addCourses(final int i, List<StudentCourse> courses) {
        int counter = 0;
        if (i > 0 && i <= degrees.size()) {
            for (StudentCourse course : courses) {
                if (addCourse(i, course)) {
                    counter++;
                }
            }
        }
        return counter;
    }
  
     
     public void printCourses() {
       for (int i = 0; i < degrees.size(); i++) {
           if (degrees.get(i) != null){
               degrees.get(i).printCourses();
           }
       }
      }
     
     public void printDegrees() {
       for (int i = 0; i < degrees.size(); i++) {
           if (degrees.get(i) != null) {
               degrees.get(i).toString();
           }
       }
     }
     
     public void setTitleOfThesis(final int i, String title) {
       if ((i >= 0 && i <= degrees.size()) && title != null) {
           degrees.get(i).setTitleOfThesis(title);
       }
     }
     
     
     
     public String setBirthDate(String personid){
        PersonID person = new PersonID();
        if (person.setPersonId(personid) == "Ok"){
           return person.getBirthDate();
        }
        return "No change";
     }
     
     public boolean hasGraduated(){
        if(canGraduate() && isValidGraduationYear(graduationYear)){
           return true;
        }
        else{
           return false;
        }      
     }
     
     private boolean canGraduate(){
        if (degrees.get(0).getCredits() >= ConstantValues.BACHELOR_MANDATORY
                  && degrees.get(0).getCredits() >= ConstantValues.BACHELOR_CREDITS
                  && degrees.get(0).getCredits() <= ConstantValues.MAX_CREDITS
                  && degrees.get(1).getCredits() >= ConstantValues.MASTER_MANDATORY
                  && degrees.get(0).getCredits() >= ConstantValues.MASTER_CREDITS
                  && degrees.get(1).getCredits() <= ConstantValues.MAX_CREDITS
                  && degrees.get(0).getTitleOfThesis() != ConstantValues.NO_TITLE
                  && degrees.get(1).getTitleOfThesis() != ConstantValues.NO_TITLE) {
              return true;
          }
          return false;
      }
     
     public int getStudyYears(){
        if (hasGraduated()){
           return  graduationYear - startYear;
        }
        else{
           return Year.now().getValue() - startYear;
        }
        
     }
     
     public String getIdString(){
        String finalStr = "Student id: " + getId();
        return finalStr;
     }
     
     public String toString() {
          StringBuilder sb = new StringBuilder();
          sb.append("Student id: ").append(super.getRandomId(1, 100)).append("\n");
          sb.append("First name: ").append(super.getFirstName()).append(", Last name: ").append(super.getLastName()).append("\n");
          sb.append("Date of birth: ").append(getBirthDate() != null ? "\"" + getBirthDate() + "\"" : "\"Not available\"")
                  .append("\n");
          sb.append("Status: ");
              if (hasGraduated()) {
                    sb.append("The student has graduated in ").append(graduationYear).append("\n");
                    sb.append("Start year: ").append(startYear).append(" (studies lasted for ")
                    .append(getGraduationYear() - startYear).append(" years)\n");
              } else {
                      sb.append("The student has not graduated, yet").append("\n");
                      sb.append("Start year: ").append(startYear).append(" (studies have lasted for ")
                .append(2024 - startYear).append(" years)\n");

                  }
        
          sb.append("Total credits: ").append(degrees.get(0).getCredits() + degrees.get(1).getCredits()).append("\n");
          
          if(degrees.get(0).getCredits() >= 180){
            sb.append("Total bachelor credits completed (").append(degrees.get(0).getCredits()).append("/180.0)\n");
          }
          else{
            sb.append("Missing bachelor's credits: ").append(180 - degrees.get(0).getCredits()).append("/180.0)\n");
          } 
          sb.append("All mandatory credits completed (").append(degrees.get(0).getGPA(1).get(0)).append("/180.0)\n");
          sb.append("GPA of Bachelor studies: ").append(degrees.get(0).getGPA(2).get(2)).append("\n");
          sb.append("Title of BSc Thesis: ").append(degrees.get(0).getTitleOfThesis()).append("\n");

          sb.append("Master credits: ").append(degrees.get(1).getCredits()).append("\n");
          
          if(degrees.get(1).getCredits() >= 120){
            sb.append("Total master credits completed (").append(degrees.get(1).getCredits()).append("/120.0)\n");
          }
          else{
            sb.append("Missing Master's credits: ").append(120 - degrees.get(1).getCredits()).append("/120.0)\n");
          } 
          
          sb.append("All mandatory master credits completed (").append(degrees.get(1).getGPA(1).get(0)).append("/50\n");
          sb.append("GPA of Master studies: ").append(degrees.get(1).getGPA(2).get(2)).append("\n");
          sb.append("Title of BSc Thesis: ").append(degrees.get(1).getTitleOfThesis()).append("\n");
         return sb.toString();
        //   sb.append("Master credits: ").append(degrees[1].getCredits()).append("\n");
        //   if (120.0 - degrees[1].getCredits() <= 0) {
        //       sb.append("Total master's credits completed (").append(degrees[1].getCredits()).append("/120.0)\n");
        //   } else {
        //       sb.append("Missing master's credits ").append(120.0 - degrees[1].getCredits()).append(" (")
        //               .append(degrees[1].getCredits()).append("/120.0)\n");
        //   }
        //   sb.append("Title of MSc Thesis: ").append(degrees[1].getTitleOfThesis() + "\n");
        //   return sb.toString();
      
      }
    
     
     
  }


