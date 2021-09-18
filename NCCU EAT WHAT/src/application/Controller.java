package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	String searchText;
	RestaurantList r;
	ExecSQL exec; 
	
	@FXML
	private TextField getSearchTextField;
	@FXML
	private Button searchButton;
	@FXML
	private ScrollPane getSearchScrollPane;
	@FXML
	private TextArea getSearchTextArea;
	@FXML
	private TextArea getRestaurantTextArea;
	@FXML 
	private ScrollPane getRestaurantScrollPane;
	@FXML
	private TextArea getRandomTextArea;
	
	public Controller() throws SQLException{
		searchText = "";
		r = new RestaurantList();
		exec = new ExecSQL();
	}
	
	//button start //
	public void switchToMain(ActionEvent event )throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToSearch(ActionEvent event )throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("Search.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToRestaurant(ActionEvent event )throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("Restaurant.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToSearch2(ActionEvent event )throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("Search2.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToRandomChoice(ActionEvent event )throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("RandomChoice.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	//button end//
	
	public void getSearchText(ActionEvent event)throws IOException{
		try {
			String info = "";
			
			searchText = getSearchTextField.getText();
			
			if(searchText.isBlank()==true) {
				getSearchTextArea.setText("Please enter restaurant!");
			}else {
				if(exec.findRestaurant(searchText)!=null) {
					info = exec.findRestaurant(searchText).getInfo();
					getSearchTextArea.setText(info);
				}else {
					getSearchTextArea.setText("Restaurant is not found");
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void All(ActionEvent event) throws IOException{
		try {
			getRestaurantTextArea.setText(exec.findAll());
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void Taiwanese(ActionEvent event) throws IOException{
		try {
			getRestaurantTextArea.setText(exec.findTaiwanese());
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void Japanese(ActionEvent event) throws IOException{
		try {
			getRestaurantTextArea.setText(exec.findJapanese());
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void American(ActionEvent event) throws IOException{
		try {
			getRestaurantTextArea.setText(exec.findAmerican());
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void Other(ActionEvent event)throws IOException{
		try {
			getRestaurantTextArea.setText(exec.findOther());
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void Random(ActionEvent event)throws IOException{
		try {
			getRandomTextArea.setText(exec.RandomChoice().getInfo());
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
