import java.io.File; 
import java.util.Scanner;

/*

- Simple Script That When Run Deletes All Shortcuts On Your Desktop
- I Made This Because I Got Annoyed Of Game Shortcuts On My Desktop Whenever I Installed Them And This Does It All For Me :)

*/



public class ShortcutDeleter {
    public static void main(String[] args) throws Exception {
        if (doubleCheck()) {         //
            deleteShortcuts();       // COMMENT OUT THESE THREE IF YOU DO NOT WANT TO BE ASKED CONFIRMATION EVERY TIME
        }                            //

        // deleteShortcuts();        // THEN UNCOMMENT THIS LINE
    }

    private static void deleteShortcuts () {
        String desktopPathStr = System.getProperty("user.home") + "/Desktop";
        File desktopPath = new File(desktopPathStr);
        File[] filesFromDesktop = desktopPath.listFiles();
        for(File f : filesFromDesktop) {
            if ((f.getName().endsWith(".url")) || (f.getName().endsWith(".exe")) || (f.getName().endsWith(".lnk"))) {
                f.delete();
            }
        }
    }

    public static boolean doubleCheck() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*** --- WARNING --- ***");
        System.out.println("To Delete All Files Of Type [.exe,.url,.lnk ] From Your Desktop:");
        System.out.println("Enter 1 To Execute");
        System.out.println("Enter Any Other Input To Cancel");
        String answer = sc.nextLine();

        if (answer.equals("1")) { return true; }
        else { return false; }
    }
}
