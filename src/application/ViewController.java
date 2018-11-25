package application;



import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
//import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.DirectoryChooser;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
	private ScrollPane scrollPane;
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
		 	 VBox re = new VBox();
		 	 scrollPane.setContent(re);
		 	 re.setSpacing(10);
             if (dir != null) {
                 //System.out.println(dir); 
            	 File[] listFile = dir.listFiles();
            	 // listSong.setText(null);
            	 //System.out.println(listFile[0].getName());
            	 Media media = new Media(listFile[0].toURI().toASCIIString()); // lấy path của file đầu tiên làm mặc định
   				 mediaPlayer = new MediaPlayer(media);
   				 mediaShow.setMediaPlayer(mediaPlayer);
            	 for(File file: listFile) {
//            		 listSong.appendText(file.getName()+"\n");
            		 Button button = new Button(); //tạo nút mới
            		 button.setText(file.getName()); // đặt tên nút
            		 button.setId(file.getPath()); // đặt ID cho nút, lấy id bằng path luôn
            		 button.setOnAction(click->{   // tạo một event trong nút
            			
//            			for(File file1 : listFile) {
//            				mediaPlayer = new MediaPlayer(new Media(file1.toURI().toASCIIString()));
            				mediaPlayer.stop(); // dừng cái đang phát hiện tại
//            				System.out.println("dm");
//            			}
            			mediaPlayer = new MediaPlayer(new Media(file.toURI().toASCIIString())); //đổi thành media mới
         				mediaPlayer.play();
//         				for(File file1: listFile) {
//                    		 if(file1.toURI().toString() != file.toURI().toString()) {
//                    			 mediaPlayer.stop();
//                    		 }
//                    	 }
            		 });

            		 //Label lb =new Label(file.getName());
            		re.getChildren().add(button); // tạo nút xong xuôi thì thêm vào VBOX -> quay lại dòng 90
            	 }
            	
             } else {
                 System.out.println("nothing");
             }
         }
	 @FXML
	 private void showSong(ActionEvent event) {
		 System.out.println("you click me");
		 //boolean vis = listSong.
		 scrollPane.setVisible(true);
	 }
//	 private void playMusic(ActionEvent event) {
//		 	Media media = new Media(this.filePath);
//			mediaPlayer = new MediaPlayer(media);
//			mediaShow.setMediaPlayer(mediaPlayer);
//	 }
}

