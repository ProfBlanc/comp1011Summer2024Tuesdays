package ca.georgiancollege.comp1011summer2024tuesdays;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BallController {


        @FXML
        ProgressBar progress;

        @FXML
        private Button btnSubmit;

        @FXML
        private ComboBox<String> cbPlayer,cbTeam;

        @FXML
        private Label lblPlayer,lblTeam;

        @FXML
        private TextField txtSearch;


          ListOfBallTeams teams;
        void populateTeamComboBox() throws Exception{

            teams = new BallDontLieAPI().getAllTeams();

            cbTeam.getItems().addAll( teams.data.stream().map(s -> s.full_name).toList()  );
            cbPlayer.getSelectionModel().selectFirst();

        }

        @FXML
        void initialize() throws Exception{

            lblTeam.setText("");
            lblPlayer.setText("");

            progress.setProgress(0);
            progress.setVisible(false);

            populateTeamComboBox();

            cbTeam.setOnAction(
                    event -> {
                        int selectedIndex = cbTeam.getSelectionModel().getSelectedIndex();
                        lblTeam.setText(
                                teams.data.get(selectedIndex).toString()
                        );
                    }
            );

        }





}
