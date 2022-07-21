package ch.makery.colorblind 

import ch.makery.colorblind.view.GameController
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import javafx.{scene => jfxs}
import scalafxml.core.{NoDependencyResolver, FXMLView, FXMLLoader}
import scalafx.scene.Scene
import scalafx.stage.Stage
import scalafx.scene.image._

object MainApp extends JFXApp {

    var score = -1

    val rootResource = getClass.getResource("view/RootLayout.fxml")
    val loader = new FXMLLoader(rootResource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.BorderPane]

    stage = new PrimaryStage {
        title = "ColorBlind"
        icons += new Image("file:resources/images/icon.png")
        scene = new Scene {
            root = roots 
        }
    }

    MainApp.stage.setResizable(false)
    
    def showMainMenu(): Unit = {
        score = -1
        val resource = getClass.getResource("view/MainMenu.fxml")
        val loader = new FXMLLoader(resource, NoDependencyResolver)
        loader.load()
        val roots = loader.getRoot[jfxs.layout.AnchorPane]
        this.roots.setCenter(roots)
    }

    def startGame(opacity: Double): Unit = {
        score += 1
        val resource = getClass.getResource("view/Game.fxml")
        val loader = new FXMLLoader(resource, NoDependencyResolver)
        loader.load()
        val control = loader.getController[GameController#Controller]
        val roots = loader.getRoot[jfxs.layout.AnchorPane]
        this.roots.setCenter(roots)
        control.answerButton.opacity = opacity
        control.scoreDisplay.setText(score.toString)
    }

    showMainMenu()

}