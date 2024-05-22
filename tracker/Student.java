package dev.m3s.programming2.homework2;
// import dev.m3s.programming2.homework1.ConstantValues;


public class Student {
   private String firstName = ConstantValues.NO_NAME;
   private String lastName = ConstantValues.NO_NAME;
   private int id;
   private int startYear = ConstantValues.CURRENT_YEAR;
   private int graduationYear;
   private int degreeCount = 3;
   private Degree[] degrees = new Degree[degreeCount];
   private String birthDate = ConstantValues.NO_BIRTHDATE;
   
   
   public Student(){
      id = getRandomId();
      this.startYear = ConstantValues.CURRENT_YEAR;
      degrees[0] = new Degree() ;
      degrees[1] = new Degree() ;
      degrees[2] = new Degree() ;
   }
   
   public Student(String lname, String fname){
      setLastName(lname); 
      setFirstName(fname);
      id = getRandomId();
   }
   
   public String getFirstName(){
      return firstName;
   }
   
   public void setFirstName(String firstName){
      if (firstName != null){
         this.firstName = firstName;
      }
   }
   
   public String getLastName(){
      return lastName;
   }
   
   public void setLastName(String lastName){
      if (lastName != null){
         this.lastName = lastName;
      }
   }
   
   public int getId(){
      return id;
   }
   
   public void setId(final int id){
      if (id >= ConstantValues.MIN_ID && id <= ConstantValues.MAX_ID){
         this.id = id;
      }
   }
   
   public int getStartYear(){
      return startYear;
   }
   
   public void setStartYear(final int startYear){
      if (startYear > 2000 && startYear <= ConstantValues.CURRENT_YEAR){
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
          } 
          return "Check graduation year";
          }

      } 
      else {
          return "Check amount of required credits";
      }

  }
  

   private boolean isValidGraduationYear(int year) {
        return year > startYear && year <= ConstantValues.CURRENT_YEAR;
   }
   public void setDegreeTitle(final int i, String dName){
      if (i >= 0 && i < degreeCount && dName != null){
         degrees[i].setDegreeTitle(dName);
      }
   }
   
   public boolean addCourse(final int i, StudentCourse course) {
      if (i >= 0 && i <= degreeCount && course != null) {
          degrees[i].addStudentCourse(course);
          return true;
      } else {
          return false;
      }
  }

   public int addCourses(final int i, StudentCourse[] courses) {
      int counter = 0;
      if (i > 0 && i < degreeCount) {
          for (StudentCourse course : courses) {
              if (addCourse(i, course)) {
                  counter++;
              }
          }
      }
      return counter;
  }

   
   public void printCourses() {
     for (int i = 0; i < degreeCount; i++) {
         if (degrees[i] != null){
             degrees[i].printCourses();
         }
     }
    }
   
   public void printDegrees() {
     for (int i = 0; i < degreeCount; i++) {
         if (degrees[i] != null) {
             System.out.println(degrees[i]);
         }
     }
   }
   
   public void setTitleOFThesis(final int i, String title) {
     if ((i >= 0 && i < degreeCount) && title != null) {
         degrees[i].setTitleOfThesis(title);
     }
   }
   
   public String getBirthDate(){
      return birthDate;
   }
   
   
   public String setBirthDate(String personid){
      PersonID person = new PersonID();
      if (person.setPersonId(personid) == "OK"){
         return birthDate;
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
      if (degrees[0].getCredits() >= ConstantValues.BACHELOR_CREDITS
                && degrees[0].getCredits() <= ConstantValues.MAX_CREDITS
                && degrees[1].getCredits() >= ConstantValues.MASTER_CREDITS
                && degrees[1].getCredits() <= ConstantValues.MAX_CREDITS
                && degrees[0].getTitleOfThesis() != ConstantValues.NO_TITLE
                && degrees[1].getTitleOfThesis() != ConstantValues.NO_TITLE) {
            return true;
        }
        return false;
    }
   
   public int getStudyYears(){
      if (setGraduationYear(graduationYear) == "OK"){
         return  graduationYear - startYear;
      }
      else{
         return ConstantValues.CURRENT_YEAR - startYear;
      }
      
   }
   
   private int getRandomId(){
      return (int)(Math.floor(Math.random()*100+1));
   }
   
   public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student id: ").append(getId()).append("\n");
        sb.append("First name: ").append(firstName).append(", Last name: ").append(lastName).append("\n");
        sb.append("Date of birth: ").append(getBirthDate() != null ? "\"" + getBirthDate() + "\"" : "\"Not available\"")
                .append("\n");
        sb.append("Status: ");
            if (hasGraduated()) {
                    sb.append("The student has graduated in ").append(graduationYear).append("\n");
                    sb.append("Start year: ").append(startYear).append(" (studies have lasted for ")
                .append(graduationYear - startYear).append(" years)\n");
            } else {
                    sb.append("The student has not graduated, yet");
                }
                sb.append("\n");
        
        sb.append("Total credits: ").append(degrees[0].getCredits() + degrees[1].getCredits()).append("\n");
        sb.append("Bachelor credits: ").append(degrees[0].getCredits()).append("\n");
        sb.append("Total bachelor credits completed (").append(degrees[0].getCredits()).append("/180.0)\n");
        sb.append("Title of BSc Thesis: ").append(degrees[0].getTitleOfThesis()).append("\n");
        sb.append("Master credits: ").append(degrees[1].getCredits()).append("\n");
        if (120.0 - degrees[1].getCredits() <= 0) {
            sb.append("Total master's credits completed (").append(degrees[1].getCredits()).append("/120.0)\n");
        } else {
            sb.append("Missing master's credits ").append(120.0 - degrees[1].getCredits()).append(" (")
                    .append(degrees[1].getCredits()).append("/120.0)\n");
        }
        sb.append("Title of MSc Thesis: ").append(degrees[1].getTitleOfThesis() + "\n");
        return sb.toString();

    }
   
    
   
}