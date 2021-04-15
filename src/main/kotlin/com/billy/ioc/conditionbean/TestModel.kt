package com.billy.ioc.conditionbean

interface TestModel {
    fun eat(): String
}

class TestModelImpl1 : TestModel {
    override fun eat(): String {
        return "肉"
    }
}

class TestModelImpl2 : TestModel {
    override fun eat(): String {
        return "鱼"
    }

}