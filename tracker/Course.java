
public class Course {

   private String name = ConstantValues.NO_TITLE;
   private String courseCode;
   private char courseBase = ' ';
   private int courseType;
   private int period;
   private double credits;
   private boolean numericGrade;
   
   public Course(){
   }
   
   public Course(String name, final int code, char courseBase, final int type, final int period, final double credits, boolean numericGrade){
      setName(name);
      setCourseCode(code, courseBase);
      setCourseType(type);
      setPeriod(period);
      setCredits(credits);
      setNumericGrade(numericGrade);
   }
   
   public Course(Course course){
      setName(course.getName());
      this.courseCode = course.courseCode;
      setCourseType(course.getCourseType());
      setPeriod(course.getPeriod());
      setCredits(course.getCredits());
      setNumericGrade(course.isNumericGrade());
   }
   
   public String getName(){
      return name;
   }
   
   public void setName(String name){
      if (name != null){
         this.name = name;
      }
   }
   
   public String getCourseTypeString(){
      if (courseType == 1){
         return "Mandatory";
      }
      if (courseType == 0){
         return "Optional";
      }
      return null;
   }
   
   public int getCourseType(){
      return courseType;
   }
   
   public void setCourseType(final int type){
      if (type == 0 || type == 1){
         courseType = type;
      }
   }
   
   public String getCourseCode(){
      return courseCode;
   }
   
   public void setCourseCode(final int courseCode, char courseBase){
      if (courseBase == 'a'){
         courseBase = 'A';
      }
      else if (courseBase == 'p'){
         courseBase = 'P';
      }
      else if (courseBase == 's'){
         courseBase = 'S';
      }
      if (String.valueOf(courseCode).length() == 6 && (courseBase == 'A' || courseBase == 'P' || courseBase == 'S')){
         this.courseBase = courseBase;
         this.courseCode = String.valueOf(courseCode) + courseBase;
         }
      }
   
   
   public char getCourseBase(){
      return courseBase;
   }
   
   public int getPeriod(){
      return period;
   }
   
   public void setPeriod(final int period){
      if (ConstantValues.MIN_PERIOD <= period && ConstantValues.MAX_PERIOD >= period){
         this.period = period;
      }
   }
   
   public double getCredits(){
      return credits;
   }
   
   private void setCredits(final double credits){
      if(credits >= ConstantValues.MIN_CREDITS && credits <= ConstantValues.MAX_CREDITS){
         this.credits = credits;
     }
   }
   
   public boolean isNumericGrade(){
      return numericGrade;
   }
   
   public void setNumericGrade(boolean numericGrade){
      this.numericGrade = numericGrade;
   }
   
   public String toString(){
        String str = "[" + getCourseCode() + " (" + getCredits() + " cr) " + getName() + ". " + getCourseTypeString() + ", " + "period: " + getPeriod() + ".] \n";  
        return str;
    }
   
   
   
}