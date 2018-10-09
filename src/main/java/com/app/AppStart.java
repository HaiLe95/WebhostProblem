package com.app;

import com.app.domain.Query;
import com.app.domain.WaitTimeLine;
import com.app.util.Filler;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AppStart {

    public static boolean serviceTest(Query query, WaitTimeLine line) {
        try {
            if (query.serviceIgnore()) {
                return true;
            }
            String[] queryArray = query.getServiceId().split(".");
            String[] timeLineArray = line.getServiceId().split(".");
            for (int i = 0; i < queryArray.length; i++) {
                if (queryArray[i] != timeLineArray[i]) {
                    return false;
                }
            }
            return true;

        } catch(ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean questionTest(Query query, WaitTimeLine line) {
        try {
            if (query.questionIgnore()) {
                return true;
            }
            String[] queryArray = query.getQuestionType().split(".");
            String[] timeLineArray = line.getQuestionType().split(".");
            for (int i = 0; i < queryArray.length; i++) {
                if (queryArray[i] != timeLineArray[i]) {
                    return false;
                }
            }
            return true;
        } catch(ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    // Checked
    public static boolean dateTest(Query query, WaitTimeLine timeLine) {
        Date qStartDate = query.getStartDate();
        Date qFinalDate = query.getFinalDate();
        Date timeLineDate = timeLine.getTimeLineDate();
        return !(timeLineDate.before(qStartDate) || timeLineDate.after(qFinalDate));
    }



    public static void main(String[] args) {

        Filler filler = new Filler();
        filler.toFill();



        ArrayList<Query> queries = filler.getQueries();
        ArrayList<WaitTimeLine> timeLines = filler.getTimeLines();


        int sumOfTimeLines;
        int cycles;
        boolean check;
        for(int i = 0; i < queries.size(); i++) {
            Query query = queries.get(i);
            check = true;
            int indexOfTimeLine = 0;
            cycles = 0;
            sumOfTimeLines = 0;
            while(check && timeLines.size() > indexOfTimeLine) {
                WaitTimeLine timeLine = timeLines.get(indexOfTimeLine);
                if(query.getQueue() < timeLine.getQueue()) {
                    check = false;
                } else if(serviceTest(query, timeLine) && questionTest(query, timeLine) && dateTest(query, timeLine)) {
                        sumOfTimeLines += timeLine.getWaitTime();
                        cycles++;
                        indexOfTimeLine++;
                } else {
                    indexOfTimeLine++;
                }
            }

            if(sumOfTimeLines == 0 || cycles == 1) {
                System.out.println("-");
            } else {
                System.out.println(sumOfTimeLines/cycles);
            }
        }

    }
}
