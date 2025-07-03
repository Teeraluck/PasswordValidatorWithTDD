package lib;

public class PasswordValidator {

    /**
     * คุณจะต้องเขียน Javadoc ที่สมบูรณ์ที่นี่ในอนาคต
     * เพื่ออธิบายกฎการทำงานของเมธอด
     * @param password string ที่ต้องการตรวจสอบ
     * @return passwordStrength INVALID อื่นๆ
     */
    // TODO: แก้ไข return type ของเมธอดนี้ให้ถูกต้อง
    public static PasswordStrength validate(String password) { // Function Type ให้เป็น PasswordStrength 
        
        if (password==null || password.length()<8) {
            return PasswordStrength.INVALID;
        }
        
        boolean lower = false;
        boolean upper = false;
        boolean digit = false;
        boolean special = false;

        
        for(char c : password.toCharArray()){
            if (Character.isLowerCase(c)) {
                lower = true;
            }
            else if (Character.isUpperCase(c)) {
                upper = true;
            }
            else if (Character.isDigit(c)) {
                digit = true;
            }
            else special = true;
        }

        int count = 0;
        if (lower) {
            count++;
        }
        if (upper) {
            count++;
        }
        if (digit) {
            count++;
        }
        if (special) {
            count++;
        }
        if (count == 4) {
            return PasswordStrength.STRONG;
        }
        else if (count == 3) {
            return PasswordStrength.MEDIUM;
        }
        else return PasswordStrength.WEAK;
    }
}