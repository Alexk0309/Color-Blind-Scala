package ch.makery.colorblind.view

import ch.makery.colorblind.MainApp
import scalafxml.core.macros.sfxml
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.control.Button
import scalafx.scene.text.Text

@sfxml
class mainMenuController(
    menuBG: ImageView
) {

    menuBG.image = new Image("file:resources/images/color-eye.jpg")
    // Easy - 0.6, Normal - 0.7, Hard - 0.8
    def easyMode(): Unit = {
        MainApp.startGame(0.6)
    }

    def normalMode(): Unit = {
        MainApp.startGame(0.7)
    }

    def hardMode(): Unit = {
        MainApp.startGame(0.8)
    }

    def quitGame(): Unit = {
        System.exit(0)
    }

}
