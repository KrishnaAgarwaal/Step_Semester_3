package class_problems;

public class NicknameTag {
    private final String firstName;
    private final String lastInitial;

    public NicknameTag(String fullName) {
        String[] parts = fullName.split(" ");

        firstName = parts[0];
        lastInitial = parts[1].substring(0, 1);
    }

    public String getNickname() {
        return firstName + " " + lastInitial + ".";
    }

    public static void main(String[] args) {
        NicknameTag tag = new NicknameTag("Maria Gomez");

        System.out.println(tag.getNickname());
    }
}