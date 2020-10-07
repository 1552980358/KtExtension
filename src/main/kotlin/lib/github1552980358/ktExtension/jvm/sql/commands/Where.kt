package lib.github1552980358.ktExtension.jvm.sql.commands

import lib.github1552980358.ktExtension.jvm.sql.SQLBuilder
import lib.github1552980358.ktExtension.jvm.sql.commands.base.Condition.AND
import lib.github1552980358.ktExtension.jvm.sql.commands.base.Condition.AND_NOT
import lib.github1552980358.ktExtension.jvm.sql.commands.base.Condition.Companion.getConditionStr
import lib.github1552980358.ktExtension.jvm.sql.commands.base.Condition.OR
import lib.github1552980358.ktExtension.jvm.sql.commands.base.Condition.OR_NOT
import lib.github1552980358.ktExtension.jvm.sql.commands.base.ConditionalExpress
import lib.github1552980358.ktExtension.jvm.sql.commands.base.SQLCommand

class Where: SQLCommand {
    
    companion object {
        const val CMD_WHERE = "where"
        const val WHERE = "Where"
        const val MSG_EMPTY_CONDITION = "Condition(s) should not be empty"
    }
    
    @Suppress("unused")
    constructor(): super()
    constructor(builder: SQLBuilder?): super(builder)
    
    private var conditions = arrayListOf<ConditionalExpress>()
    
    fun and(condition: String) = apply {
        conditions.add(ConditionalExpress().setGlobalCondition(AND).setCondition(condition))
    }
    
    @Suppress("unused")
    fun andNot(condition: String) = apply {
        conditions.add(ConditionalExpress().setGlobalCondition(AND_NOT).setCondition(condition))
    }
    
    @Suppress("unused")
    fun or(condition: String) = apply {
        conditions.add(ConditionalExpress().setGlobalCondition(OR).setCondition(condition))
    }
    
    @Suppress("unused")
    fun orNot(condition: String) = apply {
        conditions.add(ConditionalExpress().setGlobalCondition(OR_NOT).setCondition(condition))
    }
    
    @Suppress("unused")
    fun orderBy() = orderBy(OrderBy(builder))
    
    @Suppress("MemberVisibilityCanBePrivate")
    fun orderBy(orderBy: OrderBy): OrderBy {
        builder ?: throw IllegalStateException()
        builder?.where = this
        builder?.orderBy = orderBy
        return orderBy
    }
    
    override fun formString() =
        StringBuilder().apply {
            append(CMD_WHERE)
            append(SPACE)
            
            if (conditions.isEmpty()) {
                throwException(WHERE, MSG_EMPTY_CONDITION)
            }
            
            append(conditions.first().condition)
            for (i in 1 .. conditions.lastIndex) {
                append(getConditionStr(conditions[i].globalCondition))
                append(conditions[i].toString())
                append(SPACE)
            }
        }.toString()
    
}