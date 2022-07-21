package ch.makery.colorblind 

// import libraries
import ch.makery.colorblind.view.GameController
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import javafx.{scene => jfxs}
import scalafxml.core.{NoDependencyResolver, FXMLView, FXMLLoader}
import scalafx.scene.Scene
import scalafx.stage.Stage
import scalafx.scene.image._

// Main app object, inherited scalafx from JFXApp library
object MainApp extends JFXApp {

    // Count player score
    var score = -1

    // load root layout fxml file 
    val rootResource = getClass.getResource("view/RootLayout.fxml")
    val loader = new FXMLLoader(rootResource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.BorderPane]

    // Set new window for root layout 
    stage = new PrimaryStage {
        title = "ColorBlind"
        icons += new Image("file:resources/images/icon.png")
        scene = new Scene {
            root = roots 
        }
    }

    // Set window to not able to resize 
    MainApp.stage.setResizable(false)

    // Method to show main meny
    def showMainMenu(): Unit = {
        // When player comes back to main menu, score reset
        score = -1

        // load main menu fxml file
        val resource = getClass.getResource("view/MainMenu.fxml")
        val loader = new FXMLLoader(resource, NoDependencyResolver)
        loader.load()
        val roots = loader.getRoot[jfxs.layout.AnchorPane]
        this.roots.setCenter(roots)
    }

    // Method to start the game 
    def startGame(opacity: Double): Unit = {
        // When player got the right answer, will go to the next level and update score
        score += 1

        // Load game fxml file 
        val resource = getClass.getResource("view/Game.fxml")
        val loader = new FXMLLoader(resource, NoDependencyResolver)
        loader.load()

        // Get attributes from the game controller class file 
        val control = loader.getController[GameController#Controller]
        val roots = loader.getRoot[jfxs.layout.AnchorPane]
        this.roots.setCenter(roots)

        // Set the opacity of the color button
        control.answerButton.opacity = opacity
        // Update the text on the screen to display the score
        control.scoreDisplay.setText(score.toString)
    }

    // Will automatically show main menu when program run
    showMainMenu()

}