/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author Haninft
 */
public class CoursesLL {
    CoursesInfo head;

    public CoursesLL() {
        this.head = null;
    }
     
    //=================================================
    public boolean isEmpty(){
        return this.head == null;
    }
    //=================================================
    public boolean search(String data){
        return search(this.head, data);
    }
    
    private boolean search(CoursesInfo p, String data){
       
        
        while (p!= null) {
            if (p.getCourseID().equals(data)) {  //If data is found
                return true;
            }
            p = p.getNext();  //Goes to next node in the list
        }
        return false;  //If data is not found after traversing the entire link list
    }
    
    //=================================================
    public sectionInfo searchSection(int data){
        
        return searchSection(this.head, data);
    }
    sectionInfo section = new sectionInfo();
    private sectionInfo searchSection(CoursesInfo p, int data){
       
        
        
        while (p!= null) {
            if (p.getSection(data) != null ) {  //If data is found
                section = p.getSection(data);
                
                return  section;
            }
            p = p.getNext();  //Goes to next node in the list
        }
        return null;  //If data is not found after traversing the entire link list
    }
    
    //=================================================
    public void insert(String id, String major, int creditHour, boolean isProject, int numStudent, int NumSection) { 
        
        this.head = insert(this.head, id, major, creditHour, isProject, numStudent, NumSection);
    }
    
    private CoursesInfo insert(CoursesInfo head, String id, String major, int creditHour, boolean isProject, int numStudent, int NumSection) { 
       
        if (head == null) { //if the head is empty or the value of the head is smaller than the value we recieved
                            // we will sort th values according to the student's id in decreasing order
            head = new CoursesInfo(head, id, major, creditHour, isProject, numStudent, NumSection);  
                                                                  
            return head;
        } 

        else {

            CoursesInfo helpPtr = head;

            while (helpPtr.getNext() != null) { 
                
                if (Integer.parseInt(head.getNext().getCourseID().substring(1,2)) < Integer.parseInt(id)) {//if the help-pointer is empty or the value of the head is smaller than the value we recieved
                                                     // we will sort th values according to the student's id in decreasing order
                   
                    break; 
                }
                //move to the next node
                helpPtr = helpPtr.getNext();
            }
            CoursesInfo newNode = new CoursesInfo(helpPtr.getNext(), id, major, creditHour, isProject, numStudent, NumSection);
            helpPtr.setNext(newNode);  
        }
        // Return head
        return head;
    }
    
        //======================================================================
    // Displaying a specific node
     public String display(String data) { 
        return display(this.head, data); 
                                                       
    }

    private String display(CoursesInfo p, String data) { 
        
        CoursesInfo helpPtr = p;  
        
        while (helpPtr != null) {   
        
            if (helpPtr.getCourseID().equals(data)) {
               
                

            }
            helpPtr = helpPtr.getNext(); 
        }
        return null;
    }
    
    //=================================================================
    //=================================================
    public String returnCourseID(String data){
        return returnCourseID(this.head, data);
    }
    
    private String returnCourseID(CoursesInfo p, String data){
       
        
        while (p!= null) {
            if (p.getCourseID().equals(data)) {  //If data is found
                return p.getCourseID();
            }
            p = p.getNext();  //Goes to next node in the list
        }
        return null;  //If data is not found after traversing the entire link list
    }
    
    public String[][] returnCourseAttribute(){
        return returnCourseAttribute(this.head);
    }
    
    private String[][] returnCourseAttribute(CoursesInfo p){
       
        String listInstructor[][] = new String[10][4];
        int i = 0;
        while (p!= null) {
          
                
                listInstructor[i][0] = p.getCourseID();
                listInstructor[i][1] = p.getMajor();
                listInstructor[i][2] = ""+p.isIsProject();
                listInstructor[i][3] = ""+p.getNumSection();
                i++;
                
            p = p.getNext();  //Goes to next node in the list
        }
        return listInstructor;  //If data is not found after traversing the entire link list
    }
   


}
