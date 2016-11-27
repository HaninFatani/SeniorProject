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
public class sectionInfo {
    
    private String SectionName;
    private String instructorAssigned;//the assigned instructor into this section
    private double weight;
    private int numStudent;
    private int creditHour;
    
    public sectionInfo() {
        this.SectionName = null;
        this.instructorAssigned = null;
        this.numStudent = 0;
        this.creditHour = 0;
    } 

    public sectionInfo(String SectionName, int weight, int numStudent, int creditHour) {
        this.SectionName = SectionName;
        this.weight = weight;
        this.numStudent = numStudent;
        this.creditHour = creditHour;
    }
    
    public String getSectionName() {
        return SectionName;
    }

    public void setSectionName(String SectionName) {
        this.SectionName = SectionName;
    }

    public String getInstructorAssigned() {
        return instructorAssigned;
    }

    public void setInstructorAssigned(String instructorAssigned) {
        this.instructorAssigned = instructorAssigned;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
         
       this.weight = weight;
       this.weight += creditHour+(this.numStudent*0.5);
    }
    
    public int getNumStudent() {
        return numStudent;
    }

    public void setNumStudent(int numStudent) {
        this.numStudent = numStudent;
    }

    public int getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }
    
    
    
    
}
