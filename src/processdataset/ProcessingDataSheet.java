/*Samuel Julien
* created on 9-20-17 */
package processdataset;
import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class ProcessingDataSheet {
    public static void main(String[]args)throws Exception {
        File processedData = new File("salary.txt");
        Scanner input = new Scanner(new File("src\\processdataset\\salary.txt"));
        int countAssistant = 0;
        double salAssistant = 0;
        int countFull = 0;
        double salFull = 0;
        int countAssociate = 0;
        double salAssociate = 0;
        try {


            while (input.hasNext()) {
                String token = input.next();
                if (token.equals("assistant")) {
                    countAssistant++;
                    salAssistant += input.nextDouble();
                }
                if (token.equals("associate")) {
                    countAssociate++;
                    salAssociate += input.nextDouble();
                }
                if (token.equals("full")) {
                    countFull++;
                    salFull += input.nextDouble();
                }
            }
        } catch (NoSuchElementException ex) {

        }
        java.io.PrintWriter output = new java.io.PrintWriter("SalarySummary.txt");
        double averageFull = salFull / countFull;
        double averageAssociate = salAssociate / countAssociate;
        double averageAssistant = salAssistant / countAssistant;
        double totalSalary = salAssistant + salAssociate + salFull;
        double averageTotal = (averageAssistant + averageAssociate + averageFull) / 3;
        output.printf("%-8s","The total of the salaries for Full Professors is: ");
        output.printf("%-8.2f", salFull);
        output.printf("%-8s", " The average salary for Full Professors is: ");
        output.printf("%-8.2f",averageFull);
        output.println();
        output.printf("%-8s","The total of the salaries for Assistant Professors is: ");
        output.printf("%-8.2f", salAssistant);
        output.printf("%-8s", " The average salary for Assistant Professors is: ");
        output.printf("%-8.2f",averageAssistant);
        output.println();
        output.printf("%-8s","The total of the salaries for Associate Professors is: ");
        output.printf("%-8.2f", salAssociate);
        output.printf("%-8s", " The average salary for Associate Professors is: ");
        output.printf("%-8.2f",averageAssociate);
        output.println();
        output.printf("%-8s","The total of the salaries for the faculty is: ");
        output.printf("%-8.2f", totalSalary);
        output.printf("%-8s", " The average salary for faculty is: ");
        output.printf("%-8.2f",averageTotal);
        output.println();
        output.close();
    }
}

