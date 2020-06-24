/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Flight {
    private Airplane airplane;
    private String depCode;
    private String arrCode;
    
    public Flight(Airplane airplane, String depCode, String arrCode){
        this.airplane = airplane;
        this.depCode = depCode;
        this.arrCode = arrCode;
    }
    
    public String toString(){
        return airplane.toString() + " (" + depCode + "-" + arrCode + ")";
    }
    
    
}
