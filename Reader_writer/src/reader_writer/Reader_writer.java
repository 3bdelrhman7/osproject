
package reader_writer;



import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
//import javafx.scene.layout.BorderStroke;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 *
 * @author Abdelrhman Alaa
 */
public class Reader_writer extends Application{
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
        @Override
    public void start(Stage stage) throws Exception {
        Group g= new Group();
        Scene s= new Scene(g);
        Group g2=new Group();
        Scene s2=new Scene(g2);
        Group g3=new Group();
        Scene s3=new Scene(g3);
        
        Group g4=new Group();
        Scene s4=new Scene(g4);
        

        stage.setScene(s);
        s.setFill(Color.SILVER);
        s2.setFill(Color.SILVER);
        
        
        Label label=new Label("Username:");
        Label label2=new Label("Password:");
        label2.setTextFill(Color.BLUE);
        label.setTextFill(Color.BLUE);
        label.setLayoutX(140);
        label2.setLayoutX(143);
        label.setLayoutY(183);
        label2.setLayoutY(258);
        label2.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        Border xx=new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT,new Insets(0 ,0,0,0)));
        Border y=new Border(new BorderStroke(Color.BLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT,new Insets(0 ,0,0,0)));
//        label2.setBorder(x);
//        label.setBorder(x);
        

        ImageView loginpng=new ImageView("E:/osphotos/login.png");
        loginpng.setFitHeight(40);
        loginpng.setFitWidth(40);

        
        ImageView withdrawpng=new ImageView("E:/osphotos/withdraw.png");
        withdrawpng.setFitHeight(30);
        withdrawpng.setFitWidth(40);

       
        ImageView depositpng=new ImageView("E:/osphotos/deposit.png");
        depositpng.setFitHeight(30);
        depositpng.setFitWidth(40);
        
        ImageView background=new ImageView("E:/osphotos/background.jpg");
        
        TextField username =new TextField();
        username.setFocusTraversable(true);
        PasswordField password =new PasswordField();
        username.setLayoutX(260);
        password.setLayoutX(260);
        username.setLayoutY(183);
        password.setLayoutY(253);
        username.setPrefWidth(300);
        password.setPrefWidth(300);
        label.setWrapText(false);
        
        
        g.getChildren().add(background);
        g.getChildren().add(label);
        g.getChildren().add(username);
        g.getChildren().add(label2);
        g.getChildren().add(password);
        Button login= new Button("Login",loginpng);
        login.setOnAction((ActionEvent event) -> {
            int user=Integer.parseInt(username.getText().toString());
            int pass=Integer.parseInt(password.getText().toString());
            if(user==1&&pass==1){
                JOptionPane.showMessageDialog(  null, "Welcome");
                stage.setScene(s2);
            }
            else
                JOptionPane.showMessageDialog(  null, "Please enter correct credentails");

        });
        
        login.setMinWidth(300);
        login.setLayoutX(260);
        login.setLayoutY(320);
        
        
        
        
        
        
        Button logout= new Button("Logout");
        logout.setOnAction((ActionEvent event) -> {
            JOptionPane.showMessageDialog(  null, "Successfully logged out");
            stage.setScene(s);
            }

        );
        logout.setLayoutX(630);
//        logout.setBackground(Background.fill(Color.BEIGE));
        
        Button withdraw= new Button("Withdraw money",withdrawpng);
        withdraw.setOnAction((ActionEvent event) -> {
            stage.setScene(s3);
            }

        );
        withdraw.setLayoutX(180);
        withdraw.setLayoutY(195);
        withdraw.setMinWidth(350);
        withdraw.setBorder(xx);
        
        resource2 g0 = new resource2();
        
        Button deposit= new Button("Deposit money",depositpng);
        deposit.setOnAction((ActionEvent event) -> {

            Thread t0 = new Thread(g0,"w");
            t0.start();
            try {
                t0.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Reader_writer.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(  null, "Deposit success x is : "+g0.x);
            }

        );
        deposit.setLayoutX(180);
        deposit.setLayoutY(245);
        deposit.setMinWidth(350);
        deposit.setBorder(xx);
        
        
        
        
        
        TextField shownbalance =new TextField("xxxxxxxxx");
        shownbalance.setLayoutX(330);
        shownbalance.setLayoutY(295);
        shownbalance.setMinWidth(200);
        shownbalance.setMinHeight(40);
        shownbalance.setEditable(false);
        shownbalance.setBorder(y);
        
        Button showbalance= new Button("Show Account Balance");
        showbalance.setOnAction((ActionEvent event) -> {
            Thread t1 = new Thread(g0,"r");
            t1.start();
            try {
                t1.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Reader_writer.class.getName()).log(Level.SEVERE, null, ex);
            }
            int n=g0.x;
            
            shownbalance.setText(String.valueOf(n));
            //put the code here ya gom3a
            }

        );
        showbalance.setLayoutX(180);
        showbalance.setLayoutY(295);
        showbalance.setMinHeight(40);
        
        
        g2.getChildren().add(shownbalance);
        g2.getChildren().add(showbalance);
        g2.getChildren().add(logout);
        g.getChildren().add(login);
        g2.getChildren().add(deposit);
//        g.getChildren().add(login2);
        
        
        
        
        stage.setTitle("Reader Writer");
        stage.setWidth(700);
        stage.setHeight(600);
        stage.setResizable(false);
        stage.show();
    }




}
