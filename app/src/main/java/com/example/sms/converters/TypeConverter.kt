package com.example.sms.converters

import androidx.room.TypeConverter
import java.util.Date

class TypeConverter {

    @TypeConverter
    fun fromTimestamp(value:Long): Date {
        return  Date(value)
    }

    @TypeConverter
    fun dateTiTimestamp(date:Date): Long {
        return  date.time
    }
}