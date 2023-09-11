/**
 * @author Berial
 * @since 2023/09/11
 */
class Test {

    public static void main(String[] args) {
        String dir = "C:\\Program Files\\Internet Explorer";
        FileTreePrinter printer = new FileTreePrinter(dir);
        printer.printFileTree();

//        try {
//            printer.createFileTreeFile("D:\\test.txt");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
