import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class gameController {
	
	// random boolean Matrix object 
	matrixOfLife mat = new matrixOfLife();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Canvas canv;
	private GraphicsContext gc;
	private int RECTSIZE; // rectangle size
	private int SIZE; // size of the boolean matrix

	@FXML

	void btnPressed(ActionEvent event) {
		// when button 'next generation' is pressed:
		
		// check given matrix with GameOflife rules method
		mat.gameOfLifeRules();
		for (int i = 0; i < mat.board.length; i++) {
			for (int j = 0; j < mat.board[0].length; j++) {
				
				// update the color of the cell if it's value changed to 1 ( alive )
				if (mat.board[i][j] == 1) {
					gc.setFill(Color.BLACK);
					gc.fillRect(j * RECTSIZE, i * RECTSIZE, RECTSIZE, RECTSIZE);
				
				// update the color of the cell if it's value changed to 0  ( dead )
				} else {
					gc.setFill(Color.WHITE);
					gc.fillRect(j * RECTSIZE, i * RECTSIZE, RECTSIZE, RECTSIZE);
				}
			}
			// every time the button is pressed, making the matrix to be updated to next generation, redraw the grid
			drawgrid();
		}
		
		// for debugging:
		System.out.println();
		System.out.println("Next Generation: ");
		mat.printMatrix();
	}
	

	@FXML
	void initialize() {

		gc = canv.getGraphicsContext2D();
		mat.printMatrix();
		
		// define canvas size
		canv.setWidth(300);
		canv.setHeight(300);
		
		// define Rectangle size ( cell size ) by canvas sizes
		RECTSIZE = (int) canv.getWidth() / 10;
		SIZE = mat.board.length;
		drawgrid();
	}

	// Draw the grid method
	private void drawgrid() {
		// Drawing lines as strokes in order to get a grid of rectangles with black lines
		for (int i = 0; i <= SIZE; i++) {
			gc.strokeLine(0, i * RECTSIZE, RECTSIZE * SIZE, i * RECTSIZE);
			gc.setLineWidth(2);
		}
		for (int i = 0; i <= SIZE; i++) {
			gc.strokeLine(i * RECTSIZE, 0, i * RECTSIZE, SIZE * RECTSIZE);
			gc.setLineWidth(2);
		}
		// initialize and present the started/current matrix
		for (int i = 0; i < mat.board.length; i++) {
			for (int j = 0; j < mat.board[0].length; j++) {

				gc.setFill(Color.WHITE);
				if (mat.board[i][j] == 1) {
					gc.setFill(Color.BLACK);
					gc.fillRect(j * RECTSIZE, i * RECTSIZE, RECTSIZE, RECTSIZE);
				}
			}
		}
	}

}
