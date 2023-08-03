package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        int countEqual = 0;
        if ((sample == null) || (words == null)) {
            return 0;
        }
        for (String str : words) {
            if ((str == null) || (str.trim().equals(""))) {
                continue;
            }
            if (str.trim().equalsIgnoreCase(sample.trim())) {
                countEqual++;
            }
        }
        return countEqual;
    }

    public static String[] splitWords(String text) {
        if (text == null) {
            return null;
        }
        Pattern p1 = Pattern.compile("[ ,!;.?:]");
        String s[] = p1.split(text);
        int countNonNull = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null && !(s[i].trim().equals(""))) {
                countNonNull++;
            }
        }
        String returnS[] = new String[countNonNull];
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == null || !(s[i].trim().equals(""))) {
                returnS[j] = s[i];
                j++;
            }
        }
        if (countNonNull != 0) {
            return returnS;
        } else {
            return null;
        }
    }

    public static String convertPath(String path, boolean toWin) {
        String s, s1;
        if ((path == null) || (path.trim().equals(""))) {
            return null;
        }
        if ((((path.indexOf('\\')) != -1) && (path.indexOf(47)) != -1) || ((path.indexOf('~') != 0) && (path.indexOf('~') != -1))) {
            return null;
        }
        Pattern pat = Pattern.compile("~");
        Matcher mat = pat.matcher(path);
        int count_ = 0;
        while (mat.find()) {
            count_++;
            if (count_ > 1) {
                return null;
            }
        }
        Pattern patC = Pattern.compile("C:");
        Matcher matC = patC.matcher(path);
        while (matC.find()) {
            if (matC.start() != 0) {
                return null;
            }
        }
        Pattern patSlash = Pattern.compile("(\\/\\/)");
        Matcher matSlash = patSlash.matcher(path);
        while (matSlash.find()) {
            return null;
        }

        Pattern pat4 = Pattern.compile("~\\\\");
        Matcher mat4 = pat4.matcher(path);
        while (mat4.find()) {
            return null;
        }

        if (toWin) {
            s1 = path.replace("/", "\\");
            s = s1.replace("~", "C:\\User");
            if (s.charAt(0) == '\\') {
                Pattern p = Pattern.compile("\\\\+");
                Matcher m = p.matcher(s);
                return m.replaceFirst("C:\\\\");
            } else if (s.length() >= 3) {
                if (s.substring(0, 3).equalsIgnoreCase("..\\")) {
                    return "..\\" + s.substring(3);
                }
            }
        } else {

            s = path.replace("\\", "/");
            if (s.length() >= 7) {
                if (s.substring(0, 7).equalsIgnoreCase("C:/User")) {
                    return "~" + s.substring(7);
                } else if (s.substring(0, 3).equalsIgnoreCase("C:/")) {
                    return "/" + s.substring(3);
                }
            }
            return s.replaceAll("C:\\/", "/");
        }
        return s;
    }

    public static String joinWords(String[] words) {
        String str_return = "[";
        if (words == null) {
            return null;
        }
        for (String str : words) {
            if (str.trim().equals("")) {
                continue;
            }
            str_return = str_return + str + ", ";
        }
        if (str_return.equals("[")) {
            return null;

        } else {
            return str_return.substring(0, str_return.length() - 2) + "]";
        }
    }

    public static void main(String[] args) {
        /*System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS",};
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);*/

        /*String[] words = new String[] {"   nice ", "nICE", "nic3"};
        String sample = "NICE";
        int result = StringUtil.countEqualIgnoreCaseAndSpaces(words, sample); // 2
        words = new String[]{" zoOm ", " z oom", " Z O O M "};
        sample = "ZOOM";
        result = StringUtil.countEqualIgnoreCaseAndSpaces(words, sample); // 1
        System.out.println("Result: " + result);*/

        /*System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));*/
        /*String text = " go with ...the:;        FLOW ";
        String[] result = StringUtil.splitWords(text); // ["go", "with", "the", "FLOW"]
        text = ":..,,,::: ;;;      ";
        result = StringUtil.splitWords(text); // null
        System.out.println("Result : " + Arrays.toString(result));*/

        /*System.out.println("Test 3: convertPath");
        //String unixPath = "C:\\Program Files\\my_prog_file.py";//"/some/unix/path";
        String unixPath = "../script.sh";
        unixPath = "//home/user/somefile";
        String convertResult = convertPath(unixPath, true);
        //String convertResult = convertPath(unixPath, false);
        System.out.println("Result: " + convertResult);
        //String expectedWinPath = "C:\\some\\unix\\path";
        //String expectedWinPath = "../script.sh";
        String expectedWinPath = "C:\\\\home\\\\user\\\\somefile";
        System.out.println("Must be: " + expectedWinPath);*/

        /*String winPath = "C:\\Program Files\\my_prog_file.py";
        String unixPath = StringUtil.convertPath(winPath, false); // "/Program Files/my_prog_file.py"
        unixPath = "../script.sh";
        winPath = StringUtil.convertPath(unixPath, true); // "..\\script.sh"
        unixPath = StringUtil.convertPath(unixPath, false); // "../script.sh"

        unixPath = "//home/user/somefile";
        winPath = StringUtil.convertPath(unixPath, true); // "C:\\home\\user\\somefile"*/

        /*System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);*/
    }
}