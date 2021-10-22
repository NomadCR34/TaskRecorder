package ir.aminr.taskrecorder.util

interface Mapper<DomainEntity, Entity> {
    fun toEntity(domainEntity: DomainEntity): Entity
    fun fromEntity(entity: Entity): DomainEntity
}