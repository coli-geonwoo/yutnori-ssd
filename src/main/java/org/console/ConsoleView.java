package org.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.example.domain.board.BoardType;
import org.example.domain.game.GameDecision;
import org.example.domain.piece.GamePiece;
import org.example.domain.piece.GamePieces;
import org.example.domain.yut.YutGenerateOptions;
import org.example.domain.yut.YutResult;
import org.example.dto.GameInitializeDto;
import org.example.dto.NodeViewDto;
import org.example.dto.YutGenerationRequest;
import org.example.service.GameService;
import org.example.state.game.GameInProgressState;
import org.example.state.game.GameStateMachine;
import org.example.state.game.event.GameStartEvent;
import org.example.state.turn.TurnStateMachine;

public class ConsoleView {

  GameService gameService;
  GameStateMachine gameStateMachine;
  TurnStateMachine turnStateMachine;

  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  ConsoleView() {
    GameInitializeDto gameInitializeDto = initialize();

    gameService = new GameService(gameInitializeDto.teamCount(),
        gameInitializeDto.pieceCount(), gameInitializeDto.boardType());

    turnStateMachine = TurnStateMachine.create();
    gameStateMachine = GameStateMachine.create(gameService);

    gameStateMachine.observe(state -> {
      if (state instanceof GameInProgressState) {
        run();
      }
    });

    gameStateMachine.dispatchEvent(new GameStartEvent());
  }

  public void run() {
    BoardType boardType = gameService.getBoardType();
    List<NodeViewDto> nodeViewDtos = boardViewMapper.mapTo(boardType);
    viewInterface.printBoard(nodeViewDtos);
  }

  //팀 개수, 말개수, 보드 유형 받기
  public GameInitializeDto initialize() {
    System.out.println("윷놀이 게임을 시작합니다");

    System.out.println("몇 명의 팀으로 진행할까요? (최소 2개, 최대 4개 팀) : ");
    int teamCount = Integer.parseInt(readInput());

    System.out.println("몇 개의 말로 진행할까요? (최소 1개, 최대 5개 팀) : ");
    int pieceCount = Integer.parseInt(readInput());

    System.out.println("어떤 보드로 진행할까요? (4,5,6 중 선택) : ");
    int type = Integer.parseInt(readInput());
    BoardType boardType = BoardType.mapTo(type);
    return new GameInitializeDto(teamCount, pieceCount, boardType);
  }

  //윷 던지기 요청 정보 읽기 (옵션 / 지정 윷의 경우, 윷 정보)
  public YutGenerationRequest readYutGenerationInfo(int turn) {
    System.out.println(turn + "팀이 윷을 던질 차례입니다.");
    System.out.println("어떻게 던지시겠습니까?");
    System.out.println("1. 지정 윷 던지기");
    System.out.println("2. 랜덤 윷 던지기");

    int yutGeneration = Integer.parseInt(readInput());

    if (yutGeneration == 1) {
      System.out.println("어떤 윷을 던지시겠습니까?, ex) 도, 개, 걸, 윷, 모");
      YutResult yutResult = YutResult.from(readInput());
      return new YutGenerationRequest(YutGenerateOptions.DESIGNATED, yutResult);
    }

    return new YutGenerationRequest(YutGenerateOptions.RANDOM, null);
  }

  //나의 말 중에 어떤 걸 이동시킬 것인지 gamePieces 반환
  public GamePieces readMovingPiece(List<GamePieces> myGamePieces) {
    System.out.println("어떤 말을 이동하시겠습니까? ex) 0, 1 등 숫자 입력");
    for (int i = 0; i < myGamePieces.size(); i++) {
      System.out.print(i + ": ");
      printGamePiece(myGamePieces.get(i));
    }

    int chosenNumber = Integer.parseInt(readInput());
    return myGamePieces.get(chosenNumber);
  }

  //여러개의 윷 결과 중에 무엇을 적용할 것인지
  public YutResult chooseYutResult(List<YutResult> yutResults) {
    System.out.println("어떤 윷 결과를 적용할까요? ex) 0, 1 등 숫자 입력");
    for (int i = 0; i < yutResults.size(); i++) {
      System.out.println(i + ": " + yutResults.get(i).getName());
    }

    int chosenNumber = Integer.parseInt(readInput());
    return yutResults.get(chosenNumber);
  }

  // 이동가능한 칸 중에 어디로 이동할 것인지 -> place 이름 반환
  public String chooseMovingPlace(List<String> movablePlaces) {
    System.out.println("어디로 이동할까요? ex) 0, 1 등 숫자 입력");
    for (int i = 0; i < movablePlaces.size(); i++) {
      System.out.println(i + ": " + movablePlaces.get(i));
    }

    int chosenNumber = Integer.parseInt(readInput());
    return movablePlaces.get(chosenNumber);
  }

  //여러개의 잡을 수 있는 말 중에 잡을 말 고르기 -> 잡을 말의 PieceId반환
  public GamePieces readCatchingPiece(List<GamePieces> catchAblePieces) {
    System.out.println("어떤 말을 잡으시겠습니까? ex) 0, 1 등 숫자 입력");
    for (int i = 0; i < catchAblePieces.size(); i++) {
      System.out.print(i + ": ");
      printGamePiece(catchAblePieces.get(i));
    }
    int catchingPiece = Integer.parseInt(readInput());
    return catchAblePieces.get(catchingPiece);
  }

  // 여러개의 업을 수 있는 말 중에 업을 말 고르기 -> 업을 말의 PieceId반환
  // 업지 않는 선택을 했다면 null 반환
  public GamePieces readGroupingPiece(List<GamePieces> groupAblePieces) {
    System.out.println("어떤 말을 업으시겠습니까? ex) 0, 1 등 숫자 입력");
    for (int i = 0; i < groupAblePieces.size(); i++) {
      System.out.print(i + ": ");
      printGamePiece(groupAblePieces.get(i));
    }
    System.out.println(groupAblePieces.size() + " : 업지 않기");
    int groupAblePiece = Integer.parseInt(readInput());

    if (groupAblePiece == groupAblePieces.size()) {
      return null;
    }

    return groupAblePieces.get(groupAblePiece);
  }

  //재시작할 건지 종료할건지 선택
  public GameDecision readGameDecision() {
    System.out.println("재시작하시겠습니까? (Y/N)");
    String decision = readInput();

    if (decision.equals("Y")) {
      return GameDecision.RESTART;
    }
    return GameDecision.EXIT;
  }

  // 보드 노드의 x,y, 이름 dto 받아서 보드 그리기
  public void printBoard(List<NodeViewDto> nodeViewDtos) {
  }

  //이긴 사람 보여주기
  public void printWinner(int winnerNumber) {
    System.out.println(winnerNumber + "팀이 승리하셨습니다!");
  }

  //잡았다는 메시지
  public void printCatchMessage() {
    System.out.println("상대 말을 잡았습니다");
  }

  //업었다는 메시지
  public void printGroupMessage() {
    System.out.println("나의 말을 업었습니다");
  }

  private void printGamePiece(GamePieces gamePiece) {
    List<GamePiece> pieces = gamePiece.getPieces();
    int team = gamePiece.getTeam();

    System.out.print(team + "팀 - ");
    for (GamePiece piece : pieces) {
      System.out.print(piece.getPieceNumber() + " ");
    }
    System.out.println("번 말");
  }

  private String readInput() {
    try {
      return reader.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}