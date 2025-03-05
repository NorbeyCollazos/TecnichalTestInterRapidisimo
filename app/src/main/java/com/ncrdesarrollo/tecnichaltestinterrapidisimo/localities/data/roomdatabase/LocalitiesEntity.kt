package com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.data.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "localities_table")
data class LocalitiesEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "AbreviacionCiudad") val AbreviacionCiudad: String,
    @ColumnInfo(name = "NombreCompleto") val NombreCompleto: String
)