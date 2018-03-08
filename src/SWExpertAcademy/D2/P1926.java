package D2;

import java.util.Scanner;

/**
 * Created by bomikim on 2018. 3. 8. 오후 2:20:11
 */
public class P1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		String[] str = new String[N + 1];
		
		for (int i = 1; i <= N; i++) {
			str[i] = String.valueOf(i) + " ";

			if (getCharNumber(str[i]) == 1) {
				str[i] = "- ";
			} else if (getCharNumber(str[i]) == 2) {
				str[i] = "-- ";
			} else if (getCharNumber(str[i]) == 3) {
				str[i] = "--- ";
			}
		}

		for (String s : str) {

			if (s != null)
				System.out.print(s);
		}
	}

	public static int getCharNumber(String str) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (c == '3' || c == '6' || c == '9')
				count++;
		}
		return count;
	}
}
