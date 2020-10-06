package lib.github1552980358.ktExtension.jvm.sql.commands

import lib.github1552980358.ktExtension.jvm.sql.SQLBuilder
import lib.github1552980358.ktExtension.jvm.sql.commands.base.IllegalContentException
import lib.github1552980358.ktExtension.jvm.sql.commands.base.SQLCommand

class Select: SQLCommand {
    
    companion object {
        const val SELECT_ALL = "*"
        const val DIVIDER = ", "
        
        private const val CMD_SELECT = "select"
        private const val SELECT = "Select"
        private const val MSG_EMPTY_SELECTION = "Selection not specified"
    }
    
    constructor(): super()
    constructor(builder: SQLBuilder?): super(builder)
    
    private var selections = arrayListOf<String>()
    var isSelectAll = false
        set (value) {
            if (value) {
                selections.clear()
            }
            field = value
        }
    
    fun all() = apply {
        isSelectAll = true
    }
    
    @Suppress("unused")
    fun addSelection(selection: String) = apply {
        selections.add(selection)
    }
    
    @Suppress("unused")
    fun addSelectionList(selections: List<String>) = addSelectionArray(selections.toTypedArray())
    
    @Suppress("MemberVisibilityCanBePrivate")
    fun addSelectionArray(selections: Array<String>) = apply {
        selections.forEach { selection -> this@Select.selections.add(selection) }
    }
    
    @Suppress("unused")
    fun addSelections(vararg selections: String) = apply {
        selections.forEach { selection -> this@Select.selections.add(selection) }
    }
    
    fun from(): From {
        builder ?: throw IllegalStateException()
        builder?.select = this
        return From(builder)
    }
    
    fun from(from: From): From {
        builder ?: throw IllegalStateException()
        builder?.select = this
        builder?.from = from
        return from
    }
    
    override fun formString() =
        StringBuilder().apply {
            append(CMD_SELECT)
            append(SPACE)
            
            if (isSelectAll) {
                append(SELECT_ALL)
                return@apply
            }
            
            if (selections.isEmpty()) {
                throw IllegalContentException(SELECT, MSG_EMPTY_SELECTION)
            }
            
            selections.forEach { selection -> append(selection).append(SPACE) }
            
        }.toString()
    
}