
import smile.Network;
import smile.SMILEException;
import smile.learning.DataSet;
import smile.learning.TAN;

public class testA {
	public static void main(String args[]) {
			try {
				
				System.load("/Users/DanyangLi/Documents/workspace/Decision/libjsmile.jnilib");
				
				DataSet data = new DataSet();
				data.readFile("univ_20_dis.txt");

				TAN tan = new TAN();// a Tree Augmented Naive Bayes learning
				tan.setClassVariableId("university");
				tan.setRandSeed(0);
				tan.setMaxSearchTime(0);
				Network net = tan.learn(data);
				
				
				net.setEvidence("financialAid", "Yes");
				net.updateBeliefs();
				
				net.getNode("university");
				String[] aUniversityIds = net.getOutcomeIds("university");
				double[] aValues = net.getNodeValue("university");
				for (int i = 0; i < aUniversityIds.length; i++) {
					System.out.println(aUniversityIds[i] + ": "+ aValues[i]);
				}
				
				
			} catch (SMILEException e) {
				System.out.println(e.getMessage());
			}
		}
	
}
