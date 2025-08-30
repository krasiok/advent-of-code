    package advent_2022.AoC2;

    public enum MoveValue {
        ROCK(1),
        PAPER(2),
        SCISSORS(3);

        private final int value;

        MoveValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }


        public static MoveValue fromMyMove(char c) {
            return switch (c) {
                case 'X' -> ROCK;
                case 'Y' -> PAPER;
                case 'Z' -> SCISSORS;
                default -> throw new IllegalArgumentException("Unexpected move " + c);
            };
        }
    }
