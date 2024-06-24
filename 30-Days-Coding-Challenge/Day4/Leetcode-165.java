
// 165. Compare Version Numbers ( Medium )
// Question Link - https://leetcode.com/problems/compare-version-numbers/description/
// Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots '.'. The value of the revision is its integer conversion ignoring leading zeros.
// To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions, treat the missing revision values as 0.
// Return the following:
// If version1 < version2, return -1.
// If version1 > version2, return 1.
// Otherwise, return 0.
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }
}