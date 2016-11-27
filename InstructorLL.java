package algorithm;

/**
 *
 * @author Haninft
 */
public class InstructorLL {
    instrutorInfo head;

    public InstructorLL() {
        this.head = null;
    }
     
    public boolean isEmpty(){
        return this.head == null;
    }
    public boolean search(String data){
        return search(this.head, data);
    }
    private boolean search(instrutorInfo p, String data){
       
        
        while (p!= null) {
            if (p.getID().equals(data)) {  //If data is found
                return true;
            }
            p = p.getNext();  //Goes to next node in the list
        }
        return false;  //If data is not found after traversing the entire link list
    }
    
    //=================================================
    public void insert(String id, double workload, double effort, int maxWorkload, String majorI, String request ) { 
        
        this.head = insert(this.head, id, workload, effort, maxWorkload, majorI, request);
    }
    
    private instrutorInfo insert(instrutorInfo next, String id, double workload, double effort, int maxWorkload, String majorI, String request) { 
       
        
        if (head == null || Integer.parseInt(head.getID().substring(1,2)) < Integer.parseInt(id)) { //if the head is empty or the value of the head is smaller than the value we recieved
            // we will sort th values according to the student's id in decreasing order
            head = new instrutorInfo(head, id, workload, effort, maxWorkload, majorI, request);  
                                                                  
            return head;
        } 

        else {
           
            instrutorInfo helpPtr = head;

            while (helpPtr.getNext() != null) { 
                
                if (Integer.parseInt(head.getNext().getID().substring(1,2)) < Integer.parseInt(id)) {//if the help-pointer is empty or the value of the head is smaller than the value we recieved
                                                     // we will sort th values according to the student's id in decreasing order
                    break; 
                }
                //move to the next node
                helpPtr = helpPtr.getNext();
            }
            instrutorInfo newNode = new instrutorInfo(helpPtr.getNext(), id, workload, effort, maxWorkload, majorI, request);
            helpPtr.setNext(newNode); 
        }
        // Return head
        return head;
    }
    
    //======================================================================
    // Displaying a specific node
     public String display(String data) { 
        return display(head, data); 
                                                       
    }

    private String display(instrutorInfo p, String data) { 
        
        instrutorInfo helpPtr = p;  
        
        while (helpPtr != null) {   
        
            if (helpPtr.getID().equals(data)) {
               
              
              
            }
            helpPtr = helpPtr.getNext(); 
        }
        return null;
    }
    
      
    //======================================================================
    //return instructor id
     public String returnInstructorID(String data) { 
        return returnInstructorID(head, data); 
                                                       
    }

    private String returnInstructorID(instrutorInfo p, String data) { 
        
        instrutorInfo helpPtr = p;  
        
        while (helpPtr != null) {   
        
            if (helpPtr.getID().equals(data)) {
               
                return helpPtr.getID();
              
            }
            helpPtr = helpPtr.getNext(); 
        }
        return null;
    }
    
    public String[][] returnRequest(String data){
        return returnRequest(this.head, data);
    }
    
    private String[][] returnRequest(instrutorInfo p, String data){
       
        String listInstructor[][] = new String[10][5];
        int i = 0;
        while (p!= null) {
            if (p.getRequest(data) == true) {  //If data is found
                
                listInstructor[i][0] = p.getID();
                listInstructor[i][1] = ""+p.getWorkload();
                listInstructor[i][2] = ""+p.getEffort();
                listInstructor[i][3] = ""+p.getMaxWorkload();
                listInstructor[i][4] = p.getMajorI();
                i++;
            }
            p = p.getNext();  //Goes to next node in the list
        }
        return listInstructor;  //If data is not found after traversing the entire link list
    }


    
}
