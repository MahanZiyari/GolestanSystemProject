package view;

import controller.EvaluationController;
import model.entity.EvaluationEntity;
import model.entity.TeacherEntity;
import model.service.EvaluationService;
import net.miginfocom.swing.MigLayout;


import javax.swing.*;
import java.awt.*;

public class EvaluationWindow extends JFrame{

    //------------------------ create component -----------------------
    Container container;

    int count;

    JProgressBar[] progressBar ;

    JLabel[] label ;

    JPanel panel = new JPanel();
    TeacherEntity entity;
    //------------------------------ constructor -----------------------
    public EvaluationWindow(TeacherEntity entity) throws Exception {

        //------------------ create
        count = EvaluationController.getInstance().Count(entity);
        progressBar = new JProgressBar[count];
        label = new JLabel[count] ;
        this.entity = entity;
        panel.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));


        int i=0;
        for (EvaluationEntity entityEval : EvaluationController.getInstance().progress(entity))
        {

            String lessonName = EvaluationController.getInstance().courseNameFinder(entityEval.getCourse_id());
            String loc_l,loc_p;

            if (i==0 )
            {
                loc_l="cell"+" "+"30 "+" "+i+" "+"3"+" "+i;
                loc_p="cell"+" "+"40"+" "+i+" "+"3"+" "+i;
            }
            else {
                loc_l="cell"+" "+"30 "+" "+i+1 +" "+"3"+" "+i;
                loc_p="cell"+" "+"40"+" "+i+1 +" "+"3"+" "+i;
            }
            ProgressBar(0,lessonName,i ,loc_l,loc_p);
            i+=1;
        }
        // --------------- set
        this.setVisible(true);
        setBounds(200,10,700,700);

        //-------------add
        container = getContentPane();
        container.add(panel);
        Thread thread;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int i = 0, j = 0;
                try {
                    for (EvaluationEntity evaluationEntity : EvaluationController.getInstance().progress(entity)){

                        progressBar[j].setBackground(Color.LIGHT_GRAY);
                        progressBar[j].setForeground(Color.cyan.darker());
                        int value =(int) evaluationEntity.getScore();
                        i = 0;
                        while (i <= value) {
                            // fill the menu bar
                            progressBar[j].setValue(i + 5);
                            Thread.sleep(1000);
                            // delay the thread
                            i += 10;
                        }
                        j++;
                        color();

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread = new Thread(runnable);
        thread.start();





    }

    //------------------------- progress bar --------------------------
    public  void  ProgressBar(double value ,String lessonName , int i, String locationLable ,String locationPrg){
        // create
         label [i]= new JLabel(lessonName+" :  ");
         progressBar[i] = new JProgressBar();
         progressBar[i].setValue((int) value);
         progressBar[i].setStringPainted(true);


         // set


         // add
         panel.add(label[i] , locationLable);
         panel.add(progressBar[i],locationPrg);

     }


     //-------------------------- thread ------------------------------
      public void fill(int value ,int j){
          int i = 0;
          try {
              while (i <= value) {
                  // fill the menu bar
                  progressBar[j].setValue(i + 5);
                  Thread.sleep(1000);
                  // delay the thread
                  i += 10;
              }
          }
          catch (Exception e) {
          }
      }public  void color(){
        // -------------thread
      int   i=0;
        try {
            for (EvaluationEntity entityEval_fill : EvaluationController.getInstance().progress(entity))
            {

                int value =(int) entityEval_fill.getScore();

                progressBar[i].setBackground(Color.lightGray);

                if(value<=60)
                {
                    if (value<=30)
                        progressBar[i].setForeground(Color.red);
                    else
                        progressBar[i].setForeground(Color.YELLOW.darker());
                }
                else
                    progressBar[i].setForeground(Color.green.darker());


                i+=1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
      }


