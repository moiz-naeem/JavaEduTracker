

public class MonthlyPayment implements Payment {
    private double salary;
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        if(salary > 0){
            this.salary = salary;
        }
    }
    public double calculatePayment(){
        return salary;
    }
    
    

}
