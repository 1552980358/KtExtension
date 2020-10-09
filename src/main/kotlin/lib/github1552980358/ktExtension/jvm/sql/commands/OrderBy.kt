package lib.github1552980358.ktExtension.jvm.sql.commands

import lib.github1552980358.ktExtension.jvm.sql.SQLBuilder
import lib.github1552980358.ktExtension.jvm.sql.commands.base.SQLCommand
import java.lang.StringBuilder

class OrderBy: SQLCommand {
    
    companion object {
        
        const val CMD_ORDER_BY = "order by"
        
    }
    
    constructor(): super()
    constructor(builder: SQLBuilder?): super(builder)
    
    private val columns = ArrayList<String>()
    
    @Suppress("unused")
    fun setColumn(column: String) = run {
        columns.clear()
        addColumn(column)
    }
    
    @Suppress("MemberVisibilityCanBePrivate")
    fun addColumn(column: String) = apply {
        columns.add(column)
    }
    
    @Suppress("unused")
    fun addColumnArray(columns: Array<String>) = addColumnList(columns.toList())
    
    @Suppress("unused")
    fun addColumns(vararg columns: String) = addColumnList(columns.toList())
    
    @Suppress("MemberVisibilityCanBePrivate")
    fun addColumnList(columns: List<String>) = apply {
        columns.forEach { column ->
            this@OrderBy.columns.add(column)
        }
    }
    
    @Suppress("unused")
    fun removeColumn(column: String) = apply { columns.remove(column) }
    
    @Suppress("unused")
    fun removeColumns(vararg columns: String) = removeColumnList(columns.toList())
    
    @Suppress("unused")
    fun removeColumnArray(columns: Array<String>) = removeColumnList(columns.toList())
    
    @Suppress("MemberVisibilityCanBePrivate")
    fun removeColumnList(columns: List<String>) = apply {
        columns.forEach { column ->
            this@OrderBy.columns.remove(column)
        }
    }
    
    override fun formString() = StringBuilder().apply {
        append(CMD_ORDER_BY)
        append(SPACE)
        columns.forEach { column ->
            append(column)
            append(SPACE)
        }
    }.toString()
    
}