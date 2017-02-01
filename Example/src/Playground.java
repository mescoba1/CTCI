import processing.core.*;

public class Playground extends PApplet {
	Ball b;

	public static void main(String[] args) {
		PApplet.main("Playground");
	}

	public void settings() {
		size(600, 400);
	}

	public void setup() {
		b = new Ball(25);
	}

	public void draw() {
		background(255,255,255);
		b.drawBall();
		b.updateBall();
	}

	class Ball {
		float diameter, xPos, yPos, xSpeed, ySpeed;

		public Ball(float diameter) {
			this.diameter = diameter;
			this.xPos = width / 2;
			this.yPos = height / 2;
			this.xSpeed = 3;
			this.ySpeed = 3;
		}

		public void updateBall() {
			xPos += xSpeed;
			yPos += ySpeed;
			if (xPos - diameter/2 < 0 || xPos + diameter/2 > width) {
				xSpeed *= -1;
			}
			if (yPos - diameter/2 < 0 || yPos + diameter/2 > height) {
				ySpeed *= -1;
			}
		}

		public void drawBall() {
			ellipse(xPos, yPos, diameter, diameter);
			fill(110,0,110);
		}
	}

}
