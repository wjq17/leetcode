import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 242 有效的字母异位词
 * @author: junqiuwang
 * @created: 2021/06/09 20:50
 */
public class TwoHandredAndFortyTwo {

    public static void main(String[] args) {
        Map<String, String> stTest = new HashMap<String, String>();
        stTest.put("admin", "amind");
        stTest.put("error", "errori");
        for (String key : stTest.keySet()) {
            boolean isAna = isAnagram(key, stTest.get(key));
            System.out.println(String.format("判断异位词: %s VS %s , 判断结果: %b", key, stTest.get(key), isAna));
        }
    }

    public static boolean isAnagram(String s, String t) {
        // 为空或长度不等，则必然不是
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        // 字母相同，频率相同 --> 哈希表
        int[] count = new int[26];
        // 先统计
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        // 再比较
        for (int j = 0; j < t.length(); j++) {
            count[t.charAt(j) - 'a']--;
        }
        // 判断
        for (int k = 0; k < count.length; k++) {
            if (count[k] != 0) {
                System.out.println(String.format("位置[%d]上的字母出现频率不同: [%d]", k, count[k]));
                return false;
            }
        }
        return true;
    }
}
