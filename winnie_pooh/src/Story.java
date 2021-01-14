import Model.*;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * История
 */
public class Story {
    public static void main(String[] args) {
        System.out.println("НАЧАЛО ИСТОРИИ\n");
        AnimalParent kenga = (AnimalParent) create(new AnimalParent("Кенга"));
        AnimalParent kristofer = (AnimalParent) create(new AnimalParent("Кристофер Робин"));
        AnimalParent sova = (AnimalParent) create(new AnimalParent("Сова"));
        AnimalChild iA = (AnimalChild) create(new AnimalChild("Иа"));
        AnimalChildEat ry = (AnimalChildEat) create(new AnimalChildEat("Ру", true));
        AnimalChildEat tigra = (AnimalChildEat) create(new AnimalChildEat("Тигра", false));
        AnimalChildEat[] children = {ry, tigra};
        AnimalChildEmotions vinnyPux = (AnimalChildEmotions) create(new AnimalChildEmotions("Винни-Пух", false));
        AnimalChildEmotions pyatachok = (AnimalChildEmotions) create(new AnimalChildEmotions("Пятачок", false));
        AnimalChildEmotions krolik = (AnimalChildEmotions) create(new AnimalChildEmotions("Кролик", false));
        AnimalChild[] journeyChild = {krolik, pyatachok, vinnyPux};
        System.out.println();

        System.out.println(pyatachok.makeHappy());
        System.out.println(getHappyText(pyatachok));
        pyatachok.setAction(() -> System.out.printf("%s поверил, что они затеяли  доброе дело, а раз и %s и %s будут в нем участвовать, то все будет хорошо \n",
                pyatachok.getName(), vinnyPux.getName(), krolik.getName()));
        pyatachok.makeAction();
        vinnyPux.setAction(() -> System.out.printf("%s, так как решил вопрос, где им как будто потерять Тигру  \n", vinnyPux.makeHappy()));
        vinnyPux.makeAction();
        System.out.println(getHappyText(vinnyPux));
        vinnyPux.setAction(() -> System.out.printf("%s предложил выступить в поход завтра утром. И что %s спросит %s, что он завтра собирается делать \n",
                vinnyPux.getName(), krolik.getName(), tigra.getName()));
        vinnyPux.makeAction();
        // Consumer <Animal> agree = (animal -> System.out.printf("%s согласился \n", animal.getName()));
        class AgreeAction implements AnimalAction {
            Animal animal;

            public AgreeAction(Animal animal) {
                this.animal = animal;
            }

            @Override
            public void make() {
                System.out.printf("%s согласился \n", animal.getName());
            }
        }
        pyatachok.setAction(new AgreeAction(pyatachok));
        pyatachok.makeAction();
        krolik.setAction(new AgreeAction(krolik));
        krolik.makeAction();
        System.out.println();

        House tigraHouse = (House) create(new House(tigra));
        BiConsumer <Animal, House> goToHome = (animal, animalHouse) -> System.out.printf("%s отправился в %s \n", animal.getName(), animalHouse.toString());
        krolik.setAction(()-> goToHome.accept(krolik, tigraHouse));
        krolik.makeAction();
        System.out.println();

        Weather weather = (Weather) create(new Weather());
        System.out.println(weather.Bad());
        System.out.println(getBadText(weather) + "\n");

        krolik.setAction(() -> System.out.printf("%s спросил %s, что он завтра собирается делать, если он ничего не собирается, то как насчет того, чтобы отправиться на прогулку и захватить с собой %sа и %s(ка) \n",
                krolik.getName(), tigra.getName(), vinnyPux.getName(), pyatachok.getName()));
        krolik.makeAction();
        boolean answer = true;
        if (answer) {
            tigra.setAction(new AgreeAction(tigra));
        }
        else {
            tigra.setAction(() -> {
                System.out.printf("%s отказался \n", tigra.getName());
                throw new StoryException();
            });
        }
        tigra.makeAction();
        System.out.println();
        House krolikHouse = (House) create(new House(krolik));
        vinnyPux.setAction(() -> goToHome.accept(vinnyPux, krolikHouse));
        vinnyPux.makeAction();
        pyatachok.setAction(() -> goToHome.accept(pyatachok, krolikHouse));
        pyatachok.makeAction();
        System.out.println();

        krolik.setAction(() -> System.out.printf("%s сказал %sу и %s(ку), что день самый подходящий для их затеи. Но %s, ближайший друг %s(ы), тоже их ждет. \n",
                krolik.getName(), vinnyPux.getName(), pyatachok.getName(), ry.getName(), tigra.getName()));
        krolik.makeAction();
        krolik.setAction(() -> System.out.printf("%s прикрыв рот лапкой, шепнул %sу: Положитесь на меня \n",
                krolik.getName(), vinnyPux.getName()));
        krolik.makeAction();
        Consumer <Animal> goJorney = (animal -> System.out.printf("%s отправился(ась) в поход \n", animal.getName()));
        tigra.setAction(() -> goJorney.accept(tigra));
        tigra.makeAction();
        for (AnimalChild child: journeyChild) {
            child.setAction(() -> goJorney.accept(child));
            child.makeAction();
        }
        System.out.println();

        pyatachok.setAction(() -> System.out.printf("%s идет рядом с %sом и %sом \n",
                pyatachok.getName(),vinnyPux.getName(),krolik.getName()));
        pyatachok.makeAction();
        tigra.setAction(() -> System.out.printf("%s носится вокруг %sа, %sа и %s(ка)\n\n",
                tigra.getName(), vinnyPux.getName(),krolik.getName(),pyatachok.getName()));
        tigra.makeAction();

        Footpath road = (Footpath) create(new Footpath());
        System.out.println(road.Narrow());
        System.out.println(getNarrowText(road) + "\n");

        Consumer <Animal> goTandem = (animal -> System.out.printf("%s идет гуськом \n", animal.getName()));
        for (AnimalChild child: journeyChild) {
            child.setAction(() -> goTandem.accept(child));
            child.makeAction();
        }
        tigra.setAction(()-> System.out.printf("%s описывает петли вокруг %sa, %s(ка) и %sа \n\n",
                tigra.getName(),krolik.getName(),pyatachok.getName(),vinnyPux.getName()));
        tigra.makeAction();

        Fog fog = (Fog) create(new Fog());
        boolean fogСhange = true;
        try {
            if (fogСhange) {
                System.out.println(fog.thick());
                System.out.println(getThickText(fog) + "\n");
            } else {
                    System.out.println(getThickText(fog) + "\n");
                    throw new FogException();
            }
        } catch (FogException e) {
            System.out.println("Туман не стал гуше");
            System.exit(0);
        }
        tigra.setAction(() -> System.out.printf("%s стал пропадать в %s\n", tigra.getName(), fog.toString()));
        tigra.makeAction();
        tigra.setAction(() -> System.out.printf("%s свернул в прогалину\n", tigra.getName()));
        tigra.makeAction();
        Consumer <Animal> lurk = (animal -> System.out.printf("%s притаился в высоком папоротнике, прислушиваясь \n", animal.getName()));
        for (AnimalChild child: journeyChild) {
            child.setAction(() -> lurk.accept(child));
            child.makeAction();
        }
        Consumer <Animal> listen = (animal -> System.out.printf("%s услышал удаляющийся топот %s(ы) \n", animal.getName(), tigra.getName()));
        for (AnimalChild child: journeyChild) {
            child.setAction(() -> listen.accept(child));
            child.makeAction();
        }
        Consumer <Animal> wait = (animal -> System.out.printf("%s ждет\n", animal.getName()));
        for (AnimalChild child: journeyChild) {
            child.setAction(() -> wait.accept(child));
            child.makeAction();
        }
        System.out.println();

        Forest forest = (Forest) create(new Forest());
        System.out.println(forest.quiet());
        System.out.println(getQuitText(forest) + "\n");

        Consumer <Animal> run = (animal -> System.out.printf("%s побежал \n", animal.getName()));
        for (AnimalChild child: journeyChild) {
            child.setAction(() -> run.accept(child));
            child.makeAction();
        }
        System.out.println();

        Consumer <Animal> stopRun = (animal -> System.out.printf("%s остановился \n", animal.getName()));
        for (AnimalChild child: journeyChild) {
            child.setAction(() -> stopRun.accept(child));
            child.makeAction();
        }
        vinnyPux.setAction(() -> System.out.printf("%s сказал %sу, что %s чуточку приотстал \n",
                vinnyPux.getName(), krolik.getName(), pyatachok.getName()));
        vinnyPux.makeAction();
        pyatachok.setAction(()-> System.out.printf("%s подобрался к %sу сзади\n\n", pyatachok.getName(), vinnyPux.getName()));
        pyatachok.makeAction();

        House kengaHouse = (House) create(new House(kenga));
        tigra.setAction(() -> System.out.printf("%s подумал, что надо пойти в %s\n",tigra.getName(), kengaHouse.toString()));
        tigra.makeAction();
        tigra.setAction(() -> System.out.printf("%s побежал назад\n\n",tigra.getName()));
        tigra.makeAction();

        kenga.setAction(() -> System.out.printf("%s увидела %s(у), и сказала: А вот и наш милый %s! Как раз пора принимать рыбий жир\n",
                kenga.getName(),tigra.getName(),tigra.getName()));
        kenga.makeAction();
        Cup tigraCup = (Cup) create(new Cup(tigra));
        System.out.println(tigraCup.fill(kenga));
        System.out.println();
        for (AnimalChildEat child : children) {
            System.out.println(getFishOilText(child));
        }
        System.out.println();
        System.out.println(tigraCup.use());
        for (AnimalChildEat child : children) {
            if (child.equals(tigra)) {
                System.out.println(child.takeFishOil());
            }
        }
        System.out.println();
        for (AnimalChildEat child : children) {
            System.out.println(getFishOilText(child));
        }

        Chair[] chairs = new Chair[3];
        for (int i = 0; i < chairs.length; i++) {
            chairs[i] = (Chair) create(new Chair());
        }
        System.out.println();
        BiConsumer<Animal, Animal> push = (performer, target) ->
                System.out.printf(
                        "%s дружески толкнул(а) %s%n",
                        performer.getName(),
                        target.getName()
                );
        ry.setAction(() -> push.accept(ry, tigra));
        tigra.setAction(() -> push.accept(tigra, ry));
        makeActions(children);
        System.out.println();
        for (Chair chair : chairs) {
            System.out.println(chair);
        }
        System.out.println();
        ry.setAction(() -> System.out.println(chairs[0].makeDown(ry, ActionIntent.ESPECIALLY)));
        tigra.setAction(() -> {
            Random random = new Random();
            int chairCount = random.nextInt(2) + 2;
            for (int i = 1; i < chairCount; i++) {
                System.out.println(chairs[i].makeDown(tigra, ActionIntent.ACCIDENTALLY));
            }
        });
        makeActions(children);
        System.out.println();
        for (Chair chair : chairs) {
            System.out.println(chair);
        }
        System.out.println();
        kenga.setAction(() -> System.out.printf("%s сказал(а) пойти собрать шишек%n", kenga.getName()));
        kenga.makeAction();
        System.out.println();
        Consumer<Animal> goToTrees = (animal) -> System.out.printf("%s отправился(ась) к Шести соснам%n", animal.getName());
        ry.setAction(() -> goToTrees.accept(ry));
        tigra.setAction(() -> goToTrees.accept(tigra));
        makeActions(children);
        System.out.println();
        Cone[] cones = new Cone[2];
        for (int i = 0; i < 2; i++) {
            cones[i] = (Cone) create(new Cone());
        }
        System.out.println();
        ry.setAction(() -> System.out.println(cones[0].hurl(ry, tigra)));
        tigra.setAction(() -> System.out.println(cones[1].hurl(tigra, ry)));
        makeActions(children);
        System.out.println();
        Consumer<Animal> forgetAll = (animal) ->
                System.out.printf(
                        "%s забыл(а) зачем пришел(а) в лес и оставил(а) корзинку под деревом%n",
                        animal.getName()
                );
        for (AnimalChildEat child : children) {
            child.setAction(() -> forgetAll.accept(child));
        }
        makeActions(children);
        System.out.println();
        for (AnimalChildEat child : children) {
            System.out.println(getFedText(child));
        }
        System.out.println();
        for (AnimalChildEat child : children) {
            child.setAction(() -> goToHome.accept(child,kengaHouse));
        }
        makeActions(children);
        for (AnimalChildEat child : children) {
            child.setAction(() -> System.out.println(child.eat()));
        }
        makeActions(children);
        System.out.println();

        for (AnimalChildEat child : children) {
            System.out.println(getFedText(child));
        }
        System.out.println();
        Door door = (Door) create(new Door());
        kristofer.setAction(()-> System.out.println(door.makeOpen(kristofer)));
        kristofer.makeAction();
        System.out.println(getOpenText(door)+ "\n");
        tigra.setAction(()-> System.out.printf("%s стал объяснять, что произошло \n", tigra.getName()));
        tigra.makeAction();
        kristofer.setAction(()-> System.out.printf("%s понял, что %s, %s и %s бродят где-то в %s\n\n",
                kristofer.getName(), vinnyPux.getName(), pyatachok.getName(), krolik.getName(), fog.toString()));
        kristofer.makeAction();

        Pit pit = (Pit) create(new Pit());
        Consumer <Animal> restPit = (animal -> System.out.printf("%s отдыхает в %s\n", animal.getName(), pit.toString()));
        for (AnimalChild child: journeyChild) {
            child.setAction(() -> restPit.accept(child));
            child.makeAction();
        }
        System.out.println(vinnyPux.makeUnHappy());
        vinnyPux.setAction(()-> System.out.printf("%sу ужасно надоела %s\n\n",vinnyPux.getName(),pit.toString()));
        vinnyPux.makeAction();

        Consumer <Animal> toBeSilent = (animal -> System.out.printf("%s молчит\n", animal.getName()));
        for (AnimalChild child: journeyChild) {
            child.setAction(() -> toBeSilent.accept(child));
            child.makeAction();
        }
        krolik.setAction(()-> System.out.printf("%s фыркнул на %s(ка) и скрылся в %s\n\n",
                krolik.getName(), pyatachok.getName(),fog.toString()));
        krolik.makeAction();
        vinnyPux.setAction(()-> wait.accept(vinnyPux));
        vinnyPux.makeAction();
        pyatachok.setAction(()-> wait.accept(pyatachok));
        pyatachok.makeAction();
        System.out.println();

        Consumer <Animal> standUp = (animal -> System.out.printf("%s встал\n", animal.getName()));
        vinnyPux.setAction(()-> standUp.accept(vinnyPux));
        vinnyPux.makeAction();

        Consumer <Animal> go = (animal -> System.out.printf("%s пошел\n", animal.getName()));
        vinnyPux.setAction(()-> go.accept(vinnyPux));
        vinnyPux.makeAction();
        pyatachok.setAction(()-> go.accept(pyatachok));
        pyatachok.makeAction();
        System.out.println();

        kristofer.setAction(()-> System.out.printf("В далике слишится голос %sa\n",kristofer.getName()));
        kristofer.makeAction();
        Consumer <Animal> appearFog = (animal -> System.out.printf("%s появился из %s\n", animal.getName(),fog.toString()));
        kristofer.setAction(()-> appearFog.accept(kristofer));
        kristofer.makeAction();
        System.out.println();

        tigra.setAction(()-> System.out.printf("%s носится по лесу и громко кричит\n", tigra.getName()));
        tigra.makeAction();
        krolik.setAction(()-> System.out.printf("%s услышал %s(у)\n", krolik.getName(), tigra.getName()));
        krolik.makeAction();
        krolik.setAction(()-> System.out.printf("%s кинулся на голос %s(ы) сквозь %s\n",
                krolik.getName(), tigra.getName(), fog.toString()));
        krolik.makeAction();
        tigra.setAction(()-> appearFog.accept(tigra));
        tigra.makeAction();
        System.out.println(krolik.makeHappy());
        System.out.println(getHappyText(krolik)+ "\n");

        PensivePlace pensivePlace = (PensivePlace) create(new PensivePlace());
        House puxHouse = (House) create(new House(vinnyPux));
        House pyatachokHouse = (House) create(new House(pyatachok));
        vinnyPux.setAction(()-> System.out.printf("%s повидался с %s(ом) в %s на полпути от %s к %s\n",
                vinnyPux.getName(), pyatachok.getName(),pensivePlace.toString(), puxHouse.toString(), pyatachokHouse.toString()));
        vinnyPux.makeAction();
        Consumer <Animal> nothingToDo = (animal -> System.out.printf("%s решил ничем не заняться\n",animal.getName()));
        vinnyPux.setAction(() -> nothingToDo.accept(vinnyPux));
        vinnyPux.makeAction();
        pyatachok.setAction(() -> nothingToDo.accept(pyatachok));
        pyatachok.makeAction();
        vinnyPux.setAction(()-> System.out.printf("%s предумал специальный стишок про %s\n\n",vinnyPux.getName(),pensivePlace.toString()));
        vinnyPux.makeAction();

        Consumer <Animal> sitPensivePlace = (animal -> System.out.printf("%s сидит в %s\n", animal.getName(), pensivePlace.toString()));
        vinnyPux.setAction(() -> sitPensivePlace.accept(vinnyPux));
        vinnyPux.makeAction();
        pyatachok.setAction(() -> sitPensivePlace.accept(pyatachok));
        pyatachok.makeAction();
        pyatachok.setAction(()-> System.out.printf("%s предложил %sу навестить всех-всех-всех, и просит %sа что-нибудь придумать\n",
                pyatachok.getName(), vinnyPux.getName(), vinnyPux.getName()));
        pyatachok.makeAction();
        vinnyPux.setAction(new AgreeAction(vinnyPux));
        vinnyPux.makeAction();
        vinnyPux.setAction(()-> System.out.printf("%s организовал Искпедицию\n", vinnyPux.getName()));
        vinnyPux.makeAction();
        vinnyPux.setAction(()-> standUp.accept(vinnyPux));
        vinnyPux.makeAction();
        pyatachok.setAction(()-> standUp.accept(pyatachok));
        pyatachok.makeAction();
        vinnyPux.setAction(()-> goToHome.accept(vinnyPux, puxHouse));
        vinnyPux.makeAction();
        pyatachok.setAction(()-> goToHome.accept(pyatachok, puxHouse));
        pyatachok.makeAction();

        vinnyPux.setAction(()-> System.out.printf("%s предложил %s(у) подкрепиться медом\n", vinnyPux.getName(), pyatachok.getName()));
        vinnyPux.makeAction();
        pyatachok.setAction(new AgreeAction(pyatachok));
        pyatachok.makeAction();
        System.out.println();

        System.out.println(vinnyPux.eat());
        System.out.println(getFedText(vinnyPux));
        System.out.println(pyatachok.eat());
        System.out.println(getFedText(pyatachok)+"\n");

        vinnyPux.setAction(()-> goToHome.accept(vinnyPux, kengaHouse));
        vinnyPux.makeAction();
        pyatachok.setAction(()-> goToHome.accept(pyatachok, kengaHouse));
        pyatachok.makeAction();
        Consumer <Animal> goHungry = (animal -> System.out.printf("%s проголодался пока шел\n", vinnyPux.getName()));
        vinnyPux.setAction(()-> goHungry.accept(vinnyPux));
        vinnyPux.makeAction();
        System.out.println(vinnyPux.hungry());
        System.out.println(getFedText(vinnyPux));
        pyatachok.setAction(()-> goHungry.accept(pyatachok));
        pyatachok.makeAction();
        System.out.println(pyatachok.hungry());
        System.out.println(getFedText(pyatachok)+"\n");

        BiConsumer <Animal, Animal> eatAt = (eatAnimal,animal) -> System.out.printf("%s поел у %s\n", eatAnimal.getName(), animal.getName());
        vinnyPux.setAction(()-> eatAt.accept(vinnyPux, kenga));
        vinnyPux.makeAction();
        System.out.println(vinnyPux.eat());
        System.out.println(getFedText(vinnyPux));
        pyatachok.setAction(()-> eatAt.accept(pyatachok, kenga));
        pyatachok.makeAction();
        System.out.println(pyatachok.eat());
        System.out.println(getFedText(pyatachok)+"\n");

        BiConsumer <AnimalChildEmotions, House> goOutHome = (animal, animalHouse) -> System.out.printf("%s вышел из %s и %s\n",
                animal.getName(), animalHouse.toString(), animal.makeCold());
        vinnyPux.setAction(()-> goOutHome.accept(vinnyPux, kengaHouse));
        vinnyPux.makeAction();
        System.out.println(getColdText(vinnyPux));
        pyatachok.setAction(()-> goOutHome.accept(pyatachok, kengaHouse));
        pyatachok.makeAction();
        System.out.println(getColdText(pyatachok));
        BiConsumer <AnimalChildEmotions, House> runToHome = (animal, animalHouse) -> System.out.printf("%s побежал со всех ног к %s\n",
                animal.getName(), animalHouse.toString());
        vinnyPux.setAction(()-> runToHome.accept(vinnyPux, krolikHouse));
        vinnyPux.makeAction();
        pyatachok.setAction(()-> runToHome.accept(pyatachok, krolikHouse));
        pyatachok.makeAction();
        System.out.println();

        vinnyPux.setAction(()-> System.out.printf("%s объяснился %sу\n", vinnyPux.getName(), krolik.getName()));
        vinnyPux.makeAction();
        krolik.setAction(()-> System.out.printf("%s сказал %sу и %s(у), что думал, что они пришли по делу\n",
                krolik.getName(), vinnyPux.getName(), pyatachok.getName()));
        krolik.makeAction();
        vinnyPux.setAction(()-> wait.accept(vinnyPux));
        vinnyPux.makeAction();
        pyatachok.setAction(()-> wait.accept(pyatachok));
        pyatachok.makeAction();
        House kristoferHouse = (House) create(new House(kristofer));
        vinnyPux.setAction(()-> goToHome.accept(vinnyPux, kristoferHouse));
        vinnyPux.makeAction();
        pyatachok.setAction(()-> goToHome.accept(pyatachok, kristoferHouse));
        pyatachok.makeAction();
        System.out.println();

        vinnyPux.setAction(()-> goHungry.accept(vinnyPux));
        vinnyPux.makeAction();
        System.out.println(vinnyPux.hungry());
        System.out.println(getFedText(vinnyPux));
        pyatachok.setAction(()-> goHungry.accept(pyatachok));
        pyatachok.makeAction();
        System.out.println(pyatachok.hungry());
        System.out.println(getFedText(pyatachok)+"\n");

        kristofer.setAction(()-> System.out.printf("%s обрадовался, увидев %sа и %s(а)\n",
                kristofer.getName(),vinnyPux.getName(),pyatachok.getName()));
        kristofer.makeAction();
        vinnyPux.setAction(()-> eatAt.accept(vinnyPux,kristofer));
        vinnyPux.makeAction();
        System.out.println(vinnyPux.eat());
        System.out.println(getFedText(vinnyPux));
        pyatachok.setAction(()-> eatAt.accept(pyatachok, kristofer));
        pyatachok.makeAction();
        System.out.println(pyatachok.eat());
        System.out.println(getFedText(pyatachok)+"\n");

        House iAHouse = (House) create(new House(iA));
        vinnyPux.setAction(()-> goToHome.accept(vinnyPux, iAHouse));
        vinnyPux.makeAction();
        pyatachok.setAction(()-> goToHome.accept(pyatachok, iAHouse));
        pyatachok.makeAction();
        System.out.println();

        Consumer <Animal> meet = (animal -> System.out.printf("%s встретился с %s\n", animal.getName(), iA.getName()));
        vinnyPux.setAction(()-> meet.accept(vinnyPux));
        vinnyPux.makeAction();
        pyatachok.setAction(()-> meet.accept(pyatachok));
        pyatachok.makeAction();
        System.out.println();
        Consumer <Animal> sayByeIa = (animal -> System.out.printf("%s попращался с %s\n", animal.getName(), iA.getName()));
        vinnyPux.setAction(()-> sayByeIa.accept(vinnyPux));
        vinnyPux.makeAction();
        pyatachok.setAction(()-> sayByeIa.accept(pyatachok));
        pyatachok.makeAction();
        System.out.println();

        House sovaHouse = (House) create(new House(sova));
        vinnyPux.setAction(()-> goToHome.accept(vinnyPux, sovaHouse));
        vinnyPux.makeAction();
        pyatachok.setAction(()-> goToHome.accept(pyatachok, sovaHouse));
        pyatachok.makeAction();
        System.out.println();

        System.out.println("КОНЕЦ ИСТОРИИ");





    }
    
