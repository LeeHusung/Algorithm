import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long curHeroMaxHeart;
    static long curHeroCurAttack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long start = 0;
        long end = Long.MAX_VALUE;
        long n = Integer.parseInt(s[0]);
        long heroAttack = Integer.parseInt(s[1]);
        long[][] arr = new long[(int)n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        long answer = 0;

        while (start <= end) {
            long heroMaxHeart = (start + end) / 2;
            curHeroMaxHeart = heroMaxHeart;
            curHeroCurAttack = heroAttack;
//            System.out.println("=============");
//            System.out.println("start, end : " + start + " " + end);
//            System.out.println(heroMaxHeart + " " + heroAttack);
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (arr[i][0] == 1) {
                    flag = fight(arr[i][1], arr[i][2]);
                    if (!flag) {
                        break;
                    }
                } else if (arr[i][0] == 2) {
                    curHeroMaxHeart = Math.min(arr[i][2] + curHeroMaxHeart, heroMaxHeart);
                    curHeroCurAttack += arr[i][1];
                }
//                System.out.println("=============");
//                System.out.println(heroMaxHeart + " " + heroCurAttack);
            }
            if (!flag) {
                start = heroMaxHeart + 1;
            }
            if (flag) {
                answer = heroMaxHeart;
                end = heroMaxHeart - 1;
//                System.out.println(heroMaxHeart);
//                System.out.println("flag=true hit : " + end);
            }
        }
        System.out.println(answer);

    }

    private static boolean fight(long monsterCurAttack, long monsterCurHeart) {
//        System.out.println("heroCurAttack = " + heroCurAttack);
//        System.out.println("heroMaxHeart = " + heroMaxHeart);
//        System.out.println("monsterCurAttack = " + monsterCurAttack);
//        System.out.println("monsterCurHeart = " + monsterCurHeart);
//        return false;
//        long curHeroMaxHeart2 = curHeroMaxHeart;
//        while (true) {
////            System.out.println("mon : " + monsterCurHeart + " " + monsterCurAttack);
////            System.out.println("hero : " + curHeroMaxHeart + " " + curHeroCurAttack);
//            monsterCurHeart -= curHeroCurAttack;
//            if (monsterCurHeart <= 0) return true;
//            curHeroMaxHeart -= monsterCurAttack;
//            if (curHeroMaxHeart <= 0) return false;
//        }
        long monster = monsterCurHeart / curHeroCurAttack + (monsterCurHeart % curHeroCurAttack == 0 ? 0 : 1);
        long player = curHeroMaxHeart / monsterCurAttack + (curHeroMaxHeart % monsterCurAttack == 0 ? 0 : 1);
        if (monster <= player) {
            curHeroMaxHeart -= monsterCurAttack * (monster - 1);
            return true;
        }
        return false;
    }
}
