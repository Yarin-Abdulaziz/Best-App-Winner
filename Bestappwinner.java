package bestappwinner;

/**
 *
 * @author yarin
 */
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
public class Bestappwinner {
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        //create 2 files one for reading and the other to write in.
        File InputFile = new File("input.txt");
        File OutputFile = new File("output.txt");
        //make sure the file that you want to read is exixted.
        if (!(InputFile.exists())) {
            System.out.println("Source file " + InputFile + " dose not exists");
            System.exit(0);
        }
          //create a Scanner to read from the file.
             Scanner input = new Scanner(InputFile); 
          //create a printwriter to write in the file.
            PrintWriter output = new PrintWriter(OutputFile);   
           //display a greating statment to the user.
              
            output.println("\n\n***** Welcome to Best App Winner System *****\n");
    
       //creat an array for number of universities.
       String [] uni = new String[input.nextInt()];
       
       //creat an array for number of students.
       String [][] student = new String[uni.length][];
       
       //creat two single dimensional arrays for day and date.
       String [] day = new String[input.nextInt()];
       String [] date = new String[day.length];
       
       //make a loop to store number of students in each university in the students array.
       for (int i = 0; i<uni.length; i++){
        student [i]= new String[input.nextInt()];
       }
       
       //creat an array for the number of categories of the contest.
       String [] Criteria = new String[input.nextInt()];
       
       //creat three dimensional array to store the number of points each student got in each criteria.
       int [][][] score= new int[uni.length][][];
       for (int i = 0; i<student.length;i++){
          score[i]=new int[student[i].length][Criteria.length];
       }
       //creat an empty variable.
      String command = "";
        
       // make while loop that will contain swich.
        while (!command.equalsIgnoreCase("Quit")) {
            command = input.next();

       //we wil use the cases of this switch to read each command from the file.
            switch (command) { 

                case "addUniversity":{
                     	addUniversity(uni, input);
                        break;
                }
                 case "addDays": {
                     	addDays(day, input);
                        break;  
                 }
                  case "addDates":{
                     	 addDates(date, input);
                        break;
                  }    
                  case "addStudentsName":{
                     	 addStudentsName(student,uni, input);
                        break;
                  }
                   case "addAwardCriteria":{
                     	addAwardCriteria(Criteria, input);
                        break;
                   }
                    case "addScore":{
                     	addScore(score,student,uni,Criteria, input);
                        break;
                    }   
                    case "printcontestDetails":{
                     	printcontestDetails(uni,day, date,  output);
                        break;
                    }   
                    case "printcontestdetailResults":{
                     	printcontestdetailResults(uni, student,Criteria ,score, output);
                        break;
                    }   
                     case "printwinnerAwardByEachCriteria":{
                     	printwinnerAwardByEachCriteria(uni,student,score,Criteria,output);
                        break;
                    }   
                   case "Quit": {
                    
                   output.println("	Thank you for using Best App Winner System, Good Bye!\n ");     
                   output.flush();
                   output.close();
                   input.close(); 
                    break;
                }
           
            } 
                
        }
       }
      //------------------------------------------------------------------
     //method to add university in the system
            public static void addUniversity (String [] university, Scanner input){
    
        for (int i =0;i<university.length;i++){
        university[i]=input.next();
        }
    }
     //------------------------------------------------------------------
     //method to add students name to the system
    public static void addStudentsName(String[][] students,String[]university,Scanner input){
       for(int i = 0; i<university.length;i++){
           for (int j = 0;j<students[i].length;j++){
               students[i][j]=input.next();
           }
       }
    
    }
     //------------------------------------------------------------------
    //method to add days to system
    public static void addDays (String [] days, Scanner input){
    
         for (int i =0;i<days.length;i++){
        days[i]=input.next();
        }
    
    }
     //------------------------------------------------------------------
     //method to add dates to system
    public static void addDates (String [] dates, Scanner input){
    
        for (int i =0;i<dates.length;i++){
        dates[i]=input.next();
        }
    }
      //------------------------------------------------------------------
     //method to add award criteria to the system
    public static void addAwardCriteria(String [] Criteria, Scanner input){
    
        for (int i =0;i<Criteria.length;i++){
        Criteria[i]=input.next();
        }
    }
     //------------------------------------------------------------------
    //method to add scores to the system
    public static void addScore(int [][][] points,String [][] students,String []university, 
            String [] contestCriteria, Scanner input){
       
        for (int i =0;i<university.length;i++){
            for (int j = 0; j<students[i].length;j++){
                for (int k = 0; k<contestCriteria.length;k++){
                 points[i][j][k]=input.nextInt();
                }
            }
        }
    }
     //------------------------------------------------------------------
    //Method to print contest details
    public static void printcontestDetails(String[] university,String[]day,
            String[] date, PrintWriter write){
             write.println("------------  Contest App details are as follows ------");
             write.println("University Name                Contest Day                    Contest Date                   ");
             write.println("------------------------------------------------------------------------------");
         for (int i = 0; i<university.length;i++){
             write.printf(" %-30s%-31s%-31s\n",textSplit(university[i]),textSplit(day[i]),
             textSplit2(date[i]));
             }
          write.println();
    }
    
     //------------------------------------------------------------------
    //Method to print contest detail result
    public static void printcontestdetailResults(String[] university,
            String[][]students,String [] contestCriteria ,int [][][] points,PrintWriter write){
         for (int i = 0; i<university.length;i++){
              write.println("---Contest Results of  "+textSplit(university[i]
                           +" is as Follows ---"));
              write.println();
              for (int j = 0;j<students[i].length;j++){
                   write.println("---Student Name   "+textSplit(students[i][j])+
                   " points  are as Follows ---");
                   for (int k = 0;k<contestCriteria.length;k++){
                       write.println(textSplit(" "+contestCriteria[k])+" : "+points[i][j][k]);
                       }
            
              write.println();
              }
        }
    
    }
     //------------------------------------------------------------------
    //Method to print winners from each university based on contest categories
    public static void printwinnerAwardByEachCriteria(String[] university,
          String [][]students, int [][][] points, String [] contestCriteria, PrintWriter write){
       
   
       for(int i = 0; i<contestCriteria.length; i++){
           
          for(int j = 0;j<university.length;j++){
             write.println("--- Results of  " + textSplit(university[j]) + " is as Follows ---");
             write.println(" Contest Winner name in Category:   "+textSplit(contestCriteria[i])+" : ");
             int maximum = 0;
             String winner=null;
                   for (int k=0;k<students[j].length;k++){ 
                        if(maximum<points[j][k][i]){
                        maximum=points[j][k][i];
                        winner=students[j][k];
                        }
                    }
             write.println(" "+textSplit(winner)+"\n");
              
          }
      }
    }
     //------------------------------------------------------------------
    //Method to replace every "_" with the wanted character
    public static String textSplit(String word){
        String word1=word.replaceAll("_", " ");
    return word1;
    }
     //------------------------------------------------------------------
    //Method to replace every "_" with the wanted character
    public static String textSplit2(String word){
        String word1=word.replaceAll("_", "/");
    return word1;
    }

}
