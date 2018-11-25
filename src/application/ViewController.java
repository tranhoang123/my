package application;



import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.DirectoryChooser;
import javafx.scene.control.TextArea;
public class ViewController  implements Initializable  {
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	@FXML
	private MediaPlayer mediaPlayer;
	@FXML
	private MediaView mediaShow;
	private String filePath;
	@FXML
	private TextArea listSong;
	@FXML
	private Button song;
	@FXML
	private Button Library;
	@FXML
	private Button Stop;
	@FXML
	private Button Prev;
	@FXML
	private Button Play;
	@FXML
	private Button Next;
	@FXML
	private Button repeat;
	@FXML
	private Button Folder;
	@FXML
	private void handlerButtonAction(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter filter= new FileChooser.ExtensionFilter("select file(*.mp3);(*.mp4);(*.wav)", "*.mp3","*.mp4","*.wav" );
			fileChooser.getExtensionFilters().add(filter);
			File file = fileChooser.showOpenDialog(null);
			filePath = file.toURI().toString();
			if(filePath != null) {
				Media media = new Media(filePath);
				mediaPlayer = new MediaPlayer(media);
				mediaShow.setMediaPlayer(mediaPlayer);
				mediaShow.setX(400);
	        	mediaShow.setY(350);
				//mediaPlayer.play();	
	}
	}
	 @FXML
	 private void playButton(ActionEvent event) {
		 mediaPlayer.play();
	 }
	 @FXML
	 private void stopButton(ActionEvent event) {
		 mediaPlayer.stop();
	 }
	 @FXML
	 private void viewSong(ActionEvent event) {
		 System.out.print("Clicked");
	 }
	 @FXML
	 private void choseFolder(ActionEvent event) {


		 	DirectoryChooser directoryChooser = new DirectoryChooser();

		 	 File dir = directoryChooser.showDialog(null);
             if (dir != null) {
                 //System.out.println(dir); 
            	 File[] listFile = dir.listFiles();
            	 listSong.setText(null);
            	 System.out.println(listFile[0].getName());
            	 for(File file: listFile) {
            		 listSong.appendText(file.getName()+"\n");
            	 }
             } else {
                 System.out.println("nothing");
             }
         }
	 @FXML
	 private void showSong(ActionEvent event) {
		 System.out.println("you click me");
		 //boolean vis = listSong.
		 listSong.setVisible(true);
	 }
}

