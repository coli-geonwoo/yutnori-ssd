//package org.example.controller;
//
//import java.util.List;
//import java.util.Optional;
//import org.example.domain.board.BoardType;
//import org.example.domain.game.GameDecision;
//import org.example.domain.piece.GamePieces;
//import org.example.domain.yut.YutResult;
//import org.example.dto.GameInitializeDto;
//import org.example.dto.NodeViewDto;
//import org.example.service.GameService;
//import org.example.view.impl.ViewInterface;
//import org.example.view.mapper.BoardViewMapper;
//
//public class YutGameController {
//
//    private final BoardViewMapper boardViewMapper;
//    private final ViewInterface viewInterface;
//    private final GameService gameService;
//
//    public YutGameController(ViewInterface viewInterface) {
//        this.boardViewMapper = new BoardViewMapper();
//        this.viewInterface = viewInterface;
//        GameInitializeDto initializeDto = viewInterface.readInitializeInfo();
//        this.gameService = new GameService(
//                initializeDto.teamCount(),
//                initializeDto.pieceCount(),
//                initializeDto.boardType()
//        );
//    }
//
//    public void playGame() {
//
//        drawBoard();
//
//        while (!gameService.isEndGame()) {
//            List<YutResult> turnYutResults = gameService.makeTurnYutResults(viewInterface::readYutGenerationInfo);
//
//            while (!turnYutResults.isEmpty()) {
//                YutResult yutResult = chooseYutResult(turnYutResults);
//                playTurn(yutResult);
//            }
//
//            gameService.nextTurn();
//        }
//
//        // 이긴 사람 보여주기
//        viewInterface.printWinner(gameService.getWinner());
//
//        // 다시할건지 그만할건지 재입력 받기
//        askRestartOrExit();
//    }
//
//    private void playTurn(YutResult yutResult) {
//        //움직일 말 선택
//        List<GamePieces> pieces = gameService.findAllPieces();
//        GamePieces chosenPiece = viewInterface.readMovingPiece(pieces);
//
//        //이동할 칸 선택
//        List<String> movablePlaces = gameService.findMovablePlaces(chosenPiece.getPlace(), yutResult);
//        String movingPlace = viewInterface.chooseMovingPlace(movablePlaces);
//
//        //말 잡기 > 업기 > 이동
//        movePiece(chosenPiece.getId(), movingPlace);
//    }
//
//    private void movePiece(String pieceId, String place) {
//        // 잡을 수 있는 것 있으면 잡기
//        Optional<GamePieces> catchingPiece = gameService.catchPieces(place, viewInterface::readCatchingPiece);
//        if (catchingPiece.isPresent()) {
//            viewInterface.printCatchMessage();
//        }
//
//        // 업을 수 있는 것 있으면 업기
//        Optional<GamePieces> groupingPiece = gameService.groupingPieces(pieceId, place, viewInterface::readGroupingPiece);
//        if (groupingPiece.isPresent()) {
//            viewInterface.printGroupMessage();
//        }
//
//        // 장소 이동
//        gameService.moveTo(pieceId, place);
//    }
//
//    private YutResult chooseYutResult(List<YutResult> turnYutResults) {
//        YutResult chosenResult = viewInterface.chooseYutResult(turnYutResults);
//        turnYutResults.remove(chosenResult);
//        return chosenResult;
//    }
//
//    //나중에 뷰로 옮기기
//    private void drawBoard() {
//        BoardType boardType = gameService.getBoardType();
//        List<NodeViewDto> nodeViewDtos = boardViewMapper.mapTo(boardType);
//        viewInterface.printBoard(nodeViewDtos);
//    }
//
//    private void askRestartOrExit() {
//        GameDecision gameDecision = viewInterface.readGameDecision();
//
//        if (gameDecision == GameDecision.EXIT) {
//            return;
//        }
//
//        if (gameDecision == GameDecision.RESTART) {
//            playGame();
//        }
//    }
//}