

import java.util.Random;

public abstract class Person {
   private String firstName = ConstantValues.NO_NAME;
   private String lastName = ConstantValues.NO_NAME;
   private String birthDate = ConstantValues.NOT_AVAILABLE;


   Person(String lname, String fname){
        setLastName(lname);
        setFirstName(fname);
   }

   public String getFirstName(){
    return firstName;
   }
   public void setFirstName(String firstName){
    if(firstName != null){
        this.firstName = firstName;
    }
   }
   public String getLastName(){
    return lastName;
   }
   public void setLastName(String lastName){
     if(lastName != null){
        this.lastName = lastName;
     }
   }
   public String getBirthDate(){
     return birthDate;
   }
   public String setBirthDate(String personId){
      PersonID personID = new PersonID();
      if(personID.setPersonId(personId) == "ok"){ 
         birthDate = personID.getBirthDate();
          return birthDate;
       }
      else{
         return "No change";
      }
      
      }
   protected int getRandomId(final int min, final int max){
      Random random = new Random();
      int randomID = random.nextInt(max - min + 1) + min;
      return randomID;
   }
    public abstract String getIdString();
   
    
}
