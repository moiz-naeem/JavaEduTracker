package dev.m3s.programming2.homework2;
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
      if (course.isNumericGrade()){
         if (checkGradeValidity(gradeNum)){
            if (gradeNum != 'A' && gradeNum != 'F'){
               this.gradeNum = gradeNum;
            }
         }
      }
      if (!course.isNumericGrade()){
         if (checkGradeValidity(gradeNum)){
            if (gradeNum == 'A'|| gradeNum == 'F'){
               this.gradeNum = gradeNum;
            }
            else if (gradeNum == 'a'){
               this.gradeNum = 'A';
            }
            else if (gradeNum == 'f'){
               this.gradeNum = 'F';
            }
         }
      }
      if (yearCompleted < 2000){
         yearCompleted = ConstantValues.CURRENT_YEAR;
      }
   }
   
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
      if (gradeNum > 0  || gradeNum == 'A'){
         return true;
      }
      return false;
   }
   
   public int getYear(){
      return yearCompleted;
   }
   
   public void setYear(final int year){
      if (year > 2000 && year <= ConstantValues.CURRENT_YEAR){
         yearCompleted = year;
      }
   }
   
   public String toString(){
        
        String finalStr = course.toString() + " Year: " +  getYear() + ", " + "Grade: " ;
        if(getGradeNum() == 0){
         return finalStr + "Not graded" + ".]";
      }
        else{
         return finalStr + getGradeNum() +".]";
      }
   }
   
}