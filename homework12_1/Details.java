package homework12_1;

public enum Details implements descriptionOfDetails {

    HEAD{
        @Override
        public String getDescription() {
            return "Голова";
        }
    },
    BODY{
        @Override
        public String getDescription() {
            return "Тело";
        }
    },
    LEFTHAND{
        @Override
        public String getDescription() {
            return "Левая рука";
        }
    },
    RIGHTHAND{
        @Override
        public String getDescription() {
            return "Правая рука";
        }
    },
    LEFTLEG{
        @Override
        public String getDescription() {
            return "Левая нога";
        }
    },
    RIGHTLEG{
        @Override
        public String getDescription() {
            return "Правая нога";
        }
    },
    CPU{
        @Override
        public String getDescription() {
            return "Процессор";
        }
    },
    RAM{
        @Override
        public String getDescription() {
            return "Память";
        }
    },
    HDD{
        @Override
        public String getDescription() {
            return "Жесткий диск";
        }
    };
}
