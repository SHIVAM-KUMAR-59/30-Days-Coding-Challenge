
// Remove Duplicates
// Remove duplicates from the string and return a string with all unique characters. ( The string only consists of smallcase alphabets i.e. from 'a' to 'z' )

public class RemoveDuplicates {
    public static void remove(String str, int index, StringBuilder newStr, boolean map[]) {
        // Base Case
        if (index == str.length()) {
            System.out.println(newStr);
            return;
        }

        char CurrentChar = str.charAt(index);
        if (map[CurrentChar - 'a'] == true) {
            // Character was already present there
            remove(str, index + 1, newStr, map);
        } else {
            // Add the character since it is unique
            map[CurrentChar - 'a'] = true;
            newStr.append(CurrentChar);
            remove(str, index + 1, newStr, map);
        }
    }

    public static void main(String[] args) {
        String str = "abbccda"; // Output will be 'abcd'
        remove(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
