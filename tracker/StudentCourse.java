package dev.m3s.programming2.homework3;
import java.time.Year;

//the last part of setGrade regarding setting year needs to be checked 
//isNumericGrade also need to be checked in course.java

public class StudentCourse {

   private Course course;
   private int yearCompleted = 0;
   private int gradeNum;
   
   
   public StudentCourse(){
   }
   
   public StudentCourse(Course course, final int gradeNum, final int yearCompleted){
      setCourse(course);
      setYear(yearCompleted);
      setGrade(gradeNum);
      
   }
   
   public Course getCourse(){
      return course;
   }
   
   public void setCourse(Course course){
      this.course = course;
   }
   
   public int getGradeNum(){
      return gradeNum;
   }
   
   protected void setGrade(int gradeNum){
      if(Character.isLowerCase(gradeNum)){
         Character.toUpperCase(gradeNum);
      }
      if (course.isNumericGrade()){
         if (checkGradeValidity(gradeNum)){
            if (gradeNum != 'A' && gradeNum != 'F'){
               this.gradeNum = gradeNum;
         }
      }
      if (!course.isNumericGrade()){
         if (checkGradeValidity(gradeNum)){
            if (gradeNum == 'A'|| gradeNum == 'F'){
               this.gradeNum = gradeNum;
            }
         }
      }
      if (yearCompleted > 2000 && yearCompleted <= Year.now().getValue()){
         setYear(yearCompleted);
      }
      else{
         this.yearCompleted =  Year.now().getValue();
      }
      } }
   
   private boolean checkGradeValidity(final int gradeNum){
      if (gradeNum >= 0 && gradeNum <= 5){
         return true;
      }
      if (gradeNum == 'A' || gradeNum == 'F' || gradeNum == 'a' || gradeNum == 'f'){
         return true;
      }
      return false;
   }
   
   public boolean isPassed(){
      if (gradeNum == ConstantValues.MIN_GRADE || gradeNum == ConstantValues.GRADE_FAILED){
         return false;
      }
      return true;
   }
   
   public int getYear(){
      return yearCompleted;
   }
   
   public void setYear(final int year){
      if (year > 2000 && year <= Year.now().getValue()){
         yearCompleted = year;
      }
   }
   
   public String toString(){
        
        String finalStr = course.toString() + " Year: " +  getYear() + ", " + "Grade: " ;
        if(getGradeNum() == 0){
         return finalStr + "Not graded" + ".] \n";
      }
        else{
         return finalStr + getGradeNum() +".] \n";
      }
   }
   

}
