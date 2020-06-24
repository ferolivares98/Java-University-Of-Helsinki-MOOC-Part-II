package validation;

public class Calculator {

    public int multiplication(int fromInteger) {
        if(fromInteger >= 0){
            int multiplication = 1;
            for (int i = 1; i <= fromInteger; i++) {
                multiplication *= i;
            }

            return multiplication;
        }else{
            throw new IllegalArgumentException("Gotta be bigger or equal to 0");
        }
    }

    public int binomialCoefficient(int setSize, int subsetSize) {
        if(setSize >= 0 && subsetSize >= 0 && subsetSize < setSize){
            int numerator = multiplication(setSize);
            int denominator = multiplication(subsetSize) * multiplication(setSize - subsetSize);

            return numerator / denominator;
        }else{
            throw new IllegalArgumentException("Failed in binomial");
        }
    }
}
