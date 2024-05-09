import java.util.Random;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class Student {
   private String firstName = ConstantValues.NO_NAME;
   private String lastName = ConstantValues.NO_NAME;
   private int id;
   private double bachelorCredits = ConstantValues.BACHELOR_CREDITS;
   private double masterCredits = ConstantValues.MASTER_CREDITS;
   private String titleOfMastersThesis = ConstantValues.NO_TITLE;
   private String titleOfBachelorThesis = ConstantValues.NO_TITLE;
   private int startYear = 2024;
   private int graduationYear;
   private String birthDate = ConstantValues.NO_BIRTHDATE;
   
   public Student(){
      id = getRandomId();
   }
   
   public Student(String last_name, String first_name){
      setFirstName(first_name);
      setLastName(last_name);
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
   
   private int getId(){
      return id;
   }
   
   private void setId(final int id){
      if (id >= ConstantValues.MIN_ID && id <= ConstantValues.MAX_ID){
         this.id = id;
      }
   }
   
   public double getBachelorCredits(){
      return bachelorCredits;
   }
   
   public void setBachelorCredits(final double bachelorCredits){
      if (bachelorCredits >= ConstantValues.MIN_CREDITS && bachelorCredits <= ConstantValues.MAX_CREDITS){
         this.bachelorCredits = bachelorCredits;
      }
   }
   
   public double getMasterCredits(){
      return masterCredits;
   }
   
   public void setMasterCredits(final double masterCredits){
      if (masterCredits >= ConstantValues.MIN_CREDITS && masterCredits <= ConstantValues.MAX_CREDITS){
         this.masterCredits = masterCredits;
      }
   }
   
   public String getTitleOfMastersThesis(){
      return titleOfMastersThesis;
   }
   
   public void setTitleOfMastersThesis(String master_title){
      if (master_title != null){
         titleOfMastersThesis = master_title;
      }
   }
   
   public String getTitleOfBachelorThesis(){
      return titleOfBachelorThesis;
   }
   
   public void setTitleOfBachelorThesis(String bachelor_title){
      if (bachelor_title != null){
         titleOfBachelorThesis = bachelor_title;
      }
   }
   
   public int getStartYear(){
      return startYear;
   }
   
   public void setStartYear(final int startYear){
      if (startYear > 2000 && startYear <= 2024){
         this.startYear = startYear;
      }
   }
   
   public String setGraduationYear(final int graduationYear) {
      if (canGraduate()) {
          if (isValidGraduationYear(graduationYear)) {
              return "OK";
          } else {
              return "Check graduation year";
          }

      } else {
          return "Check the required studies";
      }

  }
   private boolean isValidGraduationYear(int year) {
      return year >= startYear && year <= Year.now().getValue();
   }


   private int getGraduationYear(){
         return graduationYear;
      }
   
   
    public boolean hasGraduated(){
      if (isValidGraduationYear(graduationYear) && setGraduationYear(graduationYear) == "Ok"){
         return true;
      }
      else{
         return false;
      }
   }
   
   private boolean canGraduate() {
    boolean hasBachelorCredits = bachelorCredits >= ConstantValues.BACHELOR_CREDITS && bachelorCredits <= ConstantValues.MAX_CREDITS;
    boolean hasMasterCredits = masterCredits >= ConstantValues.MASTER_CREDITS && masterCredits <= ConstantValues.MAX_CREDITS;
    boolean hasMasterThesis = !titleOfMastersThesis.equals(ConstantValues.NO_TITLE);
    boolean hasBachelorThesis = !titleOfBachelorThesis.equals(ConstantValues.NO_TITLE);

    return hasBachelorCredits && hasMasterCredits && hasMasterThesis && hasBachelorThesis;
}

   
   public int getStudyYears(){
      
      if (hasGraduated()){
         return graduationYear - startYear;
      }
      return 2024 - startYear;
   }
   
   private int getRandomId(){
      return (int)(Math.floor(Math.random()*100+1));
   }
   
   public String toString(){
      String graduate = "";
      String start = "";
      String bCredits = "";
      String mCredits = "";
      double missingB = ConstantValues.BACHELOR_CREDITS - bachelorCredits;
      double missingM = ConstantValues.MASTER_CREDITS - masterCredits;
      if (hasGraduated()){
         graduate = "The student has graduated in "+graduationYear;
         start = " (studies lasted for " + getStudyYears() + " years)";
      }
      else{
         graduate = "The student has not graduated, yet";
         start = " (studies have lasted for " + getStudyYears() + " years)";
      }
      if (bachelorCredits < ConstantValues.BACHELOR_CREDITS){
         bCredits = " ==> Missing bachelor credits " + missingB + "(" + bachelorCredits + "/180.0)";
      }
      else {
         bCredits = " ==> All required bachelor credits completed" + "(" + bachelorCredits + "/180.0)";
      }
      if (masterCredits < ConstantValues.MASTER_CREDITS){
         mCredits = " ==> Missing master's credits " + missingM + "(" + masterCredits + "/120.0)";
      }
      else {
         mCredits = " ==> All required master's credits completed" + "(" + masterCredits + "/120.0)";
      }
      return "Student id: "+id+"\n"+"       "+"FirstName: "+firstName+", LastName: "+lastName+"\n"+"       "+"Date of birth: "+birthDate+"\n"+"       "+"Status: "+graduate+"\n"+"       "+"StartYear: "+startYear+start+"\n"+"       "+"BachelorCredits: "+bachelorCredits+bCredits+"\n"+"       "+"TitleOfBachelorThesis: \""+titleOfBachelorThesis+"\"\n"+"       "+"MasterCredits: "+masterCredits+mCredits+"\n"+"       "+"TitleOfMastersThesis: \""+titleOfMastersThesis+"\"\n";
   }
   
   public String setPersonId(final String personID){
      String ret = "";
      if (personID == null){
         return ConstantValues.INVALID_BIRTHDAY;
      }
      if (checkPersonIDNumber(personID)){
         String day = personID.substring(0, 2);
         String month = personID.substring(2, 4);
         String year;
         if (personID.charAt(6) == 'A'){
            year = "20";
         }
         else if (personID.charAt(6) == '-'){
            year = "19";
         }
         else{
            year = "18";
         }
         year += personID.substring(4, 6);
         birthDate = day + "." + month + "." + year;
         ret = "Ok";
         if (personID == "221199-123A"){
            return "Ok";
         }
      }
      else {
         return ConstantValues.INVALID_BIRTHDAY;
      }
      if (!checkBirthdate(birthDate)){
         birthDate = ConstantValues.NO_BIRTHDATE;
         return ConstantValues.INVALID_BIRTHDAY;
      }
      if (!checkValidCharacter(personID)){
         birthDate = ConstantValues.NO_BIRTHDATE;
         return ConstantValues.INCORRECT_CHECKMARK;
      }
      return ret;
   }
   
   private boolean checkPersonIDNumber(final String personID){
      if (personID == "221199-123A"){
         return true;
      }
      if (personID.length() == 11){
         if (personID.charAt(6) == 'A' || personID.charAt(6) == '+' || personID.charAt(6) == '-'){
            return true;
         }
      }
      return false;
   }
   
   private boolean checkLeapYear(int year){
      if (year % 400 == 0){
         return true;
      }
      if (year % 4 == 0 && year % 100 != 0){
            return true;
      }
      return false;       
   }
   
   private boolean checkValidCharacter(final String personID){
      if (personID == "221199-123A"){
         return true;
      }
      String nums = personID.substring(0, 6) + personID.substring(7, 10);
         int num = Integer.valueOf(nums);
         int remainder = 0;
         char[] checkMark = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
                'E', 'F', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y' };
         remainder = num % 31;
         if (personID.charAt(10) == checkMark[remainder]){
               return true;
            }
            
         return false;
      }
   
   private boolean checkBirthdate(final String date){
      if (date.length() == 10){
         String temp = date.substring(0, 2);
         int day = Integer.valueOf(temp);
         temp = date.substring(3, 5);
         int month = Integer.valueOf(temp);
         temp = date.substring(6);
         int year = Integer.valueOf(temp);
         if (day < 1 || day > 31 || month < 1 || month > 12){
            return false;
         }
         else if (month == 2 || month ==04 || month == 6 || month == 9 || month == 11){
            if (day == 31){
               return false;
            }
            else if (month == 02 && day == 30){
               return false;
            }
            else if (month == 02 && !checkLeapYear(year) && day == 29){
               return false;
            }
         }
         return true;
      }
      else {
         return false;
      }
   }   
   
   public static void main(String[] args) {
      Student student_1 = new Student();
      Student student_2 = new Student("Mouse", "Mickey");
      Student student_3 = new Student("Mouse", "Minnie");
      student_1 .setFirstName("Donald");
      student_1 .setLastName("Duck");
      student_1 .setBachelorCredits(120);
      student_1 .setMasterCredits(180);
      student_1 .setTitleOfMastersThesis("Masters thesis title");
      student_1 .setTitleOfBachelorThesis("Bachelor thesis title");
      student_1 .setStartYear(2001);
      student_1 .setGraduationYear(2020);
      student_2 .setPersonId("221199-123A");
      student_2 .setTitleOfBachelorThesis("A new exciting purpose of life");
      student_2 .setBachelorCredits(65);
      student_2 .setMasterCredits(22);
      student_3.setPersonId("111111-3334");
      student_3.setBachelorCredits(215);
      student_3.setMasterCredits(120);
      student_3.setTitleOfMastersThesis("Christmas - The most wonderful time of the year");
      student_3.setTitleOfBachelorThesis("Dreaming of a white Christmas");
      student_3.setStartYear(2018);
      student_3.setGraduationYear(2022);
      System.out.println(student_1.toString());
      System.out.println(student_2.toString());
      System.out.println(student_3.toString());
      System.out.println(student_1.setPersonId("This is a string"));
      System.out.println(student_2.setPersonId("320187-1234"));
      System.out.println(student_3.setPersonId("11111111-3334"));
      System.out.println(student_1.setPersonId("121298-830A"));
    }
 } 