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
public class instrutorInfo {
    //variables I need 
    instrutorInfo next;
    private String ID;
    private double workload , effort;
    private int maxWorkload, experience;
    private String majorI;
    private String request [];
    
    
    public instrutorInfo() {
        this.next = null;
        this.ID = null;

    }

    public instrutorInfo(instrutorInfo next, String ID, double workload, double effort, int maxWorkload, String majorI, String request, int experience) {
        this.next = next;
        this.ID = ID;
        this.workload = workload;
        this.effort = effort;
        this.maxWorkload = maxWorkload;
        this.majorI = majorI;
        this.request = new String[1];
        for(int i = 0 ; i < this.request.length ; i++){
            if(this.request[i] == null){
                this.request[i] = request;
                break;
            }
        }
        
        this.experience = experience;
        
    }

    public instrutorInfo getNext() {
        return next;
    }

    public void setNext(instrutorInfo next) {
        this.next = next;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getWorkload() {
        return workload;
    }

    public void setWorkload(double workload) {
        this.workload = workload;
    }

    public double getEffort() {
        return effort;
    }

    public void setEffort(double effort) {
        this.effort = effort;
    }

    public int getMaxWorkload() {
        return maxWorkload;
    }

    public void setMaxWorkload(int maxWorkload) {
        this.maxWorkload = maxWorkload;
    }

    public String getMajorI() {
        return majorI;
    }

    public void setMajorI(String majorI) {
        this.majorI = majorI;
    }

    public boolean getRequest(String match) {
        for(int i = 0 ; i < this.request.length ; i++){
            if(this.request[i].equals(match)){
               
                return true;
            }
        }
        return false;
    }

    public void setRequest(String request) {
        for(int i = 0 ; i < this.request.length ; i++){
            if(this.request[i] == null){
                this.request[i] = request;
                break;
            }
        }
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    
}
