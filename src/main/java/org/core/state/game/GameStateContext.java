package org.core.state.game;

import org.core.domain.board.BoardType;
import org.core.domain.game.ScoreBoard;
import org.core.dto.GameInitializeDto;
import org.core.service.BoardService;

public class GameStateContext {

  public final int teamCount;
  public final int pieceCount;
  public final BoardType boardType;

  public final ScoreBoard scoreBoard;
  public final BoardService boardService;

  public GameStateContext(
      GameInitializeDto initialDto
  ) {
    this.teamCount = initialDto.teamCount();
    this.pieceCount = initialDto.pieceCount();
    this.boardType = initialDto.boardType();

    this.scoreBoard = new ScoreBoard(teamCount, pieceCount);
    this.boardService = new BoardService(teamCount, pieceCount, boardType);
  }

}