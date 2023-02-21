package view;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SonglibController {

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
        //sets the name of each category in the textbox
        String name = SongNameTextf.getText().trim();
        String artist = ArtistTextf.getText().trim();
        String album = AlbumTextf.getText().trim();
        String year = YearTextf.getText().trim();
        //combines each category int one string newSong
        String newSong = name + " | " + artist + " | " + album + " | " + year + " | ";

        //creates a new alert, sets the title and text, and then stores the resulting button press in confirmation result
        Alert confirmation = new Alert(AlertType.CONFIRMATION);
        confirmation.setTitle("Add");
        confirmation.setContentText("Are you sure you want to add this song?");
        Optional<ButtonType> confirmationresult = confirmation.showAndWait();
        
        //if the confirmation result is ok, add
        if (confirmationresult.get() == ButtonType.OK){
            ListOfSongs.getItems().add(newSong);
        }

        // Clear the text fields
        SongNameTextf.clear();
        ArtistTextf.clear();
        AlbumTextf.clear();
        YearTextf.clear();
    }

    @FXML
    void DeleteSongClicked(ActionEvent event) {

        //selected index is the currently selected index
        int selectedIndex = ListOfSongs.getSelectionModel().getSelectedIndex();

        //creates a new alert, sets the title and text, and then stores the resulting button press in confirmation result
        Alert confirmation = new Alert(AlertType.CONFIRMATION);
        confirmation.setTitle("Delete");
        confirmation.setContentText("Are you sure you want to delete this song?");
        Optional<ButtonType> confirmationresult = confirmation.showAndWait();

        //if the confirmation result is OK, delete
        if(confirmationresult.get() == ButtonType.OK){
            if (selectedIndex >= 0) {
                //removes the selected song from the index
                ListOfSongs.getItems().remove(selectedIndex);
            }
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
        String currentSong = ListOfSongs.getSelectionModel().getSelectedItem();
        String[] songParts = currentSong.split(" | ");
        String name = songParts[0];
        String artist = songParts[1];
        String album = songParts[2];
        String year = songParts[3];
        // set the text fields to the current song's information
        SongNameTextf.setText(name);
        ArtistTextf.setText(artist);
        AlbumTextf.setText(album);
        YearTextf.setText(year);
        // remove the selected song from the list
        ListOfSongs.getItems().remove(selectedIndex);

        // Clear the text fields
        SongNameTextf.clear();
        ArtistTextf.clear();
        AlbumTextf.clear();
        YearTextf.clear();
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
}
