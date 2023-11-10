/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapapsii.dom;

/**
 *
 * @author A
 */
public class Estadia {
    private Crianca crianca;
    private String time;
    
    private boolean isValid;
    
    public Estadia(Crianca crianca, String time) {
        this.crianca = crianca;
        this.time = time;
    }
    
    public void validate() {
        if(time != null && !time.isBlank()) {
            if(time.matches("[0-9]*")){
                this.isValid = true;
            } else {
                this.isValid = false;
            }
        } else {
            this.isValid = false;
        }
    }
    
    public double serviceCost() {
        double minutes = Double.parseDouble(this.time);
        double price = minutes * 1.5;
        
        if(minutes > 60) {
            price *= 0.85;
        } else if(minutes > 40) {
            price *= 0.9;
        } else if(minutes > 20) {
            price *= 0.95;
        }
        
        return price;
    }

    public Crianca getCrianca() {
        return crianca;
    }

    public String getTime() {
        return time;
    }

    public boolean getIsValid() {
        return isValid;
    }
    
    
}
