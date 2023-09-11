# FileTreePrinter
打印指定路径的目录树
Print the directory tree for the specified path

```java
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
```

print:

```
+--- en-US
|    \--- hmmapi.dll.mui
+--- images
|    \--- bing.ico
+--- SIGNUP
|    \--- install.ins
+--- zh-CN
|    +--- ieinstal.exe.mui
|    \--- iexplore.exe.mui
+--- ExtExport.exe
+--- hmmapi.dll
+--- iediagcmd.exe
+--- ieinstal.exe
+--- ielowutil.exe
+--- IEShims.dll
\--- iexplore.exe
```