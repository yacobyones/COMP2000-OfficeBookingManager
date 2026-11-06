package com.yacobyones.officebookingmanager

data class Room(val id: String, val name: String, val seats: Int, val bookedUntil: String?)

data class Booking(val id: Int, val roomName: String, val day: String, val time: String, val bookedBy: String)

data class BookingRequest(
    val id: Int, val type: String, val who: String, val roomName: String,
    val whenText: String, val clash: Boolean, var status: String = "Pending"
)

object MockData {
    var nextId = 100
    val employees = listOf("Georgia Davey", "Lewis King", "James Anstey", "Osian Hopkin")

    val rooms = listOf(
        Room("MR1", "Meeting room 1", 4, "11:00"),
        Room("MR2", "Meeting room 2", 6, null),
        Room("MR3", "Meeting room 3", 6, "12:00"),
        Room("MR4", "Meeting room 4", 8, null),
        Room("MR5", "Meeting room 5", 10, null),
        Room("SR1", "Seminar room 1", 30, "16:00"),
        Room("SR2", "Seminar room 2", 50, null)
    )

    val bookings = mutableListOf(
        Booking(1, "Meeting room 1", "Tue 3 Nov", "09:00–11:00", "Georgia Davey"),
        Booking(2, "Meeting room 3", "Tue 3 Nov", "10:00–12:00", "Lewis King"),
        Booking(3, "Seminar room 1", "Tue 3 Nov", "13:00–16:00", "James Anstey"),
        Booking(4, "Seminar room 2", "Wed 4 Nov", "10:00–12:00", "Osian Hopkin")
    )

    val requests = mutableListOf(
        BookingRequest(1, "Booking request", "Georgia Davey", "Meeting room 2", "Tue 3 Nov · 10:00–11:00", false),
        BookingRequest(2, "Cancellation request", "Lewis King", "Seminar room 1", "Wed 4 Nov · 14:00–16:00", false),
        BookingRequest(3, "Booking request", "James Anstey", "Meeting room 1", "Tue 3 Nov · 10:30–11:30", true)
    )
}