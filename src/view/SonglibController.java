package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
        String name = SongNameTextf.getText().trim();
        String artist = ArtistTextf.getText().trim();
        String album = AlbumTextf.getText().trim();
        String year = YearTextf.getText().trim();
        String newSong = name + " - " + artist + " (" + album + ", " + year + ")";
        ListOfSongs.getItems().add(newSong);
    }

    @FXML
    void DeleteSongClicked(ActionEvent event) {
        int selectedIndex = ListOfSongs.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            ListOfSongs.getItems().remove(selectedIndex);
        }
    }


    @FXML
    void EditSongClicked(ActionEvent event) {
        int selectedIndex = ListOfSongs.getSelectionModel().getSelectedIndex();
        if (selectedIndex < 0) {
            // no song selected, do nothing
            return;
        }
        String currentSong = ListOfSongs.getSelectionModel().getSelectedItem();
        String[] songParts = currentSong.split(" - | \\(|\\)|, ");
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
    }

}
