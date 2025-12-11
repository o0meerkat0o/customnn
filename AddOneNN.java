/*
   DO NOT START CODING THIS FILE UNTIL YOU HAVE COMPLETED AddOneNNTester.java!
*/

import java.util.*;

/**
   A neural network which is able to add one to a number. 
   Sample input: 1; sample output: 2.
*/
class AddOneNN {
   private NNLayer layer;
   private NNNode outputNode;
   private double learnRate;
   /* Declare instance variables: 
      an NNLayer for your hidden layer; 
      an NNNode for your output node; and
      a double for your learning rate */

   public AddOneNN(int numHiddenNodes, double learningRate) {
      this.layer = new NNLayer(numHiddenNodes, 1);
      this.outputNode = new NNNode(numHiddenNodes);
      this.learnRate = learningRate;
    
      /* Initialize the three instance variables.
         The hidden layer should have one incoming weight per node.
         The output node should have numHiddenNodes incoming weights per node.
        */
   }
   public double test(Map<List<Double>, Double> testData) {
      double error =0;
      for (Map.Entry<List<Double>, Double> entry : testData.entrySet()) {
      for (int k= 0; k<5;k++){
         double input = entry.getKey().get(k);
         System.out.println(input);
         double expectedOutput = entry.getValue();      
         double NNoutput = outputNode.getBias();
         for (int i = 0; i < layer.getNodes().size(); i++) {
            NNNode node =layer.getNodes().get(i);
            double activation = node.getBias()+node.getWeight(0)*input;
           
            NNoutput = NNoutput+outputNode.getWeight(i) * activation;
         }
      
         error = error+Math.pow(NNoutput - expectedOutput, 2);
        System.out.println(NNoutput);
      }
      }
      return Math.sqrt(error / testData.size());
   }
   /* Goal: run each of our test inputs through the network. calculate accuracy of outputs via root mean squared error.
         
         start an error variable at zero. this will calculate the sum of squared errors.
         for each key/value pair in the test data map:
            "feed forward": run the input through the neural network to get the output.
                  reminder: hidden node activation = activationFunction(bias + weight * input)
                      output = bias + weight * activation for hidden node #1 + weight * activation for hidden node #2 + ...
            calculate the squared error: (predicted output - correct output)^2. add this to your error variable.
            optional: for debugging/learning purposes, print your input, expected output, and predicted output
         
         return the error: square root of (your error sum divided by the number of inputs in your test data set)         
      */
      
         
    

   public void train(Map<List<Double>, Double> trainingData, int epochs) {
      
      double[] secretActivation = new double [layer.getNodes().size()];
      for (int j = 0; j < epochs; j++) {
      
         for (Map.Entry<List<Double>, Double> entry : trainingData.entrySet()) {
         for (int k= 0; k<5;k++){
         double input = entry.getKey().get(k); 
            double expectedOutput = entry.getValue();
            double NNoutput = outputNode.getBias();
            for (int i = 0; i < layer.getNodes().size(); i++) {
               NNNode node =layer.getNodes().get(i);
               double activation = node.getBias()+node.getWeight(0)*input;
               secretActivation[i] = activation;
               NNoutput = NNoutput+outputNode.getWeight(i) * activation;
            }
         
            outputNode.setBias(outputNode.getBias() + learnRate * (expectedOutput - NNoutput));
            for (int i = 0; i < layer.getNodes().size(); i++) {
            
               outputNode.setWeight(i, outputNode.getWeight(i) + learnRate * (expectedOutput - NNoutput) * secretActivation[i]);
               NNNode node =layer.getNodes().get(i);
               double nodeError = (expectedOutput - NNoutput) * outputNode.getWeight(i);
               node.setBias(node.getBias() + learnRate * nodeError);
               
               node.setWeight(0, node.getWeight(0) + learnRate * nodeError * input); 
                             
            }
         }
         
         /* DO THIS METHOD LAST! Check in with your teacher before starting this method. */
         
         /*
            for each epoch:
               for each key/value pair in the training data map:
                  "feed forward": run the input through the neural network to get the output. HOWEVER,
                     this version, unlike your test() version, should save the hidden activations information -
                     we will need them later. consider storing them in a double[] secretActivation.
                     
                   "backpropogate": go backwards through the network (starting at output) and adjust weights/biases:
                     (note: I'm recommending you do multiple loops for this. It could technically be done with one loop,
                              but doing it with multiple is much more extensible for if you want to add more hidden layers later.)
         
                     first, update the output node's weights and bias:
                     calculate the output error (expected output - actual output from the feed forward) 
                     update the output node's bias: bias = bias + output error * learning rate
                     for each hidden layer node:
                         set the weight between that node and the output to: its previous weight + output error * learning rate * activation for that hidden node
                         
         
                     then, update the hidden layer node's weights and biases:
                     for each hidden layer node:
                         calculate the node's error: output error * weight from hidden node to output.
                         update the weight from input to this node to: previous weight + learning rate * node's error * input
                         update the bias for this node to: previous bias + learning rate * node's error
                           
                   
         */
         }
      }
     
   }
    
    
   
   /*
      Done with training and testing?  Check with your teacher to see if it works correctly!
      
      Then, try some optional challenges:
      
      1. Adjust your "hyperparameters"! What happens if you increase or decrease: 
            The learning rate? 
            The number of neurons in the hidden layer?
            The number of epochs?
            The way biases and weights are initialized in NNNode.java?
         More specifically, can you get your test error down to 0.5? 0.1? 0.01?
      
      2. Add an activation function. Google (or ask ChatGPT) for more information!
         Note: this requires some calculus to fully understand, but you can use it
               without understanding the calculus part.
   */
    
}