    public static String getFishOilText(AnimalChildEat animalChild) {
        return String.format(
                "%s %s",
                animalChild.getName(),
                animalChild.isTookFishOil() ? "уже принял(а) рыбий жир" : "еще не принял(а) рыбий жир"
        );
    }
    
    public static String getFedText(AnimalChildEat animalChild) {
        return String.format(
                "%s %s",
                animalChild.getName(), animalChild.isFed() ? "уже сытый" : "проголодался"
        );
    }

    public static String getHappyText(AnimalChildEmotions animalChild) {
        return String.format(
                "%s %s",
                animalChild.getName(), animalChild.isHappy() ? "счастлив(а)" : "не счастлив(а)"
        );
    }

    public static String getColdText(AnimalChildEmotions animalChild) {
        return String.format(
                "%s %s",
                animalChild.getName(), animalChild.isCold() ? "замерз" : "не замезр"
        );
    }

    public static String getNarrowText(Footpath footpath) {
        return String.format(
                "Тропинка: %s",
                footpath.isNarrow() ? "узкая" : "широкая"
        );
    }

    public static String getBadText(Weather weather) {
        return String.format(
                "Погода: %s",
                weather.isBad() ? "плохая" : "хорошая"
        );
    }

    public static String getThickText(Fog fog) {
        return String.format(
                "Туман: %s",
                fog.isThick() ? "густой" : "слабый"
        );
    }

    public static String getQuitText(Forest forest) {
        return String.format(
                "Лес: %s",
                forest.isQuiet() ? "тихий" : "слышны звуки"
        );
    }

    public static String getOpenText(Door door) {
        return String.format(
                "Дверь: %s",
                door.isOpen() ? "открыта" : "закрыта"
        );
    }

    public static Object create(Object object) {
        System.out.printf("Создан обьект - %s%n", object.toString());
        return object;
    }

    public static void makeActions(Animal[] animals) {
        for (Animal animal : animals) {
            animal.makeAction();
        }
    }

}
