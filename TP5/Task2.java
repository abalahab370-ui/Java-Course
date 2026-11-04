// FsItem.java (Base Class)
class FsItem {
    protected String name;
    protected long sizeBytes;

    public FsItem(String name, long sizeBytes) {
        setName(name);
        this.sizeBytes = sizeBytes;
    }

    // Validation and renaming method
    public boolean setName(String newName) {

        if (newName != null && !newName.trim().isEmpty() && !newName.contains("/") && !newName.contains("\\")) {
            this.name = newName;
            return true;
        }
        else {
            throw new IllegalArgumentException("Name must not be empty or contain path separators.");
        }
    }

    public String getName() {
        return name;
    }

    public long getSizeBytes() {
        return sizeBytes;
    }

    public String info() {
        return "FsItem [Name: " + name + ", Size: " + sizeBytes + " bytes]";
    }
}

// TextFile.java (Subclass)
class TextFile extends FsItem {
    private int lineCount;

    public TextFile(String name, long sizeBytes, int lineCount) {
        super(name, sizeBytes); // Initialize parent fields via super()[cite: 158]
        this.lineCount = lineCount;
    }

    @Override
    public String info() {
        return "TextFile {" + super.info() + ", Lines: " + lineCount + "}";
    }
}

// ImageFile.java (Subclass)
class ImageFile extends FsItem {
    private int width;
    private int height;

    public ImageFile(String name, long sizeBytes, int width, int height) {
        super(name, sizeBytes); // Initialize parent fields via super()[cite: 158]
        this.width = width;
        this.height = height;
    }

    @Override
    public String info() {
        return "ImageFile {" + super.info() + ", Resolution: " + width + "x" + height + "px}";
    }
}

// Main.java (Test Class)
public class Task2 {
    public static void main(String[] args) {
        // 1. Create instances
        FsItem txt = new TextFile("notes.txt", 1024, 45);
        FsItem img = new ImageFile("banner.png", 204800, 1920, 1080);

        System.out.println("=== Initial Filesystem State ===");
        System.out.println(txt.info());
        System.out.println(img.info());

        // 2. Test renaming with valid inputs
        System.out.println("\n=== Testing Renaming (Valid) ===");
        boolean validRename = txt.setName("lecture_notes.txt");
        System.out.println("Renamed notes.txt to lecture_notes.txt? " + validRename);
        System.out.println(txt.info());

        // 3. Test renaming with invalid inputs (empty or forbidden characters)
        System.out.println("\n=== Testing Renaming (Invalid Inputs) ===");
        try {
            img.setName("");
        } catch (IllegalArgumentException error) {
            System.out.println("Could not rename to an empty string: " + error.getMessage());
        }

        try {
            img.setName("bad/name.png");
        } catch (IllegalArgumentException error) {
            System.out.println("Could not rename with slash ('/): " + error.getMessage());
        }
        System.out.println("Final Image Info: " + img.info());
    }
}
