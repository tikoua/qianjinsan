package com.qjs.database.flow

enum class FlowType(val type: Int) {
    Input(1),   //收入
    Output(2),  //支出
    Transfer(3) //转账
}