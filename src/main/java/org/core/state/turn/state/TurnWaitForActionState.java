package org.core.state.turn.state;

import org.core.domain.game.ScoreBoard;
import org.core.domain.piece.GamePieces;
import org.core.service.BoardService;
import org.core.state.turn.TurnStateContext;
import org.core.state.turn.TurnStateManager;
import org.core.state.turn.event.TurnMovePieceEvent;

public class TurnWaitForActionState extends TurnState {

  public TurnWaitForActionState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);
  }

  @Override
  public void handleEvent(TurnMovePieceEvent event) {
    moveTo(event.pieceId, event.placeId);
    context.useYutResult(event.yutResult);
    stateManager.setCurrentState(new TurnMovedPieceState(context, stateManager, event));
  }

  private void moveTo(String pieceId, String place) {
    BoardService boardService = context.getBoardService();

    if (place.equals("end")) {
      ScoreBoard scoreBoard = context.getScoreBoard();

      GamePieces gamePieces = boardService.findPieces(pieceId);
      scoreBoard.score(context.turn.getTurn(), gamePieces.getCount());
    }

    boardService.moveTo(pieceId, place);
  }
}