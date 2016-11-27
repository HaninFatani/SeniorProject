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
public class CoursesInfo {
    
    private CoursesInfo next;
    private String CourseID;
    private String major;
    private int creditHour;
    private boolean isProject;
    private int numStudent;
    private int NumSection;
    private sectionInfo section[];
    
    
    public CoursesInfo() {
   
        this.CourseID = null;
        this.major = null;
        this.creditHour = 0;
        this.isProject = false;
        this.NumSection = 0;
        this.section = null;
        this.next = null;
        
    } 

    public CoursesInfo(CoursesInfo next, String CourseID, String major, int creditHour, boolean isProject, int numStudent, int NumSection) {
        this.next = next;
        this.CourseID = CourseID;
        this.major = major;
        this.creditHour = creditHour;
        this.isProject = isProject;
        this.NumSection = NumSection;
        this.section = new sectionInfo[this.NumSection];
        
        for(int i = 0 ; i< this.section.length ; i++){
            this.section[i] = new sectionInfo();
            
            this.section[i].setNumStudent(numStudent);
             this.section[i].setCreditHour(this.creditHour);
            this.section[i].setSectionName(""+(1+i));
        }
    }

    public CoursesInfo getNext() {
        return next;
    }

    public void setNext(CoursesInfo next) {
        this.next = next;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    public boolean isIsProject() {
        return isProject;
    }

    public void setIsProject(boolean isProject) {
        this.isProject = isProject;
    }

    public int getNumSection() {
        return NumSection;
    }

    public void setNumSection(int NumSection) {
        this.NumSection = NumSection;
    }

    public sectionInfo getSection(int i) {
        return section[i];
    }

    public void setSection(int section, String instructor) {
        for(int i = 0 ; i< this.section.length ; i++){
           if(this.section[i].getInstructorAssigned().equals(null))
               this.section[i].setInstructorAssigned(instructor);
        }
    }

    
    
}
