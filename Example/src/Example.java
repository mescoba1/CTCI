import processing.core.*;

public class Example extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Example");
	}
	public void settings(){
		size(600,400);
	}
	public void setup(){
		fill(120,50,240);
	}
	public void draw(){
		ellipse(width/2, height/2, second(), second());
	}
}
