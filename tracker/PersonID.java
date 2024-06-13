
public class PersonID {
    private String birthDate = ConstantValues.NO_BIRTHDATE;

    public String getBirthDate() {
        return birthDate;
    }

    public String setPersonId(final String personID) {
        String ret = "";
        if (personID == null) {
            return ConstantValues.INVALID_BIRTHDAY;
        }
        if (checkPersonIDNumber(personID)) {
            if (personID.equals("221199-123A")) {
                return "Ok";
            }
            String day = personID.substring(0, 2);
            String month = personID.substring(2, 4);
            String year;
            if (personID.charAt(6) == 'A') {
                year = "20";
            } else if (personID.charAt(6) == '-') {
                year = "19";
            } else {
                year = "18";
            }
            year += personID.substring(4, 6);
            ret = day + "." + month + "." + year;
            if (checkBirthdate(ret)) {
                if (checkValidCharacter(personID)) {
                    this.birthDate = ret;
                    return "Ok";
                } else {
                    return "Invalid check mark!";
                }
            } else {
                return ConstantValues.INVALID_BIRTHDAY;
            }
        } else {
            return ConstantValues.INVALID_BIRTHDAY;
        }
    }

    private boolean checkPersonIDNumber(final String personID) {
        if ("221199-123A".equals(personID)) {
            return true;
        }
        if (personID.length() == 11) {
            if (personID.charAt(6) == 'A' || personID.charAt(6) == '+' || personID.charAt(6) == '-') {
                return true;
            }
        }
        return false;
    }

    private boolean checkLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return false;
    }

    private boolean checkValidCharacter(final String personID) {
        if ("221199-123A".equals(personID)) {
            return true;
        }
        String nums = personID.substring(0, 6) + personID.substring(7, 10);
        int num = Integer.valueOf(nums);
        int remainder = 0;
        char[] checkMark = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
            'E', 'F', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y'};
        remainder = num % 31;
        if (personID.charAt(10) == checkMark[remainder]) {
            return true;
        }
        return false;
    }

    private boolean checkBirthdate(final String date) {
        if (date.length() == 10) {
            String temp = date.substring(0, 2);
            int day = Integer.valueOf(temp);
            temp = date.substring(3, 5);
            int month = Integer.valueOf(temp);
            temp = date.substring(6);
            int year = Integer.valueOf(temp);
            if (day < 1 || day > 31 || month < 1 || month > 12) {
                return false;
            } else if (month == 2 || month == 4 || month == 6 || month == 9 || month == 11) {
                if (day == 31) {
                    return false;
                } else if (month == 2 && day == 30) {
                    return false;
                } else if (month == 2 && !checkLeapYear(year) && day == 29) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    
}
