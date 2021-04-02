package linkedList;

import java.io.File;

public class Main5 {
    public static void main(String[] args) {
        Folder root = new Folder(new File("src"));
        for(int i = 0; i<=3; i++){
            System.out.println("SubFolders for depth " + i) ;
            for(File file : root.getSubFolders(i)){
                System.out.println(file.getName());
            }
            System.out.println();
        }
    }
}
