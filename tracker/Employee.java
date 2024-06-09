
import java.time.Year;



abstract class Employee extends Person implements Payment {
    private String empId;
    private int startYear = Year.now().getValue();
    private Payment payment;

    Employee(String lname, String fname) {
        super(lname, fname);
        empId = getEmployeeIdString() + getRandomId(2001, 3000);
        startYear = Year.now().getValue();

    }


    @Override
    public String getIdString() {
        return empId;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(final int startYear) {
        if (startYear > 2000 && startYear <= Year.now().getValue()) {
            this.startYear = startYear;
        }
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        if (payment != null) {
            this.payment = payment;
        }
    }

    // public double calculatePayment() {
    //     if(payment ==  null) {
    //         return 0.0;
    //     }
    //     else{

    //     }
    // }
    public double calculatePayment() {
        if (payment != null) {
            if (payment instanceof HourBasedPayment) {
               HourBasedPayment hourBasedPayment = (HourBasedPayment) payment;
               return hourBasedPayment.calculatePayment();
        }
            else if (payment instanceof MonthlyPayment) {   
                MonthlyPayment monthlyPayment = (MonthlyPayment) payment;
                return monthlyPayment.calculatePayment();
        }
    }
        
        return 0.0;
        

    
}
    protected abstract String getEmployeeIdString();
    
    

}

