package data;

import model.Card;
import model.User;

public class GlobalData {
    public static User[] users;
    public static Card[] cards;

    static {
         int id = 1;
        cards = new Card[]{
                new Card(id++,"4169584400001111","001","01/25",1001.25),
                new Card(id++,"4169584400002222","002","01/25",655.95),
                new Card(id++,"4169584400003333","003","01/25",5220.36),
                new Card(id++,"4169584400004444","004","01/25",50010.25),
                new Card(id++,"4169584400005555","005","01/25",36.51)
        };
    }

    static {
        int id = 1;
        users = new User[]{
          new User(id++,"Ali","Cabbarov","alicabbar","ABCD001","123456","+994550000001",cards[0],null),
          new User(id++,"Rehim","Rehimov","rehimrehim","ABCD002","123456","+994550000002",cards[1],null),
          new User(id++,"Yusif","Yusifov","yusifyusif","ABCD003","123456","+994550000003",cards[2],null),
          new User(id++,"mehemmed","Memmedov","mehemmed","ABCD004","123456","+994550000004",cards[3],null),
          new User(id++,"Cefer","Cabbarov","cefercabbar","ABCD005","123456","+994550000005",cards[4],null),
        };
    }


}
