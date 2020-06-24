/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author fernando
 */
public class ProductContainerRecorder extends ProductContainer{
    
    private ContainerHistory containerHistory;
    
    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        super.addToTheContainer(initialVolume);
        this.containerHistory = new ContainerHistory();
        this.containerHistory.add(initialVolume);
    }
    
    public String history(){
        return this.containerHistory.toString();
    }
    
    @Override
    public void addToTheContainer(double amount){
        super.addToTheContainer(amount);
        containerHistory.add(super.getVolume()); //Hay que guardar el volumen, no el peso de lo que acabamos de añadir.
    }
    
    @Override
    public double takeFromTheContainer(double amount){
        double previousVolume = this.getVolume(); //Strange thing i have to do just for the return. Really bad explanation...????
        super.takeFromTheContainer(amount);
        containerHistory.add(super.getVolume());
        return previousVolume - this.getVolume();
    }
    
    public void printAnalysis(){
        System.out.println("Product: " + super.getName()
                + "\nHistory: " + containerHistory.toString()
                + "\nGreatest product amount: " + containerHistory.maxValue()
                + "\nSmallest product amount: " + containerHistory.minValue()
                + "\nAverage: " + containerHistory.average()
                + "\nGreatest change: " + containerHistory.greatestFluctuation()
                + "\nVariance: " + containerHistory.variance());
    }
    
}
