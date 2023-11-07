package com.itheima.d3_collection_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Room {
    // 必须有一副牌。
    private List<Card> allCards = new ArrayList<>();

    public Room(){
        // 1、做出54张牌，存入到集合allCards
        // a、点数：个数确定了，类型确定。
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        // b、花色：个数确定了，类型确定。
        String[] colors = {"♠", "♥", "♣", "♦"};
        int size = 0; // 表示每张牌的大小
        // c、遍历点数，再遍历花色，组织牌
        for (String number : numbers) {
            // number = "3"
            size++; // 1 2 ....
            for (String color : colors) {
                // 得到一张牌
                Card c = new Card(number, color, size);
                allCards.add(c); // 存入了牌
            }
        }
        // 单独存入小大王的。
        Card c1 = new Card("",  "🃏" , ++size);
        Card c2 = new Card("", "👲" , ++size);
        Collections.addAll(allCards, c1, c2);
        System.out.println("新牌：" + allCards);
    }

    /**
     * 游戏启动
     */
    public void start() {
        // 1、洗牌： allCards
        Collections.shuffle(allCards);
        System.out.println("洗牌后：" + allCards);

        // 2、发牌，首先肯定要定义 三个玩家。 List(ArrayList)  Set(TreeSet)
        List<Card> linHuChong = new ArrayList<>();
        List<Card> jiuMoZhi = new ArrayList<>();
        List<Card> renYingYing = new ArrayList<>();
        // 正式发牌给这三个玩家，依次发出51张牌，剩余3张做为底牌。
        // allCards = [♥3, ♣10, ♣4, ♥K, ♦Q, ♣2, 🃏, ♣8, ....
        //             0     1   2   3   4   5   6 ...   % 3
        for (int i = 0; i < allCards.size() - 3; i++) {
            Card c = allCards.get(i);
            // 判断牌发给谁
            if(i % 3 == 0){
                // 请啊冲接牌
                linHuChong.add(c);
            }else if(i % 3 == 1){
                // 请啊鸠来接牌
                jiuMoZhi.add(c);
            }else if(i % 3 == 2){
                // 请盈盈接牌
                renYingYing.add(c);
            }
        }

        // 3、对3个玩家的牌进行排序
        sortCards(linHuChong);
        sortCards(jiuMoZhi);
        sortCards(renYingYing);
        // 4、看牌
        System.out.println("啊冲：" + linHuChong);
        System.out.println("啊鸠：" + jiuMoZhi);
        System.out.println("盈盈：" + renYingYing);
        List<Card> lastThreeCards = allCards.subList(allCards.size() - 3, allCards.size()); // 51 52 53
        System.out.println("底牌：" + lastThreeCards);
        jiuMoZhi.addAll(lastThreeCards);
        sortCards(jiuMoZhi);
        System.out.println("啊鸠抢到地主后：" + jiuMoZhi);
    }

    /**
     * 集中进行排序
     * @param cards
     */
    private void sortCards(List<Card> cards) {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                // return o1.getSize() - o2.getSize(); // 升序排序
                return o2.getSize() - o1.getSize(); // 降序排序
            }
        });
    }
}








