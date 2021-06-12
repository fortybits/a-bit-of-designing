package edu.bit.designing.bookmyshow;

/**
 * book my show
 * => search movie (text: string) : Movie =>
 * => booking seats for a movie ()
 * <p>
 * search of a movie => theatre => city =>
 * <p>
 * Movie:
 * String movieId;
 * String name;
 * <p>
 * City:
 * String cityId; // used fo geolocation
 * List<Threatre> theatres;
 * <p>
 * Theatre:
 * String theatreId;
 * List<Screen> screens;
 * <p>
 * Screen:
 * String screenId;
 * String theatreId;
 * List<Show> slot;
 * <p>
 * Show:
 * String showId;
 * String movieId;
 * Duration duration;
 * List<Seat> seats;
 * <p>
 * Seat
 * String seatId;
 * Map<String, Boolean> availablity;
 * <p>
 * ShowSeat
 * String seatId;
 * String showId;
 * Boolean availablity;
 * <p>
 * User
 * String accountId;
 * <p>
 * Booking:
 * String accountId;
 * String showId;  // movie, duration
 * List<Seat> seats; // these are seats booked for
 * <p>
 * <p>
 * // 1Mil users are booking a seat and all of them are looking movieId
 * <p>
 * <p>
 * 1 				2 					3 					4 				5
 * availability	availability	availability		availability	availability
 * <p>
 * <p>
 * acquireLock
 * bookSeat
 * releaseLock
 */