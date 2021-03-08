
public class Fight {

    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.start();


    }


    public abstract static class Fighter{

        String name;
        String specialty;

        protected abstract void run();

        protected void die() {
            System.out.println("Умер");
        }
    }

    public interface HandToHandCombat {
        void hitByHand();
        void hitByPan();
        void hiss();
    }

    public interface KnifeCombat {
        void hitByLeg();
        void hitByKnife();
        void hitPanWithKnife();
        void catchUp();
    }

    private static class Cat extends Fighter implements HandToHandCombat{


        public void run() {
            System.out.println("Fighter " + this.name + " убегает");
        }

        @Override
        public void die() {
            System.out.println("Fighter " + this.name +  " умер");
        }

        public void hitByHand() {
            System.out.println("Fighter " + this.name + " ударяет противника лапкой");
        }

        public void hitByPan() {
            System.out.println("Fighter " + this.name + " ударяет противника сковородкой");
        }

        public void hiss() {
            System.out.println("Fighter " + this.name + " шипит");
        }

    }

    private static class Tiger extends Fighter implements KnifeCombat{

        public void run() {
            System.out.println("Fighter " + this.name + " убегает");
        }

        @Override
        public void die() {
            System.out.println("Fighter " + this.name + " умер");
        }

        public void hitByLeg() {
            System.out.println("Fighter " + this.name + " ударяет противника задней лапой");
        }

        public void hitByKnife() {
            System.out.println("Fighter " + this.name + " ударяет противника ножом");
        }

        public void hitPanWithKnife() {
            System.out.println("Fighter " + this.name + " отражает удар скородки ножом");
        }

        public void catchUp() {
            System.out.println("Fighter " + this.name + " догоняет противника");
        }
    }

    private static class Battle {
        public void start() {

            Tiger tiger = new Tiger();

            tiger.name = "Тигр";
            tiger.specialty = "Бой с ножом";

            Cat cat = new Cat();

            cat.name = "Кот";
            cat.specialty = "Рукопашный бой";

            cat.hitByHand();
            tiger.hitByLeg();

            cat.hitByPan();
            tiger.hitPanWithKnife();
            tiger.hitByKnife();

            cat.hiss();
            cat.run();

            tiger.catchUp();
            tiger.hitByKnife();
            cat.die();

            System.out.println(" ");

            System.out.println("Бой закончен!");

        }
    }
}
