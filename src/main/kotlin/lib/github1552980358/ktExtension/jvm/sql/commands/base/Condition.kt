package lib.github1552980358.ktExtension.jvm.sql.commands.base

enum class Condition {
    AND,
    OR,
    AND_NOT,
    OR_NOT;
    
    companion object {
        @JvmStatic
        fun getConditionStr(condition: Condition) =
            when (condition) {
                AND -> " and "
                OR -> "or"
                AND_NOT -> "and not"
                OR_NOT -> "or not"
            }
    }
    
}