package java_practice;
//目標90分　結果100分
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice0811_1 {
    public static void main(String[] args) {

        findLowerLimitPrimeNumbers();
    }

    /**
     * 入力された上限値内の素数を出力するメソッド
     */
    public static void findPrimeNumbers() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("上限値を入力してください(2~9999):");
            String str = "";

            try {
                str = reader.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!isCheckNum(str)) {
                continue;
            }

            int numMax = Integer.parseInt(str);
            //1以下10000以上の場合、入力に戻る
            if (numMax < 2 || 9999 < numMax) {
                continue;
            }
            //入力された上限値の分だけ要素数を持った配列を作成
            int[] primeNumbers = new int[numMax + 1];
            for (int i = 2; i < numMax; i++) {
                for (int j = 2; j < numMax; j++) {
                    //割り切れた場合にカウントアップを行う
                    if (i % j == 0) {
                        primeNumbers[i]++;
                    }
                }

            }
            System.out.print(numMax + "以下の素数は、");
            String val = "";
            //カウントアップされた回数が一回のみの数字を出力する
            for (int i = 0; i < primeNumbers.length; i++) {
                if (primeNumbers[i] == 1) {
                    val += String.valueOf(i) + ",";
                }
            }
            val = val.substring(0, val.length() - 1);
            System.out.print(val + "です。");
            break;
        }
    }

    /**
     *
     */
    public static void findLowerLimitPrimeNumbers() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("下限値を入力してください(2~9999):");
            String str = "";

            try {
                str = reader.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!isCheckNum(str)) {
                continue;
            }
            System.out.print("上限値を入力してください(2~9999):");
            String str2 = "";

            try {
                str2 = reader.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!isCheckNum(str2)) {
                continue;
            }
            int numMin = Integer.parseInt(str);
            if (numMin < 2 || 9999 < numMin) {
                continue;
            }
            int numMax = Integer.parseInt(str2);
            if (numMax < 2 || 9999 < numMax) {
                continue;
            }
            int[] primeNumbers = new int[numMax + 1];
            //入力された下限値で初期化
            for (int i = numMin; i < numMax; i++) {
                for (int j = 2; j < numMax; j++) {
                    if (i % j == 0) {
                        primeNumbers[i]++;
                    }
                }

            }
            System.out.print(numMin + "以上" + numMax + "以下の素数は、");
            String val = "";
            for (int i = 0; i < primeNumbers.length; i++) {
                if (primeNumbers[i] == 1) {
                    val += String.valueOf(i) + ",";
                }
            }
            //最後の","を削除
            val = val.substring(0, val.length() - 1);
            System.out.print(val + "です。");
            break;
        }
    }
    /** 入力された文字列が数値に変換出来るか判定するメソッド
     * @param str
     * @return 数値に変換できるかの判定結果
     */
    public static boolean isCheckNum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
