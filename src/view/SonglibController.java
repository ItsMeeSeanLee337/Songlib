// Sean Lee & Carlos Aguilar
package view;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SonglibController implements Initializable {

    Stage mainStage;

    @FXML
    private Button AddSongButton;

    @FXML
    private TextField AlbumTextf;

    @FXML
    private TextField ArtistTextf;

    @FXML
    private Button DeleteSongButton;

    @FXML
    private Button EditSongButton;

    @FXML
    private ListView<String> ListOfSongs;

    @FXML
    private TextField SongNameTextf;

    @FXML
    private TextField YearTextf;

    public void setMainStage(Stage stage) {
		mainStage = stage;
	}

    @FXML
    void AddSongClicked(ActionEvent event) {
        // Check that Name and Artist are not empty
        String name = SongNameTextf.getText().trim();
        String artist = ArtistTextf.getText().trim();
        if (name.isEmpty() || artist.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Name and Artist are mandatory fields.");
            alert.showAndWait();
            return;
        }

        // Check for duplicates
        String newSong = name + " | " + artist;
        for (String song : ListOfSongs.getItems()) {
            if (song.startsWith(newSong)) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Song already exists in the list.");
                alert.showAndWait();
                return;
            }
        }

        String album = AlbumTextf.getText().trim();
        newSong += " | " + album;
        String year = YearTextf.getText().trim();
        newSong += " | " + year;
        newSong += " | ";

        //creates a new alert, sets the title and text, and then stores the resulting button press in confirmation result
        Alert confirmation = new Alert(AlertType.CONFIRMATION);
        confirmation.setTitle("Add");
        confirmation.setContentText("Are you sure you want to add this song?");
        Optional<ButtonType> confirmationresult = confirmation.showAndWait();
        
        //if the confirmation result is ok, add
        if (confirmationresult.get() == ButtonType.OK){
            ListOfSongs.getItems().add(newSong);
            // Select the most recently added song
            ListOfSongs.getSelectionModel().select(newSong);
        }

        // Sort the list of songs by alphabetical order and update text file
        ListOfSongs.getItems().sort(String.CASE_INSENSITIVE_ORDER);
        File SonglistFile = new File("songlist.txt");
        try {
            BufferedWriter filewriter = new BufferedWriter(new FileWriter(SonglistFile));
            for(int count = 0; count < ListOfSongs.getItems().size() ; count++){
                filewriter.write(ListOfSongs.getItems().get(count)+ "\n");
            }
            filewriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Clear the text fields
        SongNameTextf.clear();
        ArtistTextf.clear();
        AlbumTextf.clear();
        YearTextf.clear();
    }

    @FXML
    void DeleteSongClicked(ActionEvent event) {

        // Store the current selected index
        int currentIndex = ListOfSongs.getSelectionModel().getSelectedIndex();

        // Create a new alert to confirm the deletion
        Alert confirmation = new Alert(AlertType.CONFIRMATION);
        confirmation.setTitle("Delete");
        confirmation.setContentText("Are you sure you want to delete this song?");
        Optional<ButtonType> confirmationResult = confirmation.showAndWait();

        // If the user confirms deletion, proceed with deleting the selected song
        if (confirmationResult.get() == ButtonType.OK) {
            // Remove the selected song from the list
            ListOfSongs.getItems().remove(currentIndex);

            // Select the next song in the list, or the previous song if there is no next song
            int numSongs = ListOfSongs.getItems().size();
            if (numSongs > 0) {
                int nextIndex = Math.min(currentIndex, numSongs - 1);
                ListOfSongs.getSelectionModel().select(nextIndex);
            } else {
                // If there are no songs left in the list, clear the selection
                ListOfSongs.getSelectionModel().clearSelection();
            }
        }


        // Sort the list of songs by alphabetical order and update text file
        ListOfSongs.getItems().sort(String.CASE_INSENSITIVE_ORDER);
        File SonglistFile = new File("songlist.txt");
        try {
            BufferedWriter filewriter = new BufferedWriter(new FileWriter(SonglistFile));
            for(int count = 0; count < ListOfSongs.getItems().size() ; count++){
                filewriter.write(ListOfSongs.getItems().get(count)+ "\n");
            }
            filewriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Clear the text fields
        SongNameTextf.clear();
        ArtistTextf.clear();
        AlbumTextf.clear();
        YearTextf.clear();
    }


    @FXML
    void EditSongClicked(ActionEvent event) {
        int selectedIndex = ListOfSongs.getSelectionModel().getSelectedIndex();
        if (selectedIndex < 0) {
            // no song selected, do nothing
            return;
        }
        //creates a new alert, sets the title and text, and then stores the resulting button press in confirmation result
        Alert confirmation = new Alert(AlertType.CONFIRMATION);
        confirmation.setTitle("Edit");
        confirmation.setContentText("Are you sure you want to edit this song?");
        Optional<ButtonType> confirmationresult = confirmation.showAndWait();

        //if the confirmation result is OK, delete
        if(confirmationresult.get() == ButtonType.OK){
            if (selectedIndex >= 0) {
                // check that name and artist fields are not empty
                String name = SongNameTextf.getText().trim();
                String artist = ArtistTextf.getText().trim();
                if (name.isEmpty() || artist.isEmpty()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Edit Error");
                    alert.setHeaderText("Name and Artist fields are mandatory.");
                    alert.setContentText("Please enter values for Name and Artist.");
                    alert.showAndWait();
                    return;
                }
                // Check for duplicates
                String newSong = name + " | " + artist;
                for (String song : ListOfSongs.getItems()) {
                    if (song.startsWith(newSong)) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Song already exists in the list.");
                        alert.showAndWait();
                        return;
                    }
                }
                String album = AlbumTextf.getText().trim();
                String year = YearTextf.getText().trim();
                // create the new song string with updated information
                String updatedSong = name + " | " + artist + " | " + album + " | " + year + " | ";
                // set the selected song to the updated song
                ListOfSongs.getItems().set(selectedIndex, updatedSong);

                // Sort the list of songs by alphabetical order and update text file
               ListOfSongs.getItems().sort(String.CASE_INSENSITIVE_ORDER);
                File SonglistFile = new File("songlist.txt");
                try {
                 BufferedWriter filewriter = new BufferedWriter(new FileWriter(SonglistFile));
                    for(int count = 0; count < ListOfSongs.getItems().size() ; count++){
                        filewriter.write(ListOfSongs.getItems().get(count)+ "\n");
                    }
                    filewriter.close();
                } catch (IOException e) {
                   // TODO Auto-generated catch block
                  e.printStackTrace();
                }

                // Clear the text fields
                SongNameTextf.clear();
                ArtistTextf.clear();
                AlbumTextf.clear();
                YearTextf.clear();

            }
        }
    }

    @FXML
    void SongSelected(MouseEvent event) {
        String selectedItem = ListOfSongs.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String[] songInfo = selectedItem.split("\\s*\\|\\s*");
            SongNameTextf.setText(songInfo[0]);
            ArtistTextf.setText(songInfo[1]);
            AlbumTextf.setText(songInfo[2]);
            YearTextf.setText(songInfo[3]);
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //Create a new file songlist.txt for reading/writing
        File SonglistFile = new File("songlist.txt");
        try {
            SonglistFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //create a writer for the file 
        try {
            Scanner SongReader = new Scanner(SonglistFile);
            while(SongReader.hasNext()){
                //sets the name of each category in the textbox
                String newSong = SongReader.nextLine();
                ListOfSongs.getItems().add(newSong);
            }
            SongReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
