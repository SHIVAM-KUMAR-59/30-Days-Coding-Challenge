
// 393. UTF-8 Validation ( Medium )
// Question Link - https://leetcode.com/problems/utf-8-validation/description/ 
// Given an integer array data representing the data, return whether it is a valid UTF-8 encoding (i.e. it translates to a sequence of valid UTF-8 encoded characters). A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules: For a 1-byte character, the first bit is a 0, followed by its Unicode code. For an n-bytes character, the first n bits are all one's, the n + 1 bit is 0, followed by n - 1 bytes with the most significant 2 bits being 10.

class Utf {
    // return byte - 1
    public int Get_Bytes(int val) {
        int pos = 1;
        int res = 0;
        while (val > 0) {
            if ((val & 1) == 0) {
                res = pos;
            }
            val >>= 1;
            pos++;
        }
        return 7 - res;
    }

    public boolean validUtf8(int[] data) {

        int byt = 0;
        for (int i = 0; i < data.length; i++) {
            if (byt == 0) {
                // if one byte number continue
                if (((data[i] >> 7) & 1) == 0)
                    continue;

                byt = Get_Bytes(data[i]);

                if (byt >= 4)
                    return false;
                // invaild no return false(10xxxxxx can't be start of any sequence)
                if (byt == 0)
                    return false;
            } else {
                int x = data[i] >> 6;
                // if(first two bits are not 10)
                if (x != 2)
                    return false;
                byt--;
            }
        }
        return byt == 0;
    }
}