package com.app.util;

import com.app.domain.Query;
import com.app.domain.WaitTimeLine;

import java.util.ArrayList;
import java.util.Scanner;

public class Filler {

    private Scanner scanner;
    private int count;
    private ArrayList<Query> queries;
    private ArrayList<WaitTimeLine> timeLines;

    public void toFill() {
        scanner = new Scanner(System.in);
        count = scanner.nextInt();
        queries = new ArrayList<Query>();
        timeLines = new ArrayList<WaitTimeLine>();
        int i = 0;
        int queue = 1;
        while (scanner.hasNextLine() && i <= count) {
            String input = scanner.nextLine();
            String[] temp = input.split("\\ ");

            if(temp[0].toUpperCase().equals("C")) {
                WaitTimeLine timeLine = new WaitTimeLine(
                        temp[1],
                        temp[2],
                        temp[3].charAt(0),
                        temp[4],
                        Integer.parseInt(temp[5])
                );
                timeLine.setQueue(queue);
                timeLines.add(timeLine);

            } else if(temp[0].toUpperCase().equals("D")) {
                Query query = new Query(
                        temp[1],
                        temp[2],
                        temp[3].charAt(0),
                        temp[4]
                );
                query.setQueue(queue);
                queries.add(query);
            }
            queue++;
            i++;
        }
        scanner.close();
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public ArrayList<Query> getQueries() {
        return queries;
    }
    public void setQueries(ArrayList<Query> queries) {
        this.queries = queries;
    }
    public ArrayList<WaitTimeLine> getTimeLines() {
        return timeLines;
    }
    public void setTimeLines(ArrayList<WaitTimeLine> timeLines) {
        this.timeLines = timeLines;
    }
}
