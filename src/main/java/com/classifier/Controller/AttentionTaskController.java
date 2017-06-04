package com.classifier.Controller;

import com.classifier.Domain.App;
import com.classifier.Domain.AttentionTask;
import com.classifier.Domain.Keyboard;
import com.classifier.Domain.Mouse;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Catarina
 */
public class AttentionTaskController {

    private AttentionTask task;
    
    public AttentionTaskController() {
    }

    public AttentionTaskController(AttentionTask task) {
        this.task = task;
       
    }
    
    public AttentionTask createResultTask(ArrayList<App> listT, ArrayList<Mouse> listM, ArrayList<Keyboard> listk, Date finalD){
        task=new AttentionTask();
        long timeTotal=getTimeAtivity(listT,finalD);
        long timeOther=getOtherTime(listT,finalD,listM,listk);
        long timeAplication=timeTotal-timeOther;
        System.out.println("-----------" +timeAplication);
        task.setTimeActivity((double)timeTotal/60/1000);
        task.setTimeOther((double)timeOther/60/1000);
        task.setTimeAplication((double)timeAplication/60/1000);
        task.setListAplication(listT);
        task.setPercentagemAplication((timeAplication*100)/timeTotal);
        task.setPercentagemOther((timeOther*100)/timeTotal);
        return task;
    }
    
    public long getTimeAtivity(ArrayList<App>listT,Date finalDate){
        Date initialDate=listT.get(0).getTime();
        for (App list : listT) {
            if(list.getTime().before(initialDate)||list.getTime().equals(initialDate) ){
                initialDate=list.getTime();
                
            }
        }
        return finalDate.getTime()-initialDate.getTime();
    }
    
    public long getOtherTime(ArrayList<App>listT,Date finalD,ArrayList<Mouse> listM,ArrayList<Keyboard> listk){
        long time=0;int i=0;
        int cM=0;int kM=0;
        for ( i=0;i<listT.size()-1;i++) {
            if(listT.get(i).getListT().isEmpty()){
                time=time+(listT.get(i+1).getTime().getTime()-listT.get(i).getTime().getTime());
            }else{
                cM=cM+getMouseClicks(listM, listT.get(i+1).getTime(), listT.get(i).getTime());
                kM=kM+getKeyboardClicks(listk, listT.get(i+1).getTime(), listT.get(i).getTime());
                   
            }
        }
        if(listT.get(i).getListT().isEmpty()){
           time=time+(finalD.getTime()-listT.get(i).getTime().getTime());
        }else{
            cM=cM+getMouseClicks(listM, finalD, listT.get(i).getTime());
            kM=kM+getKeyboardClicks(listk,finalD, listT.get(i).getTime());

        }
        System.out.println(" cm - "+cM);
        task.setMouseC(cM);
        System.out.println(" km - "+kM);
        task.setKeyC(kM);
        return time;
    }
    public int getMouseClicks(ArrayList<Mouse> listM,Date f,Date i){
        int count=0;
        System.out.println("EEEEEEEEEEEEEEEEEEEEEEE "+listM.size());
        for (Mouse listM1 : listM) {
            
            if(listM1.getTimestamp()>i.getTime() && listM1.getTimestamp()<f.getTime()){
                if(listM1.getMv()>0){
                    count++;
                }
            }
        }
        
        return   count;    
    }
   
    public int getKeyboardClicks(ArrayList<Keyboard> listM,Date f,Date i){
        int count=0;
        System.out.println("WWWWWWWWWWWWWWWWWW "+listM.size());
        for (Keyboard listM1 : listM) {
            
            if(listM1.getTimestamp()>i.getTime() && listM1.getTimestamp()<f.getTime()){
                //if(listM1.getKdt()>0){
                    count++;
                //}
            }
        }
        
        return   count;    
    }
}
