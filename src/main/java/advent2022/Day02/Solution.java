package advent_2022.AoC2;

import java.util.List;

public class Solution {
    int totalSum = 0;

    FileConverter fileConverter = new FileConverter();
    List<Move> allMoves = fileConverter.getListFromInput();

    public void run() {
        sol1();
        sol2();
    }

    public void sol1(){
        totalSum = 0;
        for (Move move : allMoves) {
            char opponentMove = move.getOpponentMove();
            char myMove = move.getMyMove();

            ResultPoints result;

            MoveValue myMoveValue = MoveValue.fromMyMove(myMove);
            switch (opponentMove) {
                case 'A':
                    result = switch (myMove) {
                        case 'X' -> ResultPoints.DRAW;
                        case 'Y' -> ResultPoints.WIN;
                        case 'Z' -> ResultPoints.LOSE;
                        default -> throw new IllegalArgumentException("Unexpected move: " + myMove);
                    };
                    break;
                case 'B':
                    result = switch (myMove) {
                        case 'X' -> ResultPoints.LOSE;
                        case 'Y' -> ResultPoints.DRAW;
                        case 'Z' -> ResultPoints.WIN;
                        default -> throw new IllegalArgumentException("Unexpected move: " + myMove);
                    };
                    break;
                case 'C':
                    switch (myMove) {
                        case 'X':
                            result = ResultPoints.WIN;
                            break;
                        case 'Y':
                            result = ResultPoints.LOSE;
                            break;
                        case 'Z':
                            result = ResultPoints.DRAW;
                            break;
                        default:
                            throw new IllegalArgumentException("Unexpected move: " + myMove);
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected opponent move: " + opponentMove);
            }
            totalSum += result.getPoints() + myMoveValue.getValue();
        }
        System.out.println("Part 1: " + totalSum);
    }

    public void sol2(){
        totalSum = 0;
        for (Move move : allMoves) {
            char opponentMove = move.getOpponentMove();
            char desiredOutcome = move.getMyMove();

            ResultPoints result;
            MoveValue myMoveValue;


            result = switch (desiredOutcome) {
                case 'X' -> ResultPoints.LOSE;
                case 'Y' -> ResultPoints.DRAW;
                case 'Z' -> ResultPoints.WIN;
                default -> throw new IllegalArgumentException("Unexpected outcome: " + desiredOutcome);
            };


            switch (opponentMove) {
                case 'A':
                    myMoveValue = switch (desiredOutcome) {
                        case 'X' -> MoveValue.SCISSORS;
                        case 'Y' -> MoveValue.ROCK;
                        case 'Z' -> MoveValue.PAPER;
                        default -> throw new IllegalArgumentException("Unexpected outcome: " + desiredOutcome);
                    };
                    break;
                case 'B':
                    myMoveValue = switch (desiredOutcome) {
                        case 'X' -> MoveValue.ROCK;
                        case 'Y' -> MoveValue.PAPER;
                        case 'Z' -> MoveValue.SCISSORS;
                        default -> throw new IllegalArgumentException("Unexpected outcome: " + desiredOutcome);
                    };
                    break;
                case 'C':
                    myMoveValue = switch (desiredOutcome) {
                        case 'X' -> MoveValue.PAPER;
                        case 'Y' -> MoveValue.SCISSORS;
                        case 'Z' -> MoveValue.ROCK;
                        default -> throw new IllegalArgumentException("Unexpected outcome: " + desiredOutcome);
                    };
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected opponent move: " + opponentMove);
            }

            totalSum += result.getPoints() + myMoveValue.getValue();
        }
        System.out.println("Part 2: " + totalSum);
    }
}