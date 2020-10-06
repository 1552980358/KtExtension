package lib.github1552980358.ktExtension.jvm.sql

import lib.github1552980358.ktExtension.jvm.sql.commands.From
import lib.github1552980358.ktExtension.jvm.sql.commands.Select

class SQLBuilder {
    
    companion object {
        
        @Suppress("unused")
        fun select(): Select {
            return SQLBuilder().select()
        }
        
        @Suppress("unused")
        fun select(select: Select) = SQLBuilder().apply { select(select) }
        
    }
    
    var select: Select? = null
    var from: From? = null
    
    fun select(select: Select) = apply {
        this.select = select
    }
    
    fun select() = Select(this)
    
}