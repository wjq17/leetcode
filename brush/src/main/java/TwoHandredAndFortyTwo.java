import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 242 ��Ч����ĸ��λ��
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
            System.out.println(String.format("�ж���λ��: %s VS %s , �жϽ��: %b", key, stTest.get(key), isAna));
        }
    }

    public static boolean isAnagram(String s, String t) {
        // Ϊ�ջ򳤶Ȳ��ȣ����Ȼ����
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        // ��ĸ��ͬ��Ƶ����ͬ --> ��ϣ��
        int[] count = new int[26];
        // ��ͳ��
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        // �ٱȽ�
        for (int j = 0; j < t.length(); j++) {
            count[t.charAt(j) - 'a']--;
        }
        // �ж�
        for (int k = 0; k < count.length; k++) {
            if (count[k] != 0) {
                System.out.println(String.format("λ��[%d]�ϵ���ĸ����Ƶ�ʲ�ͬ: [%d]", k, count[k]));
                return false;
            }
        }
        return true;
    }
}
