package ch.makery.colorblind.view

import ch.makery.colorblind.MainApp
import scalafxml.core.macros.sfxml
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.control.Button
import scalafx.scene.text.Text

@sfxml
class MainMenuController(
    menuBG: ImageView
) {

    // List of opacity values for each game mode
    var opacityList = List(0.77, 0.8, 0.9)

    // Main menu background image 
    menuBG.image = new Image("file:resources/images/color-eye.jpg")

    // Methods to start the game in its respective game modes
    // Easy - 0.6, Normal - 0.7, Hard - 0.8
    def easyMode(): Unit = {
        MainApp.startGame(opacityList(0))
    }

    def normalMode(): Unit = {
        MainApp.startGame(opacityList(1))
    }

    def hardMode(): Unit = {
        MainApp.startGame(opacityList(2))
    }

    // Method to quit and terminate the progream
    def quitGame(): Unit = {
        System.exit(0)
    }

}
