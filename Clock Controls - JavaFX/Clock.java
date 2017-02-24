package ex15_32;
//Author: Shane Asel

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Clock extends Pane {
    private int hour;
    private int minute;
    private int second;
    private Timeline animation;

    //Clock pane width and height
    private double w = 450, h = 450;

    //Build default clock with the current time
    public Clock() {
        setCurrentTime();
        animation = new Timeline(
            new KeyFrame(Duration.millis(1000), e -> moveClock()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    //Build clock with specified hour, min, and sec
    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        paintClock();
        animation = new Timeline(
            new KeyFrame(Duration.millis(1000), e -> moveClock()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    //Return hour
    public int getHour() {
	return hour;
    }

    //Set new hour
    public void setHour(int hour) {
	this.hour = hour;
	paintClock();
    }

    //Return min
    public int getMinute() {
	return minute;
    }

    //Set new min
    public void setMinute(int minute) {
	this.minute = minute;
	paintClock();
    }

    //Return sec
    public int getSecond() {
	return second;
    }

    //Set new sec
    public void setSecond(int second) {
	this.second = second;
	paintClock();
    }

    //Return clock pane's width
    public double getW() {
	return w;
    }

    //Set clock pane's width
    public void getW(double w) {
	this.w = w;
	paintClock();
    }

    //Return clock pane's height
    public double getH() {
	return h;
    }

    //Set clock pane's height
    public void setH(double h) {
	this.h = h;
	paintClock();
    }

    //Set current time for clock
    public void setCurrentTime() {
        //Build cal for current date + time
	Calendar calendar = new GregorianCalendar();

	//Set current hour, min, and sec
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        //Repaint clock
        paintClock(); 
    }
	
    //Paint clock
    protected void paintClock() {
	//Initialize clock param
        double clockRadius = Math.min(w, h) * 0.8 * 0.5;
        double centerX = w / 2;
        double centerY = h / 2;

	//Draw circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

        //Draw sec hand
        double sLength = clockRadius * 0.9;
        double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.BROWN);

        //Draw min hand
        double mLength = clockRadius * 0.75;
        double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, xMinute, minuteY);
        mLine.setStroke(Color.SILVER);

        //Draw hour hand 
        double hLength = clockRadius * 0.55;
        double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GOLD);

        getChildren().clear();
        getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
    }

	//Animate clock
	protected void moveClock() {
            if (minute == 60) {
		hour += 1; 
            }	
            if (second == 60) {
		minute += 1;
            }
            second = (second < 60 ? second + 1 : 1);
            paintClock();	
	}

	public void play() {
            animation.play();
	}

	public void pause() {
            animation.pause();
	}
}