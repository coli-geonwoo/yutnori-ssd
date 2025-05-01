package org.example.view.impl;

import java.util.List;
import org.example.domain.game.GameDecision;
import org.example.domain.piece.GamePieces;
import org.example.domain.yut.YutResult;
import org.example.dto.GameInitializeDto;
import org.example.dto.NodeViewDto;
import org.example.dto.YutGenerationRequest;

public interface ViewInterface {

    //팀 개수, 말개수, 보드 유형 받기
    GameInitializeDto readInitializeInfo();

    //윷 던지기 요청 정보 읽기 (옵션 / 지정 윷의 경우, 윷 정보)
    YutGenerationRequest readYutGenerationInfo(int team);

    //나의 말 중에 어떤 걸 이동시킬 것인지 gamePieces 반환
    GamePieces readMovingPiece(List<GamePieces> myGamePieces);

    //여러개의 윷 결과 중에 무엇을 적용할 것인지
    YutResult chooseYutResult(List<YutResult> yutResults);

    // 이동가능한 칸 중에 어디로 이동할 것인지 -> place 이름 반환
    String chooseMovingPlace(List<String> movablePlaces);

    //여러개의 잡을 수 있는 말 중에 잡을 말 고르기 -> 잡을 말의 PieceId반환
    GamePieces readCatchingPiece(List<GamePieces> catchAblePieces);

    // 여러개의 업을 수 있는 말 중에 업을 말 고르기 -> 업을 말의 PieceId반환
    // 업지 않는 선택을 했다면 null 반환
    GamePieces readGroupingPiece(List<GamePieces> catchAblePieces);

    //재시작할 건지 종료할건지 선택
    GameDecision readGameDecision();

    // 보드 노드의 x,y, 이름 dto 받아서 보드 그리기
    void printBoard(List<NodeViewDto> nodeViewDtos);

    //이긴 사람 보여주기
    void printWinner(int winnerNumber);

    //잡았다는 메시지
    void printCatchMessage();

    //업었다는 메시지
    void printGroupMessage();
}
