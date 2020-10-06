package lib.github1552980358.ktExtension.jvm.sql.commands.base

import lib.github1552980358.ktExtension.jvm.sql.SQLBuilder

abstract class SQLCommand: SQLComponent {
    
    internal var builder: SQLBuilder? = null
    
    constructor(): super()
    
    constructor(builder: SQLBuilder?): this() {
        this.builder = builder
    }
    
}