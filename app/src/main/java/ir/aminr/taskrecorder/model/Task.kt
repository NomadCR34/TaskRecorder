package ir.aminr.taskrecorder.model

data class Task(
    var title:String,
    var startDate:Long,
    var endDate:Long
){
    var id:Long = 0
}
