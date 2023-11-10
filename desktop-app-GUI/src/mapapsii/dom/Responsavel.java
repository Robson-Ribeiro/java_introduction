/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapapsii.dom;

/**
 *
 * @author A
 */
public class Responsavel {
    private String respName;
    private String respTel;
    private String respAdress;
    private String respCPF;
    private String respEmail;
    private String respAge;
    
    private boolean isValid;
    
    public Responsavel(String respName, String respTel, String respAdress, String respCPF, String respEmail, String respAge) {
        this.respName = respName;
        this.respTel = respTel;
        this.respCPF = respCPF;
        this.respAdress = respAdress;
        this.respEmail = respEmail;
        this.respAge = respAge;
    }
    
    public void validate() {
        
        if(respAge != null && !respAge.isBlank() && respAge.matches("[0-9]*")) {
            double age = Double.parseDouble(this.respAge);
            if(age >= 18){
                this.isValid = true;
            } else {
                this.isValid = false;
            }
        } else {
            this.isValid = false;
        }
        

    }

    public String getRespName() {
        return respName;
    }

    public String getRespTel() {
        return respTel;
    }

    public String getRespAdress() {
        return respAdress;
    }

    public String getRespCPF() {
        return respCPF;
    }

    public String getRespEmail() {
        return respEmail;
    }

    public String getRespAge() {
        return respAge;
    }

    public boolean getIsValid() {
        return isValid;
    }
    
    
}
