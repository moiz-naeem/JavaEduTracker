package dev.m3s.programming2.homework2;
public class Degree {

   private static final int MAX_COURSES = 50;
   private int count;
   private String degreeTitle = ConstantValues.NO_TITLE;
   private String titleOfThesis = ConstantValues.NO_TITLE;
   private StudentCourse[] myCourses = new StudentCourse[MAX_COURSES];
   
   public StudentCourse[] getCourses(){
      return myCourses;
   }
   
   public void addStudentCourses(StudentCourse[] courses){
      for(StudentCourse course : courses){
         addStudentCourse(course);
     }
   }
   
   public boolean addStudentCourse(StudentCourse course){
      if(course != null && count < MAX_COURSES){
          myCourses[count] = course;
          count++;
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
      for (StudentCourse course : myCourses){
         if (isCourseCompleted(course) && course.course.getCourseBase() == base){
            total += course.getCourse().getCredits();
         }
      }
      return total++;
   }
   
   public double getCreditsByType(final int courseType){
      double ret = 0;
      for (StudentCourse course : myCourses){
         if (isCourseCompleted(course) && course.course.getCourseType() == courseType){
            ret+= course.getCourse().getCredits();
         }
      }
      return ret;
   }
   
   public double getCredits(){
      double total = 0;
        for(StudentCourse course : myCourses ){
            if(course == null){
               return total;
            }
            if(isCourseCompleted(course)){
               total += course.getCourse().getCredits();
            }
        }
        return total;
   }
   
   private boolean isCourseCompleted(StudentCourse c){
      if ( c != null && c.isPassed()){
         return true;
      }
      return false;
   }
   
   public void printCourses(){
      for(StudentCourse course : myCourses){
          if(course == null){
            break;
          }
          else{
            System.out.println(course+ " ");
          }
      }
  }
   
   public String toString(){
     StringBuilder sb = new StringBuilder();
     sb.append("Degree [Title: \"").append(degreeTitle).append("\" (courses: ").append(count).append(")\n");
     sb.append("Thesis title: \"").append(titleOfThesis).append("\"\n");
     for (int i = 0; i < count; i++) {
         sb.append(i + 1).append(". ").append(myCourses[i]).append(" Year: ").append(myCourses[i].getYear()).append(", Grade: ").append(myCourses[i].getGradeNum()).append("]\n");
     }
     sb.append("]");
     return sb.toString();

    }
   
}