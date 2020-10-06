package lib.github1552980358.ktExtension.jvm.sql.commands.base

abstract class SQLComponent {
    
    companion object {
        
        const val SPACE = ' '
        
    }
    
    abstract fun formString(): String
    
    override fun toString() = formString()
    
    fun throwException(causer: String, msg: String): Unit = throw IllegalContentException(causer, msg)
    
}