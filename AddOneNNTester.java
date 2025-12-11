import java.util.*;

public class AddOneNNTester
{
   public static void main(String[] args) {
      Map<Double, Double> trainingData = new HashMap<Double, Double>();
      AddOneNN network = new AddOneNN(5,0.000001);
      double i = -1000;
      while(i<=1000){
        trainingData.put(i,i+1);
         i=i+1;
      }
      
      network.train(trainingData, 20);
      Map<Double, Double> testData = new HashMap<Double, Double>();
      double j = 1000;
      while(j<=2000){
         testData.put(j,j+1);
         j=j+1;
      }
      System.out.print(network.test(testData));
   
          /*
         Create an AddOneNN object with 2 hidden nodes, and a learning rate of 10^-6.
         
         Create a Map<Double, Double> for your training data. It should map a valid input to its correct output.
         Add input data from -1000 to 1000 to your training data set. It should contain (-1000, 999) through (1000, 1001)
         Create a Map<Double, Double> for your testing data. It should map a valid input to its correct output.
         Add input data from 1000 to 2000 to your testing data set. It should contain (1000, 1001) through (2000, 2001)
         
         Call the train method to train your neural network with 20 epochs.
         Call the test method to test your neural network, and print its return value (the root mean squared error).
         */
         
         /*
            Testing your code:
            Before modifying AddOneNN, this should print zero.
            After completing everything except the train() function in AddOneNN, this should print a large error, around 1500.
            After completing the entirety of AddOneNN, this should print a small error, around 0.2.
         */
   }
}