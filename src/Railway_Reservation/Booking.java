package Railway_Reservation;

import java.sql.Timestamp;

public class Booking {
    private String name;
    private String address;
    private String email;
    private String mobile;
    private String coach;
    private int seat;
    private String train;
    private Timestamp timestamp;
    private String allotted_coach;
    private int allotted_seat;

    public String getAllotted_coach() {
        return allotted_coach;
    }

    public void setAllotted_coach(String allotted_coach) {
        this.allotted_coach = allotted_coach;
    }

    public int getAllotted_seat() {
        return allotted_seat;
    }

    public void setAllotted_seat(int allotted_seat) {
        this.allotted_seat = allotted_seat;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", coach='" + coach + '\'' +
                ", seat=" + seat +
                ", train='" + train + '\'' +
                ", timestamp=" + timestamp +
                ", allotted_coach='" + allotted_coach + '\'' +
                ", allotted_seat=" + allotted_seat +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
