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
    double[][] assignMatrix = new double[numSections][numInstructors];
    
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * retrive the date from file instead of database
         * The data will be stored temporary in linked-list
         */
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
        //=====================================================================
        String IorC = input.next();
        
        //store data in the linked list Instructors/Courses 
        while(!IorC.equals("done")){
            
            if(IorC .substring(0, 1).equals("I")){
                workload = input.nextDouble();
                effort = input.nextDouble();
                maxWorkload = input.nextInt();
                majorI = input.next();
                request = input.next(); 
                experience = input.nextInt();
                System.out.println(workload+" "+effort+" "+maxWorkload+" "+majorI+" "+request+" "+experience);
                
                instructor.insert(IorC, workload, effort, maxWorkload, majorI, request, experience);
                
            }else if(IorC.substring(0, 1).equals("C")){
                 majorC = input.next();
                 creditHour = input.nextInt();
                 isProject = input.nextBoolean();
                 numStudent = input.nextInt();
                 numSection = input.nextInt();
                 System.out.println(majorC+" "+creditHour+" "+isProject+" "+numStudent+" "+numSection);
                 course.insert(IorC, majorC, creditHour, isProject, numStudent, numSection);
            }
            
            IorC = input.next();
            
        }
        /**
        instructor.display("I1");
        course.display("C1");
        */
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
        double[][] ScoreMatrix;
        double[][] assignMatrix;
        String listCourses[][] = course.returnCourseAttribute();
        String listInstructors[][] = instructor.returnAllInstructor();
        int i = 0;
        int j = 0;
        
        while(listCourses[i][0] != null){
                
            String CourseID = listCourses[i][0];
            String MajorC = listCourses[i][1];
            boolean IsProject = Boolean.parseBoolean(listCourses[i][2]); 
            int NumSection = Integer.parseInt(listCourses[i][3]);
            ScoreMatrix = new double[instructor.returnCounter()][NumSection];
            assignMatrix = new double[instructor.returnCounter()][NumSection];
            
            
            while(!listInstructors[j][0].equals(null)){
                
               
                
                String InstID = listInstructors[j][0];
                double Workload = Double.parseDouble(listInstructors[j][1]);
                double Effort = Double.parseDouble(listInstructors[j][2]);
                double MaxWorkload = Integer.parseInt(listInstructors[j][3]);
                String MajorI = listInstructors[j][4];
                int experienc = Integer.parseInt(listInstructors[j][5]);
                
                //compare request and course
                if(instructor.returnRequest(InstID ,CourseID)){
                    ScoreMatrix[i][j] += 10;
                //compare major, true weight
                    if(MajorI.equals(MajorC)){
                        ScoreMatrix[j][i] += 30;
                    }   
                    if(experienc>0) ScoreMatrix[j][i] += 30;
                }
                j++;
 
            }
            int n = 0;
            double max = ScoreMatrix[i][0];
            for(n = 0 ; n <ScoreMatrix[i].length ; n++){
                if(max < ScoreMatrix[i][n])
                    max = ScoreMatrix[i][n];
            }
            assignMatrix[i][n] = max;
            i++;
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
