import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.{Alert, Button, Label, TextArea}
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.layout.{GridPane, VBox}
import scalafx.geometry.Pos
import scalafx.Includes._

abstract class Game {
  def reset(): Unit
  def playTurn(row: Int, col: Int, button: Button): Unit
  def checkWinner(): Boolean
  def isGameOver: Boolean
}

class TicTacToe extends Game {
  val board: Array[Array[String]] = Array.ofDim[String](3, 3)
  var currentPlayer: String = "X"

  override def reset(): Unit = {
    board.indices.foreach(i => board(i).indices.foreach(j => board(i)(j) = null))
    currentPlayer = "X"
  }

  override def playTurn(row: Int, col: Int, button: Button): Unit = {
    if (board(row)(col) == null && !isGameOver) {
      board(row)(col) = currentPlayer
      button.text = currentPlayer
      if (checkWinner()) {
        TicTacToeApp.statusLabel.text = s"Player $currentPlayer Wins!"
      } else if (isBoardFull) {
        TicTacToeApp.statusLabel.text = "It's a draw!"
      } else {
        currentPlayer = if (currentPlayer == "X") "O" else "X"
        TicTacToeApp.statusLabel.text = s"Player $currentPlayer's turn"
      }
    }
  }

  override def checkWinner(): Boolean = {
    val rows = board.exists(row => row.forall(_ == currentPlayer))
    val cols = board.transpose.exists(col => col.forall(_ == currentPlayer))
    val diag1 = (0 until 3).forall(i => board(i)(i) == currentPlayer)
    val diag2 = (0 until 3).forall(i => board(i)(2 - i) == currentPlayer)
    rows || cols || diag1 || diag2
  }

  override def isGameOver: Boolean = checkWinner() || isBoardFull

  def isBoardFull: Boolean = board.flatten.forall(_ != null)
}

abstract class GameButtonAction {
  def performAction(row: Int, col: Int, button: Button): Unit
}

class PlayButtonAction(game: TicTacToe) extends GameButtonAction {
  override def performAction(row: Int, col: Int, button: Button): Unit = {
    game.playTurn(row, col, button)
  }
}

class ResetButtonAction(game: TicTacToe) extends GameButtonAction {
  override def performAction(row: Int, col: Int, button: Button): Unit = {
    game.reset()
  }
}

object TicTacToeApp extends JFXApp {

  val game = new TicTacToe()

  val statusLabel = new Label(s"Player ${game.currentPlayer}'s turn") {
    alignment = Pos.Center
  }
  GridPane.setColumnSpan(statusLabel, 3)

  val grid = new GridPane {
    hgap = 10
    vgap = 10
    alignment = Pos.Center
  }

  def createGameButton(row: Int, col: Int, action: GameButtonAction): Button = {
    new Button {
      text = ""
      minWidth = 175
      minHeight = 175
      onAction = handle {
        action.performAction(row, col, this)
      }
    }
  }

  for (i <- 0 to 2; j <- 0 to 2) {
    val playAction = new PlayButtonAction(game)
    grid.add(createGameButton(i, j, playAction), j, i)
  }

  def showHowToPlay(): Unit = {
    val instructions =
      """|How to Play:
         |1. Two players take turns placing Xs and Os on a 3x3 grid.
         |2. The first player to get three in a row (horizontally, vertically, or diagonally) wins.
         |3. If the grid is full and no one has won, the game ends in a draw.
         |4. Players alternate turns with Player X going first.""".stripMargin

    val textArea = new TextArea {
      text = instructions
      editable = false
      wrapText = true
      maxWidth = 400
      maxHeight = 200
    }

    val alert = new Alert(AlertType.Information) {
      title = "How to Play"
      headerText = "Tic-Tac-Toe Instructions"
      dialogPane().setContent(textArea)
    }

    alert.showAndWait()
  }

  val howToPlayButton = new Button("How to Play") {
    onAction = handle {
      showHowToPlay()
    }
  }

  val resetButton = new Button("Reset") {
    onAction = handle {
      new ResetButtonAction(game).performAction(0, 0, this)
      grid.getChildren.clear()
      for (i <- 0 to 2; j <- 0 to 2) {
        val playAction = new PlayButtonAction(game)
        grid.add(createGameButton(i, j, playAction), j, i)
      }
      statusLabel.text = s"Player ${game.currentPlayer}'s turn"
    }
  }
  GridPane.setColumnSpan(resetButton, 3)

  stage = new PrimaryStage {
    title = "Tic-Tac-Toe"
    scene = new Scene {
      content = new VBox {
        spacing = 10
        alignment = Pos.Center
        children = Seq(statusLabel, grid, resetButton, howToPlayButton)
      }
    }
  }
}