package ua.hillel.api.services;

import io.restassured.response.Response;
import ua.hillel.api.dto.BookingDTO;

public class BookingService extends BaseService {
    protected static final String bookingPath = "/booking";

    public Response getBookingIdsList() {
        return setRequestSpec().when()
                .get(bookingPath);
    }

    public Response createNewBooking(BookingDTO booking) {
        return setRequestSpec()
                .body(booking)
                .when().post(bookingPath);
    }
}
