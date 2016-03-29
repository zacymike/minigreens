public final class Logger {
    private static int indentLength = 0;
    private static final String tab = "\t";
    private static StringBuilder sb;

    private static String createIndent() {
        sb = new StringBuilder();
        for (int i = 0; i < indentLength; i++) {
            sb.append("\t");
        }

        return sb.toString();
    }

    public static void enter (Class<?> sender, String msg, Class<?> receiver) {
        String indent = createIndent();
        System.out.println(indent + sender.getTypeName() + " --- " + msg + " --> " + (receiver != null ? receiver.getTypeName() : ""));
        indentLength++;
    }

    public static void exit(Class<?> receiver, String msg, Class<?> sender) {
        indentLength--;
        String indent = createIndent();
        System.out.println(indent + receiver.getTypeName() + " <-- " + msg + " --- " + (sender != null ? sender.getTypeName() : ""));
    }
}
