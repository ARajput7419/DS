package Railway_Reservation;
import java.util.HashMap;

class SeatNotAvailable extends Exception{
    @Override
    public  String toString(){
        return "Seat Not Available";
    }
}

public class Train {

    public static class Pointer {
        public Pointer(String train) {
            this.train = train;
        }

        private String train;
        private int D_pointer = 1;
        private int D_seat_pointer = 1;
        private int S_pointer = 1;
        private int S_seat_pointer = 1;

        public  int[] get_D() throws SeatNotAvailable {
            boolean[] reservation = trains.get(train).get("D"+D_pointer);
            while (D_pointer < 11) {
                if (reservation[D_seat_pointer]) {
                    D_seat_pointer++;
                    if (D_seat_pointer > reservation.length) {
                        D_pointer++;
                        if (D_pointer > 10)
                            throw new SeatNotAvailable();
                        else
                            reservation = trains.get(train).get("D"+D_pointer);
                    }
                } else {
                    return new int[]{D_pointer, D_seat_pointer};
                }
            }
            throw new SeatNotAvailable();
        }

        public int[] get_S() throws SeatNotAvailable {
            boolean[] reservation = trains.get(train).get("S"+S_pointer);
            while (S_pointer < 11) {
                if (reservation[S_seat_pointer]) {
                    S_seat_pointer++;
                    if (S_seat_pointer > reservation.length) {
                        S_pointer++;
                        if (S_pointer > 10)
                            throw new SeatNotAvailable();
                        else
                            reservation = trains.get(train).get("S"+S_pointer);
                    }
                } else {
                    return new int[]{S_pointer, S_seat_pointer};
                }
            }
            throw new SeatNotAvailable();
        }
    }



    public static void makeReservation(String train , String coach , int seat){
        trains.get(train).get(coach)[seat]=true;
    }

    public  static boolean query(String train ,String coach,int seat) throws Exception{
            return trains.get(train).get(coach)[seat];
    }

    private static HashMap<String,HashMap<String,boolean[]>> trains = new HashMap<>();
    public static HashMap<String,Pointer> indexing = new HashMap<>();

    public  static void train_Initializer( String [] trains ){
        for ( String temp : trains )
            initialize_Coach(temp);
    }
    static void initialize_Coach(String train){
        HashMap<String,boolean[]> coach = new HashMap<>();
        for (int i = 1;i<=10;i++)
        {
            coach.put("D"+i,new boolean[100]);
            coach.put("S"+i,new boolean[50]);
        }
        trains.put(train,coach);
        indexing.put(train,new Pointer(train));
    }

}
