package org.example.controller;

import java.util.ArrayList;
import java.util.List;
import org.example.domain.piece.GamePieces;
import org.example.domain.yut.YutResult;
import org.example.dto.GameInitializeDto;
import org.example.dto.YutGenerationRequest;
import org.example.service.GameService;
import org.example.view.InputView;
import org.example.view.OutputView;

public class YutGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;

    public YutGameController(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;

        GameInitializeDto initializeDto = inputView.readInitializeInfo();
        this.gameService = new GameService(initializeDto.teamCount(), initializeDto.pieceCount(),
                initializeDto.boardType());
    }

    public void playGame() {

        while (!gameService.isEndGame()) {
            List<YutResult> turnYutResults = readTurnYutResults();

            while(!turnYutResults.isEmpty()){
                YutResult yutResult = chooseYutResult(turnYutResults);
                playTurn(yutResult);
            }

            gameService.nextTurn();
        }
    }

    private void playTurn(YutResult yutResult) {
        //움직일 말 선택
        List<GamePieces> pieces = gameService.findAllPieces();
        GamePieces chosenPiece = inputView.readMovingPiece(pieces);

        //이동할 칸 선택
        List<String> movablePlaces = gameService.findMovablePlaces(chosenPiece.getPlace(), yutResult);
        String movingPlace = inputView.chooseMovingPlace(movablePlaces);

        //말 잡기 > 업기 > 이동
        movePiece(chosenPiece.getId(), movingPlace);
    }

    private void movePiece(String pieceId, String place) {
        // 잡을 수 있는 것 있으면 잡기
        catchPieces(place);

        // 업을 수 있는 것 있으면 업기
        groupingPieces(pieceId, place);

        // 장소 이동
        gameService.moveTo(pieceId, place);
    }

    private void groupingPieces(String movingPieceId, String place){
        List<GamePieces> groupablePieces = gameService.findGroupablePieces(place);

        if(groupablePieces.isEmpty()){
            return;
        }

        GamePieces groupingPiece = inputView.readCatchingPiece(groupablePieces);

        if(groupingPiece==null){
            return;
        }

        gameService.groupPieces(movingPieceId, groupingPiece.getId());
    }

    private void catchPieces(String place) {
        List<GamePieces> catchablePieces = gameService.findCatchablePieces(place);

        if(catchablePieces.isEmpty()){
            return;
        }

        if(catchablePieces.size()==1){
            GamePieces catchablePiece = catchablePieces.get(0);
            gameService.catchPieces(catchablePiece.getId());
            return;
        }

        GamePieces catchingPiece = inputView.readCatchingPiece(catchablePieces);
        gameService.catchPieces(catchingPiece.getId());
    }

    private List<YutResult> readTurnYutResults() {
        YutResult yutResult;
        List<YutResult> turnYutResults = new ArrayList<>();

        do {
            YutGenerationRequest request = inputView.readYutGenerationInfo();
            yutResult = gameService.generateYut(request.options(), request.yutResult());
            turnYutResults.add(yutResult);
        } while (yutResult == YutResult.YUT || yutResult ==YutResult.MO);

        return turnYutResults;
    }

    private YutResult chooseYutResult(List<YutResult> turnYutResults) {
        if(turnYutResults.size()==1){
            return turnYutResults.get(0);
        }
        return inputView.chooseYutResult(turnYutResults);
    }
}
