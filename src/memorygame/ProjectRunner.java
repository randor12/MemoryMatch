/**
 * Memory Match
 */
package memorygame;

import java.util.*;
import java.io.*;

/**
 * @author Ryan Nicholas (rynicholas)
 * @version 2020.02.03
 *
 */
public class ProjectRunner {

    /**
     * @param args
     *            arguments
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, false);
        int n = input.nextInt();
        int k = input.nextInt();

        String[] card = new String[n];
        boolean[] removed = new boolean[n];
        // Loop through the cards
        for (int i = 0; i < k; i++) {
            int a = input.nextInt();
            int b = input.nextInt();

            String c1 = input.next();
            String c2 = input.next();
            // If the cards are a match
            card[a] = c1;
            card[b] = c2;
            if (c1.equals(c2)) {
                removed[a] = true;
                removed[b] = true;

            }
        }

        int ans = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int unseen = 0;
        int seen = 0;
        for (int i = 0; i < n; i++) {
            if (card[i] == null) {
                unseen++;
                continue;
            }
            if (removed[i])
                continue;
            Integer val = map.get(card[i]);
            if (val == null) {
                map.put(card[i], 1);
            }
            else {
                map.put(card[i], val + 1);
                ans++;
                seen -= 2;
            }
        }

        if (seen == unseen) {
            ans += seen;
        }
        else if (unseen == 2) {
            ans++;
        }

        out.println(ans);

        out.flush();

        input.close();
    }

}
