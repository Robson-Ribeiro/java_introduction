/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapapsii.dom;

/**
 *
 * @author A
 */
public class Crianca {
    private Responsavel responsavel;
    private String name;
    private String sex;
    private String age;
    
    private boolean isValid;
    
    public Crianca(Responsavel responsavel, String name, String sex, String age) {
        this.responsavel = responsavel;
        this.age = age;
        this.name = name;
        this.sex = sex;
    }
    
    public void validate() {
        if(age != null && !age.isBlank() && age.matches("[0-9]*")) {
            double kidAge = Double.parseDouble(this.age);
            if(kidAge <= 10){
                this.isValid = true;
            } else {
                this.isValid = false;
            }
        } else {
            this.isValid = false;
        }
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getAge() {
        return age;
    }

    public boolean getIsValid() {
        return isValid;
    }
}
