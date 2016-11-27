package algorithm;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;

public class Algorithm {
    public int numSections = 5;
    public int numInstructors= 5;
    public double Satisfactionfactor= .5;
    double[][] weightMatrix = new double[numSections][numInstructors];
    double[][] ScoreMatrix = new double[numSections][numInstructors];
    double[][] assignMatrix = new double[numSections][numInstructors];
    
    public static void main(String[] args) throws FileNotFoundException {
        
        File inputFile = new File("input.in");
        Scanner input = new Scanner(inputFile);
        
        //instructor's attributes
        double workload = 0, 
                effort = 0;
        int maxWorkload = 0;
        String majorI = null;
        String request = null;
        int experience = 0;
        InstructorLL instructor = new InstructorLL();
        
        //course's attributes
        String majorC = null;
        int creditHour = 0;
        boolean isProject = false;
        int numStudent = 0;
        int numSection = 0;
        CoursesLL course = new CoursesLL();
        //get instructor/courses info
        String who = input.next();
        
        while(!who.equals("done")){
            
            if(who.substring(0, 1).equals("I")){
                workload = input.nextDouble();
                effort = input.nextDouble();
                maxWorkload = input.nextInt();
                majorI = input.next();
                request = input.next(); 
                experience = input.nextInt();
                System.out.println(workload+" "+effort+" "+maxWorkload+" "+majorI+" "+request+" "+experience);
                
                instructor.insert(who, workload, effort, maxWorkload, majorI, request);
                
            }else if(who.substring(0, 1).equals("C")){
                 majorC = input.next();
                 creditHour = input.nextInt();
                 isProject = input.nextBoolean();
                 numStudent = input.nextInt();
                 numSection = input.nextInt();
                 System.out.println(majorC+" "+creditHour+" "+isProject+" "+numStudent+" "+numSection);
                 course.insert(who, majorC, creditHour, isProject, numStudent, numSection);
            }
            
            who = input.next();
            
        }
        
        instructor.display("I1");
        course.display("C1");
        
        DistrbutAlgo(instructor, course);
    }
    
    public static void DistrbutAlgo(InstructorLL instructor, CoursesLL course){
        
        int i= 0;
        
        while (!course.searchSection(i).equals(null)) 
        {

            System.out.println(course.section.getSectionName());
            
            while (course.section.getInstructorAssigned()== null) 
            {
                 FindHighPriorityInstructorID(instructor,course.section, course);

                if (satisfactionLoad(InstructorID) > (totalAEPH(InstructorID)+ AEPH(course.section.getWeight(), InstructorID))) // && no constraints exception occurs 
                {
                    course.section.setInstructorAssigned(instructor.returnInstructor("I1"));
                }

                increaseTotalAEPH(InstructorID, AEPH(course.section.getWeight(), InstructorID));

                else if decresePriority(sectionPtr.ID , InstructorID);
            }// END WHILE 

        }//END WHILE 

    }
    
    private static int FindHighPriorityInstructorID(InstructorLL instructor, sectionInfo section, CoursesLL course) {
        String listInstructors[][] = instructor.returnRequest(course.returnCourseID("C1"));
        for(int i = 0 ; i < listInstructors.length ; i++){
           
                if(!listInstructors[i][0].equals(null)){
                    
                    String getID = listInstructors[i][0];
                    double Workload = Double.parseDouble(listInstructors[i][1]);
                    double Effort = Double.parseDouble(listInstructors[i][2]);
                    double MaxWorkload = Integer.parseInt(listInstructors[i][3]);
                    String MajorI = listInstructors[i][4];
                    
                    
                    if(Workload >= MaxWorkload) 
                        continue;
                    else{
                        if(MajorI == course.returnCourseID(getID)) {
                            Effort += 1;
                            Workload += Effort;
                        }
                        else {Effort -= 1;}
                        
                        listInstructors[i][1] = ""+Workload;
                        listInstructors[i][2] = ""+Effort;
                          
                    }
                    
                    
            }
        
        }
        
        return 1; 
    }

    private static int satisfactionLoad(int InstructorID) {
      return 1 ;
    }

    private static double totalAEPH(int InstructorID) {
        int sum = 0;
         // summation : 
         
           for (int i = 0; i <= numSections ; i++) {
              if (weightMatrix[i][InstructorID] != 0)
               sum += AEPH(i,InstructorID);
           }
           return sum;
         }

    private static double AEPH(double weight, int InstructorID) {
       return weightMatrix[section][InstructorID] ;

    }

    private static void increaseTotalAEPH(int InstructorID, boolean AEPH) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    private double getWeight(int Sid , int Iid) {
       
       return weightMatrix[Sid][Iid] ;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
