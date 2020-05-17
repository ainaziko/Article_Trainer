package sample;

import java.awt.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label art;

    @FXML
    private Label label;

    @FXML
    private Button dieButton;

    @FXML
    private Button derButton;

    @FXML
    private Button dasButton;

    @FXML
    private Button nextButton;

    @FXML
    private Label meaning;

    @FXML
    private Label plural;

    @FXML
    private ProgressBar progress;

    @FXML
    private Label emptyPlace;

    @FXML
    private Label finishLabel;

    @FXML
    void der(ActionEvent event) {

    }
    static double i = 0;


    @FXML
    void initialize() {
        finishLabel.setVisible(false);
        emptyPlace.setVisible(false);
        derButton.setVisible(false);
        dieButton.setVisible(false);
        dasButton.setVisible(false);
        progress.setVisible(false);
        derButton.setOnAction(e -> der());
        dieButton.setOnAction(e -> die());
        dasButton.setOnAction(e -> das());
        nextButton.setOnAction(e -> update());
    }

    // updating and getting the next word
    public void update() {
        //icon.setImage(null);
        emptyPlace.setVisible(true);
        progress.setVisible(true);
        nextButton.setText("Next");
        nextButton.setVisible(false);
        dasButton.setVisible(true);
        derButton.setVisible(true);
        dieButton.setVisible(true);
        String word = getRundomWord();

        int stopEnglish = word.indexOf("–");
        int stopGerman = word.indexOf("~");

        meaning.setText(word.substring(0,stopEnglish));
        label.setText(word.substring(stopEnglish + 6, stopGerman));
        art.setText(word.substring(stopEnglish + 2,stopEnglish + 5));
        plural.setText(word.substring(stopGerman, word.length()));
        plural.setVisible(false);
        art.setVisible(false);
        meaning.setVisible(false);
    }



    // function for the button "der"
    public void der(){
        emptyPlace.setVisible(false);
        String der = "Der";
        String answer = art.getText();
        art.setVisible(true);
        meaning.setVisible(true);
        plural.setVisible(true);
        dasButton.setVisible(false);
        derButton.setVisible(false);
        dieButton.setVisible(false);
        nextButton.setVisible(true);
        if(!der.equals(answer)){ // checking if the user's answer is true or false
            art.setTextFill(javafx.scene.paint.Color.RED);
        } else {
            if(i >= 1){
                art.setVisible(false);
                derButton.setVisible(false);
                dieButton.setVisible(false);
                dasButton.setVisible(false);
                nextButton.setVisible(false);
                label.setVisible(false);
                meaning.setVisible(false);
                plural.setVisible(false);
                progress.setVisible(false);
                finishLabel.setVisible(true);
            } else {
                i += 0.001;
                progress.setProgress(i);
                art.setTextFill(javafx.scene.paint.Color.GREEN);
            }
        }

    }
// funtion for the button "die"
    public void die(){
        emptyPlace.setVisible(false);
        String die = "Die";
        String answer = art.getText();
        art.setVisible(true);
        meaning.setVisible(true);
        plural.setVisible(true);
        dasButton.setVisible(false);
        derButton.setVisible(false);
        dieButton.setVisible(false);
        nextButton.setVisible(true);
        if(!die.equals(answer)){
            art.setTextFill(javafx.scene.paint.Color.RED);
        } else {
            if(i >= 1){
                art.setVisible(false);
                derButton.setVisible(false);
                dieButton.setVisible(false);
                dasButton.setVisible(false);
                nextButton.setVisible(false);
                label.setVisible(false);
                meaning.setVisible(false);
                plural.setVisible(false);
                progress.setVisible(false);
                finishLabel.setVisible(true);
            } else {
                i += 0.001;
                progress.setProgress(i);
                art.setTextFill(javafx.scene.paint.Color.GREEN);
            }
        }

    }
// function for button 'das'
    public void das(){
        emptyPlace.setVisible(false);
        String d = "Das";
        String answer = art.getText();
        art.setVisible(true);
        meaning.setVisible(true);
        plural.setVisible(true);
        dasButton.setVisible(false);
        derButton.setVisible(false);
        dieButton.setVisible(false);
        nextButton.setVisible(true);
        if(!d.equals(answer)){
            art.setTextFill(javafx.scene.paint.Color.RED);
        } else {
            if(i >= 1){
                art.setVisible(false);
                derButton.setVisible(false);
                dieButton.setVisible(false);
                dasButton.setVisible(false);
                nextButton.setVisible(false);
                label.setVisible(false);
                meaning.setVisible(false);
                plural.setVisible(false);
                progress.setVisible(false);
                finishLabel.setVisible(true);
            } else {
                i += 0.001;
                progress.setProgress(i);
                art.setTextFill(javafx.scene.paint.Color.GREEN);
            }
        }

    }


    //Getting a random word
    public String getRundomWord(){
        ArrayList listOfWords = new ArrayList();
        try {
            File myObj = new File("/Users/mac/Downloads/Article_Trainer-master/Project/src/derdiedas.txt"); //reading a file
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                listOfWords.add(data);// adding every word to list
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //getting a random word from a list
        Random random = new Random();
        String word = (listOfWords.get(random.nextInt(listOfWords.size())) + " ");
        return word;
    }
}
