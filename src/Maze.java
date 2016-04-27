
import java.io.*;
import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Maze {

    private static boolean run = true;
    private static Floor[][] maze;

    private enum ParsingState {
        INITIAL,
        ERROR,
        ELEMENT,
        ELEMENT_CLOSED,
        ELEMENT_SPECIFIED,
        SCALE_SPECIFIED,
        DOOR_SPECIFIED,
        COLONEL_SPECIFIED,
        JAFFA_SPECIFIED,
        BOX_SPECIFIED,
        SPECIAL_WALL_SPECIFIED,
        WEIGHTELEMENT_SPECIFIED,
        FLOOR_ADDED
    }

    private static ParsingState state = ParsingState.INITIAL;
    /**
     * Ez a függvény a main függvény, innen indul a játék
     */
    public static void main(String[] args) throws IOException
    {
        //ReadMaze("tesztek/setdirtest.txt");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String Str = "";
        String[] darabok = {"","",""};
        String[] palya = {"fg", "sd", "fg"};

        System.out.println("Lehetseges parancsok:\n " +
                "load filename\n " +
                "print filename \n " +
                "step mo \n " +
                "setDir mo dir \n " +
                "pickup mo \n " +
                "setDir mo dir \n " +
                "putdown mo \n " +
                "shoot c \n " +
                "show x y \n " +
                "rep state \n " +
                "hasBox mo \n " +
                "collcectedZPM mo \n " +
                "autoZPM state \n");

        while(run)
        {
            System.out.println("Johetnek a parancsok: ");

            try
            {
                Str = (br.readLine());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            int i = 0;
            for (String retval: Str.split(" ")){
                darabok[i] = retval;
                i++;
            }

            String parancs = darabok[0];
            String masodik = darabok[1];
            String harmadik = darabok[2];

            switch (parancs)
            {
                /* load filename
                * Leírás: A pályafájl beolvasására szolgáló parancs. A megadott fájlt egy helyre kell
                * másolni az osztályfájlokkal, ebben a mappában fogja keresni a prototípus.
                * Opciók: filename: a játéktér leírását tartalmazó txt fájl neve
                * */
                case "load":
                    palya = ReadMaze("tesztek/"+masodik+".txt");
                    parseMaze(palya);

                    break;

                /* print filename
                 *  Leírás: A megadott fájlnévvel létrehoz egy fájlt, amibe kimenti a
                 *  pálya pillanatnyiképét a 7.1.1-ben definiált pályaleíró nyelvet használva. Ha a megadott névvel már
                 *  létezik txt fájl, akkor felül fogja írni azt.
                 *  Opciók: filename: a txt fájl neve, amibe a játéktér állapotát menteni szeretnénk.
                 *  */
                case "print":
                    if (masodik != null) {
                        /**
                         * 2D String tömb létrehozása a mazeből
                         */
                        String[][] map2d = createStringMap(maze);
                        String[] ujpalya = new String[map2d.length];
                        /**
                         * 2D -> 1D String tömb alakítás
                         */
                        for(int row = 0; row < map2d.length; row++)
                        {
                            StringBuilder concrow = new StringBuilder("");
                            for(int col = 0; col < map2d.length; col++)
                            {
                                concrow.append(map2d[row][col]);
                            }
                            ujpalya[row] = concrow.toString();
                        }
                        /**
                         * A pálya kiírása
                         */
                        WriteMaze(masodik, ujpalya);
                    }
                    break;

                /* step mo
                 * Leírás: Az mo helyén megadott movable objektumot lépteti az objektumban tárolt
                 * pillanatnyi irányban lévő mezőre. Az mo lehetséges értékeinek
                 * jelentése megegyezik a pályaleíró nyelvben definiált jelentéssel.
                 * Opciók: mo = {o | j | r}
                 * */
                case "step":
                    break;

                /* setDir mo dir
                * Leírás: Az mo helyén megadott movable objektum irányát állítja a dir helyén megadottra.
                * Az mo lehetséges értékeinek jelentése megegyezik a pályaleíró nyelvben definiált jelentéssel.
                * A dir lehetséges értékeinél a fel és az f, a le és az l, a jobb és a j illetve a
                * bal és a bjelentése páronként megegyezik.
                * Opciók: mo = {o | j | r}, dir = {fel | le | jobb | bal | f | l | j | b}
                * */
                case "setDir":
                    break;

                /* pickup mo
                * Leírás: Az mo helyén megadott movable objektum megpróbálja az
                * irányában lévőmezőn található pályaelemet felvenni. Az mo lehetséges
                * értékeinek jelentése megegyezik a pályaleíró nyelvben definiált jelentéssel.
                * Előfordulhat, hogy az ezredes páros számú ZPM-et vett fel a parancs végrehajtása
                * után. A specifikáció szerint ekkor egy új ZPM jön létre egy véletlenszerű helyen, ez
                * alapból automatikusan megtörténik. Ezt a funkciót az autoZPM funkcióval lehet ki- és
                * bekapcsolni (pontosabban lásd később). Az mo lehetséges értékeinek
                * jelentése megegyezik a pályaleíró nyelvben definiált jelentéssel.
                * Opciók: mo = {o | j }
                 */
                case "pickup":
                    break;

                /* putdown mo
                * Leírás: Az mo helyén megadott movable objektum megpróbálja az irányában lévő
                * mezőre letenni a nála lévő pályaelemet, ami a specifikációnak megfelelően csak doboz lehet.
                * Az mo lehetséges értékeinek jelentése megegyezik a pályaleíró nyelvben definiált
                * jelentéssel.
                * Opciók: mo = {o | j }
                 */
                case "putdown":
                    System.out.println("putdown");
                    break;


                case "shoot":
                    System.out.println("shoot");
                    break;


                case "show":
                    System.out.println("show");
                    break;


                case "rep":
                    System.out.println("rep");
                    break;


                case "hasBox":
                    System.out.println("hasBox");
                    break;


                case "collectedZPM":
                    System.out.println("collectedZPM");
                    break;


                case "autoZPM":
                    System.out.println("autoZPM");
                    break;

                default:
                    System.out.println("Sajnos ilyen parancs nincs");
                    break;
            }
        }
    }

    private static void parseMaze(String[] palya) {
        boolean hadJaffa = false;
        boolean hadColonel = false;
        boolean hadReplicator = false;
        Box box = null;
        Door door = null;
        Wall specWall = null;
        Scale scale = null;
        maze = new Floor[palya.length][];
        for( int i = 0; i < palya.length; i++) {
            String line = palya[i];
            state = ParsingState.INITIAL;
            int countOfFloors = line.length() - line.replace(".", "").length();
            maze[i] = new Floor[countOfFloors];
            int indexOfFloor = 0;
            int countOfEmbeddedElements = 0;
            for ( int j = 0; j < line.length(); j++ ) {
                char c = line.charAt(j);
                System.out.print(c);
                switch( state ) {
                    case INITIAL:
                        if (c == '.') {
                            maze[i][indexOfFloor] = new Floor();
                            state = ParsingState.FLOOR_ADDED;
                        } else {
                            System.out.println("hibas bemenet " + i + ":" + j);
                            state = ParsingState.ERROR;
                            break;
                        }
                        break;
                    case FLOOR_ADDED:
                        if (c == '.') {
                            if (countOfEmbeddedElements == 0) {
                                indexOfFloor++;
                                maze[i][indexOfFloor] = new Floor();
                                state = ParsingState.FLOOR_ADDED;
                            } else {
                                System.out.println("hibas bemenet " + i + ":" + j);
                                state = ParsingState.ERROR;
                                break;
                            }
                        } else if (c == '(') {
                            state = ParsingState.ELEMENT;
                            countOfEmbeddedElements++;
                        } else {
                            System.out.println("hibas bemenet " + i + ":" + j);
                            state = ParsingState.ERROR;
                            break;
                        }
                        break;
                    case ELEMENT:
                        if (c == 'o') {
                            if (!hadColonel) {
                                Colonel.getInstance().setPosition(maze[i][indexOfFloor]);
                                state = ParsingState.COLONEL_SPECIFIED;
                            } else {
                                System.out.println("csak egy O'Neill lehet " + i + ":" + j);
                                state = ParsingState.ERROR;
                                break;
                            }
                        } else if (c == 'j') {
                            if (!hadJaffa) {
                                Jaffa.getInstance().setPosition(maze[i][indexOfFloor]);
                                state = ParsingState.JAFFA_SPECIFIED;
                            } else {
                                System.out.println("csak egy Jaffa lehet " + i + ":" + j);
                                state = ParsingState.ERROR;
                                break;
                            }
                        } else if (c == 'b') {
                            box = new Box();
                            maze[i][indexOfFloor].setElement(box);
                            state = ParsingState.BOX_SPECIFIED;
                        } else if (c == 'd') {
                            door = new Door();
                            maze[i][indexOfFloor].setElement(door);
                            state = ParsingState.DOOR_SPECIFIED;
                        } else if (c == 's') {
                            scale = new Scale(null);
                            maze[i][indexOfFloor].setElement(scale);
                            state = ParsingState.SCALE_SPECIFIED;
                        } else if (c == 'g') {
                            maze[i][indexOfFloor].setElement(new Gap());
                            state = ParsingState.ELEMENT_SPECIFIED;
                        } else if (c == 'z') {
                            maze[i][indexOfFloor].setElement(new ZPM());
                            state = ParsingState.ELEMENT_SPECIFIED;
                        } else if (c == 'w') {
                            maze[i][indexOfFloor].setElement(new Wall(false));
                            state = ParsingState.ELEMENT_SPECIFIED;
                        } else if (c == 'u') {
                            j++;
                            System.out.print(line.charAt(j));
                            if (line.charAt(j) == 'b') {
                                Bullet bullet = new Bullet(maze[i][indexOfFloor], Direction.NORTH, Type.BLUE);
                                Colonel.getInstance().addBullet(bullet);
                                state = ParsingState.ELEMENT_SPECIFIED;
                            } else if (line.charAt(j) == 'y') {
                                Bullet bullet = new Bullet(maze[i][indexOfFloor], Direction.NORTH, Type.YELLOW);
                                Colonel.getInstance().addBullet(bullet);
                                state = ParsingState.ELEMENT_SPECIFIED;
                            } else if (line.charAt(j) == 'r') {
                                Bullet bullet = new Bullet(maze[i][indexOfFloor], Direction.NORTH, Type.RED);
                                Jaffa.getInstance().addBullet(bullet);
                                state = ParsingState.ELEMENT_SPECIFIED;
                            } else if (line.charAt(j) == 'g') {
                                Bullet bullet = new Bullet(maze[i][indexOfFloor], Direction.NORTH, Type.GREEN);
                                Jaffa.getInstance().addBullet(bullet);
                                state = ParsingState.ELEMENT_SPECIFIED;
                            } else {
                                System.out.println("hibas bemenet " + i + ":" + j);
                                state = ParsingState.ERROR;
                                break;
                            }
                        } else if (c == 'x') {
                            specWall = new Wall(true);
                            maze[i][indexOfFloor].setElement(specWall);
                            state = ParsingState.SPECIAL_WALL_SPECIFIED;
                        } else if (c == 'r') {
                            if (!hadReplicator) {
                                Replicator.getInstance().setPosition(maze[i][indexOfFloor]);
                                state = ParsingState.ELEMENT_SPECIFIED;
                                hadReplicator = true;
                            } else {
                                System.out.println("csak egy replikator lehet " + i + ":" + j);
                                state = ParsingState.ERROR;
                                break;
                            }
                        } else {
                            System.out.println("hibas bemenet " + i + ":" + j);
                            state = ParsingState.ERROR;
                            break;
                        }
                        break;
                    case ELEMENT_CLOSED:
                        if (countOfEmbeddedElements == 0) {
                            if (c == '.') {
                                indexOfFloor++;
                                maze[i][indexOfFloor] = new Floor();
                                state = ParsingState.FLOOR_ADDED;
                            } else {
                                System.out.println("hibas bemenet " + i + ":" + j);
                                state = ParsingState.ERROR;
                                break;
                            }
                        } else if (c == ',') {
                            state = ParsingState.ELEMENT;
                        } else if (c != ')') {
                            System.out.println("hibas bemenet " + i + ":" + j);
                            state = ParsingState.ERROR;
                            break;
                        }
                        break;
                    case COLONEL_SPECIFIED:
                        if (c == '[') {
                            for (j++; line.charAt(j) != ']'; j++) {
                                c = line.charAt(j);
                                System.out.print(c);
                                Colonel.getInstance().setWeight(Colonel.getInstance().getWeight() * 10 + Character.getNumericValue(c));
                            }
                            hadColonel = true;
                            System.out.print(line.charAt(j));
                            state = ParsingState.WEIGHTELEMENT_SPECIFIED;
                        } else {
                            System.out.println("hibas bemenet " + i + ":" + j);
                            state = ParsingState.ERROR;
                            break;
                        }
                        break;
                    case JAFFA_SPECIFIED:
                        if (c == '[') {
                            for (j++; line.charAt(j) != ']'; j++) {
                                c = line.charAt(j);
                                System.out.print(c);
                                Colonel.getInstance().setWeight(Colonel.getInstance().getWeight() * 10 + Character.getNumericValue(c));
                            }
                            hadJaffa = true;
                            System.out.print(line.charAt(j));
                            state = ParsingState.WEIGHTELEMENT_SPECIFIED;
                        } else {
                            System.out.println("hibas bemenet " + i + ":" + j);
                            state = ParsingState.ERROR;
                            break;
                        }
                        break;
                    case BOX_SPECIFIED:
                        if (c == '[') {
                            for (j++; line.charAt(j) != ']'; j++) {
                                c = line.charAt(j);
                                System.out.print(c);
                                box.setWeight(box.getWeight() * 10 + Character.getNumericValue(c));
                            }
                            System.out.print(line.charAt(j));
                            state = ParsingState.WEIGHTELEMENT_SPECIFIED;
                        } else {
                            System.out.println("hibas bemenet " + i + ":" + j);
                            state = ParsingState.ERROR;
                            break;
                        }
                        break;
                    case DOOR_SPECIFIED:
                        if (c == '[') {
                            j++;
                            c = line.charAt(j);
                            System.out.print(line.charAt(j));
                            if (c == 'X') {
                                door.close();
                            } else if (c == '_') {
                                door.open();
                            } else {
                                System.out.println("hibas bemenet " + i + ":" + j);
                                state = ParsingState.ERROR;
                                break;
                            }

                            j++;
                            c = line.charAt(j);
                            System.out.print(line.charAt(j));
                            if (c != ']') {
                                System.out.println("hibas bemenet " + i + ":" + j);
                                state = ParsingState.ERROR;
                                break;
                            }

                            state = ParsingState.ELEMENT_SPECIFIED;
                        } else {
                            System.out.println("hibas bemenet " + i + ":" + j);
                            state = ParsingState.ERROR;
                            break;
                        }
                        break;
                    case SCALE_SPECIFIED:
                        if (c == '[') {
                            for (j++; line.charAt(j) != ']'; j++) {
                                c = line.charAt(j);
                                System.out.print(c);
                                scale.setLimit(scale.getLimit() * 10 + Character.getNumericValue(c));
                            }
                            System.out.print(line.charAt(j));
                            state = ParsingState.WEIGHTELEMENT_SPECIFIED;
                        } else {
                            System.out.println("hibas bemenet " + i + ":" + j);
                            state = ParsingState.ERROR;
                            break;
                        }
                        break;
                    case WEIGHTELEMENT_SPECIFIED:
                        if (c == '(') {
                            state = ParsingState.ELEMENT;
                            countOfEmbeddedElements++;
                        } else if (c == ')') {
                            state = ParsingState.ELEMENT_CLOSED;
                            countOfEmbeddedElements--;
                        }
                        break;
                    case ELEMENT_SPECIFIED:
                        if (c == ')') {
                            state = ParsingState.ELEMENT_CLOSED;
                            countOfEmbeddedElements--;
                        } else {
                            System.out.println("hibas bemenet " + i + ":" + j);
                            state = ParsingState.ERROR;
                            break;
                        }
                        break;
                    case SPECIAL_WALL_SPECIFIED:
                        if (c == '(') {
                            j++;
                            c = line.charAt(j);
                            if (Character.isDigit(c)) {
                                System.out.print(c);
                                if (Character.getNumericValue(c) == 1) {
                                    specWall.setSG(SGBlue.getInstance());
                                } else if (Character.getNumericValue(c) == 2) {
                                    specWall.setSG(SGYellow.getInstance());
                                } else if (Character.getNumericValue(c) == 3) {
                                    specWall.setSG(SGGreen.getInstance());
                                } else if (Character.getNumericValue(c) == 4) {
                                    specWall.setSG(SGRed.getInstance());
                                } else {
                                    System.out.println("hibas bemenet " + i + ":" + j);
                                    state = ParsingState.ERROR;
                                    break;
                                }
                                j++;
                                c = line.charAt(j);
                                if (c == ')') {
                                    System.out.print(c);
                                    state = ParsingState.ELEMENT_SPECIFIED;
                                } else {
                                    System.out.println("hibas bemenet " + i + ":" + j);
                                    state = ParsingState.ERROR;
                                    break;
                                }
                            } else {
                                System.out.println("hibas bemenet " + i + ":" + j);
                                state = ParsingState.ERROR;
                                break;
                            }
                        } else if (c == ')') {
                            state = ParsingState.ELEMENT_CLOSED;
                            countOfEmbeddedElements--;
                        } else {
                            System.out.println("hibas bemenet " + i + ":" + j);
                            state = ParsingState.ERROR;
                            break;
                        }
                        break;
                    case ERROR:
                        return;
                    default: return;
                }
            }
            System.out.println("");
        }
    }

    /**
     * Ez a függvény a pálya/labirintus beolvasására való, a paraméterben megadott elérési útvonalban megadott filet olvassa ki,
     * ez lesz a mi pályaleíró nyelvünkkel megadott pálya
     * visszatérési értéke pedig string tömbben megadott pálya
     */
    public static String[] ReadMaze(String path) throws IOException {
        URL url = Maze.class.getResource(path);
        File file2 = new File(url.getPath());
        String fname = file2.toString();

        try {
            FileData file = new FileData();
            file.ReadFile(fname);
            String[] aryLines = file.OpenFile();

            int i;
            for ( i=0; i < aryLines.length; i++ ) {
                System.out.println(aryLines[i]) ;
            }
            System.out.println("");
            return aryLines;
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Ez a függvény való a pálya változásainak elmentésére, egy új/vagy régi txt fileba menti el
     */
    public static void WriteMaze(String path, String[] ujpalya){
        try {
            WriteFile data = new WriteFile(path, true);
            for(int i = 0; i < ujpalya.length; i++)
                data.writeToFile(ujpalya[i]);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static String[][] createStringMap(Floor[][] maze)
    {
        int rows = maze.length;
        int cols = maze[0].length;
        String[][] outmap = new String[rows][cols];

        boolean hasColonel = false;
        boolean hasJaffa = false;
        boolean hasReplicator = false;
        boolean hasBulletColonel = false;
        boolean hasBulletJaffa = false;

        Map<String, String> symbols = new HashMap<String, String>();

        Floor positionColonel = Colonel.getInstance().getPosition();
        Floor positionJaffa = Jaffa.getInstance().getPosition();
        Floor positionReplicator = Replicator.getInstance().getPosition();
        Floor positionBulletColonel = null;
        if(Colonel.getInstance().getBullet() != null)
        {
            positionBulletColonel = Colonel.getInstance().getBullet().getPosition();
            hasBulletColonel = true;

            String type ="";
            switch (Colonel.getInstance().getBullet().getType())
            {
                case BLUE:
                    type = "b";
                    break;
                case YELLOW:
                    type = "y";
                    break;
                case RED:
                    type = "r";
                    break;
                case GREEN:
                    type = "g";
                    break;
            }

            symbols.put("BulletColonel", String.format("(u%s)", type));
        }
        Floor positionBulletJaffa = null;
        if(Jaffa.getInstance().getBullet() != null)
        {
            positionBulletJaffa = Jaffa.getInstance().getBullet().getPosition();
            hasBulletJaffa = true;

            String type ="";
            switch (Jaffa.getInstance().getBullet().getType())
            {
                case BLUE:
                    type = "b";
                    break;
                case YELLOW:
                    type = "y";
                    break;
                case RED:
                    type = "r";
                    break;
                case GREEN:
                    type = "g";
                    break;
            }

            symbols.put("BulletJaffa", String.format("(u%s)", type));
        }



        if (positionColonel != null)
        {
            hasColonel = true;
            if(Colonel.getInstance().getBox() != null)
                symbols.put("Colonel", String.format("(o[%d](b[%d]))", Colonel.getInstance().getWeight(), Colonel.getInstance().getBox().getWeight()));
            else
                symbols.put("Colonel", String.format("(o[%d])", Colonel.getInstance().getWeight()));
        }
        if (positionJaffa != null)
        {
            hasJaffa = true;
            symbols.put("Jaffa", String.format("(j[%d])", Jaffa.getInstance().getWeight()));
        }
        if (positionReplicator != null)
        {
            hasReplicator = true;
            symbols.put("Replicator", "(r)");
        }

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                Element element = maze[i][j].getElement();

                /**
                 * Floor típusú objektum szimbólumának beírása
                 */
                if(element == null)
                {
                    if(hasColonel && positionColonel == maze[i][j])
                        outmap[i][j] = symbols.get("Colonel");
                    else if(hasJaffa && positionJaffa == maze[i][j])
                        outmap[i][j] = symbols.get("Jaffa");
                    else if(hasReplicator && positionReplicator == maze[i][j])
                        outmap[i][j] = symbols.get("Replicator");
                    else if(hasBulletColonel && positionBulletColonel == maze[i][j])
                        outmap[i][j] = symbols.get("BulletColonel");
                    else if(hasBulletJaffa && positionBulletJaffa == maze[i][j])
                        outmap[i][j] = symbols.get("BulletJaffa");
                    else
                        outmap[i][j] = ".";
                }
                else
                {
                    /**
                     * Ha van valmilyen Movable a flooron és egy element is
                     */
                    boolean hasmovable = false;
                    StringBuilder out = new StringBuilder("(");
                    if(hasColonel && positionColonel == maze[i][j])
                    {
                        out.append(symbols.get("Colonel"));
                        out.append(",");
                        hasmovable = true;
                    }
                    else if(hasJaffa && positionJaffa == maze[i][j])
                    {
                        out.append(symbols.get("Jaffa"));
                        out.append(",");
                        hasmovable = true;
                    }
                    else if(hasReplicator && positionReplicator == maze[i][j])
                    {
                        out.append(symbols.get("Replicator"));
                        out.append(",");
                        hasmovable = true;
                    }
                    else if(hasBulletColonel && positionBulletColonel == maze[i][j])
                    {
                        out.append(symbols.get("BulletColonel"));
                        out.append(",");
                        hasmovable = true;
                    }
                    else if(hasBulletJaffa && positionBulletJaffa == maze[i][j])
                    {
                        out.append(symbols.get("BulletJaffa"));
                        out.append(",");
                        hasmovable = true;
                    }

                    /**
                     * Elementek konkatenálása
                     */
                    /**
                     * Box típusú element szimbólumának és súlyának beírása
                     */
                    if (element instanceof Box)
                    {
                        int weight = ((Box) element).getWeight();
                        out.append(String.format("b[%d])", weight));
                    }
                    /**
                     * Door típusú element szimbólumának és állapotának beírása
                     */
                    else if (element instanceof Door)
                    {
                        boolean open = ((Door) element).isOpened();
                        if(open)
                        {
                            out.append("d[_])");
                        }
                        else
                        {
                            out.append("d[X])");
                        }
                    }
                    /**
                     * Gap típusú element szimbólumának beírása
                     */
                    else if (element instanceof Gap)
                    {
                        out.append("g)");
                    }
                    /**
                     * Scale típusú element szimbólumának és rajta lévő súlyok összegének beírása
                     */
                    else if (element instanceof Scale)
                    {
                        out.append(String.format("s[%d])", ((Scale) element).getCurrent_w()));
                    }
                    /**
                     * Wall típusú element szimbólumának beírása
                     */
                    else if (element instanceof Wall)
                    {
                        if(((Wall) element).getIsSpecial())
                        {
                            /**
                             * SG típusú element szimbólumának és típusának beírása
                             */
                            String type = "";
                            switch (((Wall) element).getSG().getType())
                            {
                                case BLUE:
                                    type = "(1)";
                                    break;
                                case YELLOW:
                                    type = "(2)";
                                    break;
                                case RED:
                                    type = "(4)";
                                    break;
                                case GREEN:
                                    type = "(3)";
                                    break;
                            }
                            out.append(String.format("x%s)", type));
                        }
                        else
                        {
                            out.append("x)");
                        }
                    }
                    /**
                     * ZPM típusú element szimbólumának beírása
                     */
                    else if (element instanceof ZPM)
                    {
                        out.append("z)");
                    }

                    /**
                     * Ha volt Movable is az adott Flooron akkor lezáró ) a több objektumot összefogó zárójelhez
                     */
                    if(hasmovable)
                        out.append(")");

                    outmap[i][j] = out.toString();
                }
            }
        }

        return outmap;
    }

    /**
     * Ez a függvény a képernyő/konzol törtlését végzi
     */
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
