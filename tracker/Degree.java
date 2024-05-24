package dev.m3s.programming2.homework3;
import java.util.ArrayList;
import java.util.List;
public class Degree {
//getCreditsbyBase & typr might need fixation
   private static final int MAX_COURSES = 50;
   // private int count;
   private String degreeTitle = ConstantValues.NO_TITLE;
   private String titleOfThesis = ConstantValues.NO_TITLE;
   private ArrayList<StudentCourse> myCourses = new ArrayList<StudentCourse>();
   
   
   public List<StudentCourse> getCourses(){
      return myCourses;
   }
   
   public void addStudentCourses(List<StudentCourse> courses){
      if(courses != null && courses.size() + myCourses.size() <= MAX_COURSES){
         for(StudentCourse course : courses){
            addStudentCourse(course);
        }
      }
      
   }
   
   public boolean addStudentCourse(StudentCourse course){
      if(course != null && myCourses.size() < MAX_COURSES){
         myCourses.add(course);
         return true;
     }
         return false;
      }

   
   public String getDegreeTitle(){
      return degreeTitle;
   }
   
   public void setDegreeTitle(String degreeTitle){
      if (degreeTitle != null){
         this.degreeTitle = degreeTitle;
      }
   }
   
   public String getTitleOfThesis(){
      return titleOfThesis;
   }
   
   public void setTitleOfThesis(String titleOfThesis){
      if (titleOfThesis != null){
         this.titleOfThesis = titleOfThesis;
      }
   }
   
   public double getCreditsByBase(char base){
      double total = 0;
      if (base != ' '){
         if (base == 'a'){
            base = 'A';
         }
         else if (base == 'p'){
            base = 'P';
         }
         else if (base == 's'){
            base = 'S';
         }
         for (StudentCourse course : myCourses){
            Course courseC = course.getCourse();
            if (isCourseCompleted(course) && courseC.getCourseBase() == base){
               total += courseC.getCredits();
            }
         }
         return total;
      }
      return total;
   }
   
   public double getCreditsByType(final int courseType){
      double total = 0;
      for (int i = 0; i < myCourses.size(); i++){
         if ((myCourses.get(i).getCourse().getCourseType() == courseType) && (myCourses.get(i).getGradeNum() > 0) && myCourses.get(i).getGradeNum() != 70){
            total += myCourses.get(i).getCourse().getCredits();
         }   
      }
      return total;
   }
   
   public double getCredits(){
      double total = 0;
      for (int i = 0; i <  myCourses.size(); i++){
         if ( myCourses.get(i) == null){
            return total;
         }
         if (isCourseCompleted(myCourses.get(i))){
            total+=  myCourses.get(i).getCourse().getCredits();
         }
      }
      return total;
   }
   
   private boolean isCourseCompleted(StudentCourse c){
      if (c.isPassed() && c != null){
         return true;
      }
      return false;
   }
   
   public void printCourses(){
      for (int i = 0; i <  myCourses.size(); i++){
         if ( myCourses.get(i) != null){
            myCourses.get(i).toString();
         }
      }
   }
   
   public List<Double> getGPA(int type){
      ArrayList<Double> total = new ArrayList<Double>();
      double count = 0;
      double nCount = 0;
      double sum = 0;
      for (int i = 0; i < myCourses.size(); i++){
         if (type == 0){
            if (myCourses.get(i).getCourse().getCourseTypeString() == "Optional"){
               count++;
               if (myCourses.get(i).getCourse().isNumericGrade()){
                  sum += myCourses.get(i).getGradeNum();
                  nCount++;
               }
            }
         }
         else if (type == 1){
            if (myCourses.get(i).getCourse().getCourseTypeString() == "Mandatory"){
               count++;
               if (myCourses.get(i).getCourse().isNumericGrade()){
                  sum += myCourses.get(i).getGradeNum();
                  nCount++;
               }
            }
         }
         else if (type == 2){
            count++;
            if (myCourses.get(i).getCourse().isNumericGrade()){
               sum += myCourses.get(i).getGradeNum();
               nCount++;
            }
         }
         else{
            total.add(0.0);
            total.add(0.0);
            total.add(0.0);
            return total;
         }
      }
      total.add(sum);
      total.add(count);
      double cgpa = Math.round((sum/nCount)*100) / 100;
      total.add(cgpa);
      return total;
   }
   public String toString(){
     StringBuilder sb = new StringBuilder();
     sb.append("Degree [Title: \"").append(degreeTitle).append("\" (courses: ").append(myCourses.size()).append(")\n");
     sb.append("Thesis title: \"").append(titleOfThesis).append("\"\n");
     for (int i = 0; i < myCourses.size(); i++) {
         sb.append(i + 1).append(". ").append(myCourses.get(i).toString());
     }

     return sb.toString();

    }
   
   
   
}
