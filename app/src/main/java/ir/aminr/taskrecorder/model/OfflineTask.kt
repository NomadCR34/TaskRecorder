package ir.aminr.taskrecorder.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class OfflineTask(
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "start_date")
    var startDate: Long,
    @ColumnInfo(name = "end_date")
    var endDate: Long
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}
