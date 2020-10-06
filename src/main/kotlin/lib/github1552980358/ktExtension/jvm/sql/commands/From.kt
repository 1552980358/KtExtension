package lib.github1552980358.ktExtension.jvm.sql.commands

import lib.github1552980358.ktExtension.jvm.sql.SQLBuilder
import lib.github1552980358.ktExtension.jvm.sql.commands.base.SQLCommand

class From: SQLCommand {
    
    companion object {
        private const val CMD_FROM = "from"
        private const val FROM = "From"
        private const val MSG_EMPTY_TABLE = "Table not specified"
    }
    
    constructor(): super()
    constructor(builder: SQLBuilder?): super(builder)

    private var table = ""
    
    fun setTable(table: String) = apply {
        this@From.table = table
    }
    
    fun where(): Where {
        builder ?: throw IllegalStateException()
        builder?.from = this
        return Where(builder)
    }
    
    override fun formString() = StringBuilder().apply {
        append(CMD_FROM)
        append(SPACE)
        
        if (table.isEmpty()) {
            throwException(FROM, MSG_EMPTY_TABLE)
        }
        
        append(table)
    }.toString()
    
}