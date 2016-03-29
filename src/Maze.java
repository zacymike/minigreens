import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Maze {

    private static boolean run = true;

    public static void main(String[] args)
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int testnum = 0;
        Player oneill;
        Floor pos;
        Floor neighbour;
        Floor neighbour2;
        SGBlue blue;
        SGYellow yellow;
        Wall wall1;
        Wall wall2;
        Scale scale;
        Door door;
        Gap gap;
        Box box;
        ZPM zpm;


        while(run)
        {
            System.out.println("Válassz test esetet: ");

            try
            {
                testnum = Integer.parseInt(br.readLine());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            clear();

            switch (testnum)
            {
                // Fordulás
                case 1:
                    System.out.println("Fordulás:");
                    oneill = new Player();
                    oneill.turn(TurnDirection.LEFT);
                    break;

                // Lépés üres mezőre
                case 2:
                    System.out.println("Lépés üres mezőre:");

                    pos = new Floor();
                    neighbour = new Floor();
                    oneill = new Player();

                    pos.setNeighbours(Direction.NORTH, neighbour);
                    oneill.setPosition(pos);

                    oneill.step();
                    break;

                // Lépés mérlegre
                case 3:
                    System.out.println("Lépés mérlegre:");

                    pos = new Floor();
                    neighbour = new Floor();
                    door = new Door();
                    scale = new Scale(door);
                    oneill = new Player();

                    neighbour.setElement(scale);
                    pos.setNeighbours(Direction.NORTH, neighbour);
                    oneill.setPosition(pos);

                    oneill.step();
                    break;

                // Lépés csillagkapura
                case 4:
                    System.out.println("Lépés csillagkapura:");

                    pos = new Floor();
                    neighbour = new Floor();
                    neighbour2 = new Floor();
                    oneill = new Player();
                    wall1 = new Wall(true);
                    wall2 = new Wall(true);
                    blue = SGBlue.getInstance();
                    yellow = SGYellow.getInstance();

                    blue.setEntry(neighbour);
                    yellow.setEntry(neighbour2);
                    wall1.setSG(blue);
                    wall2.setSG(yellow);
                    neighbour.setElement(wall1);
                    neighbour2.setElement(wall2);
                    pos.setNeighbours(Direction.NORTH, neighbour);
                    oneill.setPosition(pos);

                    oneill.step();
                    break;

                // Lépés szakadékba
                case 5:
                    System.out.println("Lépés szakadékba:");

                    pos = new Floor();
                    neighbour = new Floor();
                    gap = new Gap();
                    oneill = new Player();

                    neighbour.setElement(gap);
                    pos.setNeighbours(Direction.NORTH, neighbour);
                    oneill.setPosition(pos);

                    oneill.step();
                    break;

                // Lépés falra
                case 6:
                    System.out.println("Lépés falra:");

                    pos = new Floor();
                    neighbour = new Floor();
                    oneill = new Player();
                    wall1 = new Wall(false);

                    neighbour.setElement(wall1);
                    pos.setNeighbours(Direction.NORTH, neighbour);
                    oneill.setPosition(pos);

                    oneill.step();
                    break;

                // Lépés dobozra
                case 7:
                    System.out.println("Lépés dobozra:");

                    pos = new Floor();
                    neighbour = new Floor();
                    oneill = new Player();
                    box = new Box();

                    neighbour.setElement(box);
                    pos.setNeighbours(Direction.NORTH, neighbour);
                    oneill.setPosition(pos);

                    oneill.step();
                    break;

                // Lépés zpmre
                case 8:
                    System.out.println("Lépés zpmre:");

                    pos = new Floor();
                    neighbour = new Floor();
                    oneill = new Player();
                    zpm = new ZPM();

                    neighbour.setElement(zpm);
                    pos.setNeighbours(Direction.NORTH, neighbour);
                    oneill.setPosition(pos);

                    oneill.step();
                    break;

                // Lépés zárt ajtóra
                case 9:
                    System.out.println("Lépés zárt ajtóra:");

                    pos = new Floor();
                    neighbour = new Floor();
                    oneill = new Player();
                    door = new Door();

                    neighbour.setElement(door);
                    pos.setNeighbours(Direction.NORTH, neighbour);
                    oneill.setPosition(pos);

                    oneill.step();
                    break;
                // Lépés nyitott ajtóra
                case 10:
                    System.out.println("Lépés zárt ajtóra:");

                    pos = new Floor();
                    neighbour = new Floor();
                    oneill = new Player();
                    door = new Door();

                    door.open();
                    neighbour.setElement(door);
                    pos.setNeighbours(Direction.NORTH, neighbour);
                    oneill.setPosition(pos);

                    oneill.step();
                    break;
                // Felvesz dobozt
                case 11:
                    System.out.println("Felvesz dobozt:");

                    pos = new Floor();
                    neighbour = new Floor();
                    oneill = new Player();
                    box = new Box();

                    neighbour.setElement(box);
                    pos.setNeighbours(Direction.NORTH, neighbour);
                    oneill.setPosition(pos);

                    oneill.pickUp();
                    break;
                // Felvesz zpmet
                case 12:
                    System.out.println("Felvesz zpmet:");

                    pos = new Floor();
                    neighbour = new Floor();
                    oneill = new Player();
                    zpm = new ZPM();

                    neighbour.setElement(zpm);
                    pos.setNeighbours(Direction.NORTH, neighbour);
                    oneill.setPosition(pos);

                    oneill.pickUp();
                    break;
                // Lerak dobozt üresmezőre
                case 13:
                    System.out.println("Lerak dobozt üres mezőre:");

                    pos = new Floor();
                    neighbour = new Floor();
                    oneill = new Player();
                    box = new Box();

                    oneill.setBox(box);
                    pos.setNeighbours(Direction.NORTH, neighbour);
                    oneill.setPosition(pos);

                    oneill.putDown();
                    break;
                // Lerak dobozt szakadékba
                case 14:
                    System.out.println("Lerak dobozt üres mezőre:");

                    pos = new Floor();
                    neighbour = new Floor();
                    oneill = new Player();
                    gap = new Gap();
                    box = new Box();

                    oneill.setBox(box);
                    neighbour.setElement(gap);
                    pos.setNeighbours(Direction.NORTH, neighbour);
                    oneill.setPosition(pos);

                    oneill.putDown();
                    break;
                // Lő speciális falra
                case 15:
                    System.out.println("Lövés speciális falra:");

                    pos = new Floor();
                    neighbour = new Floor();
                    oneill = new Player();
                    wall1 = new Wall(true);

                    neighbour.setElement(wall1);
                    pos.setNeighbours(Direction.NORTH, neighbour);
                    oneill.setPosition(pos);

                    oneill.shoot(Type.BLUE);
                    break;
                // Lő sima falra
                case 16:
                    System.out.println("Lövés sima falra:");

                    pos = new Floor();
                    neighbour = new Floor();
                    oneill = new Player();
                    wall1 = new Wall(false);

                    neighbour.setElement(wall1);
                    pos.setNeighbours(Direction.NORTH, neighbour);
                    oneill.setPosition(pos);

                    oneill.shoot(Type.BLUE);
                    break;
                // Kilépés
                case 17:
                    run = false;
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Nincs ilyen számú menüpont");
                    break;
            }
        }
    }

    public static void clear()
    {
        try
        {
            if (System.getProperty("os.name").contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            } else
            {
                System.out.print("\033[H\033[2J");
            }
        }
        catch (final Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
