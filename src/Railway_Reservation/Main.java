package Railway_Reservation;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

public class Main {
    private  static Booking[] bookings;
    private static LinkedList<ArrayList<String>> data() throws IOException {
        FileReader reader = new FileReader("/home/aniket/IdeaProjects/DS/src/Railway_Reservation/Railway Reservation Data.csv");
        StringBuilder temp = new StringBuilder();
        LinkedList<ArrayList<String>> result = new LinkedList<>();
        ArrayList<String> temp_list = new ArrayList<>();
        boolean inside_double_quotes = false;
        int character;
        while ((character = reader.read()) != -1) {
            if (character == '"') {
                inside_double_quotes = !inside_double_quotes;
            } else if (character == ',') {
                if (inside_double_quotes) {
                    temp.append((char) character);
                } else {
                    temp_list.add(temp.toString());
                    temp.delete(0, temp.length());
                }
            } else if (character == '\n') {
                temp_list.add(temp.toString());
                temp.delete(0, temp.length());
                result.addLast(temp_list);
                temp_list = new ArrayList<>();
            } else {
                temp.append((char) character);
            }
        }
        return result;
    }


    private static Booking[] getBookings() throws IOException {
        LinkedList<ArrayList<String>> list = data();
        list.removeFirst();
        bookings = new Booking[list.size()];
        int i = 0;
        for (ArrayList<String> booking : list) {
            bookings[i] = new Booking();
            bookings[i].setEmail(booking.get(0));
            bookings[i].setName(booking.get(1));
            bookings[i].setMobile(booking.get(2));
            bookings[i].setAddress(booking.get(3));
            bookings[i].setTrain(booking.get(4));
            String[] temp = booking.get(5).split(",");
            if (temp.length == 2) {
                bookings[i].setCoach(temp[0].trim());
                bookings[i].setSeat(Integer.parseInt(temp[1].trim()));
            }
            bookings[i].setTimestamp(Timestamp.valueOf(booking.get(6) + " " + booking.get(7) + ":00"));
            i++;


        }
        return bookings;
    }

    private static void alternative(Booking  booking){
        Train.Pointer  pointer = Train.indexing.get(booking.getTrain());
        int seat=0;
        String coach;
        try {
            int [] pos = pointer.get_D();
            coach = "D"+pos[0];
            seat=pos[1];
        }
        catch (SeatNotAvailable seatNotAvailable){
            try {
                int [] pos = pointer.get_S();
                coach ="S"+pos[0];
                seat=pos[1];
            }
            catch (SeatNotAvailable seatNotAvailable1){
                return;
            }
        }
        booking.setAllotted_seat(seat);
        booking.setAllotted_coach(coach);
        Train.makeReservation(booking.getTrain(),coach,seat);
    }

    private static void allotment(Booking [] bookings)  {
        PriorityQueue<Booking> queue = new PriorityQueue<>((a,b)->{
            long first = a.getTimestamp().getTime();
            long second = b.getTimestamp().getTime();
            return Long.compare(first, second);
        });
        queue.addAll(Arrays.asList(bookings));
        while (!queue.isEmpty()){
            Booking booking = queue.poll();
            if (booking.getCoach()!=null){
                try{
                    if(Train.query(booking.getTrain(),booking.getCoach(),booking.getSeat())){
                        throw new Exception("Redirecting .... ");
                    }
                    else{
                        booking.setAllotted_coach(booking.getCoach());
                        booking.setAllotted_seat(booking.getSeat());
                        Train.makeReservation(booking.getTrain(),booking.getCoach(),booking.getSeat());
                    }
                }
                catch (Exception e){
                    alternative(booking);
                }
            }
            else{
                alternative(booking);
            }
        }
    }

    private static void initializer(){
        HashSet<String> set = new HashSet<>();
        for (Booking b:bookings)
            set.add(b.getTrain());
        String [] trains_names = new String[set.size()];
        int i = 0;
        for (String s:set)
            trains_names[i++]=s;
        Train.train_Initializer(trains_names);
    }

    public static void main(String[] args) throws IOException {
        Booking [] bookings =  getBookings();
        initializer();
        allotment(bookings);
        Arrays.sort(bookings,(a,b)->{
            long first = a.getTimestamp().getTime();
            long second = b.getTimestamp().getTime();
            return Long.compare(first, second);
        });
        for (Booking booking:bookings){
            System.out.println(booking.getName()+"  "+booking.getCoach()+"  "+booking.getSeat()+"   "+booking.getAllotted_coach()+"  "+booking.getAllotted_seat()+"   "+booking.getTimestamp()+"  "+booking.getTrain()+"\n\n");
        }

    }
}