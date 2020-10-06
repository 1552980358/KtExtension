package lib.github1552980358.ktExtension.jvm.sql.commands.base

import lib.github1552980358.ktExtension.jvm.keyword.tryOnly
import lib.github1552980358.ktExtension.jvm.sql.commands.base.Condition.Companion.getConditionStr

class ConditionalExpress: SQLComponent() {
    
    companion object {
        private const val CONDITIONAL_EXPRESS = "ConditionalExpress"
        private const val MSG_EMPTY_CONDITION = "Condition(s) should not be empty"
        
        private const val OPEN_BRACKET = '('
        private const val CLOSE_BRACKET = ')'
        private const val EQUAL = '='
    }
    
    lateinit var globalCondition: Condition
    
    val subConditions = arrayListOf<ConditionalExpress>()
    
    var singleCondition = true
    var condition: String? = null
    
    @Suppress("unused")
    fun setCondition(column: String, condition: String) = setCondition("$column$EQUAL$condition")
    
    @Suppress("MemberVisibilityCanBePrivate")
    fun setCondition(condition: String) = apply {
        subConditions.clear()
        singleCondition = true
        this.condition = condition
    }
    
    fun setGlobalCondition(condition: Condition) = apply {
        globalCondition = condition
    }
    
    fun addCondition(conditionalExpress: ConditionalExpress) = apply {
        if (singleCondition) {
            subConditions.add(ConditionalExpress().setCondition(condition!!).setGlobalCondition(globalCondition))
        }
        condition = null
        singleCondition = false
        
        subConditions.add(conditionalExpress)
    }
    
    @Suppress("MemberVisibilityCanBePrivate")
    fun addConditionsArray(conditions: Array<ConditionalExpress>) {
        if (singleCondition) {
            subConditions.add(ConditionalExpress().setCondition(condition!!).setGlobalCondition(globalCondition))
        }
        condition = null
        singleCondition = false
    
        conditions.forEach { condition -> subConditions.add(condition) }
    }
    
    fun addConditions(vararg conditions: ConditionalExpress) = addConditionsArray(conditions.toList().toTypedArray())
    
    override fun formString() = StringBuilder().apply {
        append(getConditionStr(globalCondition))
        append(SPACE)
        if (singleCondition) {
            condition ?: throw IllegalContentException(CONDITIONAL_EXPRESS, MSG_EMPTY_CONDITION)
            append(condition)
            return@apply
        }
    
        append(OPEN_BRACKET)
        append(SPACE)
    
        subConditions.forEach { conditionalExpress ->
            tryOnly { append(getConditionStr(conditionalExpress.globalCondition)) }
            append(conditionalExpress.condition)
            append(SPACE)
        }
    
        append(CLOSE_BRACKET)
    }.toString()
    
}
