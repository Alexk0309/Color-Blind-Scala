package ch.makery.colorblind.view

import ch.makery.colorblind.MainApp
import scalafxml.core.macros.sfxml
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.control.Button
import scalafx.scene.text.Text
import scala.util.Random
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType

@sfxml
class GameController(
    b1: Button, b2: Button, b3: Button, b4: Button, b5: Button, b6: Button, b7: Button, b8: Button, b9: Button, b10: Button, b11: Button, b12: Button, b13: Button,
    b14: Button, b15: Button, b16: Button, b17: Button, b18: Button, b19: Button, b20: Button, b21: Button, b22: Button, b23: Button, b24: Button,
    b25: Button, b26: Button, b27: Button, b28: Button, b29: Button, b30: Button, b31: Button, b32: Button, b33: Button, b34: Button, b35: Button, b36: Button,
    b37: Button, b38: Button, b39: Button, b40: Button, b41: Button, b42: Button, scoreText: Text
) {

    // Method to return to the main menu
    def goHome(): Unit = {
        MainApp.showMainMenu()
    }

    // Method to exit and terminate the program
    def closeGame(): Unit = {
        System.exit(0)
    }

    // ScoreDisplay is the text that will display on the screen
    var scoreDisplay = scoreText

    // List of color, will randomly generate 
    var colorList = List("-fx-background-color: red; -fx-border-color: white", "-fx-background-color: blue; -fx-border-color: white", "-fx-background-color: green; -fx-border-color: white", "-fx-background-color: orange; -fx-border-color: white")
    // Chosen color from the color list
    var color = colorList(scala.util.Random.nextInt(colorList.length))

    // List of buttons 
    var buttonList = List(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24,
    b25, b26, b27, b28, b29, b30, b31, b32, b33, b34, b35, b36,b37, b38, b39, b40, b41, b42)

    // The button to the answer
    var answerButton = buttonList(scala.util.Random.nextInt(buttonList.length))

    // Loop through every button in the button list
    // Set its style 
    // When player press the button, will check if it satisfy the condition
    // Where if the button they clicked matches with the answer button 
    for (b <- buttonList) {
        b.style = color
        b.onAction = (e: ActionEvent) => {
            if (b == answerButton) {
                // Will go to next level and update score when pressed correctly
                MainApp.startGame(answerButton.opacity.toDouble)
            }
            else {
                // Otherwise, will display a game over message and return back to the main menu
                new Alert(AlertType.Information){
                    title = "Game Over"
                    headerText = "Game Over, you lost!"
                    contentText = "Practice makes perfect!"
                }.showAndWait()
                MainApp.showMainMenu()
            }
        }
    }


}
