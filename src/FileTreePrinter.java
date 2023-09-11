import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 目录树打印
 */
public class FileTreePrinter {

    private File dir;
    private StringBuilder fileTree = new StringBuilder();

    public FileTreePrinter(File dir) {
        this.dir = dir;
    }

    public FileTreePrinter(String path) {
        this.dir = new File(path);
    }

    public void printFileTree() {
        printFileTree(dir, "");
        System.out.println(fileTree.toString());
    }

    public void createFileTreeFile(String path) throws IOException {
        createFileTreeFile(new File(path));
    }

    public void createFileTreeFile(File file) throws IOException {
        printFileTree(dir, "");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(fileTree.toString().getBytes(StandardCharsets.UTF_8));
        fos.close();
    }

    /**
     * 打印通过递归生成的目录树
     * 文件夹在前，文件在后
     *
     * @param dir
     * @param prefix
     */
    private void printFileTree(File dir, String prefix) {
        File[] files = dir.listFiles();

        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                if (f1.isDirectory() && !f2.isDirectory()) {
                    return -1;
                } else if (!f1.isDirectory() && f2.isDirectory()) {
                    return 1;
                } else {
                    return f1.compareTo(f2);
                }
            }
        });

        for (int i = 0; i < files.length; i++) {
            fileTree.append(prefix + (i == files.length - 1 ? "\\--- " : "+--- ") + files[i].getName()).append("\n");
            if (files[i].isDirectory()) {
                printFileTree(files[i], prefix + (i == files.length - 1 ? "     " : "|    "));
            }
        }
    }
}
