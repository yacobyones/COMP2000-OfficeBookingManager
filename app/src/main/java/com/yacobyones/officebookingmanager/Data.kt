package com.yacobyones.officebookingmanager

class Room(val name: String, val capacity: Int, val busyFrom: String, val busyTo: String)

class Booking(
    val room: String,
    val date: String,
    val start: String,
    val end: String,
    val title: String,
    var status: String
)

object Data {

    val rooms = listOf(
        Room("Meeting Room 1", 6, "09:00", "12:00"),
        Room("Meeting Room 2", 6, "14:00", "15:00"),
        Room("Meeting Room 3", 8, "13:00", "15:00"),
        Room("Meeting Room 4", 8, "", ""),
        Room("Meeting Room 5", 10, "15:00", "17:00"),
        Room("Seminar Room 1", 30, "10:30", "11:30"),
        Room("Seminar Room 2", 40, "", "")
    )

    // time sin 30 minute increments
    val times = (16..36).map { String.format("%02d:%02d", it / 2, (it % 2) * 30) }

    // The time the employee has chosen (shared by Rooms and Request screens)
    var date = "07/11/2026"
    var start = "10:00"
    var end = "11:00"
    var selectedRoom: Room? = null

    val bookings = mutableListOf(
        Booking("Meeting Room 2", "07/11/2026", "14:00", "15:00", "Project sync", "Approved"),
        Booking("Meeting Room 4", "08/11/2026", "10:00", "11:00", "Client prep", "Pending"),
        Booking("Meeting Room 5", "09/11/2026", "09:00", "10:00", "Team workshop", "Rejected")
    )

    // True if the room is free for the chosen time
    fun isFree(room: Room, s: String, e: String): Boolean {
        if (room.busyFrom == "") return true
        return !(s < room.busyTo && e > room.busyFrom)
    }
